package gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class MembersAttendanceHistory extends javax.swing.JPanel {

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public MembersAttendanceHistory() {
        initComponents();
        
            
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        user_table.setDefaultRenderer(Object.class, renderer);
        child_table.setDefaultRenderer(Object.class, renderer);
    }

    private void userSearchTable() {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser1.getDate());

            ResultSet resultSet = MySQL.execute("SELECT * FROM `user_attendance` WHERE `date` = '" + date + "' ORDER BY `time` DESC ");

            DefaultTableModel table = (DefaultTableModel) user_table.getModel();
            table.setRowCount(0);

            while (resultSet.next()) {

                String user_nic = resultSet.getString("user_nic");

                ResultSet result = MySQL.execute("SELECT * FROM `user` WHERE `nic` = '" + user_nic + "' ");
                result.next();

                Vector v = new Vector();
                v.add(result.getString("nic"));
                v.add(result.getString("fname"));
                v.add(result.getString("lname"));
                v.add(result.getString("mobile"));

                table.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void userTNCTable() {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());

            if (date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a date", "Warning", JOptionPane.WARNING_MESSAGE);
            }

            ResultSet result = MySQL.execute("SELECT * FROM `user` WHERE `registered_date` = '" + date + "' ");
//
            DefaultTableModel table = (DefaultTableModel) user_table.getModel();
            table.setRowCount(0);

            while (result.next()) {

                Vector v = new Vector();
                v.add(result.getString("nic"));
                v.add(result.getString("fname"));
                v.add(result.getString("lname"));
                v.add(result.getString("mobile"));
                table.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ChildrenSearchTable() {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser1.getDate());

            ResultSet resultSet = MySQL.execute("SELECT * FROM `children_attendance` WHERE `date` = '" + date + "' ORDER BY `time` DESC ");

            DefaultTableModel table = (DefaultTableModel) child_table.getModel();
            table.setRowCount(0);

            while (resultSet.next()) {

                String child_id = resultSet.getString("children_id");

                ResultSet result = MySQL.execute("SELECT * FROM `children` WHERE `id` = '" + child_id + "' ");
                result.next();

                Vector v = new Vector();
                v.add(result.getString("id"));
                v.add(result.getString("fname"));
                v.add(result.getString("lname"));
                v.add(result.getString("parent_nic"));
                table.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void ChildrenTNSTable() {

        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());

            ResultSet result = MySQL.execute("SELECT * FROM `children` WHERE `registered_date` = '" + date +"' ");

            DefaultTableModel table = (DefaultTableModel) child_table.getModel();
            table.setRowCount(0);

            while (result.next()) {

                Vector v = new Vector();
                v.add(result.getString("id"));
                v.add(result.getString("fname"));
                v.add(result.getString("lname"));
                v.add(result.getString("parent_nic"));
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
        jLabel2 = new javax.swing.JLabel();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        date_chooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        child_table = new javax.swing.JTable();
        btn_print = new javax.swing.JButton();
        btn_print1 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Members Attendance History");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("TNC :");

        date_chooser.setForeground(new java.awt.Color(255, 255, 255));
        date_chooser.setDateFormatString("yyyy-MM-dd");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("Find");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Date :");

        date_chooser1.setForeground(new java.awt.Color(255, 255, 255));
        date_chooser1.setDateFormatString("yyyy-MM-dd");

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("Find");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "First Name", "Last Name", "Mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(user_table);

        child_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Parent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        child_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                child_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(child_table);

        btn_print.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_print.setText("Report");
        btn_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_print1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_print1.setText("Report");
        btn_print1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_chooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_print1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(date_chooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(btn_print)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_print1)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        userTNCTable();
        ChildrenTNSTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userSearchTable();
        ChildrenSearchTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void child_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_child_tableMouseClicked

    }//GEN-LAST:event_child_tableMouseClicked

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try {
            String date = sdf.format(date_chooser1.getDate());
            HashMap <String, Object> parameters = new HashMap<>();
            parameters.put("Date", date );
            String filePath = "src//reports//daily_users.jasper";
            JRDataSource dataSource = new JRTableModelDataSource(user_table.getModel());
            
            JasperPrint print = JasperFillManager.fillReport(filePath, parameters, dataSource);
            JasperViewer.viewReport(print, false);
            
        } catch (JRException e) {
            throw new RuntimeException(e.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print1ActionPerformed
        try {
            String date = sdf.format(date_chooser1.getDate());
            HashMap <String, Object> parameters = new HashMap<>();
            parameters.put("Date", date );
            String filePath = "src//reports//daily_users.jasper";
            JRDataSource dataSource = new JRTableModelDataSource(child_table.getModel());
            
            JasperPrint print = JasperFillManager.fillReport(filePath, parameters, dataSource);
            JasperViewer.viewReport(print, false);
            
        } catch (JRException e) {
            throw new RuntimeException(e.getMessage());
        }
    }//GEN-LAST:event_btn_print1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_print1;
    private javax.swing.JTable child_table;
    private com.toedter.calendar.JDateChooser date_chooser;
    private com.toedter.calendar.JDateChooser date_chooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
