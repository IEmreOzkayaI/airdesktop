/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advertisement.concretes;

import GUI.PersonnelScreen;
import Singleton.SingletonConnection;
import advertisement.abstracts.House;
import advertisement.abstracts.IAdvertisement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.concretes.Personnel;

/**
 *
 * @author EmreOzkaya
 */
public class Advertisement implements IAdvertisement {

    private int id;
    private int houseOwnerId;
    private House house;
    private int price;
    private String advertisementName;
    private String advertisementType;
    private List<Comment> comments;
    private String hireStart;
    private String hireFinish;

    private int activationPersonnelId;
    private boolean activationResult;

    Connection db = Singleton.SingletonConnection.getCon();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    HouseFactory houseFactory = new HouseFactory();

    public Advertisement() {

    }

    @Override
    public void create() {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.insertionAdvertisement);
            pst.setInt(1, 0);
            pst.setInt(2, getHouseOwnerId());
            pst.setInt(3, getHouse().getId());
            pst.setString(4, getAdvertisementName());
            pst.setString(5, getAdvertisementType());
            pst.setInt(6, 0);
            pst.setBoolean(7, false);
            pst.setInt(8, getPrice());
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.updateAdvertisementById + "'" + getId() + "'");
            pst.setString(1, getAdvertisementName());
            pst.setInt(2, getActivationPersonnelId());
            pst.setBoolean(3, isActivationResult());
            pst.setInt(4, getPrice());
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        String deleteAdvertisement = "DELETE FROM advertisements WHERE id='" + getId() + "'";
        try {
            pst = db.prepareStatement(deleteAdvertisement);
            pst.execute();
            getHouse().delete();
            pst = db.prepareStatement(SingletonConnection.deleteHireDates + "'" + getId() + "'");
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void validateAdvertisement(Personnel personnel, int advertisementId) {
        String updateAdvertisementValidation = "UPDATE advertisements SET activation_result=true , activation_personnel_id='" + personnel.getPerson_id() + "' WHERE id='" + advertisementId + "'";
        try {
            pst = db.prepareStatement(updateAdvertisementValidation);
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(PersonnelScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Advertisement> getAllAdvertisementsIsActiveFalse() {
        List<Advertisement> list = new ArrayList<>();

        try {
            st = db.createStatement();
            rs = st.executeQuery(SingletonConnection.getAllAdvertisementsIsActiveFalse);
            while (rs.next()) {
                Advertisement ad = new Advertisement();
                ad.setId(rs.getInt("id"));
                ad.setHouseOwnerId(rs.getInt("person_id"));
                ad.setAdvertisementName(rs.getString("advertisement_name"));
                String type = rs.getString("advertisement_type");
                ad.setAdvertisementType(type);
                ad.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                ad.setActivationResult(rs.getBoolean("activation_result"));
                ad.setPrice(rs.getInt("price"));
                Statement st2 = db.createStatement();
                ResultSet rs2 = st2.executeQuery(SingletonConnection.getHouseById + "'" + rs.getInt("house_id") + "'");
                House house = houseFactory.getHouse(type);

                while (rs2.next()) {
                    house.setId(rs2.getInt("id"));
                    house.setHasVehiclePark(rs2.getBoolean("has_vehicle_park"));
                    house.setRoomNumber(rs2.getString("room_number"));
                    house.setHeating(rs2.getString("heating"));
                    house.setHouseOwnerId(rs2.getInt("person_id"));
                    house.setLocation(rs2.getString("address"));
                    house.setShortDescription(rs2.getString("short_description"));

//                    house.setHouseImage(rs2.getString("address"));
                }
                ad.setHouse(house);
                list.add(ad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Advertisement> getAllAdvertisementsIsActiveTrue() {
        List<Advertisement> list = new ArrayList<>();

        try {
            st = db.createStatement();
            rs = st.executeQuery(SingletonConnection.getAllAdvertisementsIsActiveTrue);
            while (rs.next()) {
                Advertisement ad = new Advertisement();
                ad.setId(rs.getInt("id"));
                ad.setHouseOwnerId(rs.getInt("person_id"));
                ad.setAdvertisementName(rs.getString("advertisement_name"));
                String type = rs.getString("advertisement_type");
                ad.setAdvertisementType(type);
                ad.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                ad.setActivationResult(rs.getBoolean("activation_result"));
                ad.setPrice(rs.getInt("price"));
                Statement st2 = db.createStatement();
                ResultSet rs2 = st2.executeQuery(SingletonConnection.getHouseById + "'" + rs.getInt("house_id") + "'");
                House house = houseFactory.getHouse(type);
                while (rs2.next()) {
                    house.setId(rs2.getInt("id"));
                    house.setHasVehiclePark(rs2.getBoolean("has_vehicle_park"));
                    house.setRoomNumber(rs2.getString("room_number"));
                    house.setHeating(rs2.getString("heating"));
                    house.setHouseOwnerId(rs2.getInt("person_id"));
                    house.setLocation(rs2.getString("address"));
                    house.setShortDescription(rs2.getString("short_description"));
                    Statement st3 = db.createStatement();
                    ResultSet rs3 = st3.executeQuery(SingletonConnection.getHouseIconImg + "'" + rs.getInt("house_id") + "'");
                    System.out.println(SingletonConnection.getHouseIconImg + "'" + rs.getInt("house_id") + "'");
                    while (rs3.next()) {
                        System.out.println("RAW IMAGE BLOB FROM DATABASE=" + rs3.getBytes("image_file").length);
                        house.setHouseIconImg(rs3.getBytes("image_file"));
                    }
//                    house.setHouseImage(rs2.getString("address"));
                }
                ad.setHouse(house);
                list.add(ad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Advertisement showDetailedInfo(int advertisementId) {
        Advertisement ad = new Advertisement();
        try {
            st = db.createStatement();
            rs = st.executeQuery(SingletonConnection.getAdvertisementById + "'" + advertisementId + "'");
            while (rs.next()) {
                ad.setId(rs.getInt("id"));
                ad.setHouseOwnerId(rs.getInt("person_id"));
                ad.setAdvertisementName(rs.getString("advertisement_name"));
                String type = rs.getString("advertisement_type");
                ad.setAdvertisementType(type);
                ad.setActivationPersonnelId(rs.getInt("activation_personnel_id"));
                ad.setActivationResult(rs.getBoolean("activation_result"));
                ad.setPrice(rs.getInt("price"));
                Statement st2 = db.createStatement();
                ResultSet rs2 = st2.executeQuery(SingletonConnection.getHouseById + "'" + rs.getInt("house_id") + "'");
                House house = houseFactory.getHouse(type);
                while (rs2.next()) {
                    house.setId(rs2.getInt("id"));
                    house.setHasVehiclePark(rs2.getBoolean("has_vehicle_park"));
                    house.setRoomNumber(rs2.getString("room_number"));
                    house.setHeating(rs2.getString("heating"));
                    house.setHouseOwnerId(rs2.getInt("person_id"));
                    house.setLocation(rs2.getString("address"));
                    house.setShortDescription(rs2.getString("short_description"));
                    Statement st3 = db.createStatement();
                    ResultSet rs3 = st3.executeQuery(SingletonConnection.getHouseIconImg + "'" + rs.getInt("house_id") + "'");
                    System.out.println(SingletonConnection.getHouseIconImg + "'" + rs.getInt("house_id") + "'");
                    ArrayList<byte[]> imgs = new ArrayList();
                    while (rs3.next()) {
                        imgs.add(rs3.getBytes("image_file"));
                        house.setHouseIconImg(rs3.getBytes("image_file"));
                    }
                    house.setImages(imgs);
                }
                ad.setHouse(house);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Advertisement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }


    
    public int getActivationPersonnelId() {
        return activationPersonnelId;
    }

    public String getAdvertisementName() {
        return advertisementName;
    }

    public String getAdvertisementType() {
        return advertisementType;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public House getHouse() {
        return house;
    }

    public int getHouseOwnerId() {
        return houseOwnerId;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
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

    public void setAdvertisementName(String advertisementName) {
        this.advertisementName = advertisementName;
    }

    public void setAdvertisementType(String advertisementType) {
        this.advertisementType = advertisementType;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setHouseOwnerId(int houseOwnerId) {
        this.houseOwnerId = houseOwnerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHireFinish() {
        return hireFinish;
    }

    public String getHireStart() {
        return hireStart;
    }

    public void setHireFinish(String hireFinish) {
        this.hireFinish = hireFinish;
    }

    public void setHireStart(String hireStart) {
        this.hireStart = hireStart;
    }
}
