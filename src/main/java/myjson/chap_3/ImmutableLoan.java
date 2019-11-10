package myjson.chap_3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import myjson.commun.Job;
import myjson.commun.LoanDetails;

import java.util.List;

public class ImmutableLoan {

    private String name;

    private String purposeOfLoan;

    @JsonProperty("details")
    private LoanDetails loanDetails;
    private List<Job> jobs;

    public ImmutableLoan() {}

    @JsonCreator
    public ImmutableLoan( @JsonProperty("name") String name,
                          @JsonProperty("purposeOfLoan") String purposeOfLoan,
                          @JsonProperty("details") LoanDetails loanDetails,
                          @JsonProperty("jobs")List<Job> jobs ) {
        this.name = name;
        this.purposeOfLoan = purposeOfLoan;
        this.loanDetails = loanDetails;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public LoanDetails getLoanDetails() {
        return loanDetails;
    }

    public List<Job> getJobs() {
        return jobs;
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
