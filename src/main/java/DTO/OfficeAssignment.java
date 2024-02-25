package DTO;

import java.sql.Timestamp;

public class OfficeAssignment {
    private int InstructorID;
    private String Location;
    private  Timestamp TimeStamp;

    public OfficeAssignment() {
    }

    public OfficeAssignment(int InstructorID, String Location, Timestamp TimeStamp) {
        this.InstructorID = InstructorID;
        this.Location = Location;
        this.TimeStamp = TimeStamp;
    }

    public int getInstructorID() {
        return this.InstructorID;
    }

    public void setInstructorID(int InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Timestamp getTimeStamp() {
        return this.TimeStamp;
    }

    public void setTimeStamp(Timestamp TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    public OfficeAssignment InstructorID(int InstructorID) {
        setInstructorID(InstructorID);
        return this;
    }

    public OfficeAssignment Location(String Location) {
        setLocation(Location);
        return this;
    }

    public OfficeAssignment TimeStamp(Timestamp TimeStamp) {
        setTimeStamp(TimeStamp);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " InstructorID='" + getInstructorID() + "'" +
            ", Location='" + getLocation() + "'" +
            ", TimeStamp='" + getTimeStamp() + "'" +
            "}";
    }
    
}
