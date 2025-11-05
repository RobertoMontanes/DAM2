import { Component, OnInit } from '@angular/core';
import { StarWarsPerson } from '../../interfaces/StarWarsPeopleList-response-interface';  
import { SwService } from '../../services/sw-service';
import { PeopleComponent } from "../people-component/people-component";
@Component({
  selector: 'app-people-list-component',
  imports: [PeopleComponent],
  templateUrl: './people-list-component.html',
  styleUrl: './people-list-component.css',
})
export class PeopleListComponent implements OnInit {

  peopleList: StarWarsPerson[] = [];

  constructor(private swService: SwService){}

  ngOnInit(): void {
    this.swService.getSWPeople().subscribe(res => {
      this.peopleList = res.results;
    })
  }

}
