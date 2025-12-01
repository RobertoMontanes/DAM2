import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ListDetails } from '../interfaces/lists-details-interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ListsService {
  
  constructor(private http: HttpClient) {}

  getListDetails(list_id: string): Observable<ListDetails> {
    return this.http.get<ListDetails>(`https://api.themoviedb.org/3/list/${list_id}`);
  }
  
}
