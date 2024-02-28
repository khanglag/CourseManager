/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PersonDAL;
import DTO.Person;
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
        return personDAL.findPerson(fullName);
    }
}
