/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.engine.QueryManager;
import es.unavarra.iws.routerinstall.gui.wiz.Wizard;
import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import java.awt.Container;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author aqm
 */
public class Instalar extends javax.swing.JPanel {
    QueryManager qm = null;
    /**
     * Creates new form Menu
     */
    public Instalar(QueryManager qm) {
        this.qm = qm;
        initComponents();
        jlError.setVisible(false);
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
        jtBusqueda = new javax.swing.JTextField();
        jlError = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbBuscar = new javax.swing.JButton();
        jbRouter4 = new javax.swing.JButton();
        jbRouter3 = new javax.swing.JButton();
        jbRouter2 = new javax.swing.JButton();
        jbRouter1 = new javax.swing.JButton();
        jbRouter5 = new javax.swing.JButton();
        jbRouter6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlBacground = new javax.swing.JLabel();

        setLayout(null);

        jbInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/home32.png"))); // NOI18N
        jbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbInicioMouseClicked(evt);
            }
        });
        add(jbInicio);
        jbInicio.setBounds(420, 20, 50, 50);

        jtBusqueda.setFont(new java.awt.Font("Tahoma", 0, 18));
        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyTyped(evt);
            }
        });
        add(jtBusqueda);
        jtBusqueda.setBounds(20, 100, 330, 40);

        jlError.setForeground(new java.awt.Color(255, 0, 51));
        jlError.setText("No se encuentran resultados...");
        add(jlError);
        jlError.setBounds(20, 160, 200, 14);
        add(jSeparator1);
        jSeparator1.setBounds(-20, 198, 500, 2);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/search32.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBuscarMouseClicked(evt);
            }
        });
        add(jbBuscar);
        jbBuscar.setBounds(360, 100, 110, 40);

        jbRouter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_tg585v7_60.png"))); // NOI18N
        jbRouter4.setText("      TG585v7");
        add(jbRouter4);
        jbRouter4.setBounds(250, 380, 200, 80);

        jbRouter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_x70028r_60.png"))); // NOI18N
        jbRouter3.setText("      x7028r");
        jbRouter3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRouter3MouseClicked(evt);
            }
        });
        jbRouter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRouter3ActionPerformed(evt);
            }
        });
        add(jbRouter3);
        jbRouter3.setBounds(20, 380, 200, 80);

        jbRouter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_ct5071_60.png"))); // NOI18N
        jbRouter2.setText("      CT-5071");
        jbRouter2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRouter2MouseClicked(evt);
            }
        });
        add(jbRouter2);
        jbRouter2.setBounds(250, 260, 200, 80);

        jbRouter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_ct-351_60.png"))); // NOI18N
        jbRouter1.setText("      CT-351");
        jbRouter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRouter1MouseClicked(evt);
            }
        });
        add(jbRouter1);
        jbRouter1.setBounds(20, 260, 200, 80);

        jbRouter5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_sagemFast2604_30.png"))); // NOI18N
        jbRouter5.setText("  SagemFast_2604");
        jbRouter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRouter5ActionPerformed(evt);
            }
        });
        add(jbRouter5);
        jbRouter5.setBounds(20, 500, 200, 80);

        jbRouter6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_hg556_60.png"))); // NOI18N
        jbRouter6.setText("      HG556");
        add(jbRouter6);
        jbRouter6.setBounds(250, 500, 200, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr32.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(10, 30, 30, 30);

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("       Instalación");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.black));
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(0, 20, 480, 50);

        jlBacground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr2.png"))); // NOI18N
        add(jlBacground);
        jlBacground.setBounds(0, 0, 480, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void jbInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbInicioMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Container menu = this.getFocusCycleRootAncestor();
        Menu principal = new Menu(qm);
        menu.remove(this);
        principal.setSize(menu.getSize());
        menu.add(principal, 0);        
    }//GEN-LAST:event_jbInicioMouseClicked

    private void jbRouter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRouter3ActionPerformed
        
    }//GEN-LAST:event_jbRouter3ActionPerformed

    private void jbRouter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRouter1MouseClicked
        String routerActual = "CT-351";
        String primerPaso;
        
        primerPaso = qm.initInstallationByModelName(routerActual);
        
        Wizard wizard = new Wizard();
        wizard.getDialog().setTitle("Instalación router " + routerActual);
        
        WizardPanelDescriptor descriptor1 = new Rct351Panel1Descriptor(primerPaso!=null ? primerPaso:"");
        wizard.registerWizardPanel(Rct351Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new Rct351Panel2Descriptor();
        wizard.registerWizardPanel(Rct351Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new Rct351Panel3Descriptor();
        wizard.registerWizardPanel(Rct351Panel3Descriptor.IDENTIFIER, descriptor3);
        
        WizardPanelDescriptor descriptor4 = new Rct351Panel4Descriptor();
        wizard.registerWizardPanel(Rct351Panel4Descriptor.IDENTIFIER, descriptor4);
        
        WizardPanelDescriptor descriptor5 = new Rct351Panel5Descriptor();
        wizard.registerWizardPanel(Rct351Panel5Descriptor.IDENTIFIER, descriptor5);
        
        WizardPanelDescriptor descriptor6 = new Rct351Panel6Descriptor();
        wizard.registerWizardPanel(Rct351Panel6Descriptor.IDENTIFIER, descriptor6);
        
        WizardPanelDescriptor descriptor7 = new Rct351Panel7Descriptor();
        wizard.registerWizardPanel(Rct351Panel7Descriptor.IDENTIFIER, descriptor7);
        
        WizardPanelDescriptor descriptor8 = new Rct351Panel8Descriptor();
        wizard.registerWizardPanel(Rct351Panel8Descriptor.IDENTIFIER, descriptor8);
        
        WizardPanelDescriptor descriptor9 = new Rct351Panel9Descriptor();
        wizard.registerWizardPanel(Rct351Panel9Descriptor.IDENTIFIER, descriptor9);
        
        wizard.setCurrentPanel(Rct351Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
        /*
        System.out.println("Dialog return code is (0=Finish,1=Cancel,2=Error): " + ret);
        System.out.println("Second panel selection is: " + 
            (((Router1Panel2)descriptor2.getPanelComponent()).getRadioButtonSelected()));    */    
        
    }//GEN-LAST:event_jbRouter1MouseClicked

    private void jbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarMouseClicked
        busquedaRouter(this.jtBusqueda.getText());
    }//GEN-LAST:event_jbBuscarMouseClicked

    private void jtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyTyped
        if(jlError.isVisible())
            jlError.setVisible(false);

    }//GEN-LAST:event_jtBusquedaKeyTyped

    private void jtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyReleased
        /*if(evt.getKeyCode()==KeyEvent.VK_ENTER && evt.getComponent().equals(this)){
            busquedaRouter(this.jtBusqueda.getText());
        }*/
    }//GEN-LAST:event_jtBusquedaKeyReleased

    private void jbRouter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRouter5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRouter5ActionPerformed

private void jbRouter3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRouter3MouseClicked
// TODO add your handling code here:
        String routerActual = "x7028r";
        String primerPaso;
        
        primerPaso = qm.initInstallationByModelName(routerActual);
        
        Wizard wizard = new Wizard();
        wizard.getDialog().setTitle("Instalación router " + routerActual);
        
        WizardPanelDescriptor descriptor1 = new Rx7028rPanel1Descriptor(primerPaso!=null ? primerPaso:"");
        wizard.registerWizardPanel(Rx7028rPanel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new Rx7028rPanel2Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new Rx7028rPanel3Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel3Descriptor.IDENTIFIER, descriptor3);
        
        WizardPanelDescriptor descriptor4 = new Rx7028rPanel4Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel4Descriptor.IDENTIFIER, descriptor4);
        
        WizardPanelDescriptor descriptor5 = new Rx7028rPanel5Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel5Descriptor.IDENTIFIER, descriptor5);
        
        WizardPanelDescriptor descriptor6 = new Rx7028rPanel6Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel6Descriptor.IDENTIFIER, descriptor6);
        
        WizardPanelDescriptor descriptor7 = new Rx7028rPanel7Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel7Descriptor.IDENTIFIER, descriptor7);
        
        WizardPanelDescriptor descriptor8 = new Rx7028rPanel8Descriptor();
        wizard.registerWizardPanel(Rx7028rPanel8Descriptor.IDENTIFIER, descriptor8);
        
        wizard.setCurrentPanel(Rx7028rPanel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
}//GEN-LAST:event_jbRouter3MouseClicked

private void jbRouter2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRouter2MouseClicked
// TODO add your handling code here:
        String routerActual = "CT-5071";
        String primerPaso;
        
        primerPaso = qm.initInstallationByModelName(routerActual);
        
        Wizard wizard = new Wizard();
        
        wizard.getDialog().setTitle("Instalación router " + routerActual);
        
        WizardPanelDescriptor descriptor1 = new Router1Panel1Descriptor(primerPaso!=null ? primerPaso:"");
        wizard.registerWizardPanel(Router1Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new Router1Panel2Descriptor();
        wizard.registerWizardPanel(Router1Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new Router1Panel3Descriptor();
        wizard.registerWizardPanel(Router1Panel3Descriptor.IDENTIFIER, descriptor3);
        
        WizardPanelDescriptor descriptor4 = new Router1Panel4Descriptor();
        wizard.registerWizardPanel(Router1Panel4Descriptor.IDENTIFIER, descriptor4);
        
        WizardPanelDescriptor descriptor5 = new Router1Panel5Descriptor();
        wizard.registerWizardPanel(Router1Panel5Descriptor.IDENTIFIER, descriptor5);
        
        WizardPanelDescriptor descriptor6 = new Router1Panel6Descriptor();
        wizard.registerWizardPanel(Router1Panel6Descriptor.IDENTIFIER, descriptor6);
        
        WizardPanelDescriptor descriptor7 = new Router1Panel7Descriptor();
        wizard.registerWizardPanel(Router1Panel7Descriptor.IDENTIFIER, descriptor7);


        wizard.setCurrentPanel(Router1Panel1Descriptor.IDENTIFIER);
}//GEN-LAST:event_jbRouter2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbInicio;
    private javax.swing.JButton jbRouter1;
    private javax.swing.JButton jbRouter2;
    private javax.swing.JButton jbRouter3;
    private javax.swing.JButton jbRouter4;
    private javax.swing.JButton jbRouter5;
    private javax.swing.JButton jbRouter6;
    private javax.swing.JLabel jlBacground;
    private javax.swing.JLabel jlError;
    private javax.swing.JTextField jtBusqueda;
    // End of variables declaration//GEN-END:variables

    private void busquedaRouter(String txtBusqueda) {
        String txtResultado;
        jlError.setVisible(false);
        if(!txtBusqueda.isEmpty()){
            txtResultado = qm.initInstallationByCharacteristics(txtBusqueda);
            if(txtResultado!=null && txtResultado.length()>0)
                JOptionPane.showMessageDialog(this, txtResultado,"Resultados",JOptionPane.INFORMATION_MESSAGE);
            else
                jlError.setVisible(true);
                
        }
    }
}


