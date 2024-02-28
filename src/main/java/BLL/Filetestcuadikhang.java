/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DAL.OnlineCourseDAL;
import DAL.OnsiteCourseDAL;
import DTO.Course;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Filetestcuadikhang {
    public static void main(String[] args) throws SQLException {
        OnsiteCourseDAL dAL=new OnsiteCourseDAL();
        for(OnsiteCourse temp: dAL.getOnsiteCourses()){
            System.out.println(temp.toString());
        }
    }
}
