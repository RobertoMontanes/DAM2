import { Component } from '@angular/core';
import { CustomProgressBarComponent } from "../../components/custom-progress-bar-component/custom-progress-bar-component";

@Component({
  selector: 'app-home-page',
  imports: [CustomProgressBarComponent],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage {

  value = 10;
  color = 'blue';
  isStriped = true;
  showProgress = true;

  modificarColor() {
    this.color = (<HTMLInputElement>document.getElementById("changeColor")).value;
  }

  modificarValue() {
    this.value = Number((<HTMLInputElement>document.getElementById("value")).value);
  }

}
