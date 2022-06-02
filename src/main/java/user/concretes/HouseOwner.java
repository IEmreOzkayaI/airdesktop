/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.concretes;

import advertisement.abstracts.House;
import advertisement.concretes.Apartment;
import advertisement.concretes.Comment;
import core.concretes.Block;
import core.concretes.Wallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.concretes.Person;
import user.abstracts.ICustomer;

/**
 *
 * @author EmreOzkaya
 */
public class HouseOwner extends Person implements ICustomer {

    private int person_id;
    private Wallet wallet;
    private House rentedHouse;
    private List<House> housesToRent;
    private List<Comment> comments;

    private boolean isBlocked;
    Connection db = Singleton.SingletonConnection.getCon();

    public HouseOwner() {
        super();
        wallet = null;
        rentedHouse = null;
        comments = null;
        isBlocked = false;
        housesToRent = null;
    }

    @Override
    public boolean register() {
        boolean flag = false;
        this.setWallet(new Wallet());
        try {

            PreparedStatement prepstmtPerson = db.prepareStatement(Singleton.SingletonConnection.insertionPerson, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement prepstmtCustomer = db.prepareStatement(Singleton.SingletonConnection.insertionHouseOwner);

            // this id is null value because our database id increasing auto.
            // because of a error we couldn't do fk relation on the database table.So we use different values.
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
            prepstmtCustomer.setBoolean(4, this.getIsBlocked());

            prepstmtCustomer.execute();

            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean registerFromCustomer() {
        boolean flag = false;

        try {

            PreparedStatement prepstmtCustomer = db.prepareStatement(Singleton.SingletonConnection.insertionHouseOwner);
            PreparedStatement removeCustomer = db.prepareStatement(Singleton.SingletonConnection.deleteFromCustomer + "'" + this.getId() + "'");

            prepstmtCustomer.setInt(1, this.getId());
            prepstmtCustomer.setInt(2, this.getWallet().getId());
            if (this.getRentedHouse() != null) {
                prepstmtCustomer.setInt(3, this.getRentedHouse().getId());
            } else {
                prepstmtCustomer.setInt(3, 0);
            }
            prepstmtCustomer.setBoolean(4, false);

            prepstmtCustomer.execute();
            removeCustomer.execute();

            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public HouseOwner getUserByEmail(String email) {
        HouseOwner houseOwner = new HouseOwner();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE email='" + email + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                houseOwner.setBirthDate(rs.getString("birth_date"));
                houseOwner.setEmail(rs.getString("email"));
                houseOwner.setGender(rs.getString("gender"));
                houseOwner.setId(rs.getInt("id"));
                houseOwner.setIdentityNumber(rs.getString("identity_number"));
                houseOwner.setName(rs.getString("name"));
                houseOwner.setPassword(rs.getString("password"));
                houseOwner.setPhoneNumber(rs.getString("phone_number"));
                houseOwner.setSurname(rs.getString("surname"));
                houseOwner.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                houseOwner.setActivationResult(rs.getBoolean("activation_result"));
            }
            String getCustomerInfoByEmail = "SELECT * FROM house_owners WHERE person_id='" + houseOwner.getId() + "'";
            Statement stmt2 = db.createStatement();
            ResultSet rs2 = stmt2.executeQuery(getCustomerInfoByEmail);
            if (rs2.next()) {
                houseOwner.setIsBlocked(rs2.getBoolean("is_blocked"));
                houseOwner.setPerson_id(rs2.getInt("person_id"));
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
                houseOwner.setRentedHouse(house);
                Statement stmt3 = db.createStatement();
                ResultSet rs3 = stmt3.executeQuery(Singleton.SingletonConnection.getWalletById + "'" + rs2.getInt("wallet_id") + "'");
                while (rs3.next()) {
                    Wallet wallet = new Wallet(rs3.getInt("id"), rs3.getInt("total_amount"));
                    houseOwner.setWallet(wallet);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return houseOwner;
    }

    @Override
    public HouseOwner getUserById(int id) {
        HouseOwner houseOwner = new HouseOwner();
        String getPersonInfoByEmail = " SELECT * FROM persons WHERE id='" + id + "'";
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(getPersonInfoByEmail);
            if (rs.next()) {
                houseOwner.setBirthDate(rs.getString("birth_date"));
                houseOwner.setEmail(rs.getString("email"));
                houseOwner.setGender(rs.getString("gender"));
                houseOwner.setId(rs.getInt("id"));
                houseOwner.setIdentityNumber(rs.getString("identity_number"));
                houseOwner.setName(rs.getString("name"));
                houseOwner.setPassword(rs.getString("password"));
                houseOwner.setPhoneNumber(rs.getString("phone_number"));
                houseOwner.setSurname(rs.getString("surname"));
                houseOwner.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                houseOwner.setActivationResult(rs.getBoolean("activation_result"));
            }
            String getCustomerInfoByEmail = "SELECT * FROM house_owners WHERE person_id='" + houseOwner.getId() + "'";
            Statement stmt2 = db.createStatement();

            ResultSet rs2 = stmt2.executeQuery(getCustomerInfoByEmail);
            if (rs2.next()) {
                houseOwner.setIsBlocked(rs2.getBoolean("is_blocked"));
                houseOwner.setPerson_id(rs2.getInt("person_id"));
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
                houseOwner.setRentedHouse(house);
                Statement stmt3 = db.createStatement();

                ResultSet rs3 = stmt3.executeQuery(Singleton.SingletonConnection.getWalletById + "'" + rs2.getInt("wallet_id") + "'");
                while (rs3.next()) {
                    Wallet wallet = new Wallet(rs3.getInt("id"), rs3.getInt("total_amount"));
                    houseOwner.setWallet(wallet);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return houseOwner;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<House> getHousesToRent() {
        return housesToRent;
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

    public void setHousesToRent(List<House> housesToRent) {
        this.housesToRent = housesToRent;
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
