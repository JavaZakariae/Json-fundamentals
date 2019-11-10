package myjson.chap_3;

import com.fasterxml.jackson.annotation.JsonProperty;
import myjson.commun.Job;
import myjson.commun.LoanDetails;

import java.util.List;

public class AnnotatedLoan {

    private String name;
    private String purposeOfLoan;

    @JsonProperty("details")
    private LoanDetails loanDetails;
    private List<Job> jobs;

    public AnnotatedLoan() {}

    public AnnotatedLoan( String name, String purposeOfLoan, LoanDetails loanDetails, List<Job> jobs ) {
        this.name = name;
        this.purposeOfLoan = purposeOfLoan;
        this.loanDetails = loanDetails;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan( String purposeOfLoan ) {
        this.purposeOfLoan = purposeOfLoan;
    }

    public LoanDetails getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails( LoanDetails loanDetails ) {
        this.loanDetails = loanDetails;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs( List<Job> jobs ) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "name='" + name + '\'' +
                ", purposeOfLoan='" + purposeOfLoan + '\'' +
                ", loanDetails=" + loanDetails +
                ", jobs=" + jobs +
                '}';
    }
}
