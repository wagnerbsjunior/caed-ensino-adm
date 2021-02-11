import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Professor } from './professor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadProfessoresService {

  professores!: Observable<Professor[]>;

  constructor( private http: HttpClient ) {}

  salvar( professor: Professor ) : Observable<Professor> {
    return this.http.post<Professor>('http://localhost:8080/api/professores', professor);
  }

  atualizar( professor: Professor ) : Observable<any> {
    return this.http.put<Professor>(`http://localhost:8080/api/professores/${professor.id}`, professor);
  }

  getProfessores() : Observable<Professor[]> {
    return this.http.get<Professor[]>('http://localhost:8080/api/professores');
  }

  getProfessoresById(id: number) : Observable<Professor>{
    return this.http.get<Professor>(`http://localhost:8080/api/professores/${id}`);
  }

  deletar(professor: Professor) : Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/professores/${professor.id}`);
  }

  /*-- Testes de retorno da lista  */
  /*getProfessores() : Professor[] {
    let professor = new Professor();
    professor.id = 1;
    professor.nome = 'Fulano';
    professor.cpf = '12345678'
    return  [professor];
  }*/
}
