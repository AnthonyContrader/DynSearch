import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { DishDTO } from 'src/dto/dishdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class DishService extends AbstractService<DishDTO>{
    constructor(http: HttpClient){
        super(http);
        this.type='dish';
    }
}