package myjson.chap_2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import myjson.commun.Job;
import myjson.commun.Loan;

import java.io.IOException;


/**
 * using generator api to create json object
 * Jackson library
 * even if it is better than the manual handling
 * it also needs some work.
 */
public class GeneratorApi {

    public static void main( String[] args ) throws IOException {
        toJson(JsonRunner.getLoan());
    }

    /**
     * // TODO: 06/11/2019 to be refactored
     * @param loan
     * @throws IOException
     */
    private static void toJson( Loan loan ) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        final JsonGenerator generator = jsonFactory.createGenerator(System.out);

        generator.setPrettyPrinter(new DefaultPrettyPrinter());
        generator.writeStartObject();
        generator.writeStringField("name", loan.getName());
        generator.writeStringField("purpose", loan.getPurposeOfLoan());

        generator.writeFieldName("details");
        generator.writeStartObject();
        generator.writeNumberField("amount", loan.getLoanDetails().getAmount());
        generator.writeStringField("startDate", loan.getLoanDetails().getStartDate().toString());
        generator.writeStringField("endDate", loan.getLoanDetails().getEndDate().toString());
        generator.writeEndObject();

        generator.writeFieldName("jobs");
        generator.writeStartArray();
        for (Job job: loan.getJobs()) {
            generator.writeStartObject();
            generator.writeStringField("title", job.getTitle());
            generator.writeNumberField("income", job.getIncome());
            generator.writeNumberField("duration", job.getDuration());
            generator.writeEndObject();
        }
        generator.writeEndArray();


        generator.writeEndObject();
        generator.flush();
    }
}
