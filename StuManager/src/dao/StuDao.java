package dao;

import model.Course;
import model.Grade;
import model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kindleheart happily.
 */
public interface StuDao {
    //页面最大显示信息条数
    int PAGE_SIZE = 5;

    //登入
    Student login(String scode, String password) throws SQLException;

    //检验学号是否已经注册
    boolean checkScode(String scode) throws SQLException;

    //添加用户
    void add(Student student) throws SQLException;

    //更新用户
    void update(Student student) throws SQLException;

    //通过学号查询用户
    Student findByScode(String scode) throws SQLException;

    //得到页面信息
    List<Course> findCourseByPage(int currentPage) throws SQLException;

    //返回可选课程个数
    int findCount() throws SQLException;

    //模糊查询课程
    List<Course> searchCourse(String number, String cname) throws SQLException;

    //判断是否已经选择该课
    boolean hasCourse(String scode, String number) throws SQLException;

    //添加该课程
    void addCourse(String scode, String number) throws SQLException;

    //查询所有已选课程
    List<Course> showCourses(String scode) throws  SQLException;

    //通过课程号查询该课程的最高分平均分与最低分
    List<String> getThreeScore(String scode) throws  SQLException;

    //得到课程与成绩
    List<Grade> getGrade(String scode) throws SQLException;

    //根据课程号删除课程
    void deleteCourse(String scode, String number) throws  SQLException;
}
