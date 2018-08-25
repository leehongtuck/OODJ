/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;

import Model.Inventory;
import Model.Product;
import Model.ProductInventoryLoader;
import Model.ProductInventoryManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ht-19
 */
public class ManageProductView extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form ManageProduct
     */
    public ManageProductView() {
        initComponents();
        loadTable();
    }
    
    private void loadTable(){
        model = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
                
        ProductInventoryLoader p = new ProductInventoryLoader();
        ArrayList<Inventory> inventoryArrayList = p.load();
        model.addColumn("Product ID");
        model.addColumn("Product");
        model.addColumn("Price (RM)");
        model.addColumn("Type");
        model.addColumn("Stock"); 
        for(int i = 0; i < inventoryArrayList.size(); i++){
            String productId = inventoryArrayList.get(i).getProduct().getProductId();
            String productName = inventoryArrayList.get(i).getProduct().getProductName();
            String price = Double.toString(inventoryArrayList.get(i).getProduct().getPrice());
            String type = "";
            if(inventoryArrayList.get(i).getProduct().toString().equals("N")){
                type = "Non-Fragile";
            }else if(inventoryArrayList.get(i).getProduct().toString().equals("F")){
                type = "Fragile";
            }
            String quantity = Integer.toString(inventoryArrayList.get(i).getQuantity());
            Object[] data = {productId, productName, price, type, quantity};
            model.addRow(data);
        }
        tblProduct.setModel(model);
    }
    
    private void loadTable(String search){
        model = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
                
        ProductInventoryLoader p = new ProductInventoryLoader();
        ArrayList<Inventory> inventoryArrayList = p.load(search);
        model.addColumn("Product ID");
        model.addColumn("Product");
        model.addColumn("Price (RM)");
        model.addColumn("Type");
        model.addColumn("Stock"); 
        for(int i = 0; i < inventoryArrayList.size(); i++){
            String productId = inventoryArrayList.get(i).getProduct().getProductId();
            String productName = inventoryArrayList.get(i).getProduct().getProductName();
            String price = Double.toString(inventoryArrayList.get(i).getProduct().getPrice());
            String type = "";
            if(inventoryArrayList.get(i).getProduct().toString().equals("N")){
                type = "Non-Fragile";
            }else if(inventoryArrayList.get(i).getProduct().toString().equals("F")){
                type = "Fragile";
            }
            String quantity = Integer.toString(inventoryArrayList.get(i).getQuantity());
            Object[] data = {productId, productName, price, type, quantity};
            model.addRow(data);
        }
        tblProduct.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnViewAll = new javax.swing.JButton();
        btnEditProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        jButton1.setText("Add Product");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnViewAll.setText("View All Products");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        btnEditProduct.setText("Edit Product & Inventory");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setText("Delete Product");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnMainMenu.setText("Main Menu");

        jLabel1.setText("Manage Products");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(266, 266, 266))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewAll)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnEditProduct)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMainMenu))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewAll)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnDeleteProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainMenu)
                    .addComponent(btnEditProduct))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        // TODO add your handling code here:
        if(tblProduct.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select a product to edit!");
            return;                
        }
        int rowSelect = tblProduct.getSelectedRow();
        String productId = (String)model.getValueAt(rowSelect, 0);
        int stock = Integer.parseInt((String)model.getValueAt(rowSelect, 4));
        
        Product p = new ProductInventoryLoader().createProduct(productId);
        new EditProductView(new Inventory(p, stock)).setVisible(true); 
        this.dispose();
        
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        loadTable(search);    
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        if(tblProduct.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select a product to remove!");
            return;                
        }
        int rowSelect = tblProduct.getSelectedRow();
        String productId = (String)model.getValueAt(rowSelect, 0);
        new ProductInventoryManager().deleteProduct(
            new Inventory(new ProductInventoryLoader().createProduct(productId), 0)    
        );
        
        loadTable();
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}