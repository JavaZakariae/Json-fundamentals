package myjson.chap_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import myjson.commun.Loan;

import java.io.IOException;

/**
 *  creating json object using data binding api
 *  the most easy way
 */
public class JsonBindingApi {
    public static void main( String[] args ) throws IOException {
        toJson(JsonRunner.getLoan());
    }

    private static void toJson( Loan loan ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        //writer.writeValue(System.out, loan);
        String json = writer.writeValueAsString(loan);
        System.out.println("json = " + json);
    }
}

