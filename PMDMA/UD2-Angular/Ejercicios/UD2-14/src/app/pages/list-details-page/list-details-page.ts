import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ListDetails } from '../../interfaces/lists-details-interface';
import { ListsService } from '../../services/lists-service';
import { DatePipe, UpperCasePipe } from '@angular/common';

@Component({
  selector: 'app-list-details-page',
  imports: [DatePipe, UpperCasePipe],
  templateUrl: './list-details-page.html',
  styleUrl: './list-details-page.css',
})
export class ListDetailsPage implements OnInit {

  listId: string = "";
  lista: ListDetails = {} as ListDetails;

  constructor(private activatedRoute: ActivatedRoute, private service: ListsService){
    this.listId = this.activatedRoute.snapshot.paramMap.get('id') || "";
  }

  ngOnInit(): void {
    this.service.getListDetails(this.listId).subscribe(r => {
      this.lista = r;
      console.log(this.lista);
      
    });
  }





}
