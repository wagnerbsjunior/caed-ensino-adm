package io.bitbucket.wagnerbsilva_jr.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.swing.text.DateFormatter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Professor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(nullable = false, length = 10)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.nascimento.obrigatorio}")
    private LocalDate nascimento;

    @Column(nullable = false, length = 1)
    @NotNull(message = "{campo.sexo.obrigatorio}")
    private String sexo;

    @Column(nullable = true, length = 150)
    private String email;

    @Column(nullable = true, updatable = false)
    private Integer idade;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;

    @Column(nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAlteracao;

    /*public Professor(String nome, String cpf, String nascimento, String sexo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = LocalDate.parse(nascimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.sexo = sexo;
        this.email = email;
    }*/

    @PrePersist
    public void prePersist(){
        setDataCriacao(LocalDate.now());

        setIdade(calcIdade(getNascimento().toString()));

    }

    @PreUpdate
    public void preUpdate(){
        setDataAlteracao(LocalDate.now());
    }


}
