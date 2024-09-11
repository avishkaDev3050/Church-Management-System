package gui;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Employee extends javax.swing.JPanel {

    public Employee() {
        initComponents();
        loadTable();
        ActiveCount();
        InactiveCount();
        MaleCount();
        FemaleCount();
        FullTime();
        PartTime();
        AdminCount();
        TotalCount();

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        emp_tabal.setDefaultRenderer(Object.class, renderer);
    }

    private void reset() {

        lbl_active.setEnabled(true);
        lbl_inactive.setEnabled(true);
        lbl_female.setEnabled(true);
        lbl_male.setEnabled(true);
        lbl_full_time.setEnabled(true);
        lbl_part_time.setEnabled(true);
        lbl_admin.setEnabled(true);
        
        loadTable();

    }

    private void SearchEmployee() {

        String id = txt_emp_nic.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter employee id.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `id` = '" + id + "' ");

                DefaultTableModel table = (DefaultTableModel) emp_tabal.getModel();
                table.setRowCount(0);

                if (resultSet.next()) {

                    Vector v = new Vector();
                    v.add(resultSet.getString("id"));
                    v.add(resultSet.getString("fname"));
                    v.add(resultSet.getString("lname"));
                    v.add(resultSet.getString("mobile"));
                    v.add(resultSet.getString("nic"));

                    table.addRow(v);
                    txt_emp_nic.setText("");
                    lbl_active.setEnabled(false);
                    lbl_inactive.setEnabled(false);
                    lbl_female.setEnabled(false);
                    lbl_male.setEnabled(false);
                    lbl_full_time.setEnabled(false);
                    lbl_part_time.setEnabled(false);
                    lbl_admin.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid employee id.", "Warning", JOptionPane.WARNING_MESSAGE);
                    txt_emp_nic.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void TotalCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` ");
            resultSet.next();
            lbl_total_emp.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void AdminCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `employee_type_id` = '1' ");
            resultSet.next();
            lbl_admin.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void PartTime() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `employee_type_id` = '3' ");
            resultSet.next();
            lbl_part_time.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void FullTime() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `employee_type_id` = '2' ");
            resultSet.next();
            lbl_full_time.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ActiveCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `status_id` = '1' ");
            resultSet.next();
            lbl_active.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void MaleCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `gender_id` = '1' ");
            resultSet.next();
            lbl_male.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void FemaleCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `gender_id` = '2' ");
            resultSet.next();
            lbl_female.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void InactiveCount() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT COUNT(*) FROM `employee` WHERE `status_id` = '2' ");
            resultSet.next();
            lbl_inactive.setText(String.valueOf(resultSet.getInt(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadTable() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` ");

            DefaultTableModel table = (DefaultTableModel) emp_tabal.getModel();
            table.setRowCount(0);

            while (resultSet.next()) {

                Vector v = new Vector();
                v.add(resultSet.getString("id"));
                v.add(resultSet.getString("fname"));
                v.add(resultSet.getString("lname"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("nic"));

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
        txt_emp_nic = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_male = new javax.swing.JLabel();
        lbl_female = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_active = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emp_tabal = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbl_inactive = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_total_emp = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_full_time = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_part_time = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_admin = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Employees");

        jLabel1.setText("Employee ID :");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Find");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Male Employees");

        lbl_male.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_male.setText("00");

        lbl_female.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_female.setText("00");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Female Employees");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Active Employees");

        lbl_active.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_active.setText("00");

        emp_tabal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Mobile", "NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emp_tabal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_tabalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_tabalMouseEntered(evt);
            }
        });
        emp_tabal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emp_tabalKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(emp_tabal);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Inactive  Employees");

        lbl_inactive.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_inactive.setText("00");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Total Employees");

        lbl_total_emp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_total_emp.setText("00");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Full Time  Employees");

        lbl_full_time.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_full_time.setText("00");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Part Time  Employees");

        lbl_part_time.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_part_time.setText("00");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Total Admin");

        lbl_admin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_admin.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 184, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emp_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_male, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_female, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_active, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_inactive, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_total_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_full_time, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_part_time, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 459, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_emp_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total_emp)
                    .addComponent(lbl_full_time)
                    .addComponent(lbl_part_time)
                    .addComponent(lbl_admin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_male))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_female)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_active)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_inactive)))
                .addGap(22, 22, 22))
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
        SearchEmployee();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emp_tabalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_tabalMouseClicked

        int SelectedRow = emp_tabal.getSelectedRow();

        String id = String.valueOf(emp_tabal.getValueAt(SelectedRow, 0));
        String fname = String.valueOf(emp_tabal.getValueAt(SelectedRow, 1));
        String lname = String.valueOf(emp_tabal.getValueAt(SelectedRow, 2));
        String nic = String.valueOf(emp_tabal.getValueAt(SelectedRow, 4));
        
        if(evt.getClickCount() == 2) {
            EmployeeView empView = new EmployeeView(nic, fname, lname, id);
            empView.setVisible(true);
        }

    }//GEN-LAST:event_emp_tabalMouseClicked

    private void emp_tabalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_tabalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_tabalMouseEntered

    private void emp_tabalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_tabalKeyReleased

        //        System.out.println(evt.getKeyCode());
        int SelectedRow = emp_tabal.getSelectedRow();

        String user_id = String.valueOf(emp_tabal.getValueAt(SelectedRow, 0));
        String fname = String.valueOf(emp_tabal.getValueAt(SelectedRow, 1));
        String lname = String.valueOf(emp_tabal.getValueAt(SelectedRow, 2));
        String mobile = String.valueOf(emp_tabal.getValueAt(SelectedRow, 3));

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
    }//GEN-LAST:event_emp_tabalKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable emp_tabal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_active;
    private javax.swing.JLabel lbl_admin;
    private javax.swing.JLabel lbl_female;
    private javax.swing.JLabel lbl_full_time;
    private javax.swing.JLabel lbl_inactive;
    private javax.swing.JLabel lbl_male;
    private javax.swing.JLabel lbl_part_time;
    private javax.swing.JLabel lbl_total_emp;
    private javax.swing.JTextField txt_emp_nic;
    // End of variables declaration//GEN-END:variables
}
