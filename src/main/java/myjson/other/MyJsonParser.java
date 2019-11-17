package myjson.other;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.*;

/**
 * Example using:
 *  JsonToken
 *  JsonFactory
 *  JsonParser
 */
public class MyJsonParser {

    public static String loan = "src/main/resources/loan.json";

    public static void main( String[] args ) throws IOException {
        File loanFile = new File(loan);
        //printFile(loanFile);
        System.out.println(loanFile.toString());
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(loanFile);
        //iterateOverTokens(parser);
        lookForSomeSpecificField(parser, "purposeOfLoan");
    }
    // print the file char by char
    private static void printFile( File file ) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int readedByte= 0;
        while ((readedByte = fileInputStream.read())!=-1)
            System.out.println((char)readedByte);
    }

    private static void lookForSomeSpecificField( JsonParser parser, String value ) throws IOException {
        while (!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();
            if (parser.getText().equals(value)){
                jsonToken = parser.nextToken();
                System.out.println("parser.getValueAsString() = " + parser.getValueAsString());
                System.out.println("jsonToken = " + jsonToken);
            }
        }
    }

    private static void iterateOverTokens(JsonParser jsonParser) throws IOException {
        //!jsonParser.isClosed()==true means there is more tokens to read.
        while (!jsonParser.isClosed())
        {
            JsonToken jsonToken = jsonParser.nextToken();
            System.out.println("jsonToken = " + jsonToken);
        }
    }
}
