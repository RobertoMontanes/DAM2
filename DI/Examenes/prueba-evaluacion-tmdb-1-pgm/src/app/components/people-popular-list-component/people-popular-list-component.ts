import { Component, input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { PeopleService } from '../../services/people-service';
import { People } from '../../interfaces/people-response-interface';

@Component({
  selector: 'app-people-popular-list-component',
  imports: [],
  templateUrl: './people-popular-list-component.html',
  styleUrl: './people-popular-list-component.css',
})
export class PeoplePopularListComponent implements OnInit, OnChanges {

  peopleList: People[] = [];
  shownPeople: People[] = [];
  internalPage = 0;
  internalLimit = input(4);


  constructor(private service: PeopleService) {}

    // changeLimit(value: any) {  
    //   if (value == "all") {
    //       this.shownPeople = []
    //       this.shownPeople = this.shownPeople.concat(this.peopleList)
    //   } else {
    //       this.internalLimit = Number(value);
    //       this.limitList()
    //     }
    // }
  
  getPopularPeople(){
    this.service.getPopularPeople().subscribe(r => {
      this.peopleList = this.peopleList.concat(r.results);
      
      this.limitList();
    });
  }

  limitList() {
    this.shownPeople = []
    

    if(this.internalLimit() == 999) {
      this.shownPeople = this.peopleList
    } else {
      for (let index = 0; index < this.internalLimit(); index++) {      
        let operator = this.internalPage == 0 ? index : this.internalPage * this.internalLimit() + index;
        this.shownPeople.push(this.peopleList[operator]!);
      }
    }   
    

    
  }

  ngOnInit(): void {
    this.getPopularPeople()
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.limitList()
  }

  next() {
    this.internalPage += 1
    this.limitList()
  }
  
  prev() {
    if (this.internalPage != 0) {
      this.internalPage -= 1
      this.limitList()
    }
  }
}
