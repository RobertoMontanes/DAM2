import { Component, OnInit } from '@angular/core';
import { PeopleService } from '../../services/people-service';
import { PeopleListResponse, Person } from '../../interfaces/people-list-response';
import { NavbarComponent } from "../../components/navbar-component/navbar-component";
import { RouterLink } from "@angular/router";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-people-list-page',
  imports: [NavbarComponent, RouterLink,DatePipe],
  templateUrl: './people-list-page.html',
  styleUrl: './people-list-page.css',
})
export class PeopleListPage implements OnInit{

  people: Person[] = []
  actualPage = 1;

  constructor(private peopleService:PeopleService) {}

  ngOnInit(): void {
    this.obtenerPeople()
  }

  obtenerPeople() {
        this.peopleService.getPeople(this.actualPage).subscribe(r => {
          
            if (this.actualPage == 1) {
              this.people = r.results
            } else {
              this.people = this.people.concat(r.results)
            }
    })
  }

  aumentarPagina() {
    this.actualPage += 1;
    this.obtenerPeople()
  }

}
