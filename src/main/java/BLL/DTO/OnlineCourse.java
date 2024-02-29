package BLL.DTO;

public class OnlineCourse extends Course{
    
    private String Url;

    public OnlineCourse() {
    }

    
    public OnlineCourse(int CourseID, String Title, int Credits, int DepartmentId, String Url) {
        super(CourseID,Title,Credits,DepartmentId);
        this.Url = Url;
    }
    public OnlineCourse(int CourseID, String Url) {
        super(CourseID);
        this.Url = Url;
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

        return super.toString() + 

            ", Url='" + getUrl() + "'" +
            "}";
    }
}
