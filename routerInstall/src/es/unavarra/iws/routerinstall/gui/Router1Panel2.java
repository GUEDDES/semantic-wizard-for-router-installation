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
public class Router1Panel2 extends javax.swing.JPanel {

    /**
     * Creates new form Router1Panel2
     */
    public Router1Panel2() {
        initComponents();
    }

    public boolean isCheckBoxSelected() {
        return jCheckBox1.isSelected();
    }    
    
    public void addCheckBoxActionListener(ActionListener l) {
        jCheckBox1.addActionListener(l);
    }    
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
        jLabel3 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jpTitulo.setForeground(java.awt.Color.gray);
        jpTitulo.setLayout(new java.awt.BorderLayout());

        jlTexto.setBackground(java.awt.Color.lightGray);
        jlTexto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlTexto.setText("Tipo de conector");
        jlTexto.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jlTexto.setOpaque(true);
        jpTitulo.add(jlTexto, java.awt.BorderLayout.CENTER);

        jSeparator1.setBackground(java.awt.Color.lightGray);
        jSeparator1.setOpaque(true);
        jpTitulo.add(jSeparator1, java.awt.BorderLayout.SOUTH);

        jlIcono.setBackground(java.awt.Color.lightGray);
        jlIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/setting32.png"))); // NOI18N
        jlIcono.setOpaque(true);
        jpTitulo.add(jlIcono, java.awt.BorderLayout.EAST);

        add(jpTitulo, java.awt.BorderLayout.NORTH);

        jpContenido.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Por favor ingrese el tipo de conector");
        jpContenido.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(jLabel3);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");
        jPanel1.add(jRadioButton3);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");
        jPanel1.add(jRadioButton4);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");
        jPanel1.add(jRadioButton2);

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");
        jPanel1.add(jRadioButton1);
        jPanel1.add(jLabel2);

        jCheckBox1.setText("Paso completado con exito");
        jPanel1.add(jCheckBox1);
        jPanel1.add(jLabel4);

        jpContenido.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jpContenido, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlIcono;
    private javax.swing.JLabel jlTexto;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpTitulo;
    // End of variables declaration//GEN-END:variables
}
