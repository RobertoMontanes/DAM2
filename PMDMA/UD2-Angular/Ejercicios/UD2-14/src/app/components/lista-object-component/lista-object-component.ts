import { Component, input } from '@angular/core';
import { AccountList } from '../../interfaces/account-lists-interface';

@Component({
  selector: 'app-lista-object-component',
  imports: [],
  templateUrl: './lista-object-component.html',
  styleUrl: './lista-object-component.css',
})
export class ListaObjectComponent {
verDetalle() {
throw new Error('Method not implemented.');
}

  lista = input<AccountList>();

}
