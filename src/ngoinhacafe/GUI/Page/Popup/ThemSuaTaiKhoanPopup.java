/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngoinhacafe.GUI.Page.Popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author Admin
 */
public class ThemSuaTaiKhoanPopup extends javax.swing.JFrame implements ActionListener {
    
    /**
     * Creates new form PopupThemSuaKhachHang
     */
    public ThemSuaTaiKhoanPopup(String loai, String matk) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        WindowActions.WindowClosing(this);
        updateInit();
        
        if (loai.equalsIgnoreCase("thêm")) {
            setTitle("Thêm tài khoản");
            themSuaBtn.setText("Thêm");
        } else {
            setTitle("Sửa tài khoản");
            themSuaBtn.setText("Sửa");
            
            txtMaTK.setText(matk);
            txtMaTK.setEditable(false);
        }
        
    }
    
    public ThemSuaTaiKhoanPopup(javax.swing.JTextField txtMaTK) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        WindowActions.WindowClosing(this);
        updateInit();
        
        setTitle("Thêm tài khoản");
        themSuaBtn.setText("Thêm");
        
        txtMaTKOutside = txtMaTK;
    }
    
    javax.swing.JTextField txtMaTKOutside = null;
    
    private void updateInit() {
        // Add action listener
        themSuaBtn.addActionListener(this);
        thoatBtn.addActionListener(this);
        setVisible(true);
    }
    
    private void kiemTraDieuKien(String loai) {
        boolean check = true;
        
        if (txtMaTK.getText().length() == 0 && check) {
            check = false;
            
            ThongBao.hienLoi("Mã tài khoản không được để trống!");
            txtMaTK.requestFocus();
        }
        
        if (txtTenKH.getText().length() == 0 && check) {
            check = false;
            
            ThongBao.hienLoi("Tên tài khoản không được để trống!");
            txtTenKH.requestFocus();
        }
        
        if (!Regex.ktraTen(txtTenKH.getText()) && check) {
            check = false;
            
            ThongBao.hienLoi("Tên tài khoản không hợp lệ!");
            txtTenKH.requestFocus();
        }
        

        
        if (txtMK.getText().length() == 0 && check) {
            check = false;
            
            ThongBao.hienLoi("Mật khẩu không được để trống!");
            txtMK.requestFocus();
        }
        

            
        if (check) {
            if (loai.equalsIgnoreCase("thêm")) {
                themData();
                
                if (txtMaTKOutside != null) {
                    txtMaTKOutside.setText(txtMaTK.getText());
                    this.dispose();
                }
                
            } else {
                capNhatData();
            }
        }
    }
    
    private void themData() {
        
    }
    
    private void capNhatData() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        txtMaTK = new javax.swing.JTextField();
        themSuaBtn = new javax.swing.JButton();
        thoatBtn = new javax.swing.JButton();
        txtMK1 = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTenKH.setBorder(javax.swing.BorderFactory.createTitledBorder("Tài khoản"));
        txtTenKH.setPreferredSize(new java.awt.Dimension(80, 39));
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtMK.setBorder(javax.swing.BorderFactory.createTitledBorder("Mật khẩu"));
        txtMK.setPreferredSize(new java.awt.Dimension(80, 39));

        txtMaTK.setToolTipText("");
        txtMaTK.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã tài khoản"));
        txtMaTK.setPreferredSize(new java.awt.Dimension(80, 39));
        txtMaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTKActionPerformed(evt);
            }
        });

        themSuaBtn.setText("Thêm/Sửa");
        themSuaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSuaBtnActionPerformed(evt);
            }
        });

        thoatBtn.setText("Thoát");

        txtMK1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã quyền"));
        txtMK1.setPreferredSize(new java.awt.Dimension(80, 39));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(themSuaBtn)
                        .addGap(81, 81, 81)
                        .addComponent(thoatBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addComponent(txtMaTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMK1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtMaTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themSuaBtn)
                    .addComponent(thoatBtn))
                .addGap(31, 31, 31))
        );

        txtTenKH.getAccessibleContext().setAccessibleName("Tên tài khoản\n");
        txtMaTK.getAccessibleContext().setAccessibleName("Mã tài khoản");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTKActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void themSuaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSuaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themSuaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton themSuaBtn;
    private javax.swing.JButton thoatBtn;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMK1;
    private javax.swing.JTextField txtMaTK;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themSuaBtn) {
            kiemTraDieuKien(themSuaBtn.getText());
        }
        if (e.getSource() == thoatBtn) {
            this.dispose();
        }
    }
}
