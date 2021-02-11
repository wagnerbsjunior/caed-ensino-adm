import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfessoresComponent } from './professores/professores.component';
import { CadastrosComponent } from './cadastros.component';
import { CadastrosRoutingModule } from './cadastros-routing.module';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CadProfessoresService } from './cad-professores.service';
import { ProfessoresListaComponent } from './professores-lista/professores-lista.component';



@NgModule({
  declarations: [
    ProfessoresComponent,
    CadastrosComponent,
    ProfessoresListaComponent    
  ],
  imports: [
    CommonModule,
    RouterModule,
    CadastrosRoutingModule,
    FormsModule
  ],
  providers: [
    CadProfessoresService
  ],
  exports:[
    ProfessoresComponent,
    CadastrosComponent
  ]
})
export class CadastrosModule { }
