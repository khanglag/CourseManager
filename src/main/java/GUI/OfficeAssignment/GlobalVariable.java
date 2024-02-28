/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.OfficeAssignment;

/**
 *
 * @author acer
 */
public class GlobalVariable {
    public static int courseID;
    
     public GlobalVariable() {
        
    }
    public GlobalVariable(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    
}
