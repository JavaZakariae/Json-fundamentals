package myjson.annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import myjson.commun.Job;
import myjson.commun.LoanDetails;

import java.util.List;
//@JsonIgnoreProperties(value = {"name", "purposeOfLoan"})
//@JsonIgnoreType(value = true)
public class AnnotatedLoan {

    private String name;
    private String purposeOfLoan;
    //@JsonIgnore // TODO: 18/11/2019 why it doesn't work with @JsonProperty
    @JsonProperty("details")
    private LoanDetails loanDetails;
    @JsonIgnore
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
