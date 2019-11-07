package myjson.chap_2;

import myjson.commun.Loan;

/**
 * Manual Json Parsing
 *
 *  Producing JSON Demo
 */
public class ManualJsonParsing {

    public static void main( String[] args ) {
        //toJson(myjson.chap_2.JsonRunner.getLoan());
    }

    /**
     * manual operation to create a json object representation
     * As we can see, it is hard to create manually an object
     * json from a java class object
     *
     * @param loan
     */
    private static void toJson(Loan loan){
        System.out.println("ToString");
        System.out.println(loan);
        System.out.println("jsonPresentation");

        final String json = String.format("{\n" +
                        "\"name\":\"%s\",\n" +
                        "\"purposeofloan\":\"%s\",\n" +
                        "\"details\":\"%s\",\n" +
                        "\"jobs\":\"%s\",\n" +
                        "}",
                loan.getName(),
                loan.getPurposeOfLoan(),
                loan.getLoanDetails(),
                loan.getJobs());
        System.out.println("loan json object = " + json);
    }

}
