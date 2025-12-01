import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountDetailsInterface } from '../interfaces/account-details-interface';
import { Observable } from 'rxjs';
import { AccountListsResponse } from '../interfaces/account-lists-interface';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  
  constructor(private http: HttpClient) {}


  getAccountDetails(session_id: string): Observable<AccountDetailsInterface> {
    return this.http.get<AccountDetailsInterface>("https://api.themoviedb.org/3/account?session_id=" + session_id);
  }

  getAccountLists(account_id: string):Observable<AccountListsResponse> {
    return this.http.get<AccountListsResponse>(`https://api.themoviedb.org/3/account/${account_id}/lists`);
  }
  
}
