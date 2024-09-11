
package gui;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import model.MySQL;

public class EmployeeView extends javax.swing.JFrame {
    
    public String nic;
    public String id;
    
    public EmployeeView(String nic, String fname, String lname, String id) {
        initComponents();
        this.nic = nic;
        this.id = id;
        lbl_emp_name.setText(fname + " " + lname);
        EmpTSG();
        loadAddress();
        
        ImageIcon icon = new ImageIcon(EmployeeView.class.getResource("/resources/logo.png"));
        this.setIconImage(icon.getImage());
    }
    
private void EmpTSG() {
    
    try {

        ResultSet gender = MySQL.execute("SELECT * FROM `employee` "
                + "INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` "
                + "WHERE `employee`.`nic` = '"+ this.nic +"'");
        gender.next();
        lbl_gender.setText(gender.getString("gender.name"));
        
        ResultSet status = MySQL.execute("SELECT * FROM `employee` "
                + "INNER JOIN `status` ON `employee`.`status_id` = `status`.`id` "
                + "WHERE `employee`.`nic` = '"+ this.nic +"'");
        status.next();
        lbl_statux.setText(status.getString("status.status"));
        
        ResultSet type = MySQL.execute("SELECT * FROM `employee` "
                + "INNER JOIN `employee_type` ON `employee`.`employee_type_id` = `employee_type`.`id` "
                + "WHERE `employee`.`nic` = '"+ this.nic +"'");
        type.next();
        lbl_type.setText(type.getString("employee_type.type"));
        
        lbl_reg_date.setText(gender.getString("registered_date"));

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void loadAddress() {
        
        try {
            
            ResultSet resultSet = MySQL.execute("SELECT * FROM `employee_address` INNER JOIN `city`"
                    + "ON `employee_address`.`city_id`=`city`.`id`"
                    + "WHERE `employee_id`='" + this.id + "'");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("line_1"));
                vector.add(resultSet.getString("line_2"));
                vector.add(resultSet.getString("city.city"));
                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_emp_name = new javax.swing.JLabel();
        lbl_statux = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_type = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbl_reg_date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee");
        setAlwaysOnTop(true);
        setResizable(false);

        lbl_emp_name.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_emp_name.setText("Avishka Madushan");

        lbl_statux.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_statux.setText("Active");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Employee Status");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Employee's Gender");

        lbl_gender.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_gender.setText("Male");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Employee Tyoe");

        lbl_type.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_type.setText("Admin");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Line 1", "Line 2", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Registered Date");

        lbl_reg_date.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_reg_date.setText("2023-09-09");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_statux, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_type, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_reg_date, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_statux)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gender)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_type)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_reg_date))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_emp_name;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_reg_date;
    private javax.swing.JLabel lbl_statux;
    private javax.swing.JLabel lbl_type;
    // End of variables declaration//GEN-END:variables
}
