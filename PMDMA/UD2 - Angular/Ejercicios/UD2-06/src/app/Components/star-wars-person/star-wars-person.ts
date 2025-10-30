import { Component,input } from '@angular/core';

interface Person {
  name: string;
  height: string;
  mass: string;
  hair_color: string;
  skin_color: string;
  eye_color: string;
  birth_year: string;
  gender: string;
  homeworld: string;
  films: string[];
  species: string[];
  vehicles: string[];
  starships: string[];
  created: string;
  edited: string;
  url: string;
}

@Component({
  selector: 'app-star-wars-person',
  imports: [],
  templateUrl: './star-wars-person.html',
  styleUrl: './star-wars-person.css',
})
<<<<<<< HEAD
export class StarWarsPersersona = input('');
=======
export class StarWarsPerson {

    persona = input<Person>();
>>>>>>> 08ab674b7437f6ab8d84c15ed1054b4f381f2851

}
