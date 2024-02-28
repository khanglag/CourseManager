package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.OnlineCourse;

public class OnlineCourseDAL  extends MyDatabaseManager{
    public OnlineCourseDAL() {
        OnlineCourseDAL.connectDB();
    }
    public ArrayList<OnlineCourse> readOnlineCourses() throws SQLException {
        ArrayList<OnlineCourse> courses = new ArrayList<>();
        String sql = "SELECT * FROM onlinecourse ";
        ResultSet rs = OnlineCourseDAL.doReadQuery(sql);
        if (rs!= null) {
            while (rs.next()) {
                OnlineCourse course = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("url"));
                courses.add(course);
            }
        }
        
        
        return courses;
    }
    public OnlineCourse getOnlineCourse(int CourseID) throws Exception{
        String sql = "SELECT * FROM onlinecourse WHERE CourseID =?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        OnlineCourse course = new OnlineCourse();
        if (rs!= null) {
            while (rs.next()) {
                course.setCourseID(rs.getInt("CourseID"));
                course.setUrl(rs.getString("url"));
            }
        }
        return course;
    }
    public int addCourse(OnlineCourse course)  throws SQLException{
        String sql = "INSERT onlinecourse (CourseID,url) VALUES (?,?)";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, course.getCourseID());
        p.setString(2, course.getUrl());
        return p.executeUpdate();
    }
    public int updateCourse(OnlineCourse course) throws SQLException{
        String sql = "UPDATE onlinecourse SET url = ? WHERE CourseID =?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, course.getUrl());
        p.setInt(2, course.getCourseID());
        return p.executeUpdate();
    }
    public int deleteCourse(int CourseID) throws SQLException{
        String sql = "DELETE FROM onlinecourse WHERE CourseID =?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        return p.executeUpdate();
    }
    public ArrayList<OnlineCourse> findCourses(int CourseID) throws SQLException{
        ArrayList<OnlineCourse> courses = new ArrayList<>();
        String sql = "SELECT * FROM onlinecourse WHERE CourseID = ?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        if (rs!= null) {
            while (rs.next()) {
                OnlineCourse course = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Url"));
                        courses.add(course);
            }
        }
        return courses;
    }
    public ArrayList<OnlineCourse> getOnlineCourses() throws SQLException{
        ArrayList<OnlineCourse> courses = new ArrayList<>();
         String sql = "SELECT Course.CourseID, Course.Title, Course.Credits, Course.DepartmentId, OnlineCourse.Url " +
                     "FROM OnlineCourse " +
                     "LEFT JOIN Course ON OnlineCourse.CourseID = Course.CourseID";
         ResultSet rs = OnlineCourseDAL.doReadQuery(sql);
        if (rs!= null) {
            while (rs.next()) {
                OnlineCourse course = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentID"),
                        rs.getString("url"));
                courses.add(course);
            }
        }
        return courses;
         
    }
//    Tìm 
    public ArrayList<OnlineCourse> findOnlineCourses(int ID) throws SQLException{
        ArrayList<OnlineCourse> courses = new ArrayList<>();
         String sql = "SELECT Course.CourseID, Course.Title, Course.Credits, Course.DepartmentId, OnlineCourse.Url " +
                     "FROM OnlineCourse " +
                     "LEFT JOIN Course ON OnlineCourse.CourseID = Course.CourseID WHERE OnlineCourse.CourseID =?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, ID);
        ResultSet rs = p.executeQuery();
        if (rs!= null) {
            while (rs.next()) {
                OnlineCourse course = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentID"),
                        rs.getString("url"));
                courses.add(course);
            }
        }
        return courses;
    }
    public ArrayList<OnlineCourse> findOnlineCourses(String title) throws SQLException{
        ArrayList<OnlineCourse> courses = new ArrayList<>();
         String sql = "SELECT Course.CourseID, Course.Title, Course.Credits, Course.DepartmentId, OnlineCourse.Url " +
                     "FROM OnlineCourse " +
                     "LEFT JOIN Course ON OnlineCourse.CourseID = Course.CourseID WHERE title like ?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, "%"+ title + "%");
        ResultSet rs = p.executeQuery();
        if (rs!= null) {
            while (rs.next()) {
                OnlineCourse course = new OnlineCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("DepartmentID"),
                        rs.getString("url"));
                courses.add(course);
            }
        }
        return courses;
    }
//    Sửa
    public int editOnlineCourse(OnlineCourse online) throws SQLException {
        String sql = "UPDATE course\n" +
                "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n" +
                "SET course.Title = ?,\n" +
                "    course.Credits = ?,\n" +
                "    course.DepartmentID = ?,\n" +
                "    onlinecourse.url = ?\n" +
                "WHERE onlinecourse.CourseID = ?";
        PreparedStatement p = OnlineCourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, online.getTitle());
        p.setInt(2, online.getCredits());
        p.setInt(3, online.getDepartmentId());
        p.setString(4, online.getUrl());
        p.setInt(5, online.getCourseID());
        System.out.println(p.toString());
        return p.executeUpdate();
    }
//
    public static void main(String[] args) {
        OnlineCourse c = new OnlineCourse(4064,"htttttp");
        OnlineCourseDAL dal = new OnlineCourseDAL();
        // for (OnlineCourse course : result) {
        //     System.out.println(course.toString());
        // int r = dal.deleteCourse(4064);
        // if (r > 0) {
        //     System.out.println("Successfully added");
        // }
        // else
        //     System.out.println("Failed to add");
        
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // }
        try {
            ArrayList<OnlineCourse> result = dal.findCourses(2030);

            if (result != null) {
                System.out.println("Number of courses found: " + result.size());

                for (OnlineCourse course : result) {
                    System.out.println(course.toString());
                }
            } else {
                System.out.println("No courses found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
