package myjson.chap_3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 *Consuming Json with a DOM API chapter.
 *
 * Document object Model:
 * Api for describing the logical structure of a json
 * document. Represents a json document as an object graph.
 * Defines how to access and manipulate the document.
 */
public class DomApiConsumer {
    private static File loanFile = new File("src/main/resources/loan.json");

    public static void main( String[] args ) throws IOException {
        System.out.println("loanFile.exists() = " + loanFile.exists());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(loanFile);
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(jsonNode));
        //System.out.println("jsonNode = " + jsonNode);
        exploreNode(jsonNode);

    }

    private static void exploreNode( JsonNode jsonNode ) {
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while (fields.hasNext()){
            Map.Entry<String, JsonNode> entry = fields.next();
            System.out.println(entry.getKey());
            exploreNode(entry.getValue());
        }
    }
}
