import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fabricante } from './fabricante';

@Injectable({
  providedIn: 'root'
})
export class FabricanteService {

  url="http://localhost:8080/manufacturer"
  httpClient!: HttpClient
  constructor(http: HttpClient) { 
    this.httpClient = http 
  }

  getFabricante(){
    return (this.httpClient.get<Fabricante[]>(this.url+"/list"))  
  }
  saveFabricante(fabricante:Fabricante){
    return this.httpClient.post<Fabricante>(this.url+"/add", fabricante )
  }

}
