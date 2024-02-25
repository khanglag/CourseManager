/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import DTO.Course;

/**
 *
 * @author MSII
 */
public class CourseDAL extends MyDatabaseManager {
    public CourseDAL() {
        CourseDAL.connectDB();
    }

    public ArrayList<Course> readCourses() throws SQLException {
        ArrayList<Course> courseList = new ArrayList<>();
        String sql = "SELECT * FROM course";
        ResultSet rs = CourseDAL.doReadQuery(sql);
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

    public Course getCourse(int CourseID) throws SQLException {
        String sql = "SELECT * FROM course WHERE PERSONID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        Course course = new Course();
        if (rs != null) {
            while (rs.next()) {
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentId(rs.getInt("DepartmentID"));

            }
        }
        closeConnect();
        return course;
    }

    public int addCourse(Course course) throws SQLException {
        String sql = "INSERT  course (Title, Credits, DepartmentID) VALUES (?,?,?)";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, course.getTitle());
        p.setInt(2, course.getCredits());
        p.setInt(3, course.getDepartmentId());
        return p.executeUpdate();
    }

    public int updateCourse(Course course) throws SQLException {
        String sql = "UPDATE course SET Title = ? , Credits = ? , DepartmentID = ?  WHERE CourseID = ? ";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, course.getTitle());
        p.setInt(2, course.getCredits());
        p.setInt(3, course.getDepartmentId());
        p.setInt(4, course.getCourseID());
        return p.executeUpdate();
    }

    public int deleteCourse(int CourseID) throws SQLException {
        String sql = "DELETE FROM course WHERE CourseID =?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        return p.executeUpdate();
    }

    public ArrayList<Course> findCourse(int CourseID, String  Title) throws SQLException{
        ArrayList<Course> courseList = new ArrayList<>();
        String sql = "SELECT * FROM course WHERE CourseID = ? OR Title LIKE ? ";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        p.setString(2, "%" + Title + "%");
        ResultSet rs = p.executeQuery();
        if(rs != null) {
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
        int co = 4062;
        // Course dAL = new Course(co, "DDD", 5, 9);
        // // Add
        // try {
        //     int rowsAffected = courseDAL.deleteCourse(4062);
        //     if (rowsAffected > 0) {
        //         System.out.println("Course added successfully.");
        //     } else {
        //         System.out.println("Failed to add course.");
        //     }
        // } catch (SQLException ex) {
        //     ex.printStackTrace();
        // }
        try {
            ArrayList<Course> result = courseDAL.findCourse(-1,"p");
            if (result != null) {
                System.out.println("Number of courses found: " + result.size());

                for (Course course : result) {
                    System.out.println("Course ID: " + course.getCourseID());
                    System.out.println("Title: " + course.getTitle());
                    System.out.println("Credits: " + course.getCredits());
                    System.out.println("Department ID: " + course.getDepartmentId());
                    System.out.println();
                }
            } else {
                System.out.println("No courses found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Show
        // try {
        // ArrayList<Course> courses = courseDAL.readCourses();
        // for (Course course : courses) {
        // System.out.println(course.toString());
        // }
        // } catch (SQLException ex) {
        // ex.printStackTrace();
        // }
    }
}