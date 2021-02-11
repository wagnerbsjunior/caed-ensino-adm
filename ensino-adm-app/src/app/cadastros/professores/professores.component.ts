import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Professor } from '../professor';
import { CadProfessoresService } from '../cad-professores.service';
import { param } from 'jquery';

@Component({
  selector: 'app-professores',
  templateUrl: './professores.component.html',
  styleUrls: ['./professores.component.css']
})
export class ProfessoresComponent implements OnInit {

  professor: Professor;
  success: boolean = false;
  errors: String[] = [];
  id: number = 0;
  cpf_cnpj: String = "";

  constructor( 
     private service: CadProfessoresService,
     private router: Router,
     private activatedRoute: ActivatedRoute 
     ) { 
    this.professor = new Professor;
  }

  ngOnInit(): void {    
    /*let params = this.activatedRoute.snapshot.params;
    
    if(params && params.value && params.value.id){ 
      this.id = params.value.id;
    }*/

    let params = this.activatedRoute.params;
     params.forEach( value =>{
      if(value.id){
        this.id = value.id;
        this.service
        .getProfessoresById(this.id)
        .subscribe(
          response => this.professor = response,
          errorResponse => this.professor = new Professor()
        )
      }
    });
  }

  voltarParaListagem(){
    this.router.navigate(['/cadastros/professores-lista'])
  }

  onSubmit(){
    //console.log(this.professor);
    if(this.id){
      this.service
        .atualizar(this.professor)
        .subscribe(response =>{
          this.success = true;
            this.errors = [];            
        }, errorResponse => {
          this.errors = ['Erro ao atualizar cadastro']
        })

    }else{
    this.service
      .salvar(this.professor)
      .subscribe( response => {
        //console.log(response)
        this.success = true;
        this.errors = [];
        this.professor = response;
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;        
        //console.log(errorResponse.error.errors)
      }
      );
    }
  }  

}