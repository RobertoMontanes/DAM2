import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Title } from "./title/title";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Title],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('UD2-01.2');
}
