package myjson.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

/**
 * @JsonIgnore: https://medium.com/@bhanuchaddha/using-jsonignore-or-jsonproperty-to-hide-sensitive-data-in-json-response-ad12b1aacbf3
 * @JsonIgnoreProperties:
 * @JsonIgnoreType: at class level
 * @JsonAutoDetect: // TODO: 18/11/2019  
 *
 */
public class ReadAndWriteAnnotation {

    private static File loanFile = new File("src/main/resources/loan.json");

    public static void main( String[] args ) throws IOException {
        ObjectMapper objectMapper  = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        marshalingOpertaion(objectMapper);
    }

    /**
     * @JsonIgnore on fields will ignore the field when marshaling or unmarshaling the object/document.
     * @JsonIgnore could be used on the getter or the setter to customize the default behaviour.
     *
     * @JsonIgnoreProperties annotation at a class level -->@JsonIgnoreProperties(value = {"field1", "field2"})
     */
    private static void marshalingOpertaion( ObjectMapper objectMapper ) throws IOException {
        AnnotatedLoan annotatedLoan = objectMapper.readValue(loanFile, AnnotatedLoan.class);
        System.out.println("annotatedLoan = " + annotatedLoan);
    }


}
