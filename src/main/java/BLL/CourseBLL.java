/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import DAL.OnsiteCourseDAL;
import DTO.Course;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CourseBLL {
    public CourseBLL(){
        
    }
    CourseDAL dAL=new CourseDAL();
    public ArrayList<Course> getCourses() throws SQLException{
        return dAL.readCourses();
    }
    //Thêm course online
    
    public boolean addCourseOnline(int ID, String title, int credit,int department ,String url) throws SQLException{
        OnlineCourseDAL oDAL=new OnlineCourseDAL();
        Course course=new Course(ID,title, credit, department);
        OnlineCourse onlineCourse=new OnlineCourse(ID, url);
        if (dAL.addCourse(course)==0)
            return false;
        if ( oDAL.addCourse(onlineCourse)==0) {
            return false;
        }
        return true;
    }
    
    // Thêm course onsite 
    
     public boolean addCourseOnsite(int ID, String title, int credit,int department ,String location,String day, LocalTime time) throws SQLException{
        OnsiteCourseDAL oDAL=new OnsiteCourseDAL();
        Course course=new Course(ID,title, credit, department);
        OnsiteCourse onsiteCourse= new OnsiteCourse(credit, location, day, time);
        if (dAL.addCourse(course)==0)
            return false;
        if ( oDAL.addOnsite(onsiteCourse)==0) {
            return false;
        }
        return true;
        
    }
    
    // Tìm course theo ID hoặc title
    
    public ArrayList<Course> findCourse(String searchTerm) throws SQLException{
        ArrayList<Course> tempList =new ArrayList<>();
        if(isNumeric(searchTerm)) {
            tempList= dAL.findCourse(Integer.parseInt(searchTerm));
        }
        else tempList= dAL.findCourse(searchTerm);
        if (tempList==null) System.out.println(" tim course rỗng");
        return tempList;
    }
    
    
    // Sửa course online 
    
    public boolean editCourseOnline(int ID, String title, int credit,int department ,String url) throws SQLException{
        OnlineCourseDAL oDAL=new OnlineCourseDAL();
        Course course=new Course(ID,title, credit, department);
        OnlineCourse onlineCourse=new OnlineCourse(ID, url);
        if (dAL.updateCourse(course)==0)
            return false;
        if ( oDAL.updateCourse(onlineCourse)==0) {
            return false;
        }
        return true;
    }
    
    //Sửa course Onsite
    
    public boolean editCourseOnsite(int ID, String title, int credit,int department ,String location,String day, LocalTime time) throws SQLException{
        OnsiteCourseDAL oDAL=new OnsiteCourseDAL();
        Course course=new Course(ID,title, credit, department);
        OnsiteCourse onsiteCourse= new OnsiteCourse(credit, location, day, time);
        if (dAL.updateCourse(course)==0)
            return false;
        if ( oDAL.updateOnsite(onsiteCourse)==0) {
            return false;
        }
        return true;
        
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
