import { Component, OnInit } from '@angular/core';
import { DishDTO } from 'src/dto/dishdto';
import { DishService } from 'src/service/dish.service';

@Component({
  selector: 'app-dishes',
  templateUrl: './dishes.component.html',
  styleUrls: ['./dishes.component.css']
})
export class DishesComponent implements OnInit {

  dishes : DishDTO[];
  dishtoinsert : DishDTO = new DishDTO();

  constructor(private service : DishService) { }

  ngOnInit() {
    this.getDishes();
  }

  getDishes(){
    this.service.getAll().subscribe(dishes => this.dishes = dishes);
  }

  delete(dish : DishDTO){
    this.service.delete(dish.id).subscribe(() => this.getDishes());
  }

  update(dish : DishDTO){
    this.service.update(dish).subscribe(() => this.getDishes());
  }

  insert(dish : DishDTO){
    this.service.insert(dish).subscribe(() => this.getDishes());
  }

  read(dish : DishDTO){
    this.service.read(dish.id).subscribe(() => this.getDishes());
  }

  clear(){
    this.dishtoinsert = new DishDTO();
  }
}
