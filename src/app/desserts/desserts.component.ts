import { Component, OnInit } from '@angular/core';
import{DessertDTO} from 'src/dto/dessertdto'
import{DessertService} from 'src/service/dessert.service'

@Component({
  selector: 'app-desserts',
  templateUrl: './desserts.component.html',
  styleUrls: ['./desserts.component.css']
})
export class DessertsComponent implements OnInit {

  desserts:DessertDTO[];
  desserttoinsert: DessertDTO = new DessertDTO;

  constructor(private service: DessertService) { }

  ngOnInit() {
    this.getDesserts();

  }
  getDesserts() {
    this.service.getAll().subscribe(desserts => this.desserts = desserts);
  }
  delete(dessert: DessertDTO) {
    this.service.delete(dessert.id).subscribe(() => this.getDesserts());
  }

  update(dessert: DessertDTO) {
    this.service.update(dessert).subscribe(() => this.getDesserts());
  }

  insert(dessert: DessertDTO) {
    this.service.insert(dessert).subscribe(() => this.getDesserts());
  }

  clear(){
    this.desserttoinsert = new DessertDTO();
  }

}