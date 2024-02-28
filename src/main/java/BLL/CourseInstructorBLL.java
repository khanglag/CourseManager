/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseInstructorDAL;
import DTO.CourseInstructor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class CourseInstructorBLL {
    CourseInstructorDAL dAL;

    public CourseInstructorBLL() {
        dAL = new CourseInstructorDAL();
    }

    public ArrayList<CourseInstructor> getAllInstructors() throws SQLException {
        return dAL.readInstructors();
    }

    public CourseInstructor getInstructor(int CourseID) throws SQLException {
        return dAL.getInstructor(CourseID);
    }

    public int addInstructor(CourseInstructor instructor) throws SQLException {
        return dAL.addInstructor(instructor);
    }

    public int updateInstructor(CourseInstructor instructor, int oldCourseID, int oldPersonID) throws SQLException {
        return dAL.updateInstructor(instructor, oldCourseID, oldPersonID);
    }

    public int deleteInstructor(CourseInstructor instructor) throws SQLException {
        return dAL.deleteInstructor(instructor);
    }

    public ArrayList<CourseInstructor> findByCourseID(int CourseID) throws SQLException {
        return dAL.findByCourseID(CourseID);
    }

    public ArrayList<CourseInstructor> findByPersonID(int PersonID) throws SQLException {
        return dAL.findByPersonID(PersonID);
    }

}
