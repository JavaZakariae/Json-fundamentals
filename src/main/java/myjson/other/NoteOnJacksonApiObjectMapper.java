package myjson.other;

/**
 * from {@link http://tutorials.jenkov.com/java-json/jackson-objectmapper.html}
 * Jackson provides 2 Json parsers:
 *    + The Jackson ObjectMapper which parses json into java objects,
 *      or into tree data structure JsonNode.
 *    + The Jackson JsonParser which is a streaming parser that can parse one token at a time.
 *  It contains also two Json Generators:
 *    + The Jackson ObjectMapper that can generate json from java object or from tree data structure.
 *    + The Jackson JsonGenerator which generates Json one token at a time.
 *
 *    [ObjectMapper, JsonNode, JsonParser, JsonGenerator]
 *
 *  Ignore Unknown Json Field when parsing to java object
 *  ObjectMapper.configure(DeserializationFeature.Fail_On_Unknown_Properties, false);
 *
 *  Fail on Null JSON Values for Primitive Types
 *  ObjectMapper.configure(DeserializationFeature.Fail_On_Null_For_Primitives, false);
 *
 *
 *  Write Json From Object:
 *   + ObjectMapper can be sued to generate json from java object.
 *      - writeValue();
 *      - writeValueAsString();
 *      - writeValueAsBytes();
 *
 *
 *  Jackson Tree Model
 *    Jackson has a built-in tree model wich can be used to represent a json bject.
 *    It is useful when we don't know the structure of the json document.
 *      JsonNode is the main class to use for that reason.
 *
 *
 */
public class NoteOnJacksonApiObjectMapper {
}
