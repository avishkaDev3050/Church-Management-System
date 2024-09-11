package gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class AddEmployee extends javax.swing.JPanel {

    public static HashMap<String, String> typeMap = new HashMap<>();
    public static HashMap<String, String> genderMap = new HashMap<>();
    public static HashMap<String, String> statusMap = new HashMap<>();

    public AddEmployee() {
        initComponents();
        loadGender();
        loadStatus();
        loadtype();
        loadTable();

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setDefaultRenderer(Object.class, renderer);
    }

    private void reset() {

        txt_emp_id.setText("");
        txt_emp_fname.setText("");
        txt_emp_lname.setText("");
        txt_emp_nic.setText("");
        txt_emp_mobile.setText("");
        cmb_gender.setSelectedIndex(0);
        cmb_type.setSelectedIndex(0);
        cmb_status.setSelectedIndex(0);
        txt_emp_id.setEditable(true);

    }

    private void loadGender() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender` ");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("name"));
                genderMap.put(resultSet.getString("name"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            cmb_gender.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadtype() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee_type` ");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("type"));
                typeMap.put(resultSet.getString("type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            cmb_type.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadStatus() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `status` ");

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {

                v.add(resultSet.getString("status"));
                statusMap.put(resultSet.getString("status"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            cmb_status.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadTable() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee`"
                    + " INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.`id` "
                    + " INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` "
                    + " INNER JOIN `status` ON `employee`.`status_id` = `status`.`id` ");

            DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
            table.setRowCount(0);

            while (resultSet.next()) {

                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("fname"));
                v.add(resultSet.getString("lname"));
                v.add(resultSet.getString("nic"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("employee_type.type"));
                v.add(resultSet.getString("gender.name"));
                v.add(resultSet.getString("status.status"));

                table.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_emp_id = new javax.swing.JTextField();
        txt_emp_fname = new javax.swing.JTextField();
        txt_emp_lname = new javax.swing.JTextField();
        txt_emp_mobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_emp_nic = new javax.swing.JTextField();
        btn_random_id = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cmb_gender = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cmb_status = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmb_type = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(697, 0));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Employees Management");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Emplouee ID");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Mobile Number");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("NIC Number");

        btn_random_id.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_random_id.setText("Add");
        btn_random_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_random_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_random_idActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("Update");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel20.setText("Gender");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setText("Status");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setText("Employee type");

        jButton4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emp_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emp_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emp_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_emp_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_random_id, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_emp_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_emp_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_emp_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_emp_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_random_id))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String emp_id = txt_emp_id.getText();
        String emp_fname = txt_emp_fname.getText();
        String emp_lname = txt_emp_lname.getText();
        String emp_nic = txt_emp_nic.getText();
        String emp_mobile = txt_emp_mobile.getText();
        String emp_gender = String.valueOf(cmb_gender.getSelectedItem());
        String emp_type = String.valueOf(cmb_type.getSelectedItem());
        String emp_status = String.valueOf(cmb_status.getSelectedItem());

        if (emp_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee id", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee first name", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee last name", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee NIC", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee mobile", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_type.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select employee type", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_gender.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select employee gender", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_status.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select employee status", "Error", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `id` = '" + emp_id + "' OR `nic` = '" + emp_nic + "' ");

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(this, "Already registered this ID: " + emp_id + " or NIC: " + emp_nic, "Error", JOptionPane.WARNING_MESSAGE);

                } else {

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("INSERT INTO `employee`(`id`, `fname`, `lname`, `nic`, `mobile`, `employee_type_id`, `gender_id`, `status_id`, `registered_date`) "
                            + "VALUES('" + emp_id + "', '" + emp_fname + "', '" + emp_lname + "', '" + emp_nic + "', '" + emp_mobile + "', '" + typeMap.get(emp_type) + "', '" + genderMap.get(emp_gender) + "', '" + statusMap.get(emp_status) + "', '" + sdf.format(date) + "') ");

                    JOptionPane.showMessageDialog(this, "Successfully registered.", "Message", JOptionPane.INFORMATION_MESSAGE);

                    loadTable();
                    reset();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_random_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_random_idActionPerformed

        Random random = new Random();
        int randomId = random.nextInt();
        txt_emp_nic.setText(String.valueOf(randomId) + txt_emp_id.getText());

    }//GEN-LAST:event_btn_random_idActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String emp_id = txt_emp_id.getText();
        String emp_fname = txt_emp_fname.getText();
        String emp_lname = txt_emp_lname.getText();
        String emp_nic = txt_emp_nic.getText();
        String emp_mobile = txt_emp_mobile.getText();
        String emp_gender = String.valueOf(cmb_gender.getSelectedItem());
        String emp_type = String.valueOf(cmb_type.getSelectedItem());
        String emp_status = String.valueOf(cmb_status.getSelectedItem());

        if (emp_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee id", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee first name", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee last name", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee NIC", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee mobile", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_type.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select employee type", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_gender.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select employee gender", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (emp_status.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select employee status", "Error", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `nic` = '" + emp_nic + "' OR `mobile` = '" + emp_mobile + "' ");
                boolean canUpdate = false;

                if (resultSet.next()) {

                    if(!resultSet.getString("id").equals(emp_id)) {
                        JOptionPane.showMessageDialog(this, "Mobile or NIC allready used");
                    } else {

                        canUpdate = true;

                    }

                } else {

                    canUpdate = true;

                }

                if(canUpdate) {

                    MySQL.execute("UPDATE `employee` SET "
                        + "`fname` = '" + emp_fname + "', "
                        + "`lname` = '" + emp_lname + "', "
                        + "`nic` = '" + emp_nic + "', "
                        + "`mobile` = '" + emp_mobile + "', "
                        + "`employee_type_id` = '" + typeMap.get(emp_type) + "', "
                        + "`gender_id` = '" + genderMap.get(emp_gender) + "', "
                        + "`status_id` = '" + statusMap.get(emp_status) + "' "
                        + "WHERE `id` = '" + emp_id + "'");

                    JOptionPane.showMessageDialog(this, "Successfully updated.", "Messege", JOptionPane.INFORMATION_MESSAGE);

                    loadTable();
                    reset();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int selectedRow = jTable1.getSelectedRow();

        txt_emp_id.setEditable(false);
        btn_random_id.setEnabled(false);

        txt_emp_id.setText(String.valueOf(jTable1.getValueAt(selectedRow, 0)));

        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` "
                + "INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.`id` "
                + "INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` "
                + "INNER JOIN `status` ON `employee`.`status_id` = `status`.`id` "
                + "WHERE `employee`.`id` = '" + String.valueOf(jTable1.getValueAt(selectedRow, 0)) + "' ");

            if (resultSet.next()) {
                txt_emp_fname.setText(resultSet.getString("fname"));
                txt_emp_lname.setText(resultSet.getString("lname"));
                txt_emp_nic.setText(resultSet.getString("nic"));
                txt_emp_mobile.setText(resultSet.getString("mobile"));
                cmb_type.setSelectedItem(resultSet.getString("employee_type.type"));
                cmb_gender.setSelectedItem(resultSet.getString("gender.name"));
                cmb_status.setSelectedItem(resultSet.getString("status.status"));
            } else {
                // Handle the case when no results are returned
                // For example, clear the text fields and reset the combo boxes
                txt_emp_fname.setText("");
                txt_emp_lname.setText("");
                txt_emp_nic.setText("");
                txt_emp_mobile.setText("");
                cmb_type.setSelectedIndex(0);
                cmb_gender.setSelectedIndex(0);
                cmb_status.setSelectedIndex(0);
            }
            
        } catch (Exception e) {
            // Handle any exceptions that might occur during the database query
            e.printStackTrace();
        }

        if(evt.getClickCount() == 2) {

            String emp_id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String fname  = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            String lname  = String.valueOf(jTable1.getValueAt(selectedRow, 2));

            AddEmpAddress address = new AddEmpAddress(fname, lname, emp_id);
            address.setVisible(true);

        }
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_random_id;
    private javax.swing.JComboBox<String> cmb_gender;
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_emp_fname;
    private javax.swing.JTextField txt_emp_id;
    private javax.swing.JTextField txt_emp_lname;
    private javax.swing.JTextField txt_emp_mobile;
    private javax.swing.JTextField txt_emp_nic;
    // End of variables declaration//GEN-END:variables
}
