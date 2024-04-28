export class Tag{
    static readonly STANZA = new Tag('Stanza','red');
    static readonly IDRO = new Tag('Idromassaggio','verde');
    static readonly PARCHEGGIO = new Tag('Parcheggio','verde');

    static readonly COLAZIONE  = new Tag('Colazione','pink');
    static readonly SPA  = new Tag('Spa','black');
    static readonly APPARTAMENTO  = new Tag('appartamento','yellow');
    static readonly ALLINCLUSIVE  = new Tag('allinclusive','fuxia');
    static readonly CENTRO  = new Tag('centro','fuxia');



    private constructor(private readonly key: string,public readonly color: string) {}
    toString() {
        return this.key;
    }
}
