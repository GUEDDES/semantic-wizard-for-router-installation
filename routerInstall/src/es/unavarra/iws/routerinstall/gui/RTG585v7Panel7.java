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
public class RTG585v7Panel7 extends javax.swing.JPanel {

    /**
     * Creates new form Router1Panel2
     */
    public RTG585v7Panel7() {
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jpTitulo.setForeground(java.awt.Color.gray);
        jpTitulo.setLayout(new java.awt.BorderLayout());

        jlTexto.setBackground(java.awt.Color.lightGray);
        jlTexto.setFont(new java.awt.Font("Verdana", 1, 14));
        jlTexto.setText("Posibles errores presentados");
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

        jPanel1.setPreferredSize(new java.awt.Dimension(480, 192));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setText("• Error: Al marcar un número en el terminal telefónico, aparecen problemas ");
        jPanel1.add(jLabel1);

        jLabel9.setText("   en las comunicaciones ADSL.");
        jPanel1.add(jLabel9);

        jLabel3.setText("• Solución: Si el terminal utilizado es un terminal de marcación decádica (Pulsos), ");
        jPanel1.add(jLabel3);

        jLabel5.setText("   sustituya el terminal por otro de marcación Multi-Frecuencia (Tonos).");
        jPanel1.add(jLabel5);

        jLabel6.setText("• Error: Al instalar el primer microfiltro observa que en el terminal hay un aumento notable ");
        jPanel1.add(jLabel6);

        jLabel7.setText("   del ruido en el microteléfono.");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7);

        jLabel8.setText("• Solución: Si el número de microfiltros instalados es igual o superior a 3, por las características ");
        jPanel1.add(jLabel8);

        jLabel2.setText("   propias de la instalación privada del cliente puede suceder que no se puedan instalar ");
        jPanel1.add(jLabel2);

        jLabel4.setText("   más de 2 microfiltros.");
        jPanel1.add(jLabel4);

        jpContenido.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jpContenido, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlIcono;
    private javax.swing.JLabel jlTexto;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpTitulo;
    // End of variables declaration//GEN-END:variables
}
