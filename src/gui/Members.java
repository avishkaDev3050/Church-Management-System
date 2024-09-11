package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Members extends javax.swing.JPanel {

    public Members() {
        initComponents();
        userTable();
        ChildCount();
        UserCount();
        TotalCount();
            
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        user_table.setDefaultRenderer(Object.class, renderer);
    }

    private void userSearchTable() {

        try {

            String user_nic = txt_nic.getText();

            if (user_nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter member's NIC..", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                ResultSet result = MySQL.execute("SELECT * FROM `user` WHERE `nic` = '" + user_nic + "' ");

                DefaultTableModel table = (DefaultTableModel) user_table.getModel();
                table.setRowCount(0);

                if (result.next()) {

                    Vector v = new Vector();
                    v.add(result.getString("nic"));
                    v.add(result.getString("fname"));
                    v.add(result.getString("lname"));
                    v.add(result.getString("mobile"));

                    table.addRow(v);
                    txt_nic.setText("");

                } else {

                    JOptionPane.showMessageDialog(this, "Invalid NIC or user not registered...", "Error", JOptionPane.ERROR_MESSAGE);
                    txt_nic.setText("");
                    userTable();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void TotalCount() {

        int adult = Integer.parseInt(lbl_user.getText());
        int children = Integer.parseInt(lbl_children.getText());
        int total = adult + children;
        lbl_total.setText(String.valueOf(total));

    }

    private void UserCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `user`");

            if (resultSet.next()) {

                int count = resultSet.getInt(1); // Get the count from the ResultSet
                lbl_user.setText(String.valueOf(count)); // Set the label text
                int children = Integer.parseInt(lbl_children.getText());
                int total = count + children;
                lbl_total.setText(String.valueOf(total));

            } else {

                lbl_user.setText("0"); // Set a default value if no result is found
                lbl_total.setText("0");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ChildCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `children`");

            if (resultSet.next()) {

                int count = resultSet.getInt(1); // Get the count from the ResultSet
                lbl_children.setText(String.valueOf(count)); // Set the label text
                int adult = Integer.parseInt(lbl_user.getText());
                int total = adult + count;
                lbl_total.setText(String.valueOf(total));
                System.out.println(resultSet.getInt(1));

            } else {

                lbl_children.setText("0"); // Set a default value if no result is found
                lbl_total.setText("0");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void userTable() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `user` ");

            DefaultTableModel table = (DefaultTableModel) user_table.getModel();
            table.setRowCount(0);

            while (resultSet.next()) {

                Vector v = new Vector();
                v.add(resultSet.getString("nic"));
                v.add(resultSet.getString("fname"));
                v.add(resultSet.getString("lname"));
                v.add(resultSet.getString("mobile"));

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
        txt_nic = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_children = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Members");

        jLabel1.setText("NIC Number");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Find");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Total Members");

        lbl_total.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_total.setText("00");

        lbl_user.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_user.setText("00");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Total Adult");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Total Children");

        lbl_children.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_children.setText("00");

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "First Name", "Last Name", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                user_tableMouseEntered(evt);
            }
        });
        user_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                user_tableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(user_table);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 119, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_user, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_children, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(lbl_user)
                    .addComponent(lbl_children))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userSearchTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked

        int SelectedRow = user_table.getSelectedRow();

        String user_id = String.valueOf(user_table.getValueAt(SelectedRow, 0));
        String fname = String.valueOf(user_table.getValueAt(SelectedRow, 1));
        String lname = String.valueOf(user_table.getValueAt(SelectedRow, 2));

        if (evt.getClickCount() == 2) {

            Chidren c = new Chidren(fname, lname, user_id);
            c.setVisible(true);

        }

        if (evt.getButton() == 3) {

            UserAddress address = new UserAddress(user_id, fname, lname);
            address.setVisible(true);

        }
    }//GEN-LAST:event_user_tableMouseClicked

    private void user_tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_user_tableMouseEntered

    private void user_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_tableKeyReleased

//        System.out.println(evt.getKeyCode());
        int SelectedRow = user_table.getSelectedRow();

        String user_id = String.valueOf(user_table.getValueAt(SelectedRow, 0));
        String fname = String.valueOf(user_table.getValueAt(SelectedRow, 1));
        String lname = String.valueOf(user_table.getValueAt(SelectedRow, 2));
        String mobile = String.valueOf(user_table.getValueAt(SelectedRow, 3));

        if (evt.getKeyCode() == 32) {
            UpdateMember updmbr = new UpdateMember(user_id, fname, lname, mobile);
            updmbr.setVisible(true);
        }

        if (evt.getKeyCode() == 90) {

            try {

                ResultSet result = MySQL.execute("SELECT * FROM `user` WHERE `nic` = '" + user_id + "' ");

                if (result.next()) {
                    
                    String register_date = result.getString("registered_date");
                    
                    MemberView mbrView = new MemberView(fname, lname, mobile, register_date, user_id);
                    mbrView.setVisible(true);
                    
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }//GEN-LAST:event_user_tableKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        userTable();
        UserCount();
        ChildCount();
        TotalCount();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_children;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
