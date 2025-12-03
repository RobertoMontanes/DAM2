import { Component, OnInit } from '@angular/core';
import { Movie } from '../../interfaces/movie-list-response-interface';
import { MovieService } from '../../services/movie-service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MovieDetails } from '../../interfaces/movie-details-response-interface';
import { Video } from '../../interfaces/video-list-response';
import { DomSanitizer } from '@angular/platform-browser';

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

  constructor(private service:MovieService, private route: ActivatedRoute, private sanitazer:  DomSanitizer) {

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

  urlMethod(key:string, site:string) {nvnvnvvnvvbncvgcgcgchgchgcgcgcgcgchgcgcgcgccgcfgfgccc
    if (site == "YouTube" ) {
      console.log(key);
      return this.sanitazer.bypassSecurityTrustResourceUrl(`https://www.youtube.com/embed/${key}`)
    } else {
      return this.sanitazer.bypassSecurityTrustResourceUrl(`https://player.vimeo.com/video/${key}`)
    }
  }

}
