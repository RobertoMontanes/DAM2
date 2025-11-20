import { Component, OnInit } from '@angular/core';
import { Genre } from '../../interfaces/genre-list-response';
import { Movie } from '../../interfaces/movie-list-response';
import { GenresService } from '../../services/genres-service';
import { DiscoverService } from '../../services/discover-service';
import { TvDiscoverResponse, TvShow } from '../../interfaces/tv-discover-response';

@Component({
  selector: 'app-movie-discover-page',
  imports: [],
  templateUrl: './movie-discover-page.html',
  styleUrl: './movie-discover-page.css',
})
export class MovieDiscoverPage implements OnInit {

  constructor(private genreService: GenresService, private discoverService: DiscoverService) {}

  actualKind = "movie";
  actualPage = 1;
  actualGenre: String = "";

  genreList: Genre[] = [];
  movieList: Movie[] = [];
  tvShowList: TvShow[] = [];

  loadEverything() {
    this.getGenres()
    this.getDiscover()
  }

  ngOnInit(): void {
    this.loadEverything()
  }

  getGenres() {
    this.genreService.getGenres(this.actualKind).subscribe(r => {
      this.genreList = r.genres;
    })
  }

  getDiscover(genreID:String="") {
      if (this.actualKind == "movie") {

        this.discoverService.getMovies(this.actualPage,genreID).subscribe(r => {
          if(this.actualPage != 1) {
            this.movieList = this.movieList.concat(r.results);
          } else {
            this.movieList = r.results
          }
        })

      } else {

        this.discoverService.getTvShow(this.actualPage,genreID).subscribe(r => {
            if(this.actualPage != 1) {
            this.tvShowList = this.tvShowList.concat(r.results);
          } else {
            this.tvShowList = r.results
          }
        })

      }
  }

  changeGenre(idGenre:number) {
    this.actualGenre = String(idGenre);
    this.getDiscover(this.actualGenre)
    console.log("Changing genre...");
  }

  changeKind() {
    this.actualKind = this.actualKind == "movie" ? "tv" : "movie";
    this.actualPage = 1;
    this.loadEverything()
  }

  nextPage() {
    this.actualPage = this.actualPage + 1;
    this.getDiscover(this.actualGenre);
    
  }

}
