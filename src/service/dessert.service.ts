import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DessertDTO } from 'src/dto/dessertdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DessertService extends AbstractService<DessertDTO> {

  constructor(http:HttpClient) { 
    super(http);
    this.type='dessert';
  }
}