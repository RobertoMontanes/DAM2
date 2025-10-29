import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { StarWarsPerson } from "./Components/star-wars-person/star-wars-person";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, StarWarsPerson],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('UD2-06');
}
