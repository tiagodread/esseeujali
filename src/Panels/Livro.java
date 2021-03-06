package Panels;

import javax.swing.ImageIcon;
import Model.LivroModel;
import View.SingleLivro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tiago
 */
public class Livro extends javax.swing.JPanel {

    private final LivroModel lModel;
    private final int idUser;

    /**
     * Creates new form Painel
     *
     * @param id
     * @param nome
     * @param sinopse
     * @param imagem
     * @param paginas
     * @param autor
     * @param genero
     * @param lido
     * @param idUser
     */
    public Livro(int id, String nome, String sinopse, String imagem, int paginas, String autor, String genero, boolean lido, int idUser) {
        initComponents();
        this.idUser = idUser;
        ImageIcon ii = new ImageIcon(getClass().getResource(imagem));
        ii.getImage().flush();

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/icones/okicon.png"));
        icon.getImage().flush();

        img.setIcon(ii);
        tituloLivro.setText(nome);
        generoLivro.setText(genero);
        if (lido) {
            btVisualizar.setIcon(icon);
            btVisualizar.setText("Já foi Lido");
        } else {
            btVisualizar.setText("Visualizar");
        }
        lModel = new LivroModel(id, nome, sinopse, imagem, paginas, autor, genero, lido);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new javax.swing.JLabel();
        tituloLivro = new javax.swing.JLabel();
        generoLivro = new javax.swing.JLabel();
        btVisualizar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        img.setBackground(new java.awt.Color(153, 255, 255));
        img.setForeground(new java.awt.Color(102, 255, 51));
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/conquistas/quadrinho_icon.png"))); // NOI18N

        tituloLivro.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tituloLivro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLivro.setText("Leitor de Quadrinhos");

        generoLivro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloLivro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btVisualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generoLivro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        SingleLivro sl = new SingleLivro(lModel, idUser);
        sl.setVisible(true);

    }//GEN-LAST:event_btVisualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVisualizar;
    private javax.swing.JLabel generoLivro;
    private javax.swing.JLabel img;
    private javax.swing.JLabel tituloLivro;
    // End of variables declaration//GEN-END:variables
}
