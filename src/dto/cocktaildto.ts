import {Usertype} from './usertype';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Stefano Mazzeo
 */
export class CocktailDTO {

   id: number;

   name : string;

   type: string;

   isAlcohol : number;

   AVG : number;

   alcohol : string;

}

