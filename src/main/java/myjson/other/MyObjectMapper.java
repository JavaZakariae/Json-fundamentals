package myjson.other;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import myjson.commun.Job;
import myjson.commun.LoanDetails;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *  Utility of the two methods:
 *  ObjectMapper readValue,
 *  ObjectMapper writeValue,
 *
 *  Simplest way to parse json with jackson. ObjectMapper can parse json from stream, String or a File.
 *  ObjectMapper can also create Java object or JsonNode(node representation) from json.
 *
 *
 *
 */
public class MyObjectMapper {

    private static File loanFile = new File("src/main/resources/loan.json");
    private static File loanArrayFile = new File("src/main/resources/loanArrayFile.json");
    private static File resultFile = new File("src/main/resources/resultLoanFile.json");

    public static void main( String[] args ) throws IOException {
        AnnotatedLoan loan = new AnnotatedLoan.LoanBuilder()
                                              .withName("bouali zakariae")
                                              .withPurposeOfLoan("to buy a house")
                                              .withLoanDetails(new LoanDetails(2500, LocalDate.of(2020,01,30),
                                                                                           LocalDate.of(2040,01,30)))
                                              .withJobs(List.of(new Job("delhaize", 500, 5),
                                                                new Job("Mainsys", 2000, 5)))
                                              .build();

        //  System.out.println("loan = " + loan);
        //  String json = writeJsonFile(loan);
        //  System.out.println("json = " + json);


        // AnnotatedLoan annotatedLoan = readJsonFile(loanFile);
        // System.out.println("annotatedLoan = " + annotatedLoan);

        //AnnotatedLoan arraysOfLoan = readJsonFile(loanArrayFile);
        //System.out.println("annotatedLoan = " + Arrays.asList(arraysOfLoan));

        writeJsonFile(loan, resultFile);
    }

    /**
     * Create java object from a json file.
     *
     * if the attribute name loanDetails is not the same as
     *  the element details is the json document we will get an exception.
     *  to resolve this, we should use the JsonProperty annotation on ths specified field.
     */
    private static AnnotatedLoan readJsonFile( File loanFile ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        AnnotatedLoan loan = objectMapper.readValue(loanFile, AnnotatedLoan.class);
        return loan;
    }


    /**
     * ObjectMapper used to write json document from a java object
     * ObjectWriter used to print the json document in a good shape.
     */
    private static String getJsonStringFromObject( AnnotatedLoan loan ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String jsonLoan = objectWriter.writeValueAsString(loan);
        return jsonLoan;
    }


    /**
     * // TODO: 12/11/2019
     * repair the error
     *
     */
    private static AnnotatedLoan [] readArray(File loanArrayFile) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        AnnotatedLoan [] arrayOfLoan = objectMapper.readValue(loanArrayFile,AnnotatedLoan[].class);
        return arrayOfLoan;
    }

    /**
     * // TODO: 12/11/2019 choosing only some attributes to serialize,
     *      like only the year and month fo the LocalDate
     */
    private static void writeJsonFile( AnnotatedLoan loan, File file ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(file, loan);
    }
}

