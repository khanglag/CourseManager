package BLL;

import java.util.ArrayList;

import DTO.Department;
import DTO.StudentGrade;
import java.sql.SQLException;

public class t {
    public static void main(String[] args) {
            DepartmentBLL bll = new DepartmentBLL();
            StudentGradeBLL b = new StudentGradeBLL();
            try {
//                ArrayList<StudentGrade> ls =
            for(StudentGrade d : b.findGrades(4041))
                System.out.println(d.toString());
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
    }
}
