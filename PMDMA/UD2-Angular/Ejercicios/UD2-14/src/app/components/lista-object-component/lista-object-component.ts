import { Component, input } from '@angular/core';
import { AccountList } from '../../interfaces/account-lists-interface';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-object-component',
  imports: [],
  templateUrl: './lista-object-component.html',
  styleUrl: './lista-object-component.css',
})
export class ListaObjectComponent {

  constructor(private router: Router) {}


  verDetalle() {
    this.router.navigate(['/lists/', this.lista()?.id]);
  }


  lista = input<AccountList>();

}
