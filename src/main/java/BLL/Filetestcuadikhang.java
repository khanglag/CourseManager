/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.Course;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Filetestcuadikhang {
    public static void main(String[] args) throws SQLException {
        CourseBLL exBLL=new CourseBLL();
        exBLL.addCourseOnsite("eheee", 0, 0, "location", "day", LocalTime.now());
    }
}
