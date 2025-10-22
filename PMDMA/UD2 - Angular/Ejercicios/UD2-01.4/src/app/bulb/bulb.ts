import { Component } from '@angular/core';

@Component({
  selector: 'app-bulb',
  imports: [],
  templateUrl: './bulb.html',
  styleUrl: './bulb.css'
})
export class Bulb {

    luzEncencida:boolean = false;

  alternarBombilla() {
    this.luzEncencida = !this.luzEncencida
  }

}
