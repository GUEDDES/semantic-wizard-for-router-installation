/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import java.awt.Container;

/**
 *
 * @author aqm
 */
public class Busqueda extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Busqueda() {
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

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/home32.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(10, 40, 50, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/question32.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(420, 50, 30, 30);

        jLabel2.setBackground(new java.awt.Color(215, 227, 246));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Búsqueda");
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(0, 40, 480, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr2.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Container menu = this.getFocusCycleRootAncestor();
        Menu principal = new Menu();
        menu.remove(this);
        principal.setSize(menu.getSize());
        menu.add(principal, 0);        
    }//GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}