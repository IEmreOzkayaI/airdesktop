/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.concretes;

import GUI.HomeScreen;
import core.abstracts.IWallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.concretes.Person;

/**
 *
 * @author EmreOzkaya
 */
public class Wallet implements IWallet {

    private int id;
    private int totalAmount;
    Connection db = Singleton.SingletonConnection.getCon();
    PreparedStatement pst;
    ResultSet rs;
    Statement st;

    public Wallet(int id, int totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
    }

    public Wallet() {
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.insertionWallet, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setInt(2, 0);
            pst.execute();
            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                this.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalAmount = 0;

    }

    @Override
    public int balance() {

        return getTotalAmount();
    }

    @Override
    public int withdraw(int money) {

        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.updateWalletById + "'" + getId() + "'");
            if (getTotalAmount() < money) {
                return getTotalAmount();
            } else {

                pst.setInt(1, getTotalAmount() - money);
                pst.execute();
                setTotalAmount(getTotalAmount() - money);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }

    @Override
    public int deposit(int money) {
        try {
            setTotalAmount(getTotalAmount() + money);

            pst = db.prepareStatement(Singleton.SingletonConnection.updateWalletById + "'" + getId() + "'");
            pst.setInt(1, getTotalAmount());
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }

    @Override
    public void sendMoney(int money, Wallet wallet) {
        withdraw(money);
        money = money - ((money*10)/100);  // system profit.
        wallet.deposit(money);

    }

    public int getId() {
        return id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

}
