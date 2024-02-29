package DAL;

import DTO.StudentGrade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentGradeDAL extends MyDatabaseManager {
    public StudentGradeDAL() {
        StudentGradeDAL.connectDB();
    }

    public ArrayList<StudentGrade> readGrades() throws SQLException {
        ArrayList<StudentGrade> list = new ArrayList<>();
        String sql = "SELECT * FROM studentgrade";
        ResultSet rs = StudentGradeDAL.doReadQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                StudentGrade grade = new StudentGrade(
                        rs.getInt("EnrollmentID"),
                        rs.getInt("CourseID"),
                        rs.getInt("StudentID"),
                        rs.getDouble("Grade"));
                list.add(grade);
            }
        }
        //closeConnect();
        return list;
    }

    public StudentGrade getStudentGrade(int EnrollmentID) throws SQLException {
        String sql = "SELECT * FROM studentgrade WHERE EnrollmentID = ?";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(sql);
        p.setInt(1, EnrollmentID);
        StudentGrade studentGrade = new StudentGrade();
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                studentGrade.setEnrollmentID(rs.getInt("EnrollmentID"));
                studentGrade.setCourseID(rs.getInt("CourseID"));
                studentGrade.setStudentID(rs.getInt("StudentID"));
                studentGrade.setGrade(rs.getDouble("Grade"));
            }
        }
       // closeConnect();
        return studentGrade;
    }

    public int addStudentGrade(StudentGrade studentGrade) throws SQLException {
        String sql = "INSERT studentgrade (CourseID, StudentID, Grade) VALUES (?,?,?)";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(sql);
        p.setInt(1, studentGrade.getCourseID());
        p.setInt(2, studentGrade.getStudentID());
        p.setDouble(3, studentGrade.getGrade());
        return p.executeUpdate();
    }

    public int updateStudentGrade(StudentGrade studentGrade) throws SQLException {
        String sql = "UPDATE studentgrade SET Grade = ? WHERE EnrollmentID = ? AND CourseID = ? AND StudentID = ?";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(sql);
        p.setDouble(1, studentGrade.getGrade());
        p.setInt(2, studentGrade.getEnrollmentID());
        p.setInt(3, studentGrade.getCourseID());
        p.setInt(4, studentGrade.getStudentID());
        return p.executeUpdate();
    }

    public int deleteCourse(int EnrollmentID) throws SQLException {
        String sql = "DELETE FROM studentgrade WHERE EnrollmentID =? ";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(sql);
        p.setInt(1, EnrollmentID);
        return p.executeUpdate();
    }

    public ArrayList<StudentGrade> findStudentGrade(int CourseID) throws SQLException {
        ArrayList<StudentGrade> list = new ArrayList<>();
        String sql = "SELECT * FROM studentgrade WHERE CourseID =? ";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                StudentGrade grade = new StudentGrade(
                        rs.getInt("EnrollmentID"),
                        rs.getInt("CourseID"),
                        rs.getInt("StudentID"),
                        rs.getDouble("Grade"));
                list.add(grade);
            }
        }
       // closeConnect();
        return list;
    }
   
}
