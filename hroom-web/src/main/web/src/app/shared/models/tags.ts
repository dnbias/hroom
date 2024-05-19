
  enum Tags{
    BATHROOM,
    HYDROMASSAGE,
    WHEELCHAIR_ACCESS,
    SPA,
    ALLINCLUSIVE,
    CENTER,
    APARTMENT,
    ROOM,
    PRIVATEBATHROOM,
    SEA,
    MONTAIN,
    MAISON,
    PARKING,
    AIRCONDITIONER,
    BREAKFAST,
    GYM,
    CLEAN,
    MASSAGE,
    FREEZER,
    TV,
    WC,
    MINIBAR,
    BIDET
}
  export class Tag{
  static readonly STANZA = new Tag('Stanza','red');
  static readonly IDRO = new Tag('Idromassaggio','verde');
  static readonly PARCHEGGIO = new Tag('Parcheggio','verde');
  static readonly COLAZIONE  = new Tag('Colazione','pink');
  static readonly SPA  = new Tag('Spa','black');
  static readonly APPARTAMENTO  = new Tag('appartamento','yellow');
  static readonly ALLINCLUSIVE  = new Tag('allinclusive','fuxia');
  static readonly CENTRO  = new Tag('centro','fuxia');

  getcolor(tag: Tags):string{
    switch(tag){
      case Tags.BATHROOM:{
        return 'red';
      }
      case Tags.HYDROMASSAGE:{
        return 'blue';
      }
      case Tags.WHEELCHAIR_ACCESS:{
        return 'orange';
      }
      case Tags.SPA:{
        return 'yellow';
      }
      case Tags.ALLINCLUSIVE:{
        return 'pea';
      }
      case Tags.CENTER:{
        return 'pink';
      }
      case Tags.APARTMENT:{
        return 'whitesmoke';
      }
      case Tags.ROOM:{
        return 'green';
      }
      case Tags.PRIVATEBATHROOM:{
        return 'maroon';
      }
      case Tags.SEA:{
        return 'color';
      }
      case Tags.MONTAIN:{
        return 'plum';
      }
      case Tags.MAISON:{
        return 'silver';
      }
      case Tags.PARKING:{
        return 'gray';
      }
      case Tags.AIRCONDITIONER:{
        return 'hot pink';
      }
      case Tags.BREAKFAST:{
        return 'brown';
      }
      case Tags.GYM:{
        return 'salmon';
      }
      case Tags.CLEAN:{
        return 'fuchsia';
      }
      case Tags.MASSAGE:{
        return 'olive';
      }
      case Tags.FREEZER:{
        return 'cyan';
      }
      case Tags.TV:{
        return 'lime';
      }
      case Tags.WC:{
        return 'azure';
      }
      case Tags.MINIBAR:{
        return 'magenta';
      }
      case Tags.BIDET:{
        return 'teal';
      }

      default:{
        return "";
      }
    }
  }


  private constructor(private readonly key: string,public readonly color: string) {}
  toString() {
    return this.key;
  }

}
