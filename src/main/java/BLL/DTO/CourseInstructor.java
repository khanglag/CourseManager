package BLL.DTO;

public class CourseInstructor {
    private int CourseID, PersonID;

    public CourseInstructor() {
    }

    public CourseInstructor(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }

    public int getCourseID() {
        return this.CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getPersonID() {
        return this.PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public CourseInstructor CourseID(int CourseID) {
        setCourseID(CourseID);
        return this;
    }

    public CourseInstructor PersonID(int PersonID) {
        setPersonID(PersonID);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " CourseID='" + getCourseID() + "'" +
            ", PersonID='" + getPersonID() + "'" +
            "}";
    }
}
