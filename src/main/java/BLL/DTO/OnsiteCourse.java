package BLL.DTO;

import java.time.LocalTime;


public class OnsiteCourse extends Course{

    private String Location;
    private String Days;
    private  LocalTime Time;

    public OnsiteCourse() {
    }
    public OnsiteCourse(int CourseID, String Title, int Credits, int DepartmentId, String Location, String Days, LocalTime Time) {
        super(CourseID,Title,Credits,DepartmentId);
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public OnsiteCourse(int CourseID, String Location, String Days, LocalTime Time) {
        super(CourseID);
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return this.Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public LocalTime getTime() {
        return this.Time;
    }

    public void setTime(LocalTime Time) {
        this.Time = Time;
    }

    public OnsiteCourse CourseID(int CourseID) {
        setCourseID(CourseID);
        return this;
    }

    public OnsiteCourse Location(String Location) {
        setLocation(Location);
        return this;
    }

    public OnsiteCourse Days(String Days) {
        setDays(Days);
        return this;
    }

    public OnsiteCourse Time(LocalTime Time) {
        setTime(Time);
        return this;
    }

    @Override
    public String toString() {
        return super.toString()+ "{" +
            " CourseID='" + getCourseID() + "'" +
            ", Location='" + getLocation() + "'" +
            ", Days='" + getDays() + "'" +
            ", Time='" + getTime() + "'" +
            "}";
    }
}
