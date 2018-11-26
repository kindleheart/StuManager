package model;

/**
 * Created by kindleheart happily.
 */
public class Student {
    private int id;
    private String name;
    private String scode;
    private String password;
    private int age;
    private String school = "江西师范大学";
    private String QQ;
    private String Email;
    private String photo;
    private String introduction;

    public Student(String name, String scode, String password, int age, String QQ, String Email, String introduction) {
        this.name = name;
        this.scode = scode;
        this.password = password;
        this.age = age;
        this.QQ = QQ;
        this.Email = Email;
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scode='" + scode + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", QQ='" + QQ + '\'' +
                ", Email='" + Email + '\'' +
                ", photo='" + photo + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) { this.QQ = QQ; }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
