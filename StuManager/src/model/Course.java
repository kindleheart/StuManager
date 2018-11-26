package model;

/**
 * Created by kindleheart happily.
 */
public class Course {
    private int id;
    private String number;
    private String cname;
    private String ename;
    private int score;
    private int chour;
    private int lhour;
    private int tchour;
    private int tlhour;
    private int open;

    public Course(int id, String number, String cname, String ename, int score, int chour, int lhour, int tchour, int tlhour, int open) {
        this.id = id;
        this.number = number;
        this.cname = cname;
        this.ename = ename;
        this.score = score;
        this.chour = chour;
        this.lhour = lhour;
        this.tchour = tchour;
        this.tlhour = tlhour;
        this.open = open;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getChour() {
        return chour;
    }

    public void setChour(int chour) {
        this.chour = chour;
    }

    public int getLhour() {
        return lhour;
    }

    public void setLhour(int lhour) {
        this.lhour = lhour;
    }

    public int getTchour() {
        return tchour;
    }

    public void setTchour(int tchour) {
        this.tchour = tchour;
    }

    public int getTlhour() {
        return tlhour;
    }

    public void setTlhour(int tlhour) {
        this.tlhour = tlhour;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }
}
