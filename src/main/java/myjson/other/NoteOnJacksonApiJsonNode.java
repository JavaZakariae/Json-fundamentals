package myjson.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 *  Jackson can read json to jsonNode tree data structure.
 *  and  from jsonNode to json document.
 *
 *
 *  // TODO: 14/11/2019
 *  Convert JsonNode Field
 *  example : String f2Str = jsonNode.get("f2").asText();
 *            double f2Dbl = jsonNode.get("f2").asDouble();
 *            String f2Str = jsonNode.get("f2").asText("defaultValue");
 *  Handling Null Field Values
 *  Iterate JsonNode Fields
 *
 */
public class NoteOnJacksonApiJsonNode {

    private static File loanFile = new File("src/main/resources/loan.json");


    public static void main( String[] args ) throws IOException {
        JsonNode jsonNode = jsonNodeFromJsonDocument(loanFile);
        /*String jsonFieldUsingAtMethod = getJsonFieldUsingAtMethod(jsonNode, "/jobs/0/title");
        System.out.println("jsonFieldUsingAtMethod = " + jsonFieldUsingAtMethod);*/


    }

    static JsonNode jsonNodeFromJsonDocument( File loan) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(loan);
        return jsonNode;
    }

    static String  jsonDocumentFromJsonNode(JsonNode jsonNode) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonNode);
    }

    static String getJsonField(JsonNode jsonNode, String field){
        final JsonNode node = jsonNode.get(field);
        return node.toString();
    }

    // path -> "/jobs/0/title"
    static String getJsonFieldUsingAtMethod(JsonNode jsonNode, String path){
        final JsonNode node = jsonNode.at(path);
        return node.toString();
    }
}
