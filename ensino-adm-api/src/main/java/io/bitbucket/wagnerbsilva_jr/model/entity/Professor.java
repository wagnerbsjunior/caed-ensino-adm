package io.bitbucket.wagnerbsilva_jr.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

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


    //--Método para calcular a idade da pessoa
    private Integer calcIdade (String nascimento){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNascInput = null;

        try {
            dataNascInput= sdf.parse(nascimento);
        } catch (Exception e) {}

        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNascInput);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, idade);

        if (today.before(dateOfBirth)) {
            idade--;
        }
        return idade;
    }

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
