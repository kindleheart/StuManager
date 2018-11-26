package model;

/**
 * Created by kindleheart happily.
 */
public class Choose {
    String id;
    String scode;
    String number;
    int grade;

    public Choose(String id, String scode, String number, int grade) {
        this.id = id;
        this.scode = scode;
        this.number = number;
        this.grade = grade;
    }

    public Choose() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
