package BLL;

import java.util.ArrayList;
import BLL.PersonBLL;
import BLL.DTO.CourseInstructor;
import BLL.DTO.Department;
import BLL.DTO.OfficeAssignment;
import BLL.DTO.Person;
import BLL.DTO.StudentGrade;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class t {

    public static void main(String[] args) throws SQLException {
//           CourseInstructorBLL bll = new CourseInstructorBLL();
//            try {
//            for(CourseInstructor d : bll.findByCourseID(4061)) {
//                System.out.println(d.toString());
//
//            } catch (Exception e) {
//                // TODO: handle exception
//                e.printStackTrace();
//            }
//            String sql = "UPDATE course\n" +
//                "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n" +
//                "SET course.Title = ?,\n" +
//                "    course.Credits = ?,\n" +
//                "    course.DepartmentID = ?,\n" +
//                "    onsitecourse.Location = ?,\n" +
//                "    onsitecourse.Days = ?,\n" +
//                "    onsitecourse.Time = ?\n" +
//                "WHERE onsitecourse.CourseID = ?;";
//            System.out.println(sql);
  LocalDateTime currentDateTime = LocalDateTime.now();
        Date date = java.sql.Timestamp.valueOf(currentDateTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);  
        
        ArrayList<Person> person = new ArrayList<Person>();
        PersonBLL oa = new PersonBLL();
       
        person = oa.findPerson("1131");
        System.out.println(person);
//          CourseInstructorBLL xx = new CourseInstructorBLL();
//             System.out.println(xx.findByPersonID(1));
    }
}
