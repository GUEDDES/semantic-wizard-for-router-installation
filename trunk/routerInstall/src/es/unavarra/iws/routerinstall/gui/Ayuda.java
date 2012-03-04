/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.engine.InstallationError;
import es.unavarra.iws.routerinstall.engine.QueryManager;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aqm
 */
public class Ayuda extends javax.swing.JPanel {
    
    QueryManager qm = null;
    
    /**
     * Creates new form Menu
     */
    public Ayuda(QueryManager qm) {
        this.qm = qm;
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

        jlIcono = new javax.swing.JLabel();
        jbHome = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jlBarra = new javax.swing.JLabel();
        jtpAyuda = new javax.swing.JTabbedPane();
        jpPF = new javax.swing.JPanel();
        jpIN = new javax.swing.JPanel();
        jbActualizar = new javax.swing.JButton();
        jlBackground = new javax.swing.JLabel();

        setLayout(null);

        jlIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/help32.png"))); // NOI18N
        add(jlIcono);
        jlIcono.setBounds(35, 30, 30, 30);

        jbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/home32.png"))); // NOI18N
        jbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbHomeMouseClicked(evt);
            }
        });
        add(jbHome);
        jbHome.setBounds(420, 20, 50, 50);

        jlTitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlTitulo.setText("Ayuda");
        add(jlTitulo);
        jlTitulo.setBounds(100, 20, 160, 50);

        jlBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/w70.png"))); // NOI18N
        add(jlBarra);
        jlBarra.setBounds(0, 20, 840, 50);

        jtpAyuda.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jpPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpPF.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jpPF.setOpaque(false);
        jpPF.setLayout(new java.awt.BorderLayout());
        jtpAyuda.addTab("  Problemas Frecuentes  ", new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/misc_03_16.png")), jpPF); // NOI18N

        jpIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpIN.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jpIN.setOpaque(false);
        jpIN.setLayout(new java.awt.BorderLayout());
        jtpAyuda.addTab("  Routers soportados  ", new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/wlan16.png")), jpIN); // NOI18N

        add(jtpAyuda);
        jtpAyuda.setBounds(30, 100, 420, 450);
        jtpAyuda.getAccessibleContext().setAccessibleName("routerS");

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/note_search32.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbActualizarMouseClicked(evt);
            }
        });
        add(jbActualizar);
        jbActualizar.setBounds(330, 570, 120, 40);

        jlBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/swr2.png"))); // NOI18N
        add(jlBackground);
        jlBackground.setBounds(0, 0, 480, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void jbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbHomeMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Container menu = this.getFocusCycleRootAncestor();
        Menu principal = new Menu(qm);
        menu.remove(this);
        principal.setSize(menu.getSize());
        menu.add(principal, 0);        
    }//GEN-LAST:event_jbHomeMouseClicked

    private void jbActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbActualizarMouseClicked
        int i=0;
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JOutlookBar outlookBar = new JOutlookBar();
        
        int sel = jtpAyuda.getSelectedIndex(); 
        if(sel==1){
            List<String> list = new ArrayList<String>();
            list = qm.getAvailableRouters();
            Iterator iter = list.iterator();
            while (iter.hasNext()){
                String rpt = (String)iter.next();
                String sc = "Guía:\n" + qm.getGuideURL(rpt) 
                        + "\n\nManual:\n" + qm.getManualURL(rpt)
                        + "\n\nVideo:\n" + qm.getVideoURL(rpt);
                i++;
                outlookBar.addBar(rpt, 
                    "/es/unavarra/iws/routerinstall/resources/img/wlan16.png",
                    JOutlookBar.getDummyPanel(sc));                
            }
            jpIN.removeAll();
            if(i>0){
                jScrollPane1.setViewportView(outlookBar);
                //outlookBar.setVisibleBar(0); 
                jpIN.add(jScrollPane1);
                jpIN.revalidate();
                jpIN.repaint();
            }            
        }else if(sel==0){
            List<InstallationError> list = new ArrayList<InstallationError>();
            
            list = qm.getFrequentErrors();
            Iterator iter = list.iterator();
            while (iter.hasNext()){
                i++;
                InstallationError ie = (InstallationError)iter.next();
                outlookBar.addBar(ie.getProblemDescription(), 
                    "/es/unavarra/iws/routerinstall/resources/img/misc_53_16.png",
                    JOutlookBar.getDummyPanel(ie.getProblemSolution()));
            }
            jpPF.removeAll();
            if(i>0){
                jScrollPane1.setViewportView(outlookBar);
                //outlookBar.setVisibleBar(0); 
                jpPF.add(jScrollPane1);
                jpPF.revalidate();
                jpPF.repaint();
            }
        }
            
    }//GEN-LAST:event_jbActualizarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbHome;
    private javax.swing.JLabel jlBackground;
    private javax.swing.JLabel jlBarra;
    private javax.swing.JLabel jlIcono;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpIN;
    private javax.swing.JPanel jpPF;
    private javax.swing.JTabbedPane jtpAyuda;
    // End of variables declaration//GEN-END:variables
}
