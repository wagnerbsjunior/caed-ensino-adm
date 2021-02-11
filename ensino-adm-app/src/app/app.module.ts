import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component'
import { CadastrosModule } from './cadastros/cadastros.module';

import { DateValueAccessorModule } from 'angular-date-value-accessor';
import { NgxMaskModule, IConfig } from 'ngx-mask';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    DateValueAccessorModule,
    NgxMaskModule.forRoot(),
    TemplateModule,
    CadastrosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
