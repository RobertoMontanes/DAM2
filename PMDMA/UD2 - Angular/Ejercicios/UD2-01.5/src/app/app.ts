import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PgBar } from "./pg-bar/pg-bar";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PgBar],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('UD2-01.5');
}
