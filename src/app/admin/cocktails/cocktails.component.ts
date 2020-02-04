import { Component, OnInit } from '@angular/core';
import { CocktailService } from 'src/service/cocktail.service';
import { CocktailDTO } from 'src/dto/cocktaildto';

@Component({
  selector: 'app-cocktailss',
  templateUrl: './cocktails.component.html',
  styleUrls: ['./cocktails.component.css']
})
export class CocktailsComponent implements OnInit {

  cocktails: CocktailDTO[];
  cocktailtoinsert: CocktailDTO = new CocktailDTO();

  constructor(private service: CocktailService) { }

  ngOnInit() {
    this.getCocktails();
  }

  getCocktails() {
    this.service.getAll().subscribe(cocktails => this.cocktails = cocktails);
  }

  delete(cocktail: CocktailDTO) {
    this.service.delete(cocktail.id).subscribe(() => this.getCocktails());
  }

  update(cocktail: CocktailDTO) {
    this.service.update(cocktail).subscribe(() => this.getCocktails());
  }

  insert(cocktail: CocktailDTO) {
    this.service.insert(cocktail).subscribe(() => this.getCocktails());
  }

  clear(){
    this.cocktailtoinsert = new CocktailDTO();
  }
}
