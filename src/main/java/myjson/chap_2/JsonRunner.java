package myjson.chap_2;

import myjson.commun.Job;
import myjson.commun.Loan;
import myjson.commun.LoanDetails;

import java.time.LocalDate;
import java.util.List;

/**
 *
 */
public class JsonRunner {

    static Loan loan;
    static {
        Job job1 = new Job("delhaize", 500, 5);
        //System.out.println("job1 = " + job1);

        Job job2 = new Job("Mainsys", 2000, 5);
        //System.out.println("job2 = " + job2);


        LoanDetails loanDetails = new LoanDetails(2500, LocalDate.of(2019,04,20),
                LocalDate.of(2029,04,20));
        //System.out.println("loanDetails = " + loanDetails);

        loan = new Loan("Bouali Zakariae", "buying House", loanDetails, List.of(job1, job2));
        //System.out.println("loan = " + loan);
    }

    public static void main( String[] args ) {

    }

    public static Loan getLoan(){
        return loan;
    }


}
