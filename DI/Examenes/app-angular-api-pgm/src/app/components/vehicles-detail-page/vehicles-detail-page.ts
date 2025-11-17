import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { VehicleDetail } from '../../interfaces/vehicle-details-response-interface';
import { VehiclesService } from '../../services/vehicles.service';

@Component({
  selector: 'app-vehicles-detail-page',
  imports: [RouterLink],
  templateUrl: './vehicles-detail-page.html',
  styleUrl: './vehicles-detail-page.css',
})
export class VehiclesDetailPage implements OnInit {

  vehicle: VehicleDetail|null = null
  vehicleId: number = 0;
  private route = inject(ActivatedRoute);

  constructor(private apiService: VehiclesService) {
        this.vehicleId = Number(this.route.snapshot.paramMap.get('id'));
  }

  obtenerVehiculo() {
    this.apiService.obtenerDetalles(this.vehicleId).subscribe(r => {
      this.vehicle = r
    })
  }

  ngOnInit(): void {
      this.obtenerVehiculo()
    
  }


}
