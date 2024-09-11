
package gui;

public class MemberView extends javax.swing.JFrame {

    public MemberView(String fname, String lname, String mobile, String register_date, String user_id) {
        initComponents();
        lbl_member.setText(fname + " " + lname);
        lbl_fname.setText(fname);
        lbl_lname.setText(lname);
        lbl_mobile.setText(mobile);
        lbl_nic.setText(user_id);
        lbl_register_date.setText(register_date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_member = new javax.swing.JLabel();
        lbl_member1 = new javax.swing.JLabel();
        lbl_member2 = new javax.swing.JLabel();
        lbl_member3 = new javax.swing.JLabel();
        lbl_member4 = new javax.swing.JLabel();
        lbl_member5 = new javax.swing.JLabel();
        lbl_fname = new javax.swing.JLabel();
        lbl_nic = new javax.swing.JLabel();
        lbl_lname = new javax.swing.JLabel();
        lbl_mobile = new javax.swing.JLabel();
        lbl_register_date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Member View");
        setAlwaysOnTop(true);
        setResizable(false);

        lbl_member.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_member.setText("jLabel1");

        lbl_member1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_member1.setText("NIC Number");

        lbl_member2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_member2.setText("First Name");

        lbl_member3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_member3.setText("Last Name");

        lbl_member4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_member4.setText("Mobile Number");

        lbl_member5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_member5.setText("Register Date");

        lbl_fname.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_fname.setText("Avishka");

        lbl_nic.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_nic.setText("200215101221");

        lbl_lname.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_lname.setText("Madushan");

        lbl_mobile.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_mobile.setText("0715683319");

        lbl_register_date.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_register_date.setText("2023-11-20");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_member, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_member1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_member4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(179, 179, 179)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_member2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_member3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_register_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_member5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_member)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_member1)
                    .addComponent(lbl_member2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_member3)
                    .addComponent(lbl_member4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_member5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_register_date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_lname;
    private javax.swing.JLabel lbl_member;
    private javax.swing.JLabel lbl_member1;
    private javax.swing.JLabel lbl_member2;
    private javax.swing.JLabel lbl_member3;
    private javax.swing.JLabel lbl_member4;
    private javax.swing.JLabel lbl_member5;
    private javax.swing.JLabel lbl_mobile;
    private javax.swing.JLabel lbl_nic;
    private javax.swing.JLabel lbl_register_date;
    // End of variables declaration//GEN-END:variables
}
