import { Component, input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { MovieService } from '../../services/movie-service';
import { Movie } from '../../interfaces/movie-list-response-interface';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-movie-popular-list-component',
  imports: [RouterLink],
  templateUrl: './movie-popular-list-component.html',
  styleUrl: './movie-popular-list-component.css',
})
export class MoviePopularListComponent implements OnInit, OnChanges {

    movieList: Movie[] = [];
    shownMovies: Movie[] = [];
    internalPage = 0;
  internalLimit = input(4)  
    constructor(private service: MovieService) {}
  
    getPopularMovies(){
      this.service.getPopularMovies().subscribe(r => {
        this.movieList = this.movieList.concat(r.results);        
        this.limitList();
      });
    }
  
    limitList() {
      this.shownMovies = []
      if(this.internalLimit() == 999) {
        this.shownMovies = this.movieList
      } else {
        for (let index = 0; index < this.internalLimit(); index++) {      
          let operator = this.internalPage == 0 ? index : this.internalPage * this.internalLimit() + index;
          this.shownMovies.push(this.movieList[operator]!);
        }   
      }   
      
    }
  
    ngOnInit(): void {
      this.getPopularMovies()
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
