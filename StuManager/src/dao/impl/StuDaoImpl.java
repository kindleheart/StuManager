package dao.impl;

import dao.StuDao;
import model.Choose;
import model.Course;
import model.Grade;
import model.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JDBCUtil;
import util.TextUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by kindleheart happily.
 */
public class StuDaoImpl implements StuDao  {

    @Override
    public Student login(String scode, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from stuifo where scode=? and password=?";
        return runner.query(sql, new BeanHandler<>(Student.class), scode, password);
    }

    @Override
    public boolean checkScode(String scode) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from stuifo where scode=?";
        Student student = runner.query(sql, new BeanHandler<>(Student.class), scode);
        return student != null;
    }

    @Override
    public void add(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into stuifo (name, scode, password, age, school, QQ, Email, introduction)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?)";
        runner.update(sql,
                student.getName(),
                student.getScode(),
                student.getPassword(),
                student.getAge(),
                student.getSchool(),
                student.getQQ(),
                student.getEmail(),
                student.getIntroduction()
        );
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update stuifo set name=?, password=?, age=?, QQ=?, Email=?, introduction=? where scode=?";
        runner.update(sql,
                student.getName(),
                student.getPassword(),
                student.getAge(),
                student.getQQ(),
                student.getEmail(),
                student.getIntroduction(),
                student.getScode()
        );
    }

    @Override
    public Student findByScode(String scode) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from stuifo where scode=?";
        return runner.query(sql, new BeanHandler<>(Student.class), scode);
    }

    @Override
    public List<Course> findCourseByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from course limit ? offset ?";
        return runner.query(sql, new BeanListHandler<>(Course.class), PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from course";

        //ScalarHandler()一般用于个数平均值
        Long count = (Long) runner.query(sql, new ScalarHandler());
        return count.intValue();
    }

    @Override
    public List<Course> searchCourse(String number, String cname) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from course where 1=1 ";
        List<String> list = new ArrayList<>();
        if(!TextUtils.isEmpty(number)) {
            sql += "and number = ?";
            list.add(number);
        }
        if(!TextUtils.isEmpty(cname)) {
            sql +="and cname like ?";
            list.add("%" + cname + "%");
        }
        return runner.query(sql, new BeanListHandler<>(Course.class), list.toArray());
    }

    @Override
    public boolean hasCourse(String scode, String number) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from choose where scode = ? and number = ?";
        Choose choose = runner.query(sql, new BeanHandler<>(Choose.class), scode, number);
        return choose != null;
    }


    @Override
    public void addCourse(String scode, String number) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into choose values(null, ?, ?, ?) ";
        int score = new Random().nextInt(50)+50;//随机给个成绩(50-100)
        runner.update(sql, scode, number, score);
    }

    @Override
    public List<Course> showCourses(String scode) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from course where number in (select number from choose where scode = ?)";
        return runner.query(sql, new BeanListHandler<>(Course.class), scode);
    }

    @Override
    public List<String> getThreeScore(String scode) throws SQLException {
        Connection conn = JDBCUtil.getConn();
        String sql = "select max(grade), avg(grade), min(grade) from choose where number in (select number from choose where scode = ?) group by number";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, scode);
        ResultSet rs = preparedStatement.executeQuery();
        List<String> list = new ArrayList<>();
        while(rs.next()) {
            list.add(rs.getString(1) + "#" + rs.getString(2) + "#" + rs.getString(3));
        }
        return list;
    }

    @Override
    public List<Grade> getGrade(String scode) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select c.*, a.grade from course c, choose a where c.number in " +
                "(select number from choose where a.scode = ?) and c.number = a.number";
        return runner.query(sql, new BeanListHandler<>(Grade.class), scode);
    }

    @Override
    public void deleteCourse(String scode, String number) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from choose where scode = ? and number = ?";
        runner.update(sql, scode, number);
    }
}
