import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication-service';

@Component({
  selector: 'app-home-page',
  imports: [],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit {

  constructor(private service: AuthenticationService) {}

  ngOnInit(): void {
    localStorage.removeItem('request_token');
    localStorage.removeItem('session_id');
    localStorage.removeItem('user_id');
    localStorage.removeItem('timesController');
  }

  logIn() {
    console.log('Log In button clicked');

    this.service.generateRequestToken().subscribe(r => {
      console.log("Request obtenida: " + r.request_token);
      localStorage.setItem('request_token', r.request_token);
      window.open(`https://www.themoviedb.org/authenticate/${r.request_token}?redirect_to=http://localhost:4200/moviedb/auth`, '_blank', 'width=500, height=300');
      window.location.href = 'http://localhost:4200/lists';
    });
  }

}
