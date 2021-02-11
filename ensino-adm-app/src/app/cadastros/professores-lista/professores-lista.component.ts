import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CadProfessoresService } from '../cad-professores.service';
import { Professor } from '../professor';

@Component({
  selector: 'app-professores-lista',
  templateUrl: './professores-lista.component.html',
  styleUrls: ['./professores-lista.component.css']
})
export class ProfessoresListaComponent implements OnInit {

  professores: Professor[] = [];
  professorSelecionado!: Professor;
  mensagemSucesso: String = "";
  mensagemErro: String = "";
  
  constructor(
    private service: CadProfessoresService, 
    private router: Router) { }

  ngOnInit(): void {    
    //-- Teste inicial de retorno da lista, com dados de testes
    //this.professores = this.service.getProfessores();

    this.service
      .getProfessores()
      .subscribe( response => this.professores = response);
  }

  novoRegistro(){
    this.router.navigate(['/cadastros/professores'])
  }

  preparaDelecao(professor: Professor){
    this.professorSelecionado = professor;
  }

  deletarProfessor(){
    this.service
      .deletar(this.professorSelecionado)
      .subscribe( 
        response => { 
          this.mensagemSucesso = 'Registro deletado com sucesso!'
          this.ngOnInit();
        },   
        erro => this.mensagemSucesso = 'Ocorreu um erro ao deletar o registro.'
       )
  }

}
