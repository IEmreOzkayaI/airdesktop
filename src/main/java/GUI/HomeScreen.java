/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import advertisement.abstracts.House;
import javax.swing.table.DefaultTableModel;
import advertisement.concretes.Advertisement;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import user.concretes.Customer;
import user.concretes.HouseOwner;
import user.concretes.Person;
import user.concretes.Personnel;

/**
 *
 * @author EmreOzkaya
 */
public class HomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form Home2
     */
    private boolean isAdvertisementsListed = false;
    private boolean isPersonListed = false;
    private Person person;
    private HouseOwner houseOwner;
    private Customer customer;
    private Personnel personnel;
    boolean profileMenuOpen = false;
    private String searchKey2 = "";
    private int personID = 0;
    DefaultTableModel dfmodel = new DefaultTableModel();
    private boolean personnelMenuListed = false;
    private boolean clickedİsPersonnel = false;
    PreparedStatement pst;
    Connection db = Singleton.SingletonConnection.getCon();
    Statement st;
    ResultSet rs;

    public HomeScreen() {
        initComponents();
        populateTable();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public HomeScreen(HouseOwner houseOwner) {
        initComponents();
        populateTable();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.houseOwner = houseOwner;
        personID = houseOwner.getId();

        signUp.hide();
        logIn.hide();
        searchIcon.setBounds(50, 7, 32, 42);
        searchBar.setBounds(100, 8, 580, 41);
        addAdvertisement.setBounds(725, 8, 180, 40);
        profileMenu.setBounds(920, 8, 100, 40);
        profileMenu.setText(houseOwner.getName().toUpperCase());
        navbar.setPreferredSize(new Dimension(1049, 56));
        this.navbar.add(searchBar);
        this.navbar.add(profileMenu);
        this.navbar.add(addAdvertisement);
        this.navbar.add(searchIcon);

    }

    public HomeScreen(Personnel personnel) {
        initComponents();
        populateTable();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.personnel = personnel;
        personID = personnel.getId();

        signUp.hide();
        logIn.hide();
        searchIcon.setBounds(50, 7, 32, 42);

        searchBar.setBounds(100, 8, 580, 41);
        personnelMenu.setBounds(920, 8, 100, 40);
        personnelMenu.setText(personnel.getName().toUpperCase());
        navbar.setPreferredSize(new Dimension(1049, 56));
        this.navbar.add(searchBar);
        this.navbar.add(personnelMenu);
                this.navbar.add(searchIcon);

    }

    public HomeScreen(Customer customer) {
        initComponents();
        populateTable();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.customer = customer;
        personID = customer.getId();

        signUp.hide();
        logIn.hide();
        searchIcon.setBounds(50, 7, 32, 42);

        searchBar.setBounds(100, 8, 580, 41);
        becameHouseOwner.setBounds(700, 8, 210, 40);
        profileMenu.setBounds(920, 8, 100, 40);
        profileMenu.setText(customer.getName().toUpperCase());

        navbar.setPreferredSize(new Dimension(1049, 56));
        this.navbar.add(searchBar);
        this.navbar.add(profileMenu);
        this.navbar.add(becameHouseOwner);
                this.navbar.add(searchIcon);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        becameHouseOwner = new javax.swing.JButton();
        profileDetail = new javax.swing.JPanel();
        profile = new javax.swing.JButton();
        wallet = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        profileMenu = new javax.swing.JButton();
        addAdvertisement = new javax.swing.JButton();
        popUpWallet = new javax.swing.JPanel();
        cardNumber = new javax.swing.JLabel();
        moneyAmount = new javax.swing.JLabel();
        cardNumberText = new javax.swing.JTextField();
        moneyAmountText = new javax.swing.JTextField();
        depositMoney = new javax.swing.JButton();
        withdrawMoney = new javax.swing.JButton();
        balanceMoney = new javax.swing.JButton();
        personnelMenu = new javax.swing.JButton();
        personnelMenuDetail = new javax.swing.JPanel();
        profile1 = new javax.swing.JButton();
        system = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        leftSide = new javax.swing.JPanel();
        residenceFilter = new javax.swing.JButton();
        apartmentFilter = new javax.swing.JButton();
        villaFilter = new javax.swing.JButton();
        treeHouseFilter = new javax.swing.JButton();
        rightSide = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        signUp = new javax.swing.JButton();
        logIn = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        searchIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdvertisements = new javax.swing.JTable();

        becameHouseOwner.setBackground(new java.awt.Color(153, 153, 153));
        becameHouseOwner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        becameHouseOwner.setForeground(new java.awt.Color(255, 255, 255));
        becameHouseOwner.setText("Became HouseOwner");
        becameHouseOwner.setBorder(null);
        becameHouseOwner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        becameHouseOwner.setPreferredSize(new java.awt.Dimension(210, 40));
        becameHouseOwner.setRequestFocusEnabled(false);
        becameHouseOwner.setVerifyInputWhenFocusTarget(false);
        becameHouseOwner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                becameHouseOwnerMouseClicked(evt);
            }
        });
        becameHouseOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                becameHouseOwnerActionPerformed(evt);
            }
        });

        profileDetail.setBackground(new java.awt.Color(51, 51, 51));
        profileDetail.setMinimumSize(new java.awt.Dimension(100, 124));
        profileDetail.setPreferredSize(new java.awt.Dimension(100, 124));

        profile.setBackground(new java.awt.Color(51, 51, 51));
        profile.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("Profile");
        profile.setBorder(null);
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.setDefaultCapable(false);
        profile.setPreferredSize(new java.awt.Dimension(100, 40));
        profile.setRequestFocusEnabled(false);
        profile.setVerifyInputWhenFocusTarget(false);
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        wallet.setBackground(new java.awt.Color(51, 51, 51));
        wallet.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        wallet.setForeground(new java.awt.Color(255, 255, 255));
        wallet.setText("Wallet");
        wallet.setBorder(null);
        wallet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        wallet.setDefaultCapable(false);
        wallet.setPreferredSize(new java.awt.Dimension(100, 40));
        wallet.setRequestFocusEnabled(false);
        wallet.setVerifyInputWhenFocusTarget(false);
        wallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                walletActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(51, 51, 51));
        exit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Exit");
        exit.setBorder(null);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setDefaultCapable(false);
        exit.setPreferredSize(new java.awt.Dimension(100, 40));
        exit.setRequestFocusEnabled(false);
        exit.setVerifyInputWhenFocusTarget(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileDetailLayout = new javax.swing.GroupLayout(profileDetail);
        profileDetail.setLayout(profileDetailLayout);
        profileDetailLayout.setHorizontalGroup(
            profileDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileDetailLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(profileDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wallet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(214, 214, 214))
        );
        profileDetailLayout.setVerticalGroup(
            profileDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileDetailLayout.createSequentialGroup()
                .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(wallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        profileDetail.getAccessibleContext().setAccessibleName("");

        profileMenu.setBackground(new java.awt.Color(51, 51, 51));
        profileMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        profileMenu.setForeground(new java.awt.Color(255, 255, 255));
        profileMenu.setBorder(null);
        profileMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileMenu.setDefaultCapable(false);
        profileMenu.setPreferredSize(new java.awt.Dimension(100, 40));
        profileMenu.setRequestFocusEnabled(false);
        profileMenu.setVerifyInputWhenFocusTarget(false);
        profileMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMenuMouseClicked(evt);
            }
        });
        profileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileMenuActionPerformed(evt);
            }
        });

        addAdvertisement.setBackground(new java.awt.Color(153, 153, 153));
        addAdvertisement.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addAdvertisement.setForeground(new java.awt.Color(255, 255, 255));
        addAdvertisement.setText("+ Advertisement");
        addAdvertisement.setBorder(null);
        addAdvertisement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAdvertisement.setDefaultCapable(false);
        addAdvertisement.setPreferredSize(new java.awt.Dimension(143, 40));
        addAdvertisement.setRequestFocusEnabled(false);
        addAdvertisement.setVerifyInputWhenFocusTarget(false);
        addAdvertisement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAdvertisementMouseClicked(evt);
            }
        });
        addAdvertisement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdvertisementActionPerformed(evt);
            }
        });

        popUpWallet.setBackground(new java.awt.Color(255, 90, 95));
        popUpWallet.setMinimumSize(new java.awt.Dimension(500, 250));

        cardNumber.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cardNumber.setForeground(new java.awt.Color(255, 255, 255));
        cardNumber.setText("Card Number :");

        moneyAmount.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        moneyAmount.setForeground(new java.awt.Color(255, 255, 255));
        moneyAmount.setText("Money Amount :");

        cardNumberText.setText("For Deposit / Withdraw");
        cardNumberText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTextActionPerformed(evt);
            }
        });

        moneyAmountText.setText("Deposit / Withdraw");

        depositMoney.setBackground(new java.awt.Color(51, 51, 51));
        depositMoney.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        depositMoney.setForeground(new java.awt.Color(255, 255, 255));
        depositMoney.setText("Deposit");
        depositMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        depositMoney.setDefaultCapable(false);
        depositMoney.setPreferredSize(new java.awt.Dimension(80, 40));
        depositMoney.setRequestFocusEnabled(false);
        depositMoney.setVerifyInputWhenFocusTarget(false);
        depositMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositMoneyActionPerformed(evt);
            }
        });

        withdrawMoney.setBackground(new java.awt.Color(51, 51, 51));
        withdrawMoney.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        withdrawMoney.setForeground(new java.awt.Color(255, 255, 255));
        withdrawMoney.setText("Withdraw");
        withdrawMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withdrawMoney.setDefaultCapable(false);
        withdrawMoney.setPreferredSize(new java.awt.Dimension(80, 40));
        withdrawMoney.setRequestFocusEnabled(false);
        withdrawMoney.setVerifyInputWhenFocusTarget(false);
        withdrawMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawMoneyActionPerformed(evt);
            }
        });

        balanceMoney.setBackground(new java.awt.Color(51, 51, 51));
        balanceMoney.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        balanceMoney.setForeground(new java.awt.Color(255, 255, 255));
        balanceMoney.setText("Balance");
        balanceMoney.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        balanceMoney.setDefaultCapable(false);
        balanceMoney.setPreferredSize(new java.awt.Dimension(80, 40));
        balanceMoney.setRequestFocusEnabled(false);
        balanceMoney.setVerifyInputWhenFocusTarget(false);
        balanceMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceMoneyMoneyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout popUpWalletLayout = new javax.swing.GroupLayout(popUpWallet);
        popUpWallet.setLayout(popUpWalletLayout);
        popUpWalletLayout.setHorizontalGroup(
            popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popUpWalletLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(popUpWalletLayout.createSequentialGroup()
                        .addComponent(depositMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(withdrawMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(balanceMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(popUpWalletLayout.createSequentialGroup()
                        .addGroup(popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardNumber)
                            .addComponent(moneyAmount))
                        .addGap(23, 23, 23)
                        .addGroup(popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moneyAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        popUpWalletLayout.setVerticalGroup(
            popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popUpWalletLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumber)
                    .addComponent(cardNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyAmount)
                    .addComponent(moneyAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(popUpWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(withdrawMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        personnelMenu.setBackground(new java.awt.Color(51, 51, 51));
        personnelMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        personnelMenu.setForeground(new java.awt.Color(255, 255, 255));
        personnelMenu.setBorder(null);
        personnelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        personnelMenu.setDefaultCapable(false);
        personnelMenu.setPreferredSize(new java.awt.Dimension(100, 40));
        personnelMenu.setRequestFocusEnabled(false);
        personnelMenu.setVerifyInputWhenFocusTarget(false);
        personnelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personnelMenuMouseClicked(evt);
            }
        });
        personnelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personnelMenuActionPerformed(evt);
            }
        });

        personnelMenuDetail.setBackground(new java.awt.Color(51, 51, 51));
        personnelMenuDetail.setMinimumSize(new java.awt.Dimension(100, 124));

        profile1.setBackground(new java.awt.Color(51, 51, 51));
        profile1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        profile1.setForeground(new java.awt.Color(255, 255, 255));
        profile1.setBorder(null);
        profile1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile1.setDefaultCapable(false);
        profile1.setPreferredSize(new java.awt.Dimension(100, 40));
        profile1.setRequestFocusEnabled(false);
        profile1.setVerifyInputWhenFocusTarget(false);
        profile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile1ActionPerformed(evt);
            }
        });

        system.setBackground(new java.awt.Color(51, 51, 51));
        system.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        system.setForeground(new java.awt.Color(255, 255, 255));
        system.setText("System");
        system.setBorder(null);
        system.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        system.setDefaultCapable(false);
        system.setPreferredSize(new java.awt.Dimension(100, 40));
        system.setRequestFocusEnabled(false);
        system.setVerifyInputWhenFocusTarget(false);
        system.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                systemMouseClicked(evt);
            }
        });
        system.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemActionPerformed(evt);
            }
        });

        exit1.setBackground(new java.awt.Color(51, 51, 51));
        exit1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        exit1.setForeground(new java.awt.Color(255, 255, 255));
        exit1.setText("Exit");
        exit1.setBorder(null);
        exit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit1.setDefaultCapable(false);
        exit1.setPreferredSize(new java.awt.Dimension(100, 40));
        exit1.setRequestFocusEnabled(false);
        exit1.setVerifyInputWhenFocusTarget(false);
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit1MouseClicked(evt);
            }
        });
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personnelMenuDetailLayout = new javax.swing.GroupLayout(personnelMenuDetail);
        personnelMenuDetail.setLayout(personnelMenuDetailLayout);
        personnelMenuDetailLayout.setHorizontalGroup(
            personnelMenuDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personnelMenuDetailLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(personnelMenuDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(system, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(214, 214, 214))
        );
        personnelMenuDetailLayout.setVerticalGroup(
            personnelMenuDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personnelMenuDetailLayout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(system, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        leftSide.setBackground(new java.awt.Color(255, 90, 95));
        leftSide.setPreferredSize(new java.awt.Dimension(220, 800));

        residenceFilter.setBackground(new java.awt.Color(255, 90, 95));
        residenceFilter.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\apartment.png")); // NOI18N
        residenceFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apartment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        residenceFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        residenceFilter.setFocusPainted(false);
        residenceFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residenceFilterActionPerformed(evt);
            }
        });

        apartmentFilter.setBackground(new java.awt.Color(255, 90, 95));
        apartmentFilter.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\manor.png")); // NOI18N
        apartmentFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        apartmentFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apartmentFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apartmentFilterActionPerformed(evt);
            }
        });

        villaFilter.setBackground(new java.awt.Color(255, 90, 95));
        villaFilter.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\viila.png")); // NOI18N
        villaFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Villa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        villaFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        villaFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villaFilterActionPerformed(evt);
            }
        });

        treeHouseFilter.setBackground(new java.awt.Color(255, 90, 95));
        treeHouseFilter.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\tree.png")); // NOI18N
        treeHouseFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tree House", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        treeHouseFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treeHouseFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeHouseFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftSideLayout = new javax.swing.GroupLayout(leftSide);
        leftSide.setLayout(leftSideLayout);
        leftSideLayout.setHorizontalGroup(
            leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSideLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treeHouseFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(villaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apartmentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(residenceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        leftSideLayout.setVerticalGroup(
            leftSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSideLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(residenceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(treeHouseFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(apartmentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(villaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        rightSide.setBackground(new java.awt.Color(51, 51, 51));
        rightSide.setPreferredSize(new java.awt.Dimension(1101, 800));

        navbar.setBackground(new java.awt.Color(153, 153, 153));
        navbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        signUp.setBackground(new java.awt.Color(153, 153, 153));
        signUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUp.setForeground(new java.awt.Color(255, 255, 255));
        signUp.setText("Sign Up");
        signUp.setBorder(null);
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUp.setDefaultCapable(false);
        signUp.setPreferredSize(new java.awt.Dimension(80, 40));
        signUp.setRequestFocusEnabled(false);
        signUp.setVerifyInputWhenFocusTarget(false);
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        logIn.setBackground(new java.awt.Color(51, 51, 51));
        logIn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        logIn.setForeground(new java.awt.Color(255, 255, 255));
        logIn.setText("Log In");
        logIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logIn.setDefaultCapable(false);
        logIn.setPreferredSize(new java.awt.Dimension(80, 40));
        logIn.setRequestFocusEnabled(false);
        logIn.setVerifyInputWhenFocusTarget(false);
        logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInActionPerformed(evt);
            }
        });

        searchBar.setBackground(new java.awt.Color(153, 153, 153));
        searchBar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        searchBar.setForeground(new java.awt.Color(255, 255, 255));
        searchBar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchBar.setToolTipText("Search..");
        searchBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });

        searchIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\search.png")); // NOI18N

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(searchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(signUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );

        searchBar.getAccessibleContext().setAccessibleName("");

        tblAdvertisements.setBackground(new java.awt.Color(51, 51, 51));
        tblAdvertisements.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblAdvertisements.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tblAdvertisements.setForeground(new java.awt.Color(255, 255, 255));
        tblAdvertisements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "HouseID", "Image", "Name", "Type", "Heating", "Room Number", "Price", "Adress", "Short Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAdvertisements.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblAdvertisements.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblAdvertisements.setFocusable(false);
        tblAdvertisements.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAdvertisements.setShowGrid(true);
        tblAdvertisements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdvertisementsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdvertisements);
        if (tblAdvertisements.getColumnModel().getColumnCount() > 0) {
            tblAdvertisements.getColumnModel().getColumn(2).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(3).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(4).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(5).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(6).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(7).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(8).setResizable(false);
            tblAdvertisements.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout rightSideLayout = new javax.swing.GroupLayout(rightSide);
        rightSide.setLayout(rightSideLayout);
        rightSideLayout.setHorizontalGroup(
            rightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightSideLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(rightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        rightSideLayout.setVerticalGroup(
            rightSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightSideLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addComponent(leftSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightSide, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftSide, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
            .addComponent(rightSide, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );

        leftSide.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        // TODO add your handling code here:
        SignUpScreen signUp = new SignUpScreen();
        this.dispose();
        signUp.show();

    }//GEN-LAST:event_signUpActionPerformed

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed
        // TODO add your handling code here:
        LogInScreen logIn = new LogInScreen();
        this.dispose();
        logIn.show();

    }//GEN-LAST:event_logInActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void becameHouseOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_becameHouseOwnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_becameHouseOwnerActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        // TODO add your handling code here:
        if (houseOwner == null) {
            PasswordUpdateScreen pf = new PasswordUpdateScreen(customer);
            this.dispose();
            pf.show();
        } else {
            PasswordUpdateScreen pf = new PasswordUpdateScreen(houseOwner);
            this.dispose();
            pf.show();
        }


    }//GEN-LAST:event_profileActionPerformed

    private void walletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_walletActionPerformed
        // TODO add your handling code here:
        this.rightSide.add(popUpWallet);
        popUpWallet.setBounds(300, 250, 500, 250);
        cardNumber.setBounds(60, 50, 150, 40);
        moneyAmount.setBounds(60, 100, 150, 40);

        cardNumberText.setBounds(230, 50, 200, 40);
        moneyAmountText.setBounds(230, 100, 200, 40);

        depositMoney.setBounds(60, 175, 90, 40);
        withdrawMoney.setBounds(190, 175, 120, 40);
        balanceMoney.setBounds(340, 175, 90, 40);

        popUpWallet.show();
    }//GEN-LAST:event_walletActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeScreen home = new HomeScreen();
        home.show();

    }//GEN-LAST:event_exitActionPerformed

    private void profileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileMenuActionPerformed

    private void profileMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMenuMouseClicked
        // TODO add your handling code here:
        if (profileMenuOpen) {
            this.profileDetail.hide();
            this.rightSide.remove(profileDetail);
            profileMenuOpen = false;
            jScrollPane1.setVisible(true);

        } else {
            this.rightSide.add(profileDetail);
            profileDetail.show();
            this.profileDetail.add(wallet);
            this.profileDetail.add(profile);
            this.profileDetail.add(exit);

            profileDetail.setBounds(947, 85, 100, 120);
            profile.setBounds(0, 0, 100, 40);
            wallet.setBounds(0, 41, 100, 40);
            exit.setBounds(0, 82, 100, 40);
            jScrollPane1.setVisible(false);
            profileMenuOpen = true;
        }
    }//GEN-LAST:event_profileMenuMouseClicked

    private void becameHouseOwnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_becameHouseOwnerMouseClicked
        // TODO add your handling code here:

        // houseowner tablosuna aktarılacak tüm data . 
        int result = JOptionPane.showConfirmDialog(null, "Do you want to be a House Owner , We will get 10% of your earn.");

        if (result == 0) {
            HouseOwner houseOwner = new HouseOwner();
            houseOwner.setBirthDate(customer.getBirthDate());
            houseOwner.setEmail(customer.getEmail());
            houseOwner.setGender(customer.getGender());
            houseOwner.setId(customer.getId());
            houseOwner.setIdentityNumber(customer.getIdentityNumber());
            houseOwner.setName(customer.getName());
            houseOwner.setPassword(customer.getPassword());
            houseOwner.setPhoneNumber(customer.getPhoneNumber());
            houseOwner.setSurname(customer.getSurname());
            houseOwner.setComments(customer.getComments());
            houseOwner.setActivationPersonnelId(customer.getActivationPersonnelId());
            houseOwner.setRentedHouse(customer.getRentedHouse());
            houseOwner.setWallet(customer.getWallet());
            houseOwner.setActivationResult(true);
            houseOwner.setIsBlocked(false);
            houseOwner.registerFromCustomer();
            JOptionPane.showMessageDialog(null, "Welcome " + customer.getName().toUpperCase() + " . Now you can rent your houses.");
            this.dispose();
            HomeScreen home = new HomeScreen(houseOwner);
            home.show();
        }
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "Well we can't wait to see you among us");

        }
    }//GEN-LAST:event_becameHouseOwnerMouseClicked
    private void populateTable() {
        if (!isAdvertisementsListed) {
            dfmodel.setRowCount(0);
            dfmodel = (DefaultTableModel) tblAdvertisements.getModel();
            dfmodel.getColumnClass(0);

            Advertisement ad = new Advertisement();
            List<Advertisement> advertisementList = ad.getAllAdvertisementsIsActiveTrue();
            for (Advertisement advertisement : advertisementList) {
                House house = advertisement.getHouse();
                byte[] icon = house.getHouseIconImg();
                Image img = Toolkit.getDefaultToolkit().createImage(icon).getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                ImageIcon imgicn = new ImageIcon(img);

                Object tbData[] = {advertisement.getId(), advertisement.getHouse().getId(), imgicn, advertisement.getAdvertisementName(), advertisement.getAdvertisementType(), advertisement.getHouse().getHeating(), advertisement.getHouse().getRoomNumber(),
                    advertisement.getPrice(), advertisement.getHouse().getLocation(), advertisement.getHouse().getShortDescription()};

                dfmodel.addRow(tbData);
            }
            if (tblAdvertisements.getColumnName(0).equals("ID")) {
                tblAdvertisements.removeColumn(tblAdvertisements.getColumn("ID"));
            }
            if (tblAdvertisements.getColumnName(0).equals("HouseID")) {
                tblAdvertisements.removeColumn(tblAdvertisements.getColumn("HouseID"));
            }
            tblAdvertisements.setRowHeight(250);
            tblAdvertisements.getTableHeader().setReorderingAllowed(false);
            tblAdvertisements.getColumnModel().getColumn(0).setPreferredWidth(250);
            tblAdvertisements.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            isAdvertisementsListed = true;

        }
    }

    private class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel lphoto = new JLabel((ImageIcon) value);
            return lphoto;
        }

    }

    private void addAdvertisementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdvertisementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAdvertisementActionPerformed

    private void addAdvertisementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAdvertisementMouseClicked
        // TODO add your handling code here:
        AdvertisementAddScreen addAdvertismeent = new AdvertisementAddScreen(this.houseOwner);
        this.dispose();
        addAdvertismeent.show();

    }//GEN-LAST:event_addAdvertisementMouseClicked

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        // TODO add your handling code here:
        String searchKey = searchBar.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(dfmodel);
        tblAdvertisements.setRowSorter(tableRowSorter);
        List<RowFilter<Object, Object>> rfs
                = new ArrayList<RowFilter<Object, Object>>(2);
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey));
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey2));
        tableRowSorter.setRowFilter(RowFilter.andFilter(rfs));
    }//GEN-LAST:event_searchBarKeyReleased

    private void residenceFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residenceFilterActionPerformed
        // TODO add your handling code here:
        if (searchKey2 == "apartment") {
            searchKey2 = "";
            residenceFilter.setSelected(false);
            residenceFilter.setFocusPainted(false);
        } else {
            searchKey2 = "apartment";
            residenceFilter.setSelected(true);
            residenceFilter.setFocusPainted(true);
        }
        String searchKey = searchBar.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(dfmodel);
        tblAdvertisements.setRowSorter(tableRowSorter);
        List<RowFilter<Object, Object>> rfs
                = new ArrayList<RowFilter<Object, Object>>(2);
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey));
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey2));
        tableRowSorter.setRowFilter(RowFilter.andFilter(rfs));
    }//GEN-LAST:event_residenceFilterActionPerformed

    private void treeHouseFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeHouseFilterActionPerformed
        // TODO add your handling code here:
        if (searchKey2 == "tree house") {
            searchKey2 = "";
            treeHouseFilter.setSelected(false);
            treeHouseFilter.setFocusPainted(false);
        } else {
            searchKey2 = "tree house";
            treeHouseFilter.setSelected(true);
            treeHouseFilter.setFocusPainted(true);
        }
        String searchKey = searchBar.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(dfmodel);
        tblAdvertisements.setRowSorter(tableRowSorter);
        List<RowFilter<Object, Object>> rfs
                = new ArrayList<RowFilter<Object, Object>>(2);
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey));
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey2));
        tableRowSorter.setRowFilter(RowFilter.andFilter(rfs));
    }//GEN-LAST:event_treeHouseFilterActionPerformed

    private void apartmentFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apartmentFilterActionPerformed
        // TODO add your handling code here:
        if (searchKey2 == "manor") {
            searchKey2 = "";
            apartmentFilter.setSelected(false);
            apartmentFilter.setFocusPainted(false);
        } else {
            searchKey2 = "manor";
            apartmentFilter.setSelected(true);
            apartmentFilter.setFocusPainted(true);
        }
        String searchKey = searchBar.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(dfmodel);
        tblAdvertisements.setRowSorter(tableRowSorter);
        List<RowFilter<Object, Object>> rfs
                = new ArrayList<RowFilter<Object, Object>>(2);
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey));
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey2));
        tableRowSorter.setRowFilter(RowFilter.andFilter(rfs));
    }//GEN-LAST:event_apartmentFilterActionPerformed

    private void villaFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villaFilterActionPerformed
        // TODO add your handling code here:
        if (searchKey2 == "villa") {
            searchKey2 = "";
            villaFilter.setSelected(false);
            villaFilter.setFocusPainted(false);
        } else {
            searchKey2 = "villa";
            villaFilter.setSelected(true);
            villaFilter.setFocusPainted(true);
        }
        String searchKey = searchBar.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(dfmodel);
        tblAdvertisements.setRowSorter(tableRowSorter);
        List<RowFilter<Object, Object>> rfs
                = new ArrayList<RowFilter<Object, Object>>(2);
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey));
        rfs.add(RowFilter.regexFilter("(?i)" + searchKey2));
        tableRowSorter.setRowFilter(RowFilter.andFilter(rfs));
    }//GEN-LAST:event_villaFilterActionPerformed

    private void tblAdvertisementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdvertisementsMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblAdvertisements.getSelectedRow();
        try {
            pst = db.prepareStatement(Singleton.SingletonConnection.getPersonnelById + "'" + personID + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                AdvertisementDetailForPersonnelScreen adDetailPersonnel = new AdvertisementDetailForPersonnelScreen();
                int id = (Integer) tblAdvertisements.getModel().getValueAt(tblAdvertisements.convertRowIndexToModel(selectedRow), 0);
                int houseid = (Integer) tblAdvertisements.getModel().getValueAt(tblAdvertisements.convertRowIndexToModel(tblAdvertisements.getSelectedRow()), 0);
                adDetailPersonnel.viewAdvertisementDetails(id, houseid, personID);
                adDetailPersonnel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                adDetailPersonnel.setVisible(true);

            } else {
                AdvertisementDetailScreen details = new AdvertisementDetailScreen();
                int id = (Integer) tblAdvertisements.getModel().getValueAt(tblAdvertisements.convertRowIndexToModel(selectedRow), 0);
                int houseid = (Integer) tblAdvertisements.getModel().getValueAt(tblAdvertisements.convertRowIndexToModel(tblAdvertisements.getSelectedRow()), 0);
                details.viewAdvertisementDetails(id, houseid, personID);
                details.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                details.setVisible(true);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvertisementDetailScreen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tblAdvertisementsMouseClicked

    private void cardNumberTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberTextActionPerformed

    private void depositMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositMoneyActionPerformed
        // TODO add your handling code here:

        if (!cardNumberText.getText().isEmpty() && !moneyAmountText.getText().isEmpty()) {
            if (!isNumericTextFormatValid(cardNumberText.getText()) || !isNumericTextFormatValid(moneyAmountText.getText())) {
                JOptionPane.showMessageDialog(null, "Please Fill all Field As a Numeric");
            } else {
                int moneyAmount = Integer.parseInt(moneyAmountText.getText());

                if (houseOwner == null && customer != null) {
                    JOptionPane.showMessageDialog(null, "You deposit " + customer.getWallet().deposit(moneyAmount) + "$");

                } else {
                    JOptionPane.showMessageDialog(null, "You deposit " + houseOwner.getWallet().deposit(moneyAmount) + "$");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Fill all Field");

        }
    }//GEN-LAST:event_depositMoneyActionPerformed

    private void withdrawMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawMoneyActionPerformed
        // TODO add your handling code here:
        if (!cardNumberText.getText().isEmpty() && !moneyAmountText.getText().isEmpty()) {
            if (!isNumericTextFormatValid(cardNumberText.getText()) || !isNumericTextFormatValid(moneyAmountText.getText())) {
                JOptionPane.showMessageDialog(null, "Please Fill all Field As a Numeric");
            } else {
                int moneyAmount = Integer.parseInt(moneyAmountText.getText());

                if (houseOwner == null && customer != null) {
                    if (customer.getWallet().withdraw(moneyAmount) == customer.getWallet().getTotalAmount()) {
                        JOptionPane.showMessageDialog(null, "You don't have enough money . You have " + customer.getWallet().getTotalAmount() + " $");

                    } else {
                        JOptionPane.showMessageDialog(null, "You Widthdraw " + moneyAmount + " $. You can reach from related card");

                    }

                } else {
                    if (houseOwner.getWallet().withdraw(moneyAmount) == houseOwner.getWallet().getTotalAmount()) {
                        JOptionPane.showMessageDialog(null, "You don't have enough money . You have " + houseOwner.getWallet().getTotalAmount() + " $");

                    } else {
                        JOptionPane.showMessageDialog(null, "You Widthdraw " + moneyAmount + " $. You can reach from related card");

                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Fill all Field");

        }
    }//GEN-LAST:event_withdrawMoneyActionPerformed

    private void balanceMoneyMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceMoneyMoneyActionPerformed
        // TODO add your handling code here:

        if (houseOwner == null && customer != null) {
            JOptionPane.showMessageDialog(null, "You have " + customer.getWallet().balance() + " $");

        } else {
            JOptionPane.showMessageDialog(null, "You have " + houseOwner.getWallet().balance() + " $");
        }
    }//GEN-LAST:event_balanceMoneyMoneyActionPerformed

    private void personnelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personnelMenuMouseClicked
        // TODO add your handling code here:
        if (personnelMenuListed) {
            this.personnelMenuDetail.hide();
            this.rightSide.remove(personnelMenuDetail);
            personnelMenuListed = false;
            jScrollPane1.setVisible(true);

        } else {
            this.rightSide.add(personnelMenuDetail);
            personnelMenuDetail.show();

            this.personnelMenuDetail.add(system);
            this.personnelMenuDetail.add(exit1);

            personnelMenuDetail.setBounds(947, 95, 100, 120);
            system.setBounds(0, 0, 100, 40);
            exit1.setBounds(0, 41, 100, 40);
            jScrollPane1.setVisible(false);
            personnelMenuListed = true;
        }
    }//GEN-LAST:event_personnelMenuMouseClicked

    private void personnelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personnelMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personnelMenuActionPerformed

    private void profile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profile1ActionPerformed

    private void systemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_systemActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exit1ActionPerformed

    private void systemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_systemMouseClicked
        // TODO add your handling code here:
        this.dispose();
        PersonnelScreen pScreen = new PersonnelScreen(personnel);
        pScreen.show();
    }//GEN-LAST:event_systemMouseClicked

    private void exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        HomeScreen home = new HomeScreen();
        home.show();
    }//GEN-LAST:event_exit1MouseClicked

    private boolean isTextFormatValid(String text) {
        String TEXT_PATTERN = "^[a-zA-Z]*$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(TEXT_PATTERN,
                java.util.regex.Pattern.CASE_INSENSITIVE);
        return pattern.matcher(text).find();
    }

    private boolean isNumericTextFormatValid(String text) {
        String TEXT_PATTERN = "^[0-9]*$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(TEXT_PATTERN,
                java.util.regex.Pattern.CASE_INSENSITIVE);
        return pattern.matcher(text).find();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new HomeScreen().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdvertisement;
    private javax.swing.JButton apartmentFilter;
    private javax.swing.JButton balanceMoney;
    private javax.swing.JButton becameHouseOwner;
    private javax.swing.JLabel cardNumber;
    private javax.swing.JTextField cardNumberText;
    private javax.swing.JPanel content;
    private javax.swing.JButton depositMoney;
    private javax.swing.JButton exit;
    private javax.swing.JButton exit1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel leftSide;
    private javax.swing.JButton logIn;
    private javax.swing.JLabel moneyAmount;
    private javax.swing.JTextField moneyAmountText;
    private javax.swing.JPanel navbar;
    private javax.swing.JButton personnelMenu;
    private javax.swing.JPanel personnelMenuDetail;
    private javax.swing.JPanel popUpWallet;
    private javax.swing.JButton profile;
    private javax.swing.JButton profile1;
    private javax.swing.JPanel profileDetail;
    private javax.swing.JButton profileMenu;
    private javax.swing.JButton residenceFilter;
    private javax.swing.JPanel rightSide;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JButton signUp;
    private javax.swing.JButton system;
    private javax.swing.JTable tblAdvertisements;
    private javax.swing.JButton treeHouseFilter;
    private javax.swing.JButton villaFilter;
    private javax.swing.JButton wallet;
    private javax.swing.JButton withdrawMoney;
    // End of variables declaration//GEN-END:variables
}
