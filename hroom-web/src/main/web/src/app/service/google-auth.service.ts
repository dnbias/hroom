import { Injectable } from "@angular/core";

@Injectable()
export class GoogleAuthenticationService implements LoginProvider {
    constructor(private readonly _oAuthService: OAuthService) {
        this.createConfiguration();
    }

    private readonly _tokenReceived$ = this._oAuthService.events.pipe(
        filter((e) => e.type === 'token_received'),
        map(() => true as const)
    );

    private createConfiguration(): void {
        let redirectUri = window.location.origin + window.location.pathname;
        if (redirectUri.endsWith('/')) {
            redirectUri = redirectUri.substring(0, redirectUri.length - 1);
        }

        this._oAuthService.configure({
            issuer: 'https://accounts.google.com',
            strictDiscoveryDocumentValidation: false,
            redirectUri,
            silentRefreshRedirectUri: redirectUri,
            useSilentRefresh: true,
            clientId: environment.googleClientId,
            scope: 'openid profile email'
        });
    }

    async initialize(autoLogin?: boolean): Promise<void> {
        await this._oAuthService.loadDiscoveryDocument();
        if (autoLogin) {
            await this._oAuthService.tryLoginImplicitFlow();
        }
    }

    async signIn(): Promise<SocialUser> {
        const tokenReceivedPromise = firstValueFrom(this._tokenReceived$);

        await this._oAuthService.initImplicitFlowInPopup();
        await tokenReceivedPromise;

        return this.createUser(this._oAuthService.getIdToken());
    }

    async getLoginStatus(): Promise<SocialUser> {
        if (this._oAuthService.hasValidIdToken()) {
            return this.createUser(this._oAuthService.getIdToken());
        } else {
            throw `No user is currently logged in`;
        }
    }

    async signOut(revoke?: boolean): Promise<void> {
        if (revoke) {
            this._oAuthService.revokeTokenAndLogout(true, true);
        } else {
            this._oAuthService.logOut(true);
        }
    }

    private createUser(idToken: string): SocialUser {
        const user = new SocialUser();
        const payload = JSON.parse(window.atob(idToken.split('.')[1]));
        user.idToken = idToken;
        user.id = payload.sub;
        user.name = payload.name;
        user.email = payload.email;
        user.photoUrl = payload.picture;
        user.firstName = payload['given_name'];
        user.lastName = payload['family_name'];
        return user;
    }
}
