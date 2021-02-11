import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { CadastrosModule } from '../cadastros/cadastros.module';
import { RelatoriosModule } from '../relatorios/relatorios.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    CadastrosModule,
    RelatoriosModule
  ],
  exports: [
    NavbarComponent,
    SidebarComponent
  ]
  
})
export class TemplateModule { }
