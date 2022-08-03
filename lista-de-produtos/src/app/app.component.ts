import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Fabricante } from './fabricante';
import { Produtos } from './produtos';
import { ProdutosService } from './produtos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'lista-de-produtos';
//form: FormGroup;
produtoService: ProdutosService
listaDeProdutos: Produtos[] = []
constructor( produtoService: ProdutosService){
   // this.form = formGroup.group()
   this.produtoService=produtoService
  }
  
  update:Produtos =   {    id: 0,    nomeDoProduto:"",    nomeDoFabricante: "",    categoria:"",    preco: 0
};

updateLinha(elemento: Produtos){
  this.update = elemento
}
  ngOnInit(): void {
    this.getLista()
  }

  getLista(){
    this.produtoService.getProdutos().subscribe({next: produtos => {console.log(produtos); this.listaDeProdutos = produtos}})
  }
  //listaDeProdutos =
  // [
  //   {
  //     id: 1,
  //     nomeDoProduto: "Nescau",
  //     nomeDoFabricante: "Nestle",
  //     categoria: "Achocolatado",
  //     preco: 7.00
  //   },
  //   {
  //     id: 2,
  //     nomeDoProduto: "Toddy",
  //     nomeDoFabricante: "PepsiCo",
  //     categoria: "Achocolatado",
  //     preco: 4.00
  //   }
  // ]

  listaDeFabricantes = [
    {
      id: 1,
      nome: "Nestle",
      categoria1: "Achocolatado",
      categoria2: "Barra de Chocolate",
      categoria3: "Bombom"
    },
    {
      id: 2,
      nome:"PepsiCo",
      categoria1: "Achocolatado",
      categoria2: "Refrigerante",
      categoria3: "Suco"
    }
  ]

}
