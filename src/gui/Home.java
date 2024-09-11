
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Home extends javax.swing.JFrame {

    JpanelLoader jpload = new JpanelLoader();
    
    public Home() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon(SignIn.class.getResource("/resources/logo.png"));
        this.setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn = new javax.swing.JButton();
        btn_members = new javax.swing.JButton();
        btn_mbr_manage = new javax.swing.JButton();
        btn_member_attendance = new javax.swing.JButton();
        btn_mbr_attendance_history = new javax.swing.JButton();
        btn_employees = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panel_load = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_1 = new javax.swing.JMenuItem();
        menu_2 = new javax.swing.JMenuItem();
        menu_3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Love Of Jesus | Admin Dashboard");
        setMaximumSize(new java.awt.Dimension(970, 604));
        setMinimumSize(new java.awt.Dimension(970, 604));

        jPanel1.setMaximumSize(new java.awt.Dimension(970, 604));
        jPanel1.setMinimumSize(new java.awt.Dimension(970, 604));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridLayout(9, 1, 5, 5));

        btn.setBackground(new java.awt.Color(0, 102, 51));
        btn.setFont(new java.awt.Font("Goudy Stout", 2, 18)); // NOI18N
        btn.setText("WELCOME");
        jPanel2.add(btn);

        btn_members.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_members.setText("Member s");
        btn_members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_membersActionPerformed(evt);
            }
        });
        jPanel2.add(btn_members);

        btn_mbr_manage.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_mbr_manage.setText("Members Management");
        btn_mbr_manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mbr_manageActionPerformed(evt);
            }
        });
        jPanel2.add(btn_mbr_manage);

        btn_member_attendance.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_member_attendance.setText("Members Attendance");
        btn_member_attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_member_attendanceActionPerformed(evt);
            }
        });
        jPanel2.add(btn_member_attendance);

        btn_mbr_attendance_history.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_mbr_attendance_history.setText("Members Attendance History");
        btn_mbr_attendance_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mbr_attendance_historyActionPerformed(evt);
            }
        });
        jPanel2.add(btn_mbr_attendance_history);

        btn_employees.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_employees.setText("Employees");
        btn_employees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_employeesActionPerformed(evt);
            }
        });
        jPanel2.add(btn_employees);

        jButton5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton5.setText("Employees Management");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setText("Employees Attendance");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);

        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setText("Employees Attendance History");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);

        javax.swing.GroupLayout panel_loadLayout = new javax.swing.GroupLayout(panel_load);
        panel_load.setLayout(panel_loadLayout);
        panel_loadLayout.setHorizontalGroup(
            panel_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );
        panel_loadLayout.setVerticalGroup(
            panel_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenu1.setText("File");

        menu_1.setText("New Window");
        menu_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_1ActionPerformed(evt);
            }
        });
        jMenu1.add(menu_1);

        menu_2.setText("Close");
        menu_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_2ActionPerformed(evt);
            }
        });
        jMenu1.add(menu_2);

        menu_3.setText("Sign Out");
        menu_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_3ActionPerformed(evt);
            }
        });
        jMenu1.add(menu_3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AddEmployee empgui = new AddEmployee();
        jpload.jPanelLoader(panel_load,empgui);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_mbr_manageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mbr_manageActionPerformed
        MemberManagement mbrManage = new MemberManagement();
        jpload.jPanelLoader(panel_load,mbrManage);
    }//GEN-LAST:event_btn_mbr_manageActionPerformed

    private void btn_member_attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_member_attendanceActionPerformed
        MemberAttendance memberAttendance = new MemberAttendance();
        jpload.jPanelLoader(panel_load,memberAttendance);
    }//GEN-LAST:event_btn_member_attendanceActionPerformed

    private void btn_membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_membersActionPerformed
        Members members = new Members();
        jpload.jPanelLoader(panel_load,members);
    }//GEN-LAST:event_btn_membersActionPerformed

    private void btn_mbr_attendance_historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mbr_attendance_historyActionPerformed
        MembersAttendanceHistory mbrAttendanceHistory = new MembersAttendanceHistory();
        jpload.jPanelLoader(panel_load,mbrAttendanceHistory);
    }//GEN-LAST:event_btn_mbr_attendance_historyActionPerformed

    private void btn_employeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_employeesActionPerformed
        Employee emp = new Employee();
        jpload.jPanelLoader(panel_load,emp);
    }//GEN-LAST:event_btn_employeesActionPerformed

    private void menu_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_3ActionPerformed
        SignIn signIn = new SignIn();
        signIn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_3ActionPerformed

    private void menu_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_menu_2ActionPerformed

    private void menu_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_1ActionPerformed
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_menu_1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        EmployeeAttendance empAttendance = new EmployeeAttendance();
        jpload.jPanelLoader(panel_load,empAttendance);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        EmployeeAttendanceHistory empAttendanceHistory = new EmployeeAttendanceHistory();
        jpload.jPanelLoader(panel_load,empAttendanceHistory);
    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JButton btn_employees;
    private javax.swing.JButton btn_mbr_attendance_history;
    private javax.swing.JButton btn_mbr_manage;
    private javax.swing.JButton btn_member_attendance;
    private javax.swing.JButton btn_members;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menu_1;
    private javax.swing.JMenuItem menu_2;
    private javax.swing.JMenuItem menu_3;
    private javax.swing.JPanel panel_load;
    // End of variables declaration//GEN-END:variables
}
