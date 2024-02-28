package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CourseInstructor;

public class CourseInstructorDAL extends MyDatabaseManager {
    public CourseInstructorDAL() {
        CourseInstructorDAL.connectDB();
    }

    public ArrayList<CourseInstructor> readInstructors() throws SQLException {
        ArrayList<CourseInstructor> list = new ArrayList<>();
        String sql = " SELECT * FROM courseinstructor ";
        ResultSet rs = CourseInstructorDAL.doReadQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                CourseInstructor courseInstructor = new CourseInstructor(
                        rs.getInt("CourseID"),
                        rs.getInt("PersonID"));
                list.add(courseInstructor);
            }
        }
        return list;
    }

    public CourseInstructor getInstructor(int CourseID) throws SQLException {
        String sql = "SELECT * FROM courseinstructor WHERE CourseID = ?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        CourseInstructor instructor = new CourseInstructor();
        if (rs != null) {
            while (rs.next()) {
                instructor.setCourseID(rs.getInt("CourseID"));
                instructor.setPersonID(rs.getInt("PersonID"));
            }
        }
        closeConnect();
        return instructor;
    }

    public int addInstructor(CourseInstructor instructor) throws SQLException {
        String sql = "INSERT courseinstructor (CourseID, PersonID) VALUES (?, ?)";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(sql);
        p.setInt(1, instructor.getCourseID());
        p.setInt(2, instructor.getPersonID());
        return p.executeUpdate();
    }

    public int updateInstructor(CourseInstructor instructor, int oldCourseID, int oldPersonID) throws SQLException {
        String sql = "UPDATE courseinstructor  SET CourseID = ?, PersonID = ? WHERE CourseID = ? AND PersonID =?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(sql);
        p.setInt(1, instructor.getCourseID());
        p.setInt(2, instructor.getPersonID());
        p.setInt(3, oldCourseID);
        p.setInt(4, oldPersonID);
        return p.executeUpdate();

    }

    public int deleteInstructor(CourseInstructor instructor) throws SQLException {
        String sql = "DELETE  FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(sql);
        p.setInt(1, instructor.getCourseID());
        p.setInt(2, instructor.getPersonID());
        return p.executeUpdate();
    }

    public ArrayList<CourseInstructor> findByCourseID(int CourseID) throws
    SQLException {
    ArrayList<CourseInstructor> list = new ArrayList<>();
    String sql = "SELECT * FROM courseinstructor WHERE CourseID = ?";
    PreparedStatement p =
    CourseInstructorDAL.getConnection().prepareStatement(sql);
    p.setInt(1, CourseID);
    ResultSet rs = p.executeQuery();
    if (rs != null) {
    while (rs.next()) {
    CourseInstructor instructor = new CourseInstructor(
    rs.getInt("CourseID"),
    rs.getInt("PersonID"));
    list.add(instructor);
    }
    }
    closeConnect();
    return list;
    }

    public ArrayList<CourseInstructor> findByPersonID(int PersonID) throws SQLException {
        ArrayList<CourseInstructor> list = new ArrayList<>();
        String sql = "SELECT * FROM courseinstructor WHERE PersonID = ?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(sql);
        p.setInt(1, PersonID);
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                CourseInstructor instructor = new CourseInstructor(
                        rs.getInt("CourseID"),
                        rs.getInt("PersonID"));
                list.add(instructor);
            }
        }
        closeConnect();
        return list;
    }

    public static void main(String[] args) {
        CourseInstructorDAL c = new CourseInstructorDAL();
        CourseInstructor in = new CourseInstructor(4061, 18);
        CourseInstructor up = new CourseInstructor(4061, 20);
        // try {
        // int rowsAffected = c.updateInstructor(up, 4061, 18);
        // if (rowsAffected > 0) {
        // System.out.println("Course added successfully.");
        // } else {
        // System.out.println("Failed to add course.");
        // }
        // } catch (SQLException ex) {
        // ex.printStackTrace();
        // }
        try {
            ArrayList<CourseInstructor> result = c.findByPersonID(20);
            if (result != null) {
                System.out.println("Number of courses found: " + result.size());

                for (CourseInstructor course : result) {
                    System.out.println("Course ID: " + course.getCourseID());
                    System.out.println("Person ID: " + course.getPersonID());

                    System.out.println();
                }
            } else {
                System.out.println("No courses found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
