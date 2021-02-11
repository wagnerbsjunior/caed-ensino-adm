package io.bitbucket.wagnerbsilva_jr.model.entity;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Pessoa{

    //--Método para calcular a idade da pessoa
    protected Integer calcIdade (String nascimento){
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

}
