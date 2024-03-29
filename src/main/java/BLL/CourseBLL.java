/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import DAL.OnsiteCourseDAL;
import BLL.DTO.Course;
import BLL.DTO.OnlineCourse;
import BLL.DTO.OnsiteCourse;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CourseBLL {
    public CourseBLL() {

    }

    CourseDAL dAL = new CourseDAL();
    OnlineCourseDAL onlDal = new OnlineCourseDAL();
    OnsiteCourseDAL onsiteDal = new OnsiteCourseDAL();

    public ArrayList<Course> getCourses() throws SQLException {
        return dAL.readCourses();
    }
    // Thêm course online

    public boolean addCourseOnline(String title, int credit, int department, String url) throws SQLException {
        OnlineCourseDAL oDAL = new OnlineCourseDAL();
        Course course = new Course(0, title, credit, department);
        OnlineCourse onlineCourse = new OnlineCourse(0, url);
        if (dAL.addCourse(course) == 0)
            return false;
        onlineCourse.setCourseID(dAL.getID());
        System.out.println(onlineCourse.toString());
        if (oDAL.addCourse(onlineCourse) == 0) {
            return false;
        }
        return true;
    }

    // Thêm course onsite

    public boolean addCourseOnsite(String title, int credit, int department, String location, String day,
            LocalTime time) throws SQLException {
        OnsiteCourseDAL oDAL = new OnsiteCourseDAL();
        Course course = new Course(0, title, credit, department);
        OnsiteCourse onsiteCourse = new OnsiteCourse(credit, location, day, time);
        if (dAL.addCourse(course) == 0)
            return false;
        onsiteCourse.setCourseID(dAL.getID());
        if (oDAL.addOnsite(onsiteCourse) == 0) {
            return false;
        }
        return true;

    }

    // Tìm course theo ID hoặc title

    public ArrayList<Course> findCourse(String searchTerm) throws SQLException {
        ArrayList<Course> tempList = new ArrayList<>();
        if (isNumeric(searchTerm)) {
            tempList = dAL.findCourse(Integer.parseInt(searchTerm));
        } else
            tempList = dAL.findCourse(searchTerm);
        if (tempList == null)
            System.out.println(" tim course rỗng");
        return tempList;
    }

    // Sửa course online

    public boolean editCourseOnline(int ID, String title, int credit, int department, String url) throws SQLException {
        OnlineCourseDAL oDAL = new OnlineCourseDAL();
        Course course = new Course(ID, title, credit, department);
        OnlineCourse onlineCourse = new OnlineCourse(ID, url);
        if (dAL.updateCourse(course) == 0)
            return false;
        if (oDAL.updateCourse(onlineCourse) == 0) {
            return false;
        }
        return true;
    }

    // Sửa course Onsite

    public boolean editCourseOnsite(int ID, String title, int credit, int department, String location, String day,
            LocalTime time) throws SQLException {
        OnsiteCourseDAL oDAL = new OnsiteCourseDAL();
        OnsiteCourse onsiteCourse = new OnsiteCourse(ID, title, credit, department, location, day, time);
        if (oDAL.editOnsiteCourse(onsiteCourse) == 0) {
            return false;
        }
        return true;

    }

    //
    public ArrayList<OnlineCourse> getOnlineCourses() throws SQLException {
        OnlineCourseDAL oDAL = new OnlineCourseDAL();
        return oDAL.getOnlineCourses();
    }

    public ArrayList<OnsiteCourse> getOnsiteCourses() throws SQLException {
        OnsiteCourseDAL oDAL = new OnsiteCourseDAL();
        return oDAL.getOnsiteCourses();
    }

    public int editOnsiteCourse(int ID, String title, int credit, int department, String location, String day,
            LocalTime time) throws SQLException {
        OnsiteCourse onsiteCourse = new OnsiteCourse(ID, title, credit, department, location, day, time);
        OnsiteCourseDAL oDAL = new OnsiteCourseDAL();
        return oDAL.editOnsiteCourse(onsiteCourse);
    }

    public int editOnlineCourse(int ID, String title, int credit, int department, String url) throws SQLException {
        OnlineCourse onlineCourse = new OnlineCourse(ID, title, credit, department, url);
        OnlineCourseDAL oDAL = new OnlineCourseDAL();
        return oDAL.editOnlineCourse(onlineCourse);
    }

    public ArrayList<OnsiteCourse> findCourseOnsite(String searchTerm) throws SQLException {
        ArrayList<OnsiteCourse> tempList = new ArrayList<>();
        if (isNumeric(searchTerm)) {
            tempList = onsiteDal.findOnsiteCourses(Integer.parseInt(searchTerm));
        } else
            tempList = onsiteDal.findOnsiteCourses(searchTerm);

        return tempList;
    }

    public ArrayList<OnlineCourse> findCourseOnline(String searchTerm) throws SQLException {
        ArrayList<OnlineCourse> tempList = new ArrayList<>();
        if (isNumeric(searchTerm)) {
            tempList = onlDal.findOnlineCourses(Integer.parseInt(searchTerm));
        } else
            tempList = onlDal.findOnlineCourses(searchTerm);

        return tempList;
    }
    
    public int deleteCourseOnline(int id) throws SQLException{
        
        return onlDal.delete(id);
    }
    public int deleteCourseOnsite(int id) throws SQLException{
        
        return onsiteDal.delete(id);
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
