import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication-service';
import { windowWhen } from 'rxjs';

@Component({
  selector: 'app-auth-page',
  imports: [],
  templateUrl: './auth-page.html',
  styleUrl: './auth-page.css',
})
export class AuthPage implements OnInit {

  constructor(private service: AuthenticationService) {}

  ngOnInit(): void {
    console.log('Auth Page Loaded');
    localStorage.getItem('request_token');  
    this.service.generateSessionId(localStorage.getItem('request_token')!).subscribe(r => {
      localStorage.setItem('session_id', r.session_id);
      window.close();
    });
    
  }



}
