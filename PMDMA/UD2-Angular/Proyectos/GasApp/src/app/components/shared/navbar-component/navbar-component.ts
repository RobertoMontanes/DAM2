import { Component } from '@angular/core';
import { Router, RouterLink } from "@angular/router";

@Component({
  selector: 'app-navbar-component',
  imports: [RouterLink],
  templateUrl: './navbar-component.html',
  styleUrl: './navbar-component.css',
})
export class NavbarComponent {

  webPart = "";

  constructor(private router:Router) {
    if (this.router.url.includes("provincias")) {
      this.webPart = "provincias";
    } else {
      this.webPart = ""
    }
  }

}
