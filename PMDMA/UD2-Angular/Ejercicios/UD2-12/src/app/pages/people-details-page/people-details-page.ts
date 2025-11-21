import { Component, inject, OnInit } from '@angular/core';
import { PeopleService } from '../../services/people-service';
import { ActivatedRoute } from '@angular/router';
import { Person } from '../../interfaces/people-list-response';
import { PeopleDetailsResponse } from '../../interfaces/people-details-response';
import { NavbarComponent } from "../../components/navbar-component/navbar-component";
import { DatePipe, NgClass } from '@angular/common';

@Component({
  selector: 'app-people-details-page',
  imports: [NavbarComponent, NgClass, DatePipe],
  templateUrl: './people-details-page.html',
  styleUrl: './people-details-page.css',
})
export class PeopleDetailsPage implements OnInit{

    peopleId:number = 0;
    activatedRoute = inject(ActivatedRoute);
    person: PeopleDetailsResponse | null = null;

    constructor(private peopleService: PeopleService) {
        this.activatedRoute.params.subscribe((params) => {
          this.peopleId = (params['id']);
        });
    }

    obtenerDetalles() {
      this.peopleService.getPeopleDetails(this.peopleId).subscribe(r => {
        this.person = r;
      })
    }

    ngOnInit(): void {
      this.obtenerDetalles()
    }
}
