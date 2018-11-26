package model;

/**
 * Created by kindleheart happily.
 */
public class Grade {
    private String number;
    private String cname;
    private String ename;
    private int score;
    private int grade;
    private int top;
    private Double avg;
    private int low;

    public Grade(String number, String cname, String ename, int score, int grade, int top, double avg, int low) {
        this.number = number;
        this.cname = cname;
        this.ename = ename;
        this.score = score;
        this.grade = grade;
        this.top = top;
        this.avg = avg;
        this.low = low;
    }

    public Grade() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }
}
