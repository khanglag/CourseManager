package DTO;

import java.util.Date;

public class Person {
    private int PersonID;
    private String LastName, FirstName;
    private Date HireDate, EnrollmentDate;

    public Person() {
    }

    public Person(int PersonID, String LastName, String FirstName, Date HireDate, Date EnrollmentDate) {
        this.PersonID = PersonID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.HireDate = HireDate;
        this.EnrollmentDate = EnrollmentDate;
    }

    public int getPersonID() {
        return this.PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public Date getHireDate() {
        return this.HireDate;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }

    public Date getEnrollmentDate() {
        return this.EnrollmentDate;
    }

    public void setEnrollmentDate(Date EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
    }

    public Person PersonID(int PersonID) {
        setPersonID(PersonID);
        return this;
    }

    public Person LastName(String LastName) {
        setLastName(LastName);
        return this;
    }

    public Person FirstName(String FirstName) {
        setFirstName(FirstName);
        return this;
    }

    public Person HireDate(Date HireDate) {
        setHireDate(HireDate);
        return this;
    }

    public Person EnrollmentDate(Date EnrollmentDate) {
        setEnrollmentDate(EnrollmentDate);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " PersonID='" + getPersonID() + "'" +
            ", LastName='" + getLastName() + "'" +
            ", FirstName='" + getFirstName() + "'" +
            ", HireDate='" + getHireDate() + "'" +
            ", EnrollmentDate='" + getEnrollmentDate() + "'" +
            "}";
    }

}
