import { Component, inject, OnInit, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../../services/movie-service';
import { MovieDetailsResponse } from '../../interfaces/movie-details-response';
import { NavbarComponent } from "../../components/navbar-component/navbar-component";
import { CurrencyPipe, DatePipe, NgClass, UpperCasePipe } from '@angular/common';

@Component({
  selector: 'app-movie-details-page',
  imports: [NavbarComponent, DatePipe, NgClass, UpperCasePipe, CurrencyPipe],
  templateUrl: './movie-details-page.html',
  styleUrl: './movie-details-page.css',
})
export class MovieDetailsPage implements OnInit {

  movieId = 0;
  movieDetails: MovieDetailsResponse | null = null
  activatedRoute = inject(ActivatedRoute);

  constructor(private movieService: MovieService) {
      this.activatedRoute.params.subscribe((params) => {
        this.movieId = (params['id']);
      });
  }

  ngOnInit(): void {
    this.obtenerDetalles();
  }

  obtenerDetalles() {
    this.movieService.getMovieDetails(this.movieId).subscribe(r => {
      this.movieDetails = r;
    });
  }


}
