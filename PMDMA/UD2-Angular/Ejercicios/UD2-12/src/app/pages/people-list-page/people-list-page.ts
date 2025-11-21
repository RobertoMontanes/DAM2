import { Component, OnInit } from '@angular/core';
import { PeopleService } from '../../services/people-service';
import { PeopleListResponse, Person } from '../../interfaces/people-list-response';

@Component({
  selector: 'app-people-list-page',
  imports: [],
  templateUrl: './people-list-page.html',
  styleUrl: './people-list-page.css',
})
export class PeopleListPage implements OnInit{

  people: Person[] = []

  constructor(private peopleService:PeopleService) {}

  ngOnInit(): void {
    this.obtenerPeople()
  }

  obtenerPeople(page = 1) {
        this.peopleService.getPeople(page).subscribe(r => {
          console.log(r.results);
          
            if (page == 1) {
              this.people = r.results
            } else {
              this.people = this.people.concat(r.results)
            }
    })
  }

}
