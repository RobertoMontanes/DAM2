import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../services/pokemon-service';
import { Pokemon } from '../../interfaces/pokemon-list-response-interface';

@Component({
  selector: 'app-pokemon-list-component',
  imports: [],
  templateUrl: './pokemon-list-component.html',
  styleUrl: './pokemon-list-component.css',
})
export class PokemonListComponent implements OnInit {

  pokemonList: Pokemon[] = [];

  constructor(private PokemonService: PokemonService) {}

  ngOnInit(): void {
    this.PokemonService.getPokemonList().subscribe(respuesta => {
      this.pokemonList = respuesta.results;
    })
  }

}
