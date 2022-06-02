/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.concretes;

import GUI.HomeScreen;
import Singleton.SingletonConnection;
import advertisement.concretes.Advertisement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import user.abstracts.IPerson;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EmreOzkaya
 */
public class Person implements IPerson {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private String gender;
    private String password;
    private String phoneNumber;
    private String identityNumber;
    private int activationPersonnelId;
    private boolean activationResult;
    Connection db = Singleton.SingletonConnection.getCon();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public Person() {
    }

    @Override
    public boolean update() {
        try {
            pst = db.prepareStatement(SingletonConnection.updataPersonById + "'" + getId() + "'");
            pst.setString(1, this.getEmail());
            pst.setString(2, this.getPassword());
            pst.setString(3, this.getPhoneNumber());
            pst.setInt(4, this.getActivationPersonnelId());
            pst.setBoolean(5, this.isActivationResult());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public Person getUserByEmail(String email) {
        Person person = new Person();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE email='" + email + "'";
        try {
            st = db.createStatement();
            rs = st.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                person.setBirthDate(rs.getString("birth_date"));
                person.setEmail(rs.getString("email"));
                person.setGender(rs.getString("gender"));
                person.setId(rs.getInt("id"));
                person.setIdentityNumber(rs.getString("identity_number"));
                person.setName(rs.getString("name"));
                person.setPassword(rs.getString("password"));
                person.setPhoneNumber(rs.getString("phone_number"));
                person.setSurname(rs.getString("surname"));
                person.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                person.setActivationResult(rs.getBoolean("activation_result"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    @Override
    public Person getUserById(int id) {
        Person person  = new Person();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE id='" + id + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                person.setBirthDate(rs.getString("birth_date"));
                person.setEmail(rs.getString("email"));
                person.setGender(rs.getString("gender"));
                person.setId(rs.getInt("id"));
                person.setIdentityNumber(rs.getString("identity_number"));
                person.setName(rs.getString("name"));
                person.setPassword(rs.getString("password"));
                person.setPhoneNumber(rs.getString("phone_number"));
                person.setSurname(rs.getString("surname"));
                person.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                person.setActivationResult(rs.getBoolean("activation_result"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    @Override
    public boolean isEmailExist(String email) {
        String isUserRegistered = " SELECT email FROM persons WHERE email='" + email + "'";

        try {
            st = db.createStatement();
            rs = st.executeQuery(isUserRegistered);
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean isIdentityExist(String identity) {
        String isUserRegistered = " SELECT email FROM persons WHERE identity_number='" + identity + "'";

        try {
            st = db.createStatement();
            rs = st.executeQuery(isUserRegistered);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updatePassword(String email, String password) {
        String update = " UPDATE persons SET password='" + password + "' WHERE email='" + email + "'";
        Person person = getUserByEmail(email);
        if (person.getPassword().equalsIgnoreCase(password)) {
            return false;
        } else {
            try {
                PreparedStatement updatePass = db.prepareStatement(update);
                updatePass.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    @Override
    public boolean logIn(String email, String password) {

        return false;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getActivationPersonnelId() {
        return activationPersonnelId;
    }

    public boolean isActivationResult() {
        return activationResult;
    }

    public void setActivationPersonnelId(int activationPersonnelId) {
        this.activationPersonnelId = activationPersonnelId;
    }

    public void setActivationResult(boolean activationResult) {
        this.activationResult = activationResult;
    }

}
