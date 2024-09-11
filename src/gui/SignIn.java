package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.JOptionPane;
import model.MySQL;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.util.logging.*;

public class SignIn extends javax.swing.JFrame {

    private int loginAttempts = 0;
    private long lockoutEndTime = 0;
    public static Logger logger;
    public static FileHandler handler;

    public SignIn() {
        initComponents();
        ImageIcon icon = new ImageIcon(SignIn.class.getResource("/resources/logo.png"));
        this.setIconImage(icon.getImage());
        try {
            logger = Logger.getLogger(SignIn.class.getName());
            handler = new FileHandler("log_1.log", true);
            logger.addHandler(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_employee_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_mobile = new javax.swing.JPasswordField();
        btn_signIn = new javax.swing.JButton();
        btn_show = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Love Of Jesus");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setToolTipText("Love Of Jesus");
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 270));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 270));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Sign In");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Employee ID");

        txt_employee_id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        txt_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mobileActionPerformed(evt);
            }
        });

        btn_signIn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_signIn.setText("Sign In");
        btn_signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signInActionPerformed(evt);
            }
        });

        btn_show.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_show.setText("Show");
        btn_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_showMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_showMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_employee_id)
                    .addComponent(btn_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_mobile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_show, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_mobile, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_signIn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void txt_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mobileActionPerformed

    private void btn_signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signInActionPerformed

        String employee_id = txt_employee_id.getText();
        String mobile = String.valueOf(txt_mobile.getPassword());

        if (employee_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your employee id.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your password", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                ResultSet resultset = MySQL.execute("SELECT * FROM `employee` WHERE `id` = '" + employee_id + "' AND `mobile` = '" + mobile + "' ");

                if (resultset.next()) {

                    int type = Integer.parseInt(resultset.getString("employee_type_id"));

                    if (type == 1) {
                        Home home = new Home();
                        home.setVisible(true);
                        this.dispose();
                    } else {
                        Home2 home2 = new Home2();
                        home2.setVisible(true);
                        this.dispose();
                    }

                } else {
                    // Increment the login attempts
                    loginAttempts++;

                    if (loginAttempts >= 3) {
                        // Lock the system for 30 seconds
                        lockoutEndTime = System.currentTimeMillis() + 30000;
                        JOptionPane.showMessageDialog(this, "Too many failed login attempts. System is locked for 30 seconds.", "Locked", JOptionPane.WARNING_MESSAGE);
                        //                        System.out.println(employee_id + " " + mobile);
                        txt_employee_id.setText("");
                        txt_mobile.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid ID or mobile", "Error", JOptionPane.WARNING_MESSAGE);
                        txt_employee_id.setText("");
                        txt_mobile.setText("");
                    }
                }
            }catch (Exception e) {
                logger.warning(e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_signInActionPerformed

    private void btn_showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_showMousePressed

        txt_mobile.setEchoChar('\u0000');
    }//GEN-LAST:event_btn_showMousePressed

    private void btn_showMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_showMouseReleased

        txt_mobile.setEchoChar('\u2022');
    }//GEN-LAST:event_btn_showMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_show;
    private javax.swing.JButton btn_signIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_employee_id;
    private javax.swing.JPasswordField txt_mobile;
    // End of variables declaration//GEN-END:variables
}
