package service.Impl;

import dao.StuDao;
import dao.impl.StuDaoImpl;
import model.Course;
import model.Grade;
import model.PageBean;
import model.Student;
import service.StuService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kindleheart happily.
 */
public class StuServiceImpl implements StuService {
    @Override
    public Student login(String scode, String password) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.login(scode, password);
    }

    @Override
    public boolean checkScode(String scode) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.checkScode(scode);
    }

    @Override
    public void add(Student student) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        stuDao.add(student);
    }

    @Override
    public void update(Student student) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        stuDao.update(student);
    }

    @Override
    public Student findByScode(String scode) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        return  stuDao.findByScode(scode);
    }

    @Override
    public PageBean findCourseByPage(int currentPage) throws SQLException {
        PageBean<Course> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(StuDao.PAGE_SIZE);
        StuDao dao = new StuDaoImpl();
        List<Course> list = dao.findCourseByPage(currentPage);
        pageBean.setList(list);
        int count = dao.findCount();
        pageBean.setTotalSize(count);
        pageBean.setTotalPage((count + StuDao.PAGE_SIZE - 1) / StuDao.PAGE_SIZE);
        return pageBean;
    }

    @Override
    public boolean selectCourse(String scode, String number) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        if(!stuDao.hasCourse(scode, number)) {
            stuDao.addCourse(scode, number);
            return true;
        }
        return  false;
    }

    @Override
    public List<Course> searchCourse(String number, String cname) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.searchCourse(number, cname);
    }

    @Override
    public List<Course> showCourses(String scode) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        return stuDao.showCourses(scode);
    }

    @Override
    public List<Grade> showGrade(String scode) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        List<String> scorelist = stuDao.getThreeScore(scode);
        List<Grade> list  = stuDao.getGrade(scode);
        for(int i = 0; i < list.size(); i++) {
            String score[] = scorelist.get(i).split("#");
            list.get(i).setTop(Integer.parseInt(score[0]));
            list.get(i).setAvg(Double.parseDouble(score[1]));
            list.get(i).setLow(Integer.parseInt(score[2]));
        }
        return list;
    }

    @Override
    public void deleteCourse(String scode, String number) throws SQLException {
        StuDao stuDao = new StuDaoImpl();
        stuDao.deleteCourse(scode, number);
    }
}

