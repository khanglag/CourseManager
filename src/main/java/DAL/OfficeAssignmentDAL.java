package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import BLL.DTO.OfficeAssignment;

public class OfficeAssignmentDAL extends MyDatabaseManager {
    public OfficeAssignmentDAL() {
        OfficeAssignmentDAL.connectDB();
    }

    public ArrayList<OfficeAssignment> readAssignments() throws SQLException {
        ArrayList<OfficeAssignment> assignments = new ArrayList<>();
        String sql = "SELECT * FROM officeassignment ";
        ResultSet rs = OfficeAssignmentDAL.doReadQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                OfficeAssignment assignment = new OfficeAssignment(
                        rs.getInt("InstructorID"),
                        rs.getString("Location"),
                        rs.getTimestamp("Timestamp"));

                assignments.add(assignment);

            }
        }
      //  closeConnect();
        return assignments;
    }

    public OfficeAssignment getAssignment(int InstructorID) throws SQLException {
        String sql = "SELECT * FROM officeassignment WHERE instructorID = ?";
        PreparedStatement p = OfficeAssignmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, InstructorID);
        ResultSet rs = p.executeQuery();
        OfficeAssignment assignment = new OfficeAssignment();
        if (rs != null) {
            while (rs.next()) {
                assignment.setInstructorID(rs.getInt("InstructorID"));
                assignment.setLocation(rs.getString("Location"));
                assignment.setTimeStamp(rs.getTimestamp("Timestamp"));

            }
        }
   //     closeConnect();
        return assignment;
    }

    public int addAssignment(OfficeAssignment assignment) throws SQLException {
        String sql = "INSERT officeassignment(InstructorID, Location, Timestamp) VALUES (?,?,?)";
        PreparedStatement p = OfficeAssignmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, assignment.getInstructorID());
        p.setString(2, assignment.getLocation());
        p.setTimestamp(3, assignment.getTimeStamp());
        return p.executeUpdate();
    }

    public int updateAssignment(OfficeAssignment assignment) throws SQLException {
        String sql = "UPDATE  officeassignment SET Location = ?,Timestamp = ? WHERE InstructorID = ?";
        PreparedStatement p = OfficeAssignmentDAL.getConnection().prepareStatement(sql);
        p.setString(1, assignment.getLocation());
        p.setTimestamp(2, assignment.getTimeStamp());
        p.setInt(3, assignment.getInstructorID());
        return p.executeUpdate();
    }

    public int deleteAssignment(int InstructorID) throws SQLException {
        String sql = "DELETE FROM officeassignment WHERE InstructorID = ?";
        PreparedStatement p = OfficeAssignmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, InstructorID);
        return p.executeUpdate();
    }

    public ArrayList<OfficeAssignment> findAssignments(int InstructorID) throws SQLException {
        ArrayList<OfficeAssignment> assignments = new ArrayList<>();
        String sql = "SELECT * FROM officeassignment WHERE InstructorID = ? ";
        PreparedStatement p = OfficeAssignmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, InstructorID);
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                OfficeAssignment assignment = new OfficeAssignment(
                        rs.getInt("InstructorID"),
                        rs.getString("Location"),
                        rs.getTimestamp("Timestamp"));

                assignments.add(assignment);

            }
        }
        //closeConnect();
        return assignments;

    }

    public static void main(String[] args) {
        OfficeAssignment o = new OfficeAssignment(35, "Khang", new Timestamp(System.currentTimeMillis()));
        OfficeAssignmentDAL dal = new OfficeAssignmentDAL();
        // try {
        // int r = dal.deleteAssignment(35);
        // if( r > 0){
        // System.out.println("Success");
        // }
        // else System.out.println("Failure");
        // } catch (Exception e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }
        // try {
        // ArrayList<OfficeAssignment> result = dal.findAssignments("s");
        // if (result != null) {
        // System.out.println("Number of courses found: " + result.size());

        // for (OfficeAssignment course : result) {
        // System.out.println(course.toString());
        // }
        // } else {
        // System.out.println("No courses found.");
        // }
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
        try {
            ArrayList<OfficeAssignment> result = dal.findAssignments(31);
            for (OfficeAssignment assignment : result) {
                System.out.println(assignment.toString());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}
