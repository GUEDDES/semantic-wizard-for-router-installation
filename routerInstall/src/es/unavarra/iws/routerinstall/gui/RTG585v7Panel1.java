/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

/**
 *
 * @author aqm
 */
public class RTG585v7Panel1 extends javax.swing.JPanel {

    /**
     * Creates new form TestPanel11
     */
    public RTG585v7Panel1(String primerPaso) {
        initComponents();
        this.jlPrimerPaso.setText(primerPaso);
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconoLabel = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        ContenidoTodo = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        ContenidoTexto = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlPrimerPaso = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        iconoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/orange.png"))); // NOI18N
        iconoLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        add(iconoLabel, java.awt.BorderLayout.WEST);

        Contenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Contenido.setLayout(new java.awt.BorderLayout());

        ContenidoTodo.setLayout(new java.awt.BorderLayout());

        lTitulo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lTitulo.setText("Instalación del TG585v7 wifi");
        ContenidoTodo.add(lTitulo, java.awt.BorderLayout.PAGE_START);

        ContenidoTexto.setLayout(new javax.swing.BoxLayout(ContenidoTexto, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setMaximumSize(new java.awt.Dimension(257, 18));
        jLabel4.setMinimumSize(new java.awt.Dimension(257, 18));
        ContenidoTexto.add(jLabel4);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/TG585v7_1.png"))); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(531, 200));
        jLabel8.setMinimumSize(new java.awt.Dimension(531, 100));
        jLabel8.setPreferredSize(new java.awt.Dimension(531, 18));
        ContenidoTexto.add(jLabel8);

        jLabel9.setMaximumSize(new java.awt.Dimension(257, 18));
        jLabel9.setMinimumSize(new java.awt.Dimension(257, 18));
        ContenidoTexto.add(jLabel9);
        ContenidoTexto.add(jLabel5);

        jLabel1.setText("En los siguientes pasos se describe el proceso de instalación.");
        ContenidoTexto.add(jLabel1);
        ContenidoTexto.add(jLabel2);
        ContenidoTexto.add(jlPrimerPaso);

        jLabel10.setMaximumSize(new java.awt.Dimension(257, 30));
        jLabel10.setMinimumSize(new java.awt.Dimension(257, 18));
        ContenidoTexto.add(jLabel10);

        jLabel7.setText("Presione \"Siguiente\" para continuar...");
        ContenidoTexto.add(jLabel7);

        ContenidoTodo.add(ContenidoTexto, java.awt.BorderLayout.CENTER);

        Contenido.add(ContenidoTodo, java.awt.BorderLayout.CENTER);

        add(Contenido, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel ContenidoTexto;
    private javax.swing.JPanel ContenidoTodo;
    private javax.swing.JLabel iconoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlPrimerPaso;
    private javax.swing.JLabel lTitulo;
    // End of variables declaration//GEN-END:variables
}
