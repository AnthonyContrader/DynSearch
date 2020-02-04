import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { IngredientDTO } from 'src/dto/ingredientdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn : 'root'
})

export class IngredientService extends AbstractService<IngredientDTO>{
    constructor(http : HttpClient ){
        super(http);
        this.type='ingredient'
    }
}