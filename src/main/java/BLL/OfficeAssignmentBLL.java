/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OfficeAssignmentDAL;
import DTO.OfficeAssignment;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class OfficeAssignmentBLL {
    OfficeAssignmentDAL dal;

    public OfficeAssignmentBLL() {
        dal = new OfficeAssignmentDAL();
    }

    public ArrayList<OfficeAssignment> getAllAssignment() throws SQLException {
        return dal.readAssignments();
    }

    public OfficeAssignment getAssignment(int InstructorID) throws SQLException {
        return dal.getAssignment(InstructorID);
    }

    public int addAssignment(OfficeAssignment assignment) throws SQLException {
        return dal.addAssignment(assignment);
    }

    public int updateAssignment(OfficeAssignment assignment) throws SQLException {
        return dal.updateAssignment(assignment);
    }

    public int deleteAssignment(int InstructorID) throws SQLException {
        return dal.deleteAssignment(InstructorID);
    }

    public ArrayList<OfficeAssignment> findAssignments(int InstructorID) throws SQLException {
        return dal.findAssignments(InstructorID);
    }

}
