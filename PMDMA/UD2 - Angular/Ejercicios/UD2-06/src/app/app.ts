import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { StarWarsPersonList } from "./Components/star-wars-person-list/star-wars-person-list";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, StarWarsPersonList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('UD2-06');
}
