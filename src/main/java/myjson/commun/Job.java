package myjson.commun;

/**
 *
 */
public class Job {

    private String title;
    private int income;
    private int duration;

    public Job() {}

    public Job( String title, int income, int duration ) {
        this.title = title;
        this.income = income;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome( int income ) {
        this.income = income;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration( int duration ) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", income=" + income +
                ", duration=" + duration +
                '}';
    }
}
