import { Component } from '@angular/core';
import { MoviePopularListComponent } from "../../components/movie-popular-list-component/movie-popular-list-component";
import { PeoplePopularListComponent } from "../../components/people-popular-list-component/people-popular-list-component";

@Component({
  selector: 'app-home-page-component',
  imports: [MoviePopularListComponent, PeoplePopularListComponent],
  templateUrl: './home-page-component.html',
  styleUrl: './home-page-component.css',
})
export class HomePageComponent {

    internalLimit = 4;

    changeLimit(value: any) {  
        this.internalLimit = Number(value);
    }

}
