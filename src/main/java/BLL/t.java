package BLL;

import java.util.ArrayList;
import BLL.PersonBLL;
import BLL.DTO.CourseInstructor;
import BLL.DTO.Department;
import BLL.DTO.OfficeAssignment;
import BLL.DTO.Person;
import BLL.DTO.StudentGrade;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

public class t {

    public static void main(String[] args) throws SQLException, ParseException {
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
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        Date date = java.sql.Timestamp.valueOf(currentDateTime);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = dateFormat.format(date);
//
//        ArrayList<Person> person = new ArrayList<Person>();
//        PersonBLL oa = new PersonBLL();
//
//        person = oa.findPerson("1131");
//        System.out.println(person);
//          CourseInstructorBLL xx = new CourseInstructorBLL();
//             System.out.println(xx.findByPersonID(1));
// StudentGradeBLL sg = new StudentGradeBLL();
//        System.out.println(sg.findGrades(4041));
//            OfficeAssignmentBLL oa = new OfficeAssignmentBLL();
//            System.out.println(oa.findAssignments(5));
// String ts = "2022-02-24 00:19:22";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            // Cố gắng chuyển đổi chuỗi thành đối tượng Date
//            dateFormat.parse(ts);
//        } catch (ParseException e) {
//            JOptionPane.showMessageDialog(null, "Please fill yyyy-MM-dd HH:mm:ss");
//            return;
//        }
//Date parsedDate = dateFormat.parse(ts);
//  Timestamp timestamp = new Timestamp(parsedDate.getTime());
//OfficeAssignmentBLL OAbll = new OfficeAssignmentBLL();
//  OfficeAssignment oa = new OfficeAssignment(5, "ABCCCCC", timestamp);
//OAbll.updateAssignment(oa);
//        StudentGradeBLL sg = new StudentGradeBLL();
//        System.out.println(sg.findGradesByStudentID(2));
CourseBLL c = new CourseBLL();
c.findCourse("courseID");
        System.out.println(c.findCourse("1045"));
    }
}