import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {AsyncPipe,NgIf,NgTemplateOutlet} from "@angular/common"
import { Observable, tap } from "rxjs";
import { Component, ContentChild, Input, OnInit, TemplateRef } from "@angular/core";
import { LoadingService } from "./loading.service";
import { RouteConfigLoadEnd, RouteConfigLoadStart, Router } from "@angular/router";

@Component({
  selector: "loading-indicator",
  templateUrl: "./loading.component.html",
  styleUrls: ["./loading.component.scss"],
  imports: [MatProgressSpinnerModule, AsyncPipe, NgIf, NgTemplateOutlet],
  standalone: true,
})

export class LoadingComponent implements OnInit {

  loading$: Observable<boolean>;

  @Input()
  detectRouteTransitions = false;

  @ContentChild("loading")
  customLoadingIndicator: TemplateRef<any> | null = null;

  constructor(
  private loadingService: LoadingService,
  private router: Router) {
    this.loading$ = this.loadingService.loading$;
  }

  ngOnInit() {
    if (this.detectRouteTransitions) {
      this.router.events
        .pipe(
          tap((event) => {
            if (event instanceof RouteConfigLoadStart) {
              this.loadingService.loadingOn();
            } else if (event instanceof RouteConfigLoadEnd) {
              this.loadingService.loadingOff();
            }
          })
        )
        .subscribe();
    }
  }
}
