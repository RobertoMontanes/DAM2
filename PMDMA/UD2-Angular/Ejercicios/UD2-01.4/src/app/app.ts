import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Bulb } from "./bulb/bulb";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Bulb],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('UD2-01.4.2');
}
