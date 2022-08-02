import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Produtos } from './produtos';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {
  
  url="http://localhost:8080"
  httpClient: HttpClient

  constructor(http:HttpClient) { 
    this.httpClient=http
  }

  getProdutos(){
    return (this.httpClient.get<Produtos[]>(this.url+"/list"))  
  }

  updateProdutos(produto:Produtos){
    return this.httpClient.put<Produtos>(this.url+"/update", produto)
    
  }

  saveProdutos(produto:Produtos){
    return this.httpClient.post<Produtos>(this.url+"/add", produto )
  }

  deleteProdutosById(id:number){
    return this.httpClient.delete(this.url+"/delete/"+id)
  }
}