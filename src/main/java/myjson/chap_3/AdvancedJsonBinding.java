package myjson.chap_3;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class AdvancedJsonBinding {

    private static File loanFile = new File("src/main/resources/loan.json");

    public static void main( String[] args ) throws IOException {

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        ImmutableLoan annotatedLoan = mapper.readValue(loanFile, ImmutableLoan.class);
        System.out.println("annotatedLoan = \n" + annotatedLoan);
    }
}
