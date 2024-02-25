/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Course;

/**
 *
 * @author MSII
 */
public class CourseDAL extends MyDatabaseManager {
    public  CourseDAL() {
        CourseDAL.connectDB();
    }
    public ArrayList<Course> readCourses() throws SQLException {
        ArrayList<Course> courseList = new ArrayList<>();
        String sql = "SELECT * FROM course";
        ResultSet rs =CourseDAL.doReadQuery(sql);
        if (rs != null) {

            while (rs.next()) {
                Course c = new Course(
                    rs.getInt("CourseID"),
                    rs.getString("Title"),
                    rs.getInt("Credits"),
                    rs.getInt("DepartmentID"));
                courseList.add(c);

            }
            
        }
        closeConnect();
        return courseList;

    }
    public static void main(String[] args) {
        CourseDAL courseDAL = new CourseDAL();
        try {
            ArrayList<Course> courses = courseDAL.readCourses();
            for (Course course : courses) {
                System.out.println(course.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
} 

