package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import DTO.Person;

public class PersonDAL extends MyDatabaseManager {

    public PersonDAL() {
        PersonDAL.connectDB();
    }

    public ArrayList<Person> readPersons() throws SQLException {
        ArrayList<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM person";
        ResultSet rs = PersonDAL.doReadQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("LastName"),
                        rs.getString("FirstName"),
                        rs.getDate("HireDate"),
                        rs.getDate("EnrollmentDate"));
                persons.add(person);
            }
        }
        //  closeConnect();
        return persons;
    }

    public Person getPerson(int PersonID) throws SQLException {
        String sql = "SELECT * FROM person WHERE PersonID =?";
        PreparedStatement p = PersonDAL.getConnection().prepareStatement(sql);
        p.setInt(1, PersonID);
        ResultSet rs = p.executeQuery();
        Person person = new Person();
        if (rs != null) {
            while (rs.next()) {
                person.setPersonID(rs.getInt("PersonID"));
                person.setLastName(rs.getString("LastName"));
                person.setFirstName(rs.getString("FirstName"));
                person.setHireDate(rs.getDate("HireDate"));
                person.setEnrollmentDate(rs.getDate("EnrollmentDate"));
            }
        }
        // closeConnect();
        return person;
    }

    public int addPerson(Person person) throws SQLException {
        String sql = "INSERT person (LastName, FirstName, HireDate, EnrollmentDate) VALUES (?,?,?,?)";
        PreparedStatement p = PersonDAL.getConnection().prepareStatement(sql);
        p.setString(1, person.getLastName());
        p.setString(2, person.getFirstName());
//        p.setDate(3, new java.sql.Date(person.getHireDate().getTime()));
//        p.setDate(4, new java.sql.Date(person.getEnrollmentDate().getTime()));
        if (person.getHireDate() == null) {
            p.setNull(3, java.sql.Types.DATE);
        } else {
            p.setDate(3, new java.sql.Date(person.getHireDate().getTime()));
        }
        if (person.getEnrollmentDate() == null) {
            p.setNull(4, java.sql.Types.DATE);
        } else {
            p.setDate(4, new java.sql.Date(person.getEnrollmentDate().getTime()));
        }
        return p.executeUpdate();
    }

    public int updatePerson(Person person) throws SQLException {
        String sql = "UPDATE person SET LastName =?, FirstName =?, HireDate =?, EnrollmentDate =? WHERE PersonID =?";
        PreparedStatement p = PersonDAL.getConnection().prepareStatement(sql);
        p.setString(1, person.getLastName());
        p.setString(2, person.getFirstName());
        p.setDate(3, new java.sql.Date(person.getHireDate().getTime()));
        p.setDate(4, new java.sql.Date(person.getEnrollmentDate().getTime()));
        p.setInt(5, person.getPersonID());
        return p.executeUpdate();
    }

    public int deletePerson(int PersonID) throws SQLException {
        String sql = "DELETE FROM person WHERE PerSonID = ?";
        PreparedStatement p = PersonDAL.getConnection().prepareStatement(sql);
        p.setInt(1, PersonID);
        return p.executeUpdate();
    }

    public ArrayList<Person> findPerson(int PersonID) throws SQLException {
        ArrayList<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE PersonID = ?";
        PreparedStatement p = PersonDAL.getConnection().prepareStatement(sql);
        p.setInt(1, PersonID);
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("LastName"),
                        rs.getString("FirstName"),
                        rs.getDate("HireDate"),
                        rs.getDate("EnrollmentDate"));
                list.add(person);
            }
        }
        return list;
    }

    public ArrayList<Person> findPerson(String fullName) throws SQLException {
        ArrayList<Person> list = new ArrayList<>();
        String query = "SELECT * FROM person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = PersonDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("PersonID"),
                        rs.getString("LastName"),
                        rs.getString("FirstName"),
                        rs.getDate("HireDate"),
                        rs.getDate("EnrollmentDate"));
                list.add(person);
            }
        }
        //    closeConnect();
        return list;
    }

}
