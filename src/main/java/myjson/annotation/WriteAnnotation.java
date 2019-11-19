package myjson.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

/**
 *  annotation that influence jackson when writing json from java object.
 * @JsonInclude include properties only if some conditions ar fulfilled.
 * @JsonGetter
 * @JsonAnyGetter
 * @JsonPropertyOrder for specifing the order when jackson serialize the object.
 * @JsonRawValue  @JsonRawValue public String address  = "$#"; --->  {"address":$#}
 * @JsonValue specifying a method that wll be called to serialize the object.
 * @JsonSerialize custome serializer
 *
 */
public class WriteAnnotation {

    private static File loanFile = new File("src/main/resources/loan.json");

    public static void main( String[] args ) throws IOException {
        testJsonInclude(new ObjectMapper());
    }

    private static void testJsonInclude ( ObjectMapper objectMapper ) throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        WriteAnnotatedLoan writeAnnotatedLoan = objectMapper.readValue(loanFile, WriteAnnotatedLoan.class);
        System.out.println("writeAnnotatedLoan = " + writeAnnotatedLoan);
        writeAnnotatedLoan.setJobs(null);
        writeAnnotatedLoan.setLoanDetails(null);

        objectMapper.writerWithDefaultPrettyPrinter();
        objectMapper.writer().writeValue(System.out, writeAnnotatedLoan);
    }
}
