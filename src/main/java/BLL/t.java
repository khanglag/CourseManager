package BLL;

import java.util.ArrayList;

import DTO.Department;

public class t {
    public static void main(String[] args) {
            DepartmentBLL bll = new DepartmentBLL();
            try {
                ArrayList<Department> ls = bll.finDepartments("Eco");
            for(Department d : ls)
                System.out.println(d.toString());
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            String sql = "UPDATE course\n" +
                "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n" +
                "SET course.Title = ?,\n" +
                "    course.Credits = ?,\n" +
                "    course.DepartmentID = ?,\n" +
                "    onsitecourse.Location = ?,\n" +
                "    onsitecourse.Days = ?,\n" +
                "    onsitecourse.Time = ?\n" +
                "WHERE onsitecourse.CourseID = ?;";
            System.out.println(sql);
    }
}
