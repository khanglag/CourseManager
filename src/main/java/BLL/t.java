package BLL;

import java.util.ArrayList;
import BLL.PersonBLL;
import DTO.CourseInstructor;
import DTO.Department;
import DTO.OfficeAssignment;
import DTO.Person;
import DTO.StudentGrade;
import java.sql.SQLException;

public class t {
    public static void main(String[] args) {
           CourseInstructorBLL bll = new CourseInstructorBLL();
            try {
            for(CourseInstructor d : bll.findByCourseID(4061)) {
                System.out.println(d.toString());
    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
