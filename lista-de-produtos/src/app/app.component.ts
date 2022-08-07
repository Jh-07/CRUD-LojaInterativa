import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Fabricante } from './fabricante';
import { FabricanteService } from './fabricante.service';
import { Produtos } from './produtos';
import { ProdutosService } from './produtos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'lista-de-produtos';

formBuilder: FormBuilder;
formularioFabricante!: FormGroup;
formularioProduto!: FormGroup;
formularioModal!: FormGroup ;

produtoService: ProdutosService
fabricanteService: FabricanteService

listaDeProdutos: Produtos[] = []
listaTemporaria: Produtos[] = []
listaDeFabricantes: Fabricante[] = []

itemDeProcura!: string
fabricanteValor: string = ""


update:Produtos =   {id: 0,    nomeDoProduto:"",    nomeDoFabricante: "",    categoria:"",    preco: 0};
fabricanteAux?: Fabricante;
fabricanteAux2?: Fabricante;

constructor( produtoService: ProdutosService, fabricanteService: FabricanteService,  formBuilder: FormBuilder){
  this.formBuilder = formBuilder
  this.produtoService=produtoService
  this.fabricanteService =fabricanteService
   
  }
  
  
  //Métodos


  
  criarFormluarios(){
    this.formularioFabricante = this.formBuilder.group({
      nomeDoFabricante: [null,Validators.required],
      categoria1:[null,Validators.required],
      categoria2:[null,Validators.required],
      categoria3:[null,Validators.required]
    })
    
    this.formularioProduto = this.formBuilder.group({
      nomeDoProduto: ['', Validators.required],
      nomeDoFabricante: ['', Validators.required],
      categoria:['', Validators.required],
      preco:['', Validators.required],
    })

    this.formularioModal = this.formBuilder.group({
       id: [''],
      nomeDoProduto: ['', Validators.required],
      nomeDoFabricante: ['', Validators.required],
      categoria:['', Validators.required],
      preco:['', Validators.required],
    })

    }
  
  ngOnInit(): void {
    this.getListaDeProdutos()
    this.getFabricantes()
    this.criarFormluarios()
    
  }
  
  getListaDeProdutos(){
    this.produtoService.getProdutos().subscribe({next: produtos => {
      console.log(produtos); 
      this.listaDeProdutos = produtos; 
      this.listaTemporaria =this.listaDeProdutos;
      console.log(this.listaTemporaria," aqui")}})
  }

  
  
  getFabricantes(){
    this.fabricanteService.getFabricante().subscribe({next: fabricantes => {console.log(fabricantes); this.listaDeFabricantes =  fabricantes}})
    
  }    

  
  chamaModal(elemento: Produtos){
    this.update = elemento
    console.log(this.update)
    this.formularioModal.patchValue({
      id: elemento.id ,
      nomeDoProduto: elemento.nomeDoProduto,
      nomeDoFabricante: elemento.nomeDoFabricante,
      categoria: elemento.categoria,
      preco: elemento.preco
    })

  }
  
  procurarItems(){
    if (!this.itemDeProcura){ this.listaTemporaria = this.listaDeProdutos;
      return this.listaTemporaria 
    }
    
    let nome = this.itemDeProcura
    this.listaTemporaria = this.listaDeProdutos.filter((produto) =>{return produto.nomeDoProduto.includes(nome)} )
    
    return this.listaTemporaria
  }

  procurarFabricante(){
    if(!this.fabricanteValor){return}
    let nome = this.fabricanteValor
    this.listaDeFabricantes.find((fabricante)=>{
      if (fabricante.nomeDoFabricante == nome) this.fabricanteAux = fabricante
    })
  }
  procurarFabricante2(){
    if(!this.update.nomeDoFabricante){return}
    let nome = this.update.nomeDoFabricante
    this.listaDeFabricantes.find((fabricante)=>{
      if (fabricante.nomeDoFabricante == nome) this.fabricanteAux2 = fabricante
    })
  }
  
  
  //Submits
  
  deletarProduto(id: number){
    this.produtoService.deleteProdutosById(id).subscribe({
      next: () => {this.getListaDeProdutos(); console.log(this.listaTemporaria,"deletado")}
    });
    
    
  }
  
  onSubmitModal(){
    console.log(this.formularioModal.value, "chamou aqui modal")
    this.produtoService.updateProdutos(this.formularioModal.value).subscribe({
      next: () => {this.getListaDeProdutos()}
    })
    
  }

  onSubmitFabricante(){
    console.log(this.formularioFabricante.value,"chamou aqui fabricante")
    this.fabricanteService.saveFabricante(this.formularioFabricante.value).subscribe({next: ()=>{this.getFabricantes(); console.log(this.listaDeFabricantes)}})
  }

  onSubmitProduto(){
    this.produtoService.saveProdutos(this.formularioProduto.value).subscribe({
      next: () => {this.getListaDeProdutos(); console.log(this.listaDeProdutos)}})
  }
}
