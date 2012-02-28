/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.Wizard;
import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import java.awt.Container;

/**
 *
 * @author aqm
 */
public class Instalar extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Instalar() {
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

        jbInicio = new javax.swing.JButton();
        jbRouter4 = new javax.swing.JButton();
        jbRouter3 = new javax.swing.JButton();
        jbRouter2 = new javax.swing.JButton();
        jbRouter1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jbInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/home32.png"))); // NOI18N
        jbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbInicioMouseClicked(evt);
            }
        });
        add(jbInicio);
        jbInicio.setBounds(420, 20, 50, 50);

        jbRouter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/comtrend5365_60.png"))); // NOI18N
        jbRouter4.setText("      Router 4");
        add(jbRouter4);
        jbRouter4.setBounds(140, 470, 200, 80);

        jbRouter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/comtrend5365_60.png"))); // NOI18N
        jbRouter3.setText("      Router 3");
        jbRouter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRouter3ActionPerformed(evt);
            }
        });
        add(jbRouter3);
        jbRouter3.setBounds(140, 360, 200, 80);

        jbRouter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/comtrend5365_60.png"))); // NOI18N
        jbRouter2.setText("      Router 2");
        add(jbRouter2);
        jbRouter2.setBounds(140, 240, 200, 80);

        jbRouter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/comtrend5365_60.png"))); // NOI18N
        jbRouter1.setText("      Router 1");
        jbRouter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRouter1MouseClicked(evt);
            }
        });
        add(jbRouter1);
        jbRouter1.setBounds(140, 130, 200, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr32.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(10, 30, 30, 30);

        jLabel2.setBackground(new java.awt.Color(215, 227, 246));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("       Instalación");
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(0, 20, 480, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr2.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void jbInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbInicioMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Container menu = this.getFocusCycleRootAncestor();
        Menu principal = new Menu();
        menu.remove(this);
        principal.setSize(menu.getSize());
        menu.add(principal, 0);        
    }//GEN-LAST:event_jbInicioMouseClicked

    private void jbRouter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRouter3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRouter3ActionPerformed

    private void jbRouter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRouter1MouseClicked
        // TODO add your handling code here:
        
        Wizard wizard = new Wizard();
        wizard.getDialog().setTitle("Instalación router 1");
        
        WizardPanelDescriptor descriptor1 = new Router1Panel1Descriptor();
        wizard.registerWizardPanel(Router1Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new Router1Panel2Descriptor();
        wizard.registerWizardPanel(Router1Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new Router1Panel3Descriptor();
        wizard.registerWizardPanel(Router1Panel3Descriptor.IDENTIFIER, descriptor3);
        
        wizard.setCurrentPanel(Router1Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
        /*
        System.out.println("Dialog return code is (0=Finish,1=Cancel,2=Error): " + ret);
        System.out.println("Second panel selection is: " + 
            (((Router1Panel2)descriptor2.getPanelComponent()).getRadioButtonSelected()));    */    
        
    }//GEN-LAST:event_jbRouter1MouseClicked

    /*    */
    
    public String convertStreamToString(java.io.InputStream is) {
    try {
        return new java.util.Scanner(is).useDelimiter("\\A").next();
    } catch (java.util.NoSuchElementException e) {
        return "";
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbInicio;
    private javax.swing.JButton jbRouter1;
    private javax.swing.JButton jbRouter2;
    private javax.swing.JButton jbRouter3;
    private javax.swing.JButton jbRouter4;
    // End of variables declaration//GEN-END:variables
}


