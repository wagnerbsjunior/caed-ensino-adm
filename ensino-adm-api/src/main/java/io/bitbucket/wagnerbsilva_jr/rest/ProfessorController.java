package io.bitbucket.wagnerbsilva_jr.rest;

import io.bitbucket.wagnerbsilva_jr.model.entity.Professor;
import io.bitbucket.wagnerbsilva_jr.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin("http://localhost:4200")
public class ProfessorController {

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorController(ProfessorRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Professor> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor salvar(@RequestBody @Valid Professor professor ){

        //-- Posteriormente implementar a funcionalidade de verificar professor já existe
        return repository.save(professor);
    }

    @GetMapping("{id}")
    public Professor buscarPorId( @PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){

        repository
                .findById(id)
                .map( professor ->  {
                    repository.delete(professor);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody @Valid Professor professorAtualizado ){
        repository
                .findById(id)
                .map( professor ->  {
                    professor.setNome(professorAtualizado.getNome());
                    professor.setCpf(professorAtualizado.getCpf());
                    professor.setEmail(professorAtualizado.getEmail());
                    professor.setNascimento(professorAtualizado.getNascimento());
                    professor.setSexo(professorAtualizado.getSexo());

                    return repository.save(professor);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
