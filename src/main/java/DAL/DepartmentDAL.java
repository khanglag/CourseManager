package DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import BLL.DTO.Department;

public class DepartmentDAL extends MyDatabaseManager {
    public DepartmentDAL() {
        DepartmentDAL.connectDB();
    }

    public ArrayList<Department> readDepartments() throws SQLException {
        ArrayList<Department> departmentList = new ArrayList<>();
        String sql = "SELECT * FROM department";
        ResultSet rs = DepartmentDAL.doReadQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                Department d = new Department(
                        rs.getInt("DepartmentID"),
                        rs.getString("Name"),
                        rs.getDouble("Budget"),
                        rs.getDate("StartDate"),
                        rs.getInt("Administrator"));
                departmentList.add(d);
            }
        }
       // closeConnect();
        return departmentList;
    }

    public Department getDepartment(int DepartmentID) throws SQLException {
        String sql = "SELECT * FROM department WHERE DepartmentID = ?";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, DepartmentID);
        ResultSet rs = p.executeQuery();
        Department department = new Department();
        if (rs != null) {
            while (rs.next()) {
                department.setDepartmentId(rs.getInt("DepartmentID"));
                department.setName(rs.getString("Name"));
                department.setBudget(rs.getDouble("Budget"));
                department.setStartDate(rs.getDate("StartDate"));
                department.setAdministrator(rs.getInt("Administrator"));
            }
        }
        return department;
    }

    public int addDepartment(Department department) throws SQLException {
        String sql = " INSERT  department (DepartmentID,Name, Budget, StartDate, Administrator) VALUES (?,?, ?, ?, ?)";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, department.getDepartmentId());
        p.setString(2, department.getName());
        p.setDouble(3, department.getBudget());
        p.setDate(4, new java.sql.Date(department.getStartDate().getTime()));
        p.setInt(5, department.getAdministrator());
        return p.executeUpdate();
    }

    public int updateDepartment(Department department) throws SQLException {
        String sql = "UPDATE department SET Budget = ?,  Administrator = ? WHERE DepartmentID = ?";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(sql);
        p.setDouble(1, department.getBudget());
        p.setInt(2, department.getAdministrator());
        p.setInt(3, department.getDepartmentId());
        return p.executeUpdate();
    }

   
    public int getN() throws SQLException {
        String sql = "SELECT departmentid FROM department ORDER BY departmentid DESC LIMIT 1";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(sql);
        ResultSet rs = p.executeQuery();

        int departmentId = 0; // Khởi tạo biến để lưu trữ departmentId

        // Kiểm tra xem có dữ liệu trả về không
        if (rs.next()) {
            departmentId = rs.getInt("departmentid"); // Lấy giá trị departmentid từ kết quả truy vấn
        }
        return departmentId;
    }

    public ArrayList<Department> findDepartments(int DepartmentID) throws SQLException {
        ArrayList<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department WHERE DepartmentID =?";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(sql);
        p.setInt(1, DepartmentID);
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Department department = new Department(
                        rs.getInt("DepartmentID"),
                        rs.getString("Name"),
                        rs.getDouble("Budget"),
                        rs.getDate("StartDate"),
                        rs.getInt("Administrator"));
                list.add(department);
            }
        }
        return list;
    }
    

    public ArrayList<Department> findDepartments(String Name) throws SQLException {
        ArrayList<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department WHERE Name LIKE?";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(sql);
        p.setString(1, "%" + Name + "%");
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Department department = new Department(
                        rs.getInt("DepartmentID"),
                        rs.getString("Name"),
                        rs.getDouble("Budget"),
                        rs.getDate("StartDate"),
                        rs.getInt("Administrator"));
                list.add(department);
            }
        }
        return list;
    }

    
    
}
