/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.concretes;

import core.abstracts.IBlock;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.concretes.Person;

/**
 *
 * @author EmreOzkaya
 */
public class Block implements IBlock {

    private int id;
    private int personId;
    private String reason;
    private String blockTime;
    Connection db = Singleton.SingletonConnection.getCon();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    public Block() {
        blockTime = formatter.format(new Date(System.currentTimeMillis()));
    }

    public String getBlockTime() {
        return blockTime;
    }

    public int getId() {
        return id;
    }

    public int getPersonId() {
        return personId;
    }

    public String getReason() {
        return reason;
    }

    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void removeBlock() {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.removeBlockedPersonById + "'" + getPersonId() + "'");
            pst.execute();

            PreparedStatement pst2 = db.prepareStatement(Singleton.SingletonConnection.updateCustomerBlockedInfoById + "'" + getPersonId() + "'");

            pst2.setBoolean(1, false);
            pst2.execute();

            PreparedStatement pst3 = db.prepareStatement(Singleton.SingletonConnection.updateHouseOwnerBlockedInfoById + "'" + getPersonId() + "'");
            pst3.setBoolean(1, false);
            pst3.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void blockPerson() {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.insertBlockedPerson);
            pst.setInt(1, getId());
            pst.setInt(2, getPersonId());
            pst.setString(3, getReason());
            pst.setString(4, getBlockTime());
            pst.execute();
            pst = db.prepareStatement(Singleton.SingletonConnection.updateCustomerBlockedInfoById + "'" + getPersonId() + "'");
            pst.setBoolean(1, true);
            pst.execute();
            pst = db.prepareStatement(Singleton.SingletonConnection.updateHouseOwnerBlockedInfoById + "'" + getPersonId() + "'");
            pst.setBoolean(1, true);
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
