import { Component } from '@angular/core';
import { elementAt } from 'rxjs';

@Component({
  selector: 'app-calculadora',
  imports: [],
  templateUrl: './calculadora.html',
  styleUrl: './calculadora.css',
})
export class Calculadora {
  showDown: string = '0';
  valor0: string = '0';
  valor1: string = '0';
  operador: string = '';
  calc: boolean = false;

  addValue(value: number) {
    if (this.calc && this.valor1 != '0') {
      this.showDown = '0';
      this.calc = false;
      this.operador = '';
    }

    if (this.showDown == '0') {
      this.showDown = value.toString();
    } else {
      this.showDown += value.toString();
    }

    if (this.operador == '') {
      this.valor0 = this.showDown;
    } else {
      this.valor1 = this.showDown;
    }
  }

  setOperador(arg0: string) {
    this.operador = arg0;
    this.valor0 = this.showDown;
    this.showDown = '0';
    this.valor1 = '0';
    this.calc = false;
  }
  calcular() {
    if (this.calc == true) {
      this.valor0 = this.showDown;
    }

    const val0 = parseFloat(this.valor0);
    const val1 = parseFloat(this.valor1);

    this.calc = true;
    switch (this.operador) {
      case '+':
        this.showDown = (val0 + val1).toString();
        break;
      case '-':
        this.showDown = (val0 - val1).toString();
        break;
      default:
        this.showDown = '0';
    }
  }

  removeLast() {
    if (this.calc) {
      this.valor0 = this.showDown;
      this.calc = false;
      this.operador = ''; 
    } else {
      if (this.operador == '') {
        this.valor0 = this.valor0.slice(0, -1);
        if (this.valor0 == '') {
          this.valor0 = '0';
        }
        this.showDown = this.valor0;
      } else {
        this.valor1 = this.valor1.slice(0, -1);
        if (this.valor1 == '') {
          this.valor1 = '0';
        }
        this.showDown = this.valor1;
      }
    }
  }
}
