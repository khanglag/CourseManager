package DTO;

public class StudentGrade {
    private int EnrollmentID, CourseID, StudentID;
    private double Grade;

    public StudentGrade() {
    }

    public StudentGrade(int EnrollmentID, int CourseID, int StudentID, double Grade) {
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
    }

    public int getEnrollmentID() {
        return this.EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public int getCourseID() {
        return this.CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return this.StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public double getGrade() {
        return this.Grade;
    }

    public void setGrade(double Grade) {
        this.Grade = Grade;
    }

    public StudentGrade EnrollmentID(int EnrollmentID) {
        setEnrollmentID(EnrollmentID);
        return this;
    }

    public StudentGrade CourseID(int CourseID) {
        setCourseID(CourseID);
        return this;
    }

    public StudentGrade StudentID(int StudentID) {
        setStudentID(StudentID);
        return this;
    }

    public StudentGrade Grade(double Grade) {
        setGrade(Grade);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " EnrollmentID='" + getEnrollmentID() + "'" +
            ", CourseID='" + getCourseID() + "'" +
            ", StudentID='" + getStudentID() + "'" +
            ", Grade='" + getGrade() + "'" +
            "}";
    }
}
