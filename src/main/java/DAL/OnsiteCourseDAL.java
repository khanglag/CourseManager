package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.OnsiteCourse;
import java.time.LocalTime;

public class OnsiteCourseDAL extends MyDatabaseManager {
    public OnsiteCourseDAL() {
        OnsiteCourseDAL.connectDB();
    }

    public ArrayList<OnsiteCourse> readList() throws SQLException {
        ArrayList<OnsiteCourse> onsiteList = new ArrayList<>();
        String sql = "SELECT * FROM onsitecourse";
        ResultSet rs = OnlineCourseDAL.doReadQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                OnsiteCourse onsite = new OnsiteCourse(
                        rs.getInt("CourseID"),
                        rs.getString("Location"),
                        rs.getString("Days"),
                        rs.getTime("Time").toLocalTime());
                onsiteList.add(onsite);

            }
        }
        closeConnect();
        return onsiteList;
    }

    public OnsiteCourse getOnsiteCourse(int CourseID) throws SQLException {
        String sql = "SELECT * FROM onsitecourse WHERE CourseID = ? ";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        OnsiteCourse onsite = new OnsiteCourse();
        if (rs != null) {
            while (rs.next()) {
                onsite.setCourseID(rs.getInt("CourseID"));
                onsite.setLocation(rs.getString("Location"));
                onsite.setDays(rs.getString("Days"));
                onsite.setTime(rs.getTime("Time").toLocalTime());

            }
        }
        closeConnect();
        return onsite;
    }

    public int addOnsite(OnsiteCourse onsite) throws SQLException {
        String sql = "INSERT onsitecourse (CourseID, Location, Days, Time) VALUES (?,?,?,?) ";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, onsite.getCourseID());
        p.setString(2, onsite.getLocation());
        p.setString(3, onsite.getDays());
        p.setTime(4, java.sql.Time.valueOf(onsite.getTime()));
        return p.executeUpdate();
    }

    public int updateOnsite(OnsiteCourse onsite) throws SQLException {
        String sql = "UPDATE  onsitecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, onsite.getLocation());
        p.setString(2, onsite.getDays());
        p.setTime(3, java.sql.Time.valueOf(onsite.getTime()));
        p.setInt(4, onsite.getCourseID());
        return p.executeUpdate();
    }

    public int deleteOnsite(int CourseID) throws SQLException {
        String sql = "DELETE FROM onsitecourse WHERE CourseID = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(sql);
        p.setInt(1, CourseID);
        return p.executeUpdate();
    }

    public ArrayList<OnsiteCourse> findOnsite(String Location, String Days, LocalTime Time) throws SQLException {
        ArrayList<OnsiteCourse> list = new ArrayList<>();
        String sql = "SELECT * FROM onsitecourses WHERE Location LIKE ? OR Days LIKE ? OR Time = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(sql);
        p.setString(1, "%" + Location + "%");
        p.setString(2, "%" + Days + "%");
        p.setTime(3, java.sql.Time.valueOf(Time));
        ResultSet rs = p.executeQuery();
        if (rs!= null) {
            while (rs.next()) {
                OnsiteCourse onsite = new OnsiteCourse(
                    rs.getInt("CourseID"),
                        rs.getString("Location"),
                        rs.getString("Days"),
                        rs.getTime("Time").toLocalTime());
                list.add(onsite);

            }
        }
        closeConnect();
        return list;
    } 
}