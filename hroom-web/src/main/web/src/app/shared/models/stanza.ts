
import{Tag} from "./Tag";


export class stanze{
    id!: number;
    prezzo!:number;
    nome!:string;
    favorite: boolean=false;
    stelle:number=0;
    tags!:Tag[];
    imageUrl!:string;
    roomtime!:number;
    luogo!:string[];
    nomeHost!:string;


}
