import { Component, OnInit } from '@angular/core';
import { IngredientDTO } from 'src/dto/ingredientdto';
import { IngredientService } from 'src/service/ingredient.service';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.css']
})
export class IngredientsComponent implements OnInit {
  ingredients : IngredientDTO[];
  ingrediettoinsert : IngredientDTO = new IngredientDTO();
  constructor(private service : IngredientService) { }

  ngOnInit() {
    this.getIngredients();
  }
  getIngredients(){
    this.service.getAll().subscribe(ingredients => this.ingredients = ingredients)
  }
  delete(ingredient : IngredientDTO){
    this.service.delete(ingredient.id).subscribe(() => this.getIngredients());
  }
  update(ingredient : IngredientDTO){
    this.service.update(ingredient).subscribe(() => this.getIngredients());
  }
  insert(ingredient : IngredientDTO){
    this.service.insert(ingredient).subscribe(() => this.getIngredients());
  }
  read(ingredient : IngredientDTO){
    this.service.read(ingredient.id).subscribe(() => this.getIngredients());
  }
  clear(){
    this.ingrediettoinsert  = new IngredientDTO();
  }
}
