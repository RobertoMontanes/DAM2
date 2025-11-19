import { Component, OnInit } from '@angular/core';
import { Genre } from '../../interfaces/genre-list-response';
import { GenreService } from '../../services/genre-service';
import { Movie } from '../../interfaces/movie-list-response';
import { MoviesService } from '../../services/movies-service';

@Component({
  selector: 'app-select-genre-page',
  imports: [],
  templateUrl: './select-genre-page.html',
  styleUrl: './select-genre-page.css',
})
export class SelectGenrePage implements OnInit {

  genreList: Genre[] = [];
  movieList: Movie[] = [];

  actualPage: number = 1;
  totalPages: number = 0;
  actualGenre: number = -1
  end = false

  constructor(private genreService: GenreService, private movieService:MoviesService) {}

  ngOnInit(): void {
    this.obtenerGeneros();
    this.obtenerPelis();
  }

  selectGenre(genre: Genre) {
    const titleElement = document.getElementById("titleGenre");
    if (titleElement) {
      titleElement.innerHTML = "Mostrando peliculas de: " + genre.name;
    }
    this.obtenerPelis(String(genre.id));
    this.actualGenre = genre.id
  }

  obtenerGeneros() {
    this.genreService.getGeneros().subscribe(r => {
      this.genreList = this.genreList.concat(r.genres);
    })
  }

  obtenerPelis(genreId: String = "", page = 1) {    
    if (page == 1) {     
      this.movieList = [];
    }

    if (genreId == "") {
      
      this.movieService.getMovies(page).subscribe( r => {
        this.movieList = this.movieList.concat(r.results);
        this.actualPage = r.page
        this.totalPages = r.total_pages
      })
    } else  {      
      this.movieService.getMoviesByGenre(page, genreId).subscribe( r =>{
          console.log(r);
          this.movieList = this.movieList.concat(r.results)
          this.actualPage = r.page
          this.totalPages = r.total_pages
      })
    }
  }

  loadNextPage() {
    let page = this.actualPage + 1    
    
    if (page > this.totalPages) {
      alert("No hay mas peliculas para cargar.");
      this.end = true
    } else {
      let genreID;
      if (this.actualGenre == -1) {
        genreID = ""
      } else {
        genreID = String(this.actualGenre)
      }
      this.obtenerPelis(genreID, page)
    }
  }


}
