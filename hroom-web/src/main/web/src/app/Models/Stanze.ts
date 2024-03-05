export interface  IStanze{
    codSta: string
    descrizione: string
    prezzo : number
    citta: string
    valutazione : number
    active: boolean //se la stanza è attivo
    data: Date // data per l'inserimento stanza
}
