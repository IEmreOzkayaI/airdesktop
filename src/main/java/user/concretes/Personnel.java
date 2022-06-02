/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.concretes;

import Singleton.SingletonConnection;
import advertisement.concretes.Advertisement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.abstracts.IPersonnel;

/**
 *
 * @author EmreOzkaya
 */
public class Personnel extends Person implements IPersonnel {

    private int person_id;

    public Personnel() {

    }

    @Override
    public Personnel getUserByEmail(String email) {
        Personnel personnel = new Personnel();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE email='" + email + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                personnel.setBirthDate(rs.getString("birth_date"));
                personnel.setEmail(rs.getString("email"));
                personnel.setGender(rs.getString("gender"));
                personnel.setId(rs.getInt("id"));
                personnel.setIdentityNumber(rs.getString("identity_number"));
                personnel.setName(rs.getString("name"));
                personnel.setPassword(rs.getString("password"));
                personnel.setPhoneNumber(rs.getString("phone_number"));
                personnel.setSurname(rs.getString("surname"));
                personnel.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                personnel.setActivationResult(rs.getBoolean("activation_result"));
            }
            String getCustomerInfoByEmail = "SELECT * FROM personnels WHERE person_id='" + personnel.getId() + "'";
            Statement stmt2 = db.createStatement();

            ResultSet rs2 = stmt2.executeQuery(getCustomerInfoByEmail);
            if (rs2.next()) {
                personnel.setPerson_id(rs2.getInt("person_id"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnel;
    }
    
        @Override
    public Personnel getUserById(int id) {
        Personnel personnel = new Personnel();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE id='" + id + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                personnel.setBirthDate(rs.getString("birth_date"));
                personnel.setEmail(rs.getString("email"));
                personnel.setGender(rs.getString("gender"));
                personnel.setId(rs.getInt("id"));
                personnel.setIdentityNumber(rs.getString("identity_number"));
                personnel.setName(rs.getString("name"));
                personnel.setPassword(rs.getString("password"));
                personnel.setPhoneNumber(rs.getString("phone_number"));
                personnel.setSurname(rs.getString("surname"));
                personnel.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                personnel.setActivationResult(rs.getBoolean("activation_result"));
            }
            String getCustomerInfoByEmail = "SELECT * FROM personnels WHERE person_id='" + personnel.getId() + "'";
            Statement stmt2 = db.createStatement();

            ResultSet rs2 = stmt2.executeQuery(getCustomerInfoByEmail);
            if (rs2.next()) {
                personnel.setPerson_id(rs2.getInt("person_id"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnel;
    }

    @Override
    public List<Person> getAllIsBlockTrue() {
        List<Person> personList = new ArrayList<>();
        try {
            st = db.createStatement();
            rs = st.executeQuery(SingletonConnection.getAllCustomerIsBlockTrue);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("person_id"));
                Statement st2 = db.createStatement();
                ResultSet rs2 = st2.executeQuery(SingletonConnection.getPersonById + "'" + person.getId() + "'");
                while (rs2.next()) {
                    person.setName(rs2.getString("name"));
                    person.setSurname(rs2.getString("surname"));
                    person.setEmail(rs2.getString("email"));
                    person.setPassword(rs2.getString("password"));
                    person.setGender(rs2.getString("gender"));
                    person.setPhoneNumber(rs2.getString("phone_number"));
                    person.setIdentityNumber(rs2.getString("identity_number"));
                    person.setBirthDate(rs2.getString("birth_Date"));
                    person.setActivationPersonnelId(rs2.getInt("activation_personnel_id"));
                    person.setActivationResult(rs2.getBoolean("activation_result"));
                }

                personList.add(person);
            }

            rs = st.executeQuery(SingletonConnection.getAllHouseOwnerIsBlockTrue);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("person_id"));
                Statement st2 = db.createStatement();
                ResultSet rs2 = st2.executeQuery(SingletonConnection.getPersonById + "'" + person.getId() + "'");
                while (rs2.next()) {
                    person.setName(rs2.getString("name"));
                    person.setSurname(rs2.getString("surname"));
                    person.setEmail(rs2.getString("email"));
                    person.setPassword(rs2.getString("password"));
                    person.setGender(rs2.getString("gender"));
                    person.setPhoneNumber(rs2.getString("phone_number"));
                    person.setIdentityNumber(rs2.getString("identity_number"));
                    person.setBirthDate(rs2.getString("birth_Date"));
                    person.setActivationPersonnelId(rs2.getInt("activation_personnel_id"));
                    person.setActivationResult(rs2.getBoolean("activation_result"));
                }
                personList.add(person);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personList;
    }

    @Override
    public List<Person> getAllIsActiveFalse() {
        List<Person> personList = new ArrayList<>();
        try {
            st = db.createStatement();
            rs = st.executeQuery(SingletonConnection.getAllPersonIsActiveFalse);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setEmail(rs.getString("email"));
                person.setPassword(rs.getString("password"));
                person.setGender(rs.getString("gender"));
                person.setPhoneNumber(rs.getString("phone_number"));
                person.setIdentityNumber(rs.getString("identity_number"));
                person.setBirthDate(rs.getString("birth_Date"));
                person.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                person.setActivationResult(rs.getBoolean("activation_result"));
                personList.add(person);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personList;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

}
