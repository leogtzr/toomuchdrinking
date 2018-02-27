package toomuchdrinking.bean;

public class Need {

    private String date;
    private String comment;

    public Need(final String date, final String comment) {
        this.date = date;
        this.comment = comment;
    }

    public Need() {}

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

}
