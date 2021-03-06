/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simz1;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static simz1.LoginFrame1.mhp;
import static simz1.ManagerHomeScreen.resizeImageIcon;

/**
 *
 * @author CHAM PC
 */
public class LoginFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame1
     */
    public LoginFrame1() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo1.jpg")));
    }

    DBOperations dbOps = new DBOperations();
    int count = 1;
    public static ManagerHomeScreen mhp = new ManagerHomeScreen();
    public static SalespersonHomeScreen spi = new SalespersonHomeScreen();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnHint = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("User Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(198, 365, 70, 14);

        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("User");
        getContentPane().add(user);
        user.setBounds(300, 330, 130, 14);

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        getContentPane().add(txtUserName);
        txtUserName.setBounds(280, 360, 170, 20);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(198, 403, 70, 14);

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(280, 400, 170, 20);

        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(280, 440, 81, 23);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(370, 440, 80, 23);

        btnHint.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnHint.setText("?");
        btnHint.setToolTipText("Click To Show Password Hint");
        btnHint.setPreferredSize(new java.awt.Dimension(25, 25));
        btnHint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHintActionPerformed(evt);
            }
        });
        getContentPane().add(btnHint);
        btnHint.setBounds(460, 400, 50, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simz1/logo1.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(660, 520, 50, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simz1/user.png"))); // NOI18N
        jLabel4.setText("jLabel5");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(320, 220, 100, 110);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simz1/background1.jpg"))); // NOI18N
        jLabel3.setPreferredSize(null);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 740, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        String s1 = getTxtUserName().getText();

        if ("".equals(s1) && "".equals(txtPassword.getText())) {
            JOptionPane.showMessageDialog(this, "please enter your username and password!!!");
            return;
        }

        if (!"".equals(s1) && "".equals(txtPassword.getText())) {
            JOptionPane.showMessageDialog(this, "please enter your password!!!");
            return;
        }

        if ("".equals(s1) && !"".equals(txtPassword.getText())) {
            JOptionPane.showMessageDialog(this, "please enter your username!!!");
            return;
        }

        String encrypt = PswrdEncrypt.main2(txtPassword.getText());
        int x = dbOps.checkLogin(s1, encrypt);

        if (x == 11) {
            this.setVisible(false);
            spi.setVisible(true);
            //spi.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            spi.name3.setText(s1);
            spi.SalesPStock.getColumnModel().getColumn(5).setMinWidth(0);
            spi.SalesPStock.getColumnModel().getColumn(5).setMaxWidth(0);

            String rst = dbOps.getPropic(s1);

            if (rst != null) {
                ImageIcon image1 = new ImageIcon(rst);
                //spf.jLabel15.setIcon(image1);
                //spf.name.setText(s1);
            }

        } else if (x == 1) {
            this.setVisible(false);
            mhp.setVisible(true);
            //mhp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            StackedBarChart sbc = new StackedBarChart("Sales of last week");
            mhp.name1.setText(s1);
            mhp.tableProduct.getColumnModel().getColumn(7).setMinWidth(0);
            mhp.tableProduct.getColumnModel().getColumn(7).setMaxWidth(0);
            mhp.tblOrder.getColumnModel().getColumn(7).setMinWidth(0);
            mhp.tblOrder.getColumnModel().getColumn(7).setMaxWidth(0);

            String rst = dbOps.getPropic(s1);

            if (rst != null) {
                ImageIcon image1 = new ImageIcon(rst);
                //mpf.jLabel18.setIcon(image1);
                //mpf.name.setText(s1);
            }
        } else if (x == 2) {
            if (count != 3) {
                JOptionPane.showMessageDialog(this, "Incorrect password!!!");
                count += 1;
                txtPassword.setText("");
                btnHint.setVisible(true);
            } else if (count == 3) {
                JOptionPane.showMessageDialog(this, "ERROR!!! System will close!");
                this.dispose();
            }
        } else if (x == 0) {
            JOptionPane.showMessageDialog(this, "Incorrect user Name!!!");
            txtPassword.setText("");
            getTxtUserName().setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Error occured while checking the userName!!!");
            return;
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        getTxtUserName().setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnHintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHintActionPerformed
        String hint = dbOps.getHint(getTxtUserName().getText());
        if (hint != null) {
            JOptionPane.showMessageDialog(this, "The password hint is : \n" + hint);
        }
    }//GEN-LAST:event_btnHintActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String s1 = getTxtUserName().getText();

            if ("".equals(s1) && "".equals(txtPassword.getText())) {
                JOptionPane.showMessageDialog(this, "please enter your username and password!!!");
                return;
            }

            if (!"".equals(s1) && "".equals(txtPassword.getText())) {
                JOptionPane.showMessageDialog(this, "please enter your password!!!");
                return;
            }

            if ("".equals(s1) && !"".equals(txtPassword.getText())) {
                JOptionPane.showMessageDialog(this, "please enter your username!!!");
                return;
            }

            String encrypt = PswrdEncrypt.main2(txtPassword.getText());
            int x = dbOps.checkLogin(s1, encrypt);

            if (x == 11) {
                this.setVisible(false);
                spi.setVisible(true);
                //spi.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                spi.name3.setText(s1);
                spi.SalesPStock.getColumnModel().getColumn(5).setMinWidth(0);
                spi.SalesPStock.getColumnModel().getColumn(5).setMaxWidth(0);

                String rst = dbOps.getPropic(s1);

                if (rst != null) {
                    ImageIcon image1 = new ImageIcon(rst);
                    ImageIcon image2 = resizeImageIcon(image1, 60, 60);
                    spi.lablePic.setIcon(image2);
                }

            } else if (x == 1) {
                this.setVisible(false);
                mhp.setVisible(true);
                //mhp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                StackedBarChart sbc = new StackedBarChart("Sales of last week");
                mhp.name1.setText(s1);
                mhp.tableProduct.getColumnModel().getColumn(7).setMinWidth(0);
                mhp.tableProduct.getColumnModel().getColumn(7).setMaxWidth(0);
                mhp.tblOrder.getColumnModel().getColumn(7).setMinWidth(0);
                mhp.tblOrder.getColumnModel().getColumn(7).setMaxWidth(0);

                String rst = dbOps.getPropic(s1);

                if (rst != null) {
                    ImageIcon image1 = new ImageIcon(rst);
                    ImageIcon image2 = resizeImageIcon(image1, 60, 60);
                    mhp.lablePic.setIcon(image2);
                    //mpf.name.setText(s1);
                }
            } else if (x == 2) {
                if (count != 3) {
                    
                    JOptionPane.showMessageDialog(this, "Incorrect password!!!");
                    count += 1;
                    txtPassword.setText("");
                    btnHint.setVisible(true);
                } else if (count == 3) {
                    
                    int result = JOptionPane.showConfirmDialog(null, "Maximum attempts are finished for entering the password, do you want to reset your password", null, JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {

                        String password = "pereraandsons";
                        String recoverEncrypt = PswrdEncrypt.main2(password);
                        int id = dbOps.getID(txtUserName.getText());
                        dbOps.resetPswrd(recoverEncrypt, id);
                        String e_mail = dbOps.email();
                        String massege = "Password of the user who has user id " + id + " is reset to " + password;
                        System.err.println(e_mail);
                        Mail mail = new Mail(e_mail, "Reset password", massege);
                        this.dispose();
                        
                    } else if (result == JOptionPane.YES_OPTION) {
                        this.dispose();
                    }
                
            } else if (x == 0) {
                JOptionPane.showMessageDialog(this, "Incorrect user Name!!!");
                txtPassword.setText("");
                getTxtUserName().setText("");

            } else {
                JOptionPane.showMessageDialog(this, "Error occured while checking the userName!!!");
                return;
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            txtUserName.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed
    }
    
    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            txtPassword.requestFocusInWindow();
        }
        if (code == KeyEvent.VK_TAB) {
            txtPassword.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(new HiFiLookAndFeel());

                } catch (Exception e) {
                    System.out.println("e");
                }
                new LoginFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnHint;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    public javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txtUserName
     */
    public javax.swing.JTextField getTxtUserName() {
        return txtUserName;
    }

    /**
     * @param txtUserName the txtUserName to set
     */
    public void setTxtUserName(javax.swing.JTextField txtUserName) {
        this.txtUserName = txtUserName;
    }


}
