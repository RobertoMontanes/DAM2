import { Component, input } from '@angular/core';
import { MovieService } from '../../services/movie-service';
import { Movie } from '../../interfaces/movie-response-interface';

@Component({
  selector: 'app-movie-popular-list-component',
  imports: [],
  templateUrl: './movie-popular-list-component.html',
  styleUrl: './movie-popular-list-component.css',
})
export class MoviePopularListComponent {

    movieList: Movie[] = [];
    shownMovies: Movie[] = [];
    internalPage = 0;
    // internalLimit = input(4);
    internalLimit = 4;
  
    constructor(private service: MovieService) {}

    changeLimit(value: any) {  
      if (value == "all") {
          this.shownMovies = []
          this.shownMovies = this.shownMovies.concat(this.movieList)
      } else {
          this.internalLimit = Number(value);
          this.limitList()
        }
    }
  
    getPopularMovies(){
      this.service.getPopularMovies().subscribe(r => {
        this.movieList = this.movieList.concat(r.results);
        console.log(this.movieList);
        
        this.limitList();
      });
    }
  
    limitList() {
      this.shownMovies = []
      for (let index = 0; index < this.internalLimit; index++) {      
        let operator = this.internalPage == 0 ? index : this.internalPage * this.internalLimit + index;
        console.log(operator);
        this.shownMovies.push(this.movieList[operator]!);
      }    
    }
  
    ngOnInit(): void {
      this.getPopularMovies()
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
