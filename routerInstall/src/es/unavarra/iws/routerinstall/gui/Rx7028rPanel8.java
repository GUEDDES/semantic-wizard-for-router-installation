/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import java.awt.event.ActionListener;

/**
 *
 * @author aqm
 */
public class Rx7028rPanel8 extends javax.swing.JPanel {

    /**
     * Creates new form Router1Panel2
     */
    public Rx7028rPanel8() {
        initComponents();
    }
    /*
    public boolean isCheckBoxSelected() {
        return jCheckBox1.isSelected();
    }    
    
    public void addCheckBoxActionListener(ActionListener l) {
        jCheckBox1.addActionListener(l);
    } 
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jpTitulo = new javax.swing.JPanel();
        jlTexto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlIcono = new javax.swing.JLabel();
        jpContenido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jpTitulo.setForeground(java.awt.Color.gray);
        jpTitulo.setLayout(new java.awt.BorderLayout());

        jlTexto.setBackground(java.awt.Color.lightGray);
        jlTexto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlTexto.setText("Información de interés");
        jlTexto.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jlTexto.setOpaque(true);
        jpTitulo.add(jlTexto, java.awt.BorderLayout.CENTER);

        jSeparator1.setBackground(java.awt.Color.lightGray);
        jSeparator1.setOpaque(true);
        jpTitulo.add(jSeparator1, java.awt.BorderLayout.SOUTH);

        jlIcono.setBackground(java.awt.Color.lightGray);
        jlIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/setting32.png"))); // NOI18N
        jlIcono.setOpaque(true);
        jpTitulo.add(jlIcono, java.awt.BorderLayout.LINE_END);

        add(jpTitulo, java.awt.BorderLayout.NORTH);

        jpContenido.setLayout(new java.awt.BorderLayout());

        jLabel1.setMaximumSize(new java.awt.Dimension(252, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(252, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(252, 40));
        jpContenido.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel1.setPreferredSize(new java.awt.Dimension(480, 192));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(jLabel6);

        jLabel7.setText("• Manual de Usuario:");
        jPanel1.add(jLabel7);

        jLabel3.setText("<html><a href=\"\">Enlace</a></html>\");");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);

        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8);

        jLabel5.setText("• Guía Rápida: ");
        jPanel1.add(jLabel5);

        jLabel2.setText("<html><a href=\"\">Enlace</a></html>\");");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel4);

        jpContenido.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jpContenido, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
// TODO add your handling code here:
    try {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                desktop.browse(new java.net.URI("http://www.movistar.es/on/es/archivos/pdf/manual/manual_kit_adsl_convertible.pdf"));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jLabel3MouseClicked

private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
// TODO add your handling code here:
    // TODO add your handling code here:
    try {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                desktop.browse(new java.net.URI("http://www.movistar.es/on/es/archivos/pdf/manual/manual_kit_adsl_convertible.pdf"));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jLabel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlIcono;
    private javax.swing.JLabel jlTexto;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpTitulo;
    // End of variables declaration//GEN-END:variables
}
