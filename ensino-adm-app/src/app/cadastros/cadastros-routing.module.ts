import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfessoresListaComponent } from './professores-lista/professores-lista.component';
import { ProfessoresComponent } from './professores/professores.component';

const routes: Routes = [
    { path: 'cadastros/professores' , component: ProfessoresComponent },
    { path: 'cadastros/professores/:id' , component: ProfessoresComponent },
    { path: 'cadastros/professores-lista' , component: ProfessoresListaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastrosRoutingModule { }