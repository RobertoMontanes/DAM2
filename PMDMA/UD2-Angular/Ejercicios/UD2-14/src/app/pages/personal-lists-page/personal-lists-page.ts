import { Component, OnInit } from '@angular/core';
import { timeout } from 'rxjs';
import { AccountService } from '../../services/account-service';
import { AccountList } from '../../interfaces/account-lists-interface';
import { ListaObjectComponent } from "../../components/lista-object-component/lista-object-component";
import { Route, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-personal-lists-page',
  imports: [ListaObjectComponent],
  templateUrl: './personal-lists-page.html',
  styleUrl: './personal-lists-page.css',
})
export class PersonalListsPage implements OnInit {
  loading = true;
  error = false;
  session_id = localStorage.getItem('session_id');

  listData: AccountList[] = []; // Adjust type as needed

  constructor(private service: AccountService, private router: Router) {}

  ngOnInit(): void {
    this.checkSession();
  }

  getUserId() {
    this.service.getAccountDetails(this.session_id!).subscribe(r => {
      console.log("User ID:", r.id);
      localStorage.setItem('user_id', r.id.toString());
      this.getLists();
    });
  }

  getLists() {
    const userId = localStorage.getItem('user_id');
    this.service.getAccountLists(userId!).subscribe(r => {
      this.loading = false;
      this.listData = r.results
      console.log("Listas cargadas: " + this.listData.length);
      
    });
  }

  checkSession() {
    if (this.session_id) {
      this.loading = false;
      this.getUserId();
    } else {
      setTimeout(() => {
        
        if (localStorage.getItem('timesController') === null) {
          localStorage.setItem('timesController', '0');
        }

        if (parseInt(localStorage.getItem('timesController')!) > 5) {
          this.error = true;
        } else {
          localStorage.setItem('timesController', (parseInt(localStorage.getItem('timesController')!) + 1).toString());
          window.location.reload();
        }
      }, 5000);
    }
  }

  cerrarSesion() {
    this.router.navigate(['/home']);
  }


}
