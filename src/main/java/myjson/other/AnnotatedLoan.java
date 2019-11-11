package myjson.other;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public AnnotatedLoan( LoanBuilder loanBuilder ) {
        this.name = loanBuilder.name;
        this.purposeOfLoan = loanBuilder.purposeOfLoan;
        this.loanDetails = loanBuilder.loanDetails;
        this.jobs = loanBuilder.jobs;
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

    public static class LoanBuilder{
        private String name;
        private String purposeOfLoan;
        private LoanDetails loanDetails;
        private List<Job> jobs;

        public LoanBuilder() {}

        public LoanBuilder withName( String name){
            this.name=name;
            return this;
        }
        public LoanBuilder withPurposeOfLoan(String purposeOfLoan){
            this.purposeOfLoan=purposeOfLoan;
            return this;
        }
        public LoanBuilder withLoanDetails(LoanDetails loanDetails){
            this.loanDetails=loanDetails;
            return this;
        }
        public LoanBuilder withJobs(List<Job> jobs){
            this.jobs=jobs;
            return this;
        }

        public AnnotatedLoan build(){
            AnnotatedLoan annotatedLoan = new AnnotatedLoan(this);
            return annotatedLoan;
        }

    }
}
