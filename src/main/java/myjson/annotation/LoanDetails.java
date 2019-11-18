package myjson.annotation;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.time.LocalDate;

/**
 *
 */
@JsonIgnoreType
public class LoanDetails {

    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public LoanDetails() {
    }

    public LoanDetails( double amount, LocalDate startDate, LocalDate endDate ) {
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount( double amount ) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate( LocalDate startDate ) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate( LocalDate endDate ) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "amount=" + amount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
