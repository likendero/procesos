/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontexto;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author likendero
 */
public class ListaTexto extends javax.swing.JPanel {

    /**
     * Creates new form ListaTexto
     */
    public ListaTexto() {
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

        cbComida = new javax.swing.JComboBox<>();
        lbDescripcion = new javax.swing.JLabel();

        cbComida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hamburguesa", "pizza", "tapas" }));
        cbComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComidaActionPerformed(evt);
            }
        });

        lbDescripcion.setText("una jugosa hamburguesa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbComida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescripcion)
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cbComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDescripcion)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComidaActionPerformed
        switch(cbComida.getSelectedIndex()){
            case 0:
                lbDescripcion.setText("una jugosa Hamburguesa");
                break;
            case 1:
                lbDescripcion.setText("La delicia Italiana");
                break;
            case 2:
                lbDescripcion.setText("degustacion a la española <3");
                break;
        }
    }//GEN-LAST:event_cbComidaActionPerformed
    ©∑
    public JComboBox<String> getCbComida() {
        return cbComida;
    }

    public void setCbComida(JComboBox<String> cbComida) {
        this.cbComida = cbComida;
    }

    public JLabel getLbDescripcion() {
        return lbDescripcion;
    }

    public void setLbDescripcion(JLabel lbDescripcion) {
        this.lbDescripcion = lbDescripcion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbComida;
    private javax.swing.JLabel lbDescripcion;
    // End of variables declaration//GEN-END:variables
}
