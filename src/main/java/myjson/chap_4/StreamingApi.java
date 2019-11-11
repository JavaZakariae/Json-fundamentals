package myjson.chap_4;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

/**
 * the streaming Api is more powerful in term of time consuming than the binding api.
 * Binding Api create memory tree to represent the corresponding json document.
 *
 */
public class StreamingApi {

    private static File loanFile = new File("src/main/resources/loan.json");

    public static void main( String[] args ) throws IOException {

        JsonFactory jsonFactory = new JsonFactory();
        try (JsonParser jsonParser = jsonFactory.createParser(loanFile)){
            JsonToken jsonToken;
            while ((jsonToken=jsonParser.nextToken()) != null )
            {
                if (jsonToken.isNumeric()){
                    System.out.println(jsonParser.getCurrentName()+" " + jsonParser.getText());
                }
            }
        }
    }
}
