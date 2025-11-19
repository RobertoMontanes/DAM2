import { Component, OnInit } from '@angular/core';
import { Genre } from '../../interfaces/genre-list-response';
import { GenreService } from '../../services/genre-service';

@Component({
  selector: 'app-select-genre-page',
  imports: [],
  templateUrl: './select-genre-page.html',
  styleUrl: './select-genre-page.css',
})
export class SelectGenrePage implements OnInit {

  genreList: Genre[] = []

  constructor(private genreService: GenreService) {}

  ngOnInit(): void {
    this.obtenerGeneros()
  }

  obtenerGeneros() {
    this.genreService.getGeneros().subscribe(r => {
      this.genreList = this.genreList.concat(r.genres)
    })
  }



}
