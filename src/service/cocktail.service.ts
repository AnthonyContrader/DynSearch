import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CocktailDTO } from 'src/dto/cocktaildto';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Stefano Mazzeo
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class CocktailService extends AbstractService<CocktailDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'cocktail';
  }


  insert(insertDTO: CocktailDTO): Observable<CocktailDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/insert', insertDTO)
  }


  update(updateDTO: CocktailDTO): Observable<CocktailDTO> {
    return this.http.put<any>('http://localhost:8080/' + this.type + '/update', updateDTO)
  }

 
}
