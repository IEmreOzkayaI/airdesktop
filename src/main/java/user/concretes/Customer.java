/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.concretes;

import advertisement.abstracts.House;
import advertisement.concretes.Apartment;
import advertisement.concretes.Comment;
import core.concretes.Wallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.abstracts.ICustomer;

/**
 *
 * @author EmreOzkaya
 */
public class Customer extends Person implements ICustomer {

    private int person_id;
    private Wallet wallet;
    private House rentedHouse;
    private List<Comment> comments;
    private boolean isBlocked;
    private Connection db = Singleton.SingletonConnection.getCon();

    public Customer() {
        super();
        wallet = null;
        rentedHouse = null;
        comments = null;
        isBlocked = false;
    }

    @Override
    public boolean register() {
        boolean flag = false;
        this.setWallet(new Wallet());
        try {

            PreparedStatement prepstmtPerson = db.prepareStatement(Singleton.SingletonConnection.insertionPerson, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement prepstmtCustomer = db.prepareStatement(Singleton.SingletonConnection.insertionCustomer);
            // this id is null value because our database id increments auto.
            // because of an error we couldn't do fk relation on the database table.So we use different values.
            int id = 0;
            prepstmtPerson.setInt(1, this.getId());
            prepstmtPerson.setString(2, this.getName());
            prepstmtPerson.setString(3, this.getSurname());
            prepstmtPerson.setString(4, this.getEmail());
            prepstmtPerson.setString(5, this.getPassword());
            prepstmtPerson.setString(6, this.getGender());
            prepstmtPerson.setString(7, this.getPhoneNumber());
            prepstmtPerson.setString(8, this.getIdentityNumber());
            prepstmtPerson.setString(9, this.getBirthDate());
            prepstmtPerson.setInt(10, this.getActivationPersonnelId());
            prepstmtPerson.setBoolean(11, this.isActivationResult());

            prepstmtPerson.execute();
            rs = prepstmtPerson.getGeneratedKeys();
            while (rs.next()) {
                this.setId(rs.getInt(1));
            }
            prepstmtCustomer.setInt(1, this.getId());
            prepstmtCustomer.setInt(2, this.getWallet().getId());
            prepstmtCustomer.setInt(3, 0);
            prepstmtCustomer.setBoolean(4, this.isBlocked);

            prepstmtCustomer.execute();

            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public Customer getUserByEmail(String email) {
        Customer customer = new Customer();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE email='" + email + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                customer.setBirthDate(rs.getString("birth_date"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setId(rs.getInt("id"));
                customer.setIdentityNumber(rs.getString("identity_number"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setSurname(rs.getString("surname"));
                customer.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                customer.setActivationResult(rs.getBoolean("activation_result"));

            }
            String getCustomerInfoByEmail = "SELECT * FROM customers WHERE person_id='" + customer.getId() + "'";
            Statement stmt2 = db.createStatement();

            ResultSet rs2 = stmt2.executeQuery(getCustomerInfoByEmail);
            if (rs2.next()) {
                customer.setIsBlocked(rs2.getBoolean("is_blocked"));
                customer.setPerson_id(rs2.getInt("person_id"));
                            Statement stmt4 = db.createStatement();

                ResultSet rs4 = stmt4.executeQuery(Singleton.SingletonConnection.getHouseById + "'" + rs2.getInt("rented_house_id") + "'");
                House house = new Apartment();

                while (rs4.next()) {
                    house.setId(rs4.getInt(1));
                    house.setRoomNumber(rs4.getString("room_number"));
                    house.setHasVehiclePark(rs4.getBoolean("has_vehicle_park"));
                    house.setHeating(rs4.getString("heating"));
                    house.setLocation(rs4.getString("address"));
                    house.setShortDescription(rs4.getString("short_description"));

                }
                customer.setRentedHouse(house);
                            Statement stmt3 = db.createStatement();

                ResultSet rs3 = stmt3.executeQuery(Singleton.SingletonConnection.getWalletById + "'" + rs2.getInt("wallet_id") + "'");
                while (rs3.next()) {
                    Wallet wallet = new Wallet(rs3.getInt("id"), rs3.getInt("total_amount"));
                    customer.setWallet(wallet);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public Customer getUserById(int id) {
        Customer customer = new Customer();
        String getPersonInfoById = " SELECT * FROM persons WHERE id ='" + id + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoById);
            if (rs.next()) {
                customer.setBirthDate(rs.getString("birth_date"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setId(rs.getInt("id"));
                customer.setIdentityNumber(rs.getString("identity_number"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setSurname(rs.getString("surname"));
                customer.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                customer.setActivationResult(rs.getBoolean("activation_result"));

            }
            String getCustomerInfoById = "SELECT * FROM customers WHERE person_id='" + customer.getId() + "'";
            Statement stmt2 = db.createStatement();

            ResultSet rs2 = stmt2.executeQuery(getCustomerInfoById);
            if (rs2.next()) {
                customer.setIsBlocked(rs2.getBoolean("is_blocked"));
                customer.setPerson_id(rs2.getInt("person_id"));
                            Statement stmt4 = db.createStatement();

                ResultSet rs4 = stmt4.executeQuery(Singleton.SingletonConnection.getHouseById + "'" + rs2.getInt("rented_house_id") + "'");
                House house = new Apartment();

                while (rs4.next()) {
                    house.setId(rs4.getInt(1));
                    house.setRoomNumber(rs4.getString("room_number"));
                    house.setHasVehiclePark(rs4.getBoolean("has_vehicle_park"));
                    house.setHeating(rs4.getString("heating"));
                    house.setLocation(rs4.getString("address"));
                    house.setShortDescription(rs4.getString("short_description"));

                }
                customer.setRentedHouse(house);
                            Statement stmt3 = db.createStatement();

                ResultSet rs3 = stmt3.executeQuery(Singleton.SingletonConnection.getWalletById + "'" + rs2.getInt("wallet_id") + "'");
                while (rs3.next()) {
                    Wallet wallet = new Wallet(rs3.getInt("id"), rs3.getInt("total_amount"));
                    customer.setWallet(wallet);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public House getRentedHouse() {
        return rentedHouse;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public void setRentedHouse(House rentedHouse) {
        this.rentedHouse = rentedHouse;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

}
