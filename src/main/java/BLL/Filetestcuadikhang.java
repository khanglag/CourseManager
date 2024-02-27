/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.Course;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Filetestcuadikhang {
    public static void main(String[] args) throws SQLException {
        CourseBLL exBLL=new CourseBLL();
        ArrayList<Course> tempArrayList=new ArrayList<>();
        tempArrayList=exBLL.findCourse("literaturE");
        for(Course iCourse:tempArrayList)
        {
            System.out.println(iCourse.toString());
        }
    }
}
