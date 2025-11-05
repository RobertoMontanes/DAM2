import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from "./header/header";
import { Hero } from "./hero/hero";
import { Products } from "./products/products";
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, Hero, Products],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ejercicio01');
}
