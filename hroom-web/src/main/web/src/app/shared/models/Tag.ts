export class Tag{
    static readonly STANZA = new Tag('Stanza','red');
    static readonly IDRO = new Tag('Idromassaggio','verde');
    static readonly PARCHEGGIO = new Tag('Parcheggio','verde');

    static readonly COLAZIONE  = new Tag('Colazione','pink');
    static readonly SPA  = new Tag('Spa','black');



    private constructor(private readonly key: string,public readonly color: string) {}
    toString() {
        return this.key;
    }
}
