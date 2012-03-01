/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

/**
 *
 * @author aqm
 */
public class Cpuertousb extends javax.swing.JPanel {

    /**
     * Creates new form Cmicrofiltro
     */
    public Cpuertousb(String sC, String sS) {
        initComponents();
        jtaComment.setText(sC!=null?sC:"");
        jtaSeeAlso.setText(sS!=null?sS:"");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jspComment = new javax.swing.JScrollPane();
        jtaComment = new javax.swing.JTextArea();
        jspSeeAlso = new javax.swing.JScrollPane();
        jtaSeeAlso = new javax.swing.JTextArea();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Puerto USB");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/puertousb.png"))); // NOI18N

        jtaComment.setColumns(20);
        jtaComment.setLineWrap(true);
        jtaComment.setRows(5);
        jtaComment.setWrapStyleWord(true);
        jspComment.setViewportView(jtaComment);

        jtaSeeAlso.setColumns(20);
        jtaSeeAlso.setLineWrap(true);
        jtaSeeAlso.setRows(5);
        jtaSeeAlso.setWrapStyleWord(true);
        jspSeeAlso.setViewportView(jtaSeeAlso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jspSeeAlso, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jspComment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addGap(32, 32, 32)
                .addComponent(jspComment, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jspSeeAlso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jspComment;
    private javax.swing.JScrollPane jspSeeAlso;
    private javax.swing.JTextArea jtaComment;
    private javax.swing.JTextArea jtaSeeAlso;
    // End of variables declaration//GEN-END:variables
}
