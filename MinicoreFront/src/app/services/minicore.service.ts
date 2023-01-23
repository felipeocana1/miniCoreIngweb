import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const base_url = environment.url;

@Injectable({
  providedIn: 'root'
})
export class MinicoreService {

  constructor(private http: HttpClient) { }

  getClientes(){
    const url = `${base_url}/cliente`;
    return this.http.get(url);
  }

  getContratos(){
    const url = `${base_url}/contratos`;
    return this.http.get(url);
  }

  generarReporte(fechaIni: any, fechaFin:any){
    return this.http.post(`${base_url}/reporte`,{
      fechaIni,fechaFin
    });
  }


}
