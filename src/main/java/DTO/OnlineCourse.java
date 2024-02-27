package DTO;

public class OnlineCourse extends Course{
    private int CourseID;
    private String Url;

    public OnlineCourse() {
    }

    
    public OnlineCourse(int CourseID, String Title, int Credits, int DepartmentId, String Url) {
        super(CourseID,Title,Credits,DepartmentId);
        this.Url = Url;
    }
    public OnlineCourse(int CourseID, String Url) {
        this.CourseID = CourseID;
        this.Url = Url;
    }

    public int getCourseID() {
        return this.CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public OnlineCourse CourseID(int CourseID) {
        setCourseID(CourseID);
        return this;
    }

    public OnlineCourse Url(String Url) {
        setUrl(Url);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " CourseID='" + getCourseID() + "'" +
            ", Url='" + getUrl() + "'" +
            "}";
    }
}
