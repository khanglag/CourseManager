/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PersonDAL;
import BLL.DTO.Person;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class PersonBLL {
    PersonDAL personDAL;

    public PersonBLL() {
        personDAL = new PersonDAL();
    }

    public ArrayList<Person> getAllPerson() throws SQLException {
        return personDAL.readPersons();
    }

    public Person getPerson(int PersonID) throws SQLException {
        return personDAL.getPerson(PersonID);
    }

    public int addPerson(Person person) throws SQLException {
        return personDAL.addPerson(person);
    }

    public int updatePerson(Person person) throws SQLException {
        return personDAL.updatePerson(person);
    }

    public int deletePerson(int PersonID) throws SQLException {
        return personDAL.deletePerson(PersonID);
    }

    public ArrayList<Person> findPerson(String fullName) throws SQLException {
        ArrayList<Person> perList = new ArrayList<>();
        if (isNumeric(fullName)) {
            perList = personDAL.findPerson(Integer.parseInt(fullName));
        } else {
            perList = personDAL.findPerson(fullName);
        }
        return perList;
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
