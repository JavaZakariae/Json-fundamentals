package myjson.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

/**
 * @JsonSetter
 * @JsonAnySetter
 * @JsonCreator for immutable class.
 * @JacksonInject and @JsonDeserialize // TODO: 18/11/2019  
 */
public class ReadAnnotation {
    private static File loanFile = new File("src/main/resources/loan.json");

    public static void main( String[] args ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ImmutableAnnotatedLoan immutableAnnotatedLoan = immutableAnnotatedLoan(objectMapper);
        System.out.println("immutableAnnotatedLoan = " + immutableAnnotatedLoan);
    }

    private static ImmutableAnnotatedLoan immutableAnnotatedLoan( ObjectMapper objectMapper ) throws IOException {
        ImmutableAnnotatedLoan immutableAnnotatedLoan = objectMapper.readValue(loanFile, ImmutableAnnotatedLoan.class);
        return immutableAnnotatedLoan;
    }

}
