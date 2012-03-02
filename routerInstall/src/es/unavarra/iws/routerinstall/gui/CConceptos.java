/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

/**
 *
 * @author aqm
 */
public class CConceptos extends javax.swing.JPanel {

    /**
     * Creates new form CConceptos
     */
    public CConceptos(String titulo, String logo, String comments, String url) {
        initComponents();
        this.jlTitulo.setText(titulo);
        this.jlLogo.setText(logo);
        this.jtaComments.setText(comments);
        this.jtURI.setText(url);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlLogo = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jtURI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaComments = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jbWeb = new javax.swing.JButton();
        jlFondo = new javax.swing.JLabel();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(463, 435));
        setLayout(null);

        jlLogo.setText("logo");
        add(jlLogo);
        jlLogo.setBounds(270, 80, 180, 270);

        jlTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Titulo");
        jlTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jlTitulo);
        jlTitulo.setBounds(10, 20, 440, 23);

        jtURI.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtURI.setOpaque(false);
        add(jtURI);
        jtURI.setBounds(140, 370, 260, 30);

        jScrollPane1.setOpaque(false);

        jtaComments.setColumns(20);
        jtaComments.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jtaComments.setLineWrap(true);
        jtaComments.setRows(5);
        jtaComments.setWrapStyleWord(true);
        jtaComments.setOpaque(false);
        jScrollPane1.setViewportView(jtaComments);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 240, 270);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Más Información:");
        add(jLabel1);
        jLabel1.setBounds(20, 380, 130, 16);

        jbWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/browser25.png"))); // NOI18N
        jbWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbWebMouseClicked(evt);
            }
        });
        add(jbWeb);
        jbWeb.setBounds(400, 370, 50, 30);

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/vista_c.png"))); // NOI18N
        add(jlFondo);
        jlFondo.setBounds(0, 0, 463, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void jbWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbWebMouseClicked
        // TODO add your handling code here:
        try {
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    desktop.browse(new java.net.URI(jtURI.getText()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_jbWebMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbWeb;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtURI;
    private javax.swing.JTextArea jtaComments;
    // End of variables declaration//GEN-END:variables
}