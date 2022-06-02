/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import advertisement.abstracts.House;
import advertisement.concretes.Advertisement;
import advertisement.concretes.Comment;
import advertisement.concretes.HouseFactory;
import core.concretes.Block;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import user.concretes.HouseOwner;
import user.concretes.Personnel;

/**
 *
 * @author EmreOzkaya
 */
public class AdvertisementDetailForPersonnelScreen extends javax.swing.JFrame {

    /**
     * Creates new form advertisementDetailPage
     */
    DefaultTableModel dfmodel = new DefaultTableModel();
    DefaultTableModel dfmodelforPersonnel = new DefaultTableModel();

    private static int advertisementId;
    private static int houseId;
    private static int personId;
    ArrayList<byte[]> images = new ArrayList();
    ArrayList<Comment> commentList = new ArrayList();
    Advertisement ad = new Advertisement();
    PreparedStatement pst;
    Comment comment = new Comment();
    Connection db = Singleton.SingletonConnection.getCon();
    Statement st;
    ResultSet rs;

    public void viewAdvertisementDetails(int advertisementId, int houseId, int personId) {
        contentScroll.getVerticalScrollBar().setUnitIncrement(20);
        this.advertisementId = advertisementId;
        this.houseId = houseId;
        this.personId = personId;
        ad = ad.showDetailedInfo(advertisementId);
        advertisementName.setText(ad.getAdvertisementName());
        images = ad.getHouse().getImages();
        Image img = Toolkit.getDefaultToolkit().createImage(images.get(0)).getScaledInstance(178, 135, Image.SCALE_SMOOTH);
        ImageIcon imgicn = new ImageIcon(img);
        image1.setIcon(imgicn);
        img = Toolkit.getDefaultToolkit().createImage(images.get(1)).getScaledInstance(178, 135, Image.SCALE_SMOOTH);
        imgicn = new ImageIcon(img);
        image2.setIcon(imgicn);
        img = Toolkit.getDefaultToolkit().createImage(images.get(2)).getScaledInstance(178, 135, Image.SCALE_SMOOTH);
        imgicn = new ImageIcon(img);
        image3.setIcon(imgicn);
        img = Toolkit.getDefaultToolkit().createImage(images.get(3)).getScaledInstance(178, 135, Image.SCALE_SMOOTH);
        imgicn = new ImageIcon(img);
        image4.setIcon(imgicn);
        img = Toolkit.getDefaultToolkit().createImage(images.get(4)).getScaledInstance(178, 135, Image.SCALE_SMOOTH);
        imgicn = new ImageIcon(img);
        image5.setIcon(imgicn);
        img = Toolkit.getDefaultToolkit().createImage(images.get(5)).getScaledInstance(178, 135, Image.SCALE_SMOOTH);
        imgicn = new ImageIcon(img);
        image6.setIcon(imgicn);
        addressText.setText(ad.getHouse().getLocation());
        dailyPriceText.setText(String.valueOf(ad.getPrice()));
        houseTypeText.setText(ad.getAdvertisementType());
        vehicleParkText.setText(String.valueOf(ad.getHouse().isHasVehiclePark()));
        heatingTypeText.setText(ad.getHouse().getHeating());
        roomNumberText.setText(ad.getHouse().getRoomNumber());
        shortDescriptionText.setText(ad.getHouse().getShortDescription());
        if (ad.getActivationPersonnelId() == personId) {
            this.jPanel2.add(deleteButton);
            deleteButton.setBounds(10, 10, 34, 34);
            deleteButton.show();
        }
        populateCommentTable();

    }

    public AdvertisementDetailForPersonnelScreen() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public void populateCommentTable() {
        comment.setAdvertisementId(advertisementId);
        commentList = comment.getAllComments();
        dfmodel.setRowCount(0);
        dfmodel = (DefaultTableModel) jTable1.getModel();
        dfmodel.getColumnClass(0);
        TableModel model = jTable1.getModel();
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(1100);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        jTable1.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        jTable1.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));
        if (commentList != null) {
            for (Comment commitem : commentList) {
                Object tbData[] = {commitem.getPersonId(), commitem.getId(), commitem.getUserName(), commitem.getContent(), commitem.getPoint(), "BLOCK", "DELETE"};
                dfmodel.addRow(tbData);
            }
        }

        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setReorderingAllowed(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        contentScroll = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        image1 = new javax.swing.JButton();
        image2 = new javax.swing.JButton();
        image3 = new javax.swing.JButton();
        image4 = new javax.swing.JButton();
        image5 = new javax.swing.JButton();
        image6 = new javax.swing.JButton();
        advertisementName = new javax.swing.JLabel();
        houseTypeLabel = new javax.swing.JLabel();
        houseTypeText = new javax.swing.JTextField();
        heatingTypeLabel = new javax.swing.JLabel();
        heatingTypeText = new javax.swing.JTextField();
        dailyPriceLabel = new javax.swing.JLabel();
        dailyPriceText = new javax.swing.JTextField();
        roomNumberLabel = new javax.swing.JLabel();
        roomNumberText = new javax.swing.JTextField();
        vehicleParkLabel = new javax.swing.JLabel();
        vehicleParkText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        shortDescriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shortDescriptionText = new javax.swing.JTextArea();
        commentPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Point", "Comment", "Block", "Delete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        deleteButton.setBackground(new java.awt.Color(51, 51, 51));
        deleteButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\delete.png")); // NOI18N
        deleteButton.setBorder(null);
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setDefaultCapable(false);
        deleteButton.setFocusPainted(false);
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 90, 95));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1330, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        image1.setBackground(new java.awt.Color(51, 51, 51));
        image1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        image1.setForeground(new java.awt.Color(255, 255, 255));
        image1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image1ActionPerformed(evt);
            }
        });

        image2.setBackground(new java.awt.Color(51, 51, 51));
        image2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        image2.setForeground(new java.awt.Color(255, 255, 255));
        image2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                image2MouseClicked(evt);
            }
        });
        image2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image2ActionPerformed(evt);
            }
        });

        image3.setBackground(new java.awt.Color(51, 51, 51));
        image3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        image3.setForeground(new java.awt.Color(255, 255, 255));
        image3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                image3MouseClicked(evt);
            }
        });
        image3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image3ActionPerformed(evt);
            }
        });

        image4.setBackground(new java.awt.Color(51, 51, 51));
        image4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        image4.setForeground(new java.awt.Color(255, 255, 255));
        image4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image4ActionPerformed(evt);
            }
        });

        image5.setBackground(new java.awt.Color(51, 51, 51));
        image5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        image5.setForeground(new java.awt.Color(255, 255, 255));
        image5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image5ActionPerformed(evt);
            }
        });

        image6.setBackground(new java.awt.Color(51, 51, 51));
        image6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        image6.setForeground(new java.awt.Color(255, 255, 255));
        image6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image6ActionPerformed(evt);
            }
        });

        advertisementName.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        advertisementName.setForeground(new java.awt.Color(255, 255, 255));
        advertisementName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        houseTypeLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        houseTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        houseTypeLabel.setText("House Type : ");

        houseTypeText.setEditable(false);
        houseTypeText.setBackground(new java.awt.Color(51, 51, 51));
        houseTypeText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        houseTypeText.setForeground(new java.awt.Color(255, 255, 255));
        houseTypeText.setText("asdasda");
        houseTypeText.setToolTipText("");

        heatingTypeLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        heatingTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        heatingTypeLabel.setText("Heating Type : ");

        heatingTypeText.setEditable(false);
        heatingTypeText.setBackground(new java.awt.Color(51, 51, 51));
        heatingTypeText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        heatingTypeText.setForeground(new java.awt.Color(255, 255, 255));
        heatingTypeText.setText("asdasda");
        heatingTypeText.setToolTipText("");

        dailyPriceLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dailyPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        dailyPriceLabel.setText("Daily Price : ");

        dailyPriceText.setEditable(false);
        dailyPriceText.setBackground(new java.awt.Color(51, 51, 51));
        dailyPriceText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        dailyPriceText.setForeground(new java.awt.Color(255, 255, 255));
        dailyPriceText.setText("asdasda");
        dailyPriceText.setToolTipText("");

        roomNumberLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        roomNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        roomNumberLabel.setText("Room Number :");

        roomNumberText.setEditable(false);
        roomNumberText.setBackground(new java.awt.Color(51, 51, 51));
        roomNumberText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        roomNumberText.setForeground(new java.awt.Color(255, 255, 255));
        roomNumberText.setText("asdasda");
        roomNumberText.setToolTipText("");

        vehicleParkLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        vehicleParkLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleParkLabel.setText("Vehicle Park :");

        vehicleParkText.setEditable(false);
        vehicleParkText.setBackground(new java.awt.Color(51, 51, 51));
        vehicleParkText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        vehicleParkText.setForeground(new java.awt.Color(255, 255, 255));
        vehicleParkText.setText("asdasda");
        vehicleParkText.setToolTipText("");

        addressLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address :");

        addressText.setEditable(false);
        addressText.setBackground(new java.awt.Color(51, 51, 51));
        addressText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        addressText.setForeground(new java.awt.Color(255, 255, 255));
        addressText.setText("asdasda");
        addressText.setToolTipText("");

        shortDescriptionLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        shortDescriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        shortDescriptionLabel.setText("Short Description : ");

        shortDescriptionText.setEditable(false);
        shortDescriptionText.setBackground(new java.awt.Color(51, 51, 51));
        shortDescriptionText.setColumns(20);
        shortDescriptionText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        shortDescriptionText.setForeground(new java.awt.Color(255, 255, 255));
        shortDescriptionText.setLineWrap(true);
        shortDescriptionText.setRows(5);
        shortDescriptionText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(shortDescriptionText);

        commentPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTextArea5.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextArea5.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("   Add comment...");
        jScrollPane7.setViewportView(jTextArea5);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMMENTS");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinner1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        jSpinner1.setBorder(null);

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person Id", "Comment Id", "Name", "Content", "Point", "Block", "Delete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout commentPanel1Layout = new javax.swing.GroupLayout(commentPanel1);
        commentPanel1.setLayout(commentPanel1Layout);
        commentPanel1Layout.setHorizontalGroup(
            commentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPanel1Layout.createSequentialGroup()
                .addGroup(commentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commentPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(commentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commentPanel1Layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commentPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)))))
                .addContainerGap())
        );
        commentPanel1Layout.setVerticalGroup(
            commentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commentPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(commentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\emrec\\OneDrive\\Masaüstü\\airbnb_desktop\\src\\main\\img\\img\\main_logo_1.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(advertisementName, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(commentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(image5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(image4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(image6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(shortDescriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressLabel)
                                    .addComponent(dailyPriceLabel)
                                    .addComponent(houseTypeLabel)
                                    .addComponent(vehicleParkLabel)
                                    .addComponent(heatingTypeLabel)
                                    .addComponent(roomNumberLabel))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(heatingTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(vehicleParkText, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(houseTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dailyPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(addressText))))))))
                        .addGap(54, 54, 54))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(advertisementName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dailyPriceLabel)
                            .addComponent(dailyPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(houseTypeLabel)
                            .addComponent(houseTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vehicleParkLabel)
                            .addComponent(vehicleParkText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heatingTypeLabel)
                            .addComponent(heatingTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomNumberLabel)
                            .addComponent(roomNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shortDescriptionLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(image6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(image5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(image4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        contentScroll.setViewportView(jPanel2);

        jPanel1.add(contentScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1280, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void image1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image1ActionPerformed


    }//GEN-LAST:event_image1ActionPerformed

    private void image2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_image2ActionPerformed

    private void image3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_image3ActionPerformed

    private void image4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_image4ActionPerformed

    private void image5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_image5ActionPerformed

    private void image6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_image6ActionPerformed

    private void image3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_image3MouseClicked

    private void image2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_image2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Comment postComment = new Comment();
        postComment.setContent(jTextArea5.getText());
        postComment.setPersonId(personId);
        postComment.setPoint((int) jSpinner1.getValue());
        postComment.setAdvertisementId(advertisementId);
        postComment.post();
        populateCommentTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
        ad.delete();
        HomeScreen home = new HomeScreen(new HouseOwner().getUserById(personId));
        this.dispose();
        home.show();
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    // BUTTON CREATIN AND SPECİALIZATION PART
    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int column) {
            setText((obj == null) ? "" : obj.toString());

            return this;
        }

    }

    private class ButtonEditor extends DefaultCellEditor {

        protected JButton btn;
        private String lbl;
        private Boolean clicked;

        public ButtonEditor(JTextField text) {
            super(text);

            btn = new JButton();
            btn.setOpaque(true);
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int column) {
            lbl = (obj == null) ? "" : obj.toString();
            btn.setText(lbl);
            clicked = true;
            return btn;
        }

        @Override
        public Object getCellEditorValue() {
            if (clicked) {
                if (lbl.equalsIgnoreCase("block")) {

                    int index = jTable1.getSelectedRow();
                    TableModel model = jTable1.getModel();
                    String id = model.getValueAt(index, 0).toString();
                    String commentId = model.getValueAt(index, 1).toString();
                    String reason = JOptionPane.showInputDialog(null, "Enter a Reason");
                    Block block = new Block();
                    block.setPersonId(Integer.parseInt(id));
                    block.setReason(reason);
                    block.blockPerson();
                    comment.deleteByPersonId(Integer.parseInt(id));
                    populateCommentTable();

                } else {

                    int index = jTable1.getSelectedRow();
                    TableModel model = jTable1.getModel();
                    String id = model.getValueAt(index, 1).toString();
                    comment.delete(Integer.parseInt(id));
                    populateCommentTable();

                }
            }
            clicked = false;
            return new String(lbl);
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {

            super.fireEditingStopped();
        }

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
            java.util.logging.Logger.getLogger(AdvertisementDetailForPersonnelScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdvertisementDetailForPersonnelScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdvertisementDetailForPersonnelScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvertisementDetailForPersonnelScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdvertisementDetailForPersonnelScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JLabel advertisementName;
    private javax.swing.JPanel commentPanel1;
    private javax.swing.JScrollPane contentScroll;
    private javax.swing.JLabel dailyPriceLabel;
    private javax.swing.JTextField dailyPriceText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel heatingTypeLabel;
    private javax.swing.JTextField heatingTypeText;
    private javax.swing.JLabel houseTypeLabel;
    private javax.swing.JTextField houseTypeText;
    private javax.swing.JButton image1;
    private javax.swing.JButton image2;
    private javax.swing.JButton image3;
    private javax.swing.JButton image4;
    private javax.swing.JButton image5;
    private javax.swing.JButton image6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JTextField roomNumberText;
    private javax.swing.JLabel shortDescriptionLabel;
    private javax.swing.JTextArea shortDescriptionText;
    private javax.swing.JLabel vehicleParkLabel;
    private javax.swing.JTextField vehicleParkText;
    // End of variables declaration//GEN-END:variables
}
