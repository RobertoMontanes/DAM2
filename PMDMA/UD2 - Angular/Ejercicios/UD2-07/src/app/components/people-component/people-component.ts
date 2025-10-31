import { Component,input } from '@angular/core';
import { StarWarsPerson } from '../../interfaces/StarWarsPeopleList-response-interface';

@Component({
  selector: 'app-people-component',
  imports: [],
  templateUrl: './people-component.html',
  styleUrl: './people-component.css',
})
export class PeopleComponent {

  person = input<StarWarsPerson>();

}
