package service;

import model.Course;
import model.Grade;
import model.PageBean;
import model.Student;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by kindleheart happily.
 */
public interface StuService {
    Student login(String scode, String password) throws SQLException;
    boolean checkScode(String scode) throws SQLException;
    void add(Student student) throws SQLException;
    void update(Student student) throws SQLException;
    Student findByScode(String scode) throws  SQLException;
    PageBean findCourseByPage(int currentPage) throws SQLException;
    boolean selectCourse(String scode, String number) throws SQLException;
    List<Course> searchCourse(String number, String cname) throws SQLException;
    List<Course> showCourses(String scode) throws  SQLException;
    List<Grade> showGrade(String scode) throws  SQLException;
    void deleteCourse(String scode, String number) throws  SQLException;
}
