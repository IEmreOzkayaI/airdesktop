/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advertisement.concretes;

import Singleton.SingletonConnection;
import advertisement.abstracts.House;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import user.concretes.Customer;
import user.concretes.HouseOwner;

/**
 *
 * @author EmreOzkaya
 */
public class Apartment extends House {

    Connection db = Singleton.SingletonConnection.getCon();
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    
    

    @Override
    public void create(File[] imageFiles, String[] imagePaths) {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.insertionHouse, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setInt(2, getHouseOwnerId());
            pst.setString(3, getRoomNumber());
            pst.setBoolean(4, isHasVehiclePark());
            pst.setString(5, getHeating());
            pst.setString(6, getLocation());
            pst.setString(7, getShortDescription());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {

                this.setId(rs.getInt(1));
            }

            addHouseImages(imageFiles, imagePaths);
        } catch (SQLException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addHouseImages(File[] imageFiles, String[] imagePaths) {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.insertionHouseImages, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < imagePaths.length; i++) {
                InputStream file = new FileInputStream(imageFiles[i]);
                pst.setInt(1, 0);
                pst.setInt(2, getId());
                pst.setString(3, imagePaths[i]);
                pst.setBlob(4, file);
                pst.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(File[] imageFiles, String[] imagePaths) {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.updateHouseById + "'" + getId() + "'");
            pst.setString(1, getShortDescription());
            pst.execute();
            updateHouseImages(imageFiles, imagePaths);
        } catch (SQLException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateHouseImages(File[] imageFiles, String[] imagePaths) {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.updateHouseImagesById + "'" + getId() + "'");
            for (int i = 0; i < imagePaths.length; i++) {
                InputStream file = new FileInputStream(imageFiles[i]);
                pst.setString(1, imagePaths[i]);
                pst.setBlob(2, file);
                pst.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete() {
        try {
            pst = db.prepareStatement(SingletonConnection.deleteHouseById + "'" + getId() + "'");
            pst.execute();
            pst = db.prepareStatement(SingletonConnection.deleteImagesByHouseId + "'" + getId() + "'");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rent(int totalPrice, Advertisement ad, int personId) {

        Customer customer = new Customer();
        customer = customer.getUserById(personId);
        if (customer.getWallet() == null) {
            HouseOwner hoOwner = new HouseOwner();
            hoOwner = hoOwner.getUserById(personId);
            if (hoOwner.getWallet().getTotalAmount() < totalPrice) {
                JOptionPane.showMessageDialog(null, "You don't have enough money");

            } else {
                try {
                    pst = db.prepareStatement(SingletonConnection.insertionHireDates);
                    pst.setInt(1, 0);
                    pst.setInt(2, ad.getId());
                    pst.setString(3, ad.getHireStart());
                    pst.setString(4, ad.getHireFinish());
                    pst.execute();
                    HouseOwner hoOwner3 = new HouseOwner();
                    hoOwner3 = hoOwner3.getUserById(ad.getHouseOwnerId());
                    hoOwner.getWallet().sendMoney(totalPrice, hoOwner3.getWallet());
                    hoOwner.setRentedHouse(ad.getHouse());

                    try {
                        pst = db.prepareStatement(SingletonConnection.updateHouseOwnerRentedInfoById + "'" + hoOwner.getId() + "'");
                        pst.setInt(1, ad.getHouse().getId());
                        pst.execute();

                        pst.setInt(1, ad.getHouse().getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (customer.getWallet().getTotalAmount() < totalPrice) {
                JOptionPane.showMessageDialog(null, "You don't have enough money");
            } else {

                try {

                    pst = db.prepareStatement(SingletonConnection.insertionHireDates);
                    pst.setInt(1, 0);
                    pst.setInt(2, ad.getId());
                    pst.setString(3, ad.getHireStart());
                    pst.setString(4, ad.getHireFinish());
                    pst.execute();

                    HouseOwner hoOwner2 = new HouseOwner();
                    hoOwner2 = hoOwner2.getUserById(ad.getHouseOwnerId());

                    customer.getWallet().sendMoney(totalPrice, hoOwner2.getWallet());
                    customer.setRentedHouse(ad.getHouse());
                    try {
                        pst = db.prepareStatement(SingletonConnection.updateCustomerRentedInfoById + "'" + customer.getId() + "'");
                        pst.setInt(1, ad.getHouse().getId());
                        pst.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Apartment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
