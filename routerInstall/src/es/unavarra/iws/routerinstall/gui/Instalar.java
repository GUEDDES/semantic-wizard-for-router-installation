/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.engine.QueryManager;
import es.unavarra.iws.routerinstall.engine.utils.StringUtils;
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
        jbTG585v7 = new javax.swing.JButton();
        jbX7028r = new javax.swing.JButton();
        jbCT5071 = new javax.swing.JButton();
        jbCT351 = new javax.swing.JButton();
        jbSagemFast2604 = new javax.swing.JButton();
        jbHG556 = new javax.swing.JButton();
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

        jtBusqueda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyPressed(evt);
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
        jlError.setBounds(20, 160, 330, 18);
        add(jSeparator1);
        jSeparator1.setBounds(-20, 198, 500, 6);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/search32.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBuscarMouseClicked(evt);
            }
        });
        add(jbBuscar);
        jbBuscar.setBounds(360, 100, 110, 40);

        jbTG585v7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_tg585v7_60.png"))); // NOI18N
        jbTG585v7.setText("      TG585v7");
        jbTG585v7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbTG585v7MouseClicked(evt);
            }
        });
        add(jbTG585v7);
        jbTG585v7.setBounds(250, 360, 200, 80);

        jbX7028r.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_x70028r_60.png"))); // NOI18N
        jbX7028r.setText("      x7028r");
        jbX7028r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbX7028rMouseClicked(evt);
            }
        });
        jbX7028r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbX7028rActionPerformed(evt);
            }
        });
        add(jbX7028r);
        jbX7028r.setBounds(20, 360, 200, 80);

        jbCT5071.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_ct5071_60.png"))); // NOI18N
        jbCT5071.setText("      CT-5071");
        jbCT5071.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCT5071MouseClicked(evt);
            }
        });
        add(jbCT5071);
        jbCT5071.setBounds(250, 240, 200, 80);

        jbCT351.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_ct-351_60.png"))); // NOI18N
        jbCT351.setText("      CT-351");
        jbCT351.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCT351MouseClicked(evt);
            }
        });
        add(jbCT351);
        jbCT351.setBounds(20, 240, 200, 80);

        jbSagemFast2604.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_sagemFast2604_30.png"))); // NOI18N
        jbSagemFast2604.setText("  SagemFast_2604");
        jbSagemFast2604.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSagemFast2604MouseClicked(evt);
            }
        });
        jbSagemFast2604.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSagemFast2604ActionPerformed(evt);
            }
        });
        add(jbSagemFast2604);
        jbSagemFast2604.setBounds(20, 480, 200, 80);

        jbHG556.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/r_hg556_60.png"))); // NOI18N
        jbHG556.setText("      HG556");
        jbHG556.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbHG556MouseClicked(evt);
            }
        });
        add(jbHG556);
        jbHG556.setBounds(250, 480, 200, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr32.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(10, 30, 30, 30);

        jLabel2.setBackground(new java.awt.Color(0, 102, 153));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
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

    private void jbX7028rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbX7028rActionPerformed
        
    }//GEN-LAST:event_jbX7028rActionPerformed

    private void jbCT351MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCT351MouseClicked
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
        
        WizardPanelDescriptor descriptor9 = new Rct351Panel9Descriptor(qm);
        wizard.registerWizardPanel(Rct351Panel9Descriptor.IDENTIFIER, descriptor9);
        
        wizard.setCurrentPanel(Rct351Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog(); //Que boton se pulso: 0=Finish,1=Cancel,2=Error
        /*
        System.out.println("Dialog return code is (0=Finish,1=Cancel,2=Error): " + ret);
        System.out.println("Second panel selection is: " + 
            (((Router1Panel2)descriptor2.getPanelComponent()).getRadioButtonSelected()));    */    
        
    }//GEN-LAST:event_jbCT351MouseClicked

    private void jbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBuscarMouseClicked
        busquedaRouter(this.jtBusqueda.getText());
    }//GEN-LAST:event_jbBuscarMouseClicked

    private void jtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyTyped
        if(jlError.isVisible())
            jlError.setVisible(false);

    }//GEN-LAST:event_jtBusquedaKeyTyped

    private void jbSagemFast2604ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSagemFast2604ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSagemFast2604ActionPerformed

private void jbX7028rMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbX7028rMouseClicked
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
}//GEN-LAST:event_jbX7028rMouseClicked

private void jbCT5071MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCT5071MouseClicked
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
        
        WizardPanelDescriptor descriptor7 = new Router1Panel7Descriptor(qm);
        wizard.registerWizardPanel(Router1Panel7Descriptor.IDENTIFIER, descriptor7);

        wizard.setCurrentPanel(Router1Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
}//GEN-LAST:event_jbCT5071MouseClicked

private void jbHG556MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbHG556MouseClicked
// TODO add your handling code here:
        String routerActual = "HG556";
        String primerPaso;
        
        primerPaso = qm.initInstallationByModelName(routerActual);
        
        Wizard wizard = new Wizard();
        wizard.getDialog().setTitle("Instalación router " + routerActual);
        
        WizardPanelDescriptor descriptor1 = new RHG556Panel1Descriptor(primerPaso!=null ? primerPaso:"");
        wizard.registerWizardPanel(RHG556Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new RHG556Panel2Descriptor();
        wizard.registerWizardPanel(RHG556Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new RHG556Panel3Descriptor();
        wizard.registerWizardPanel(RHG556Panel3Descriptor.IDENTIFIER, descriptor3);
        
        WizardPanelDescriptor descriptor4 = new RHG556Panel4Descriptor();
        wizard.registerWizardPanel(RHG556Panel4Descriptor.IDENTIFIER, descriptor4);
        
        WizardPanelDescriptor descriptor5 = new RHG556Panel5Descriptor();
        wizard.registerWizardPanel(RHG556Panel5Descriptor.IDENTIFIER, descriptor5);
        
        WizardPanelDescriptor descriptor6 = new RHG556Panel6Descriptor();
        wizard.registerWizardPanel(RHG556Panel6Descriptor.IDENTIFIER, descriptor6);
        
        wizard.setCurrentPanel(RHG556Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
}//GEN-LAST:event_jbHG556MouseClicked

private void jbTG585v7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbTG585v7MouseClicked
// TODO add your handling code here:
            String routerActual = "TG585v7";
        String primerPaso;
        
        primerPaso = qm.initInstallationByModelName(routerActual);
        
        Wizard wizard = new Wizard();
        
        wizard.getDialog().setTitle("Instalación router " + routerActual);
        
        WizardPanelDescriptor descriptor1 = new RTG585v7Panel1Descriptor(primerPaso!=null ? primerPaso:"");
        wizard.registerWizardPanel(RTG585v7Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new RTG585v7Panel2Descriptor();
        wizard.registerWizardPanel(RTG585v7Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new RTG585v7Panel3Descriptor();
        wizard.registerWizardPanel(RTG585v7Panel3Descriptor.IDENTIFIER, descriptor3);
        
        WizardPanelDescriptor descriptor4 = new RTG585v7Panel4Descriptor();
        wizard.registerWizardPanel(RTG585v7Panel4Descriptor.IDENTIFIER, descriptor4);
        
        WizardPanelDescriptor descriptor5 = new RTG585v7Panel5Descriptor();
        wizard.registerWizardPanel(RTG585v7Panel5Descriptor.IDENTIFIER, descriptor5);
        
        WizardPanelDescriptor descriptor6 = new RTG585v7Panel7Descriptor();
        wizard.registerWizardPanel(RTG585v7Panel7Descriptor.IDENTIFIER, descriptor6);
        
        WizardPanelDescriptor descriptor7 = new RTG585v7Panel8Descriptor();
        wizard.registerWizardPanel(RTG585v7Panel8Descriptor.IDENTIFIER, descriptor7);

        wizard.setCurrentPanel(RTG585v7Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
        
}//GEN-LAST:event_jbTG585v7MouseClicked

private void jbSagemFast2604MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSagemFast2604MouseClicked
// TODO add your handling code here:
        String routerActual = "SagemFast_2604";
        String primerPaso;
        
        primerPaso = qm.initInstallationByModelName(routerActual);
        
        Wizard wizard = new Wizard();
        wizard.getDialog().setTitle("Instalación router " + routerActual);
        
        WizardPanelDescriptor descriptor1 = new RSagemFast_2604Panel1Descriptor(primerPaso!=null ? primerPaso:"");
        wizard.registerWizardPanel(RSagemFast_2604Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new RSagemFast_2604Panel2Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new RSagemFast_2604Panel3Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel3Descriptor.IDENTIFIER, descriptor3);
        
        WizardPanelDescriptor descriptor4 = new RSagemFast_2604Panel4Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel4Descriptor.IDENTIFIER, descriptor4);
        
        WizardPanelDescriptor descriptor5 = new RSagemFast_2604Panel5Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel5Descriptor.IDENTIFIER, descriptor5);
        
        WizardPanelDescriptor descriptor6 = new RSagemFast_2604Panel6Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel6Descriptor.IDENTIFIER, descriptor6);
        
        WizardPanelDescriptor descriptor7 = new RSagemFast_2604Panel7Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel7Descriptor.IDENTIFIER, descriptor7);
        
        WizardPanelDescriptor descriptor8 = new RSagemFast_2604Panel8Descriptor();
        wizard.registerWizardPanel(RSagemFast_2604Panel8Descriptor.IDENTIFIER, descriptor8);
        
        wizard.setCurrentPanel(RSagemFast_2604Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
}//GEN-LAST:event_jbSagemFast2604MouseClicked

    private void jtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            busquedaRouter(this.jtBusqueda.getText());
        }
    }//GEN-LAST:event_jtBusquedaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCT351;
    private javax.swing.JButton jbCT5071;
    private javax.swing.JButton jbHG556;
    private javax.swing.JButton jbInicio;
    private javax.swing.JButton jbSagemFast2604;
    private javax.swing.JButton jbTG585v7;
    private javax.swing.JButton jbX7028r;
    private javax.swing.JLabel jlBacground;
    private javax.swing.JLabel jlError;
    private javax.swing.JTextField jtBusqueda;
    // End of variables declaration//GEN-END:variables

    private void busquedaRouter(String txtBusqueda) {
        String txtResultado;
        jlError.setVisible(false);
        //txtBusqueda = StringUtils.prepareSearchString(txtBusqueda);
        if(txtBusqueda!=null && txtBusqueda.length()>0){
            txtResultado = qm.initInstallationByCharacteristics(txtBusqueda);
            if(txtResultado!=null && txtResultado.length()>0){
                habilitaBotones(false);
                habilitaPorId(txtResultado);
            }
            else{
                //habilitaBotones(true);
                jlError.setVisible(true);
            }
                
        }
    }
    
    private void habilitaBotones(Boolean e){
        jbCT351.setEnabled(e);
        jbCT5071.setEnabled(e);
        jbHG556.setEnabled(e);
        jbSagemFast2604.setEnabled(e);
        jbTG585v7.setEnabled(e);
        jbX7028r.setEnabled(e);
    }
    
    private void habilitaPorId(String id){
        id = id.toLowerCase();
        if(id.equals("tiporouterinalambrico")){
            jbTG585v7.setEnabled(true);
            jbHG556.setEnabled(true);
        }else if(id.equals("tiporouterusb") ){
            jbCT351.setEnabled(true);
           
        }else if(id.equals("movistar") ){
            jbCT351.setEnabled(true);
           jbCT5071.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(this, id,"Resultados",JOptionPane.INFORMATION_MESSAGE);
            habilitaBotones(true);
        }
    }
}


