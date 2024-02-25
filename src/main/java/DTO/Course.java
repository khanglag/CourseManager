package DTO;

public class Course {
    private int CourseID;
    private String Title;
    private int Credits, DepartmentId;

    public Course() {
    }

    public Course(int CourseID, String Title, int Credits, int DepartmentId) {
        this.CourseID = CourseID;
        this.Title = Title;
        this.Credits = Credits;
        this.DepartmentId = DepartmentId;
    }

    public int getCourseID() {
        return this.CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getCredits() {
        return this.Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getDepartmentId() {
        return this.DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public Course CourseID(int CourseID) {
        setCourseID(CourseID);
        return this;
    }

    public Course Title(String Title) {
        setTitle(Title);
        return this;
    }

    public Course Credits(int Credits) {
        setCredits(Credits);
        return this;
    }

    public Course DepartmentId(int DepartmentId) {
        setDepartmentId(DepartmentId);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " CourseID='" + getCourseID() + "'" +
            ", Title='" + getTitle() + "'" +
            ", Credits='" + getCredits() + "'" +
            ", DepartmentId='" + getDepartmentId() + "'" +
            "}";
    }


    
}
