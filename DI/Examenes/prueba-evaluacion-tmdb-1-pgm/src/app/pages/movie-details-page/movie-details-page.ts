import { Component, OnInit } from '@angular/core';
import { Movie } from '../../interfaces/movie-list-response-interface';
import { MovieService } from '../../services/movie-service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MovieDetails } from '../../interfaces/movie-details-response-interface';
import { Video } from '../../interfaces/video-list-response';

@Component({
  selector: 'app-movie-details-page',
  imports: [RouterLink],
  templateUrl: './movie-details-page.html',
  styleUrl: './movie-details-page.css',
})
export class MovieDetailsPage implements OnInit {

  movieID: number = 0
  movie: MovieDetails | null = null
  videos: Video[] = []

  constructor(private service:MovieService, private route: ActivatedRoute) {

  }

  obtenerDetalles() {
    this.service.getDetailMovies(this.movieID).subscribe(r => {
      this.movie = r;
      console.log(this.movie);
    })
  }

  obtenerVideos() {
    this.service.getMovieVideos(this.movieID).subscribe( r => {
      this.videos = this.videos.concat(r.results)
    })
  }

  ngOnInit(): void {
        this.movieID = Number(this.route.snapshot.paramMap.get('id'));
    this.obtenerDetalles()
    this.obtenerVideos()
  }

  urlMethod(key:string, site:string) {
    if (site == "YouTube" ) {
      console.log(key);
      return `https://www.youtube.com/embed/${key}`
    } else {
      return `https://player.vimeo.com/video/${key}`
    }
  }

}
