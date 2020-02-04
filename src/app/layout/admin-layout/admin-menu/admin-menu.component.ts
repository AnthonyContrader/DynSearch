import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isDishesCollapsed = false;
  isUserCollapsed = false;
  isCocktailCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isDessertCollapsed=false;
  isIngredientsCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }
  dishescollapse() {
    if (this.isDishesCollapsed === false) {
      this.isDishesCollapsed = true;
    } else { this.isDishesCollapsed = false; }
  }
  ingredientscollapse() {
    if (this.isIngredientsCollapsed === false) {
      this.isIngredientsCollapsed = true;
    } else { this.isIngredientsCollapsed = false; }
  }
  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  cocktailscollapse() {
    if (this.isCocktailCollapsed === false) {
      this.isCocktailCollapsed = true;
    } else { this.isCocktailCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  dessertscollapse() {
    if (this.isDessertCollapsed === false) {
      this.isDessertCollapsed = true;
    } else { this.isDessertCollapsed = false; }
  }
}
