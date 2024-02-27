/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DepartmentDAL;
import DTO.Department;

/**
 *
 * @author MSII
 */
public class DepartmentBLL {
    DepartmentDAL dpmDAL;

    public DepartmentBLL() {
        dpmDAL = new DepartmentDAL();
    }

    public ArrayList<Department> getAllDepartments() throws SQLException {
        return dpmDAL.readDepartments();
    }

    public Department getDepartment(int DepartmentID) throws SQLException {
        return dpmDAL.getDepartment(DepartmentID);
    }

    public int addDepartment(Department dpm) throws SQLException {
        return dpmDAL.addDepartment(dpm);
    }
    public int getN() throws SQLException{
        return dpmDAL.getN();
    }

    public int updateDepartment(Department dpm) throws SQLException {
        return dpmDAL.updateDepartment(dpm);
    }

    public int deleteDepartment(int DepartmentID) throws SQLException {
        return dpmDAL.deleteDepartment(DepartmentID);
    }

    public ArrayList<Department> finDepartments(String str) throws SQLException {
        ArrayList<Department> list = new ArrayList<Department>();
        if (isNumeric(str))
            list = dpmDAL.findDepartments(Integer.parseInt(str));
        else
            list = dpmDAL.findDepartments(str);
        
        return list;

    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
