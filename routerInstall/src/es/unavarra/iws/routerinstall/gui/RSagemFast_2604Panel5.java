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
public class RSagemFast_2604Panel5 extends javax.swing.JPanel {

    /**
     * Creates new form Router1Panel2
     */
    public RSagemFast_2604Panel5() {
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
        jlTexto.setText("Conexión del Router");
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
        jPanel1.add(jLabel3);

        jLabel5.setText("6.- Conectar el cable ADSL de la clavija extensora al puerto ADSL del router.");
        jPanel1.add(jLabel5);

        jLabel6.setText("7.- Conectar el cable de alimentación al router y a la toma eléctrica.");
        jPanel1.add(jLabel6);

        jLabel7.setText("8.- \tUna vez conectado el router a la toma de corriente, presionar el botón de encendido,");
        jPanel1.add(jLabel7);

        jLabel8.setText("      verificando que el led de encendido se active.  ");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8);

        jLabel2.setText("Si el led no se enciende ir al paso 6.");
        jPanel1.add(jLabel2);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlIcono;
    private javax.swing.JLabel jlTexto;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpTitulo;
    // End of variables declaration//GEN-END:variables
}
