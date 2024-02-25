/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author MSII
 */
public class Department {
    private int DepartmentId;
    private String Name;
    private double Budget;
    private Date StartDate;
    private int Administrator;

    public Department() {
    }

    public Department(int DepartmentId, String Name, double Budget, Date StartDate, int Administrator) {
        this.DepartmentId = DepartmentId;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
        this.Administrator = Administrator;
    }

    public int getDepartmentId() {
        return this.DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getBudget() {
        return this.Budget;
    }

    public void setBudget(double Budget) {
        this.Budget = Budget;
    }

    public Date getStartDate() {
        return this.StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public int getAdministrator() {
        return this.Administrator;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    public Department DepartmentId(int DepartmentId) {
        setDepartmentId(DepartmentId);
        return this;
    }

    public Department Name(String Name) {
        setName(Name);
        return this;
    }

    public Department Budget(double Budget) {
        setBudget(Budget);
        return this;
    }

    public Department StartDate(Date StartDate) {
        setStartDate(StartDate);
        return this;
    }

    public Department Administrator(int Administrator) {
        setAdministrator(Administrator);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " DepartmentId='" + getDepartmentId() + "'" +
            ", Name='" + getName() + "'" +
            ", Budget='" + getBudget() + "'" +
            ", StartDate='" + getStartDate() + "'" +
            ", Administrator='" + getAdministrator() + "'" +
            "}";
    }
}
