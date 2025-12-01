import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestTokenResponse } from '../interfaces/request-token-interface';
import { SessionIdInterface } from '../interfaces/session-id-interface';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {

  constructor(private http: HttpClient) {}

  generateRequestToken(): Observable<RequestTokenResponse> {
    return this.http.get<RequestTokenResponse>("https://api.themoviedb.org/3/authentication/token/new");
  }

  generateSessionId(requestToken: string): Observable<SessionIdInterface> {
    return this.http.post<SessionIdInterface>("https://api.themoviedb.org/3/authentication/session/new", {
      request_token: requestToken
    });
  }
  
}
