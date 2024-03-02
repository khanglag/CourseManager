/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentGradeDAL;
import BLL.DTO.StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class StudentGradeBLL {
    StudentGradeDAL dal ;
    public  StudentGradeBLL(){
        dal = new StudentGradeDAL();
    }
    public  ArrayList<StudentGrade> gettAllGrade() throws  SQLException {
        return dal.readGrades();
    }
    
    public StudentGrade getGrade(int EnrollmentID) throws  SQLException {
        return dal.getStudentGrade(EnrollmentID);
    }
    
    public int addGrade(StudentGrade grade) throws  SQLException{
        return dal.addStudentGrade(grade);
    }
    public int updateGrade(StudentGrade grade) throws  SQLException{
        return dal.updateStudentGrade(grade);
    }
    public  int deleteGrade(int EnrollmentID) throws  SQLException {
        return dal.deleteCourse(EnrollmentID);
    }
    public ArrayList<StudentGrade> findGrades(int EnrollmentID) throws SQLException {
        return dal.findStudentGrade(EnrollmentID);
    }
    public ArrayList<StudentGrade> findGradesByStudentID(int StudentID) throws SQLException {
        return dal.findStudentGradeByStudentID(StudentID);
    }
    
    
}
