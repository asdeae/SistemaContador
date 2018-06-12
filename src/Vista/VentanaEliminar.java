/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author Luis Huayta
 */
public class VentanaEliminar extends javax.swing.JDialog {

    /**
     * Creates new form VentanaEliminar
     */
    public VentanaEliminar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();
        jLabelBarra = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jButtonEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegresar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRegresar.setBorderPainted(false);
        jButtonRegresar.setFocusable(false);
        jButtonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseExited(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 0, 110, 20));
        jPanel1.add(jLabelBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 278, 20));

        jPanel2.setBackground(new java.awt.Color(18, 18, 18));

        jComboBoxProductos.setBackground(new java.awt.Color(51, 51, 51));
        jComboBoxProductos.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProductos.setFocusable(false);

        jButtonEliminar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setFocusable(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Marca");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButtonEliminar)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 278, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseEntered
        jButtonRegresar.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_jButtonRegresarMouseEntered

    private void jButtonRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseExited
        jButtonRegresar.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_jButtonRegresarMouseExited

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonEliminar;
    public javax.swing.JButton jButtonRegresar;
    public javax.swing.JComboBox<String> jComboBoxProductos;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelBarra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}