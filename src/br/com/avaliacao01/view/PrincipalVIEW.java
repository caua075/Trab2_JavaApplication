package br.com.avaliacao01.view;

import br.com.avaliacao01.dto.FuncionarioDTO;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PrincipalVIEW extends javax.swing.JFrame {

    public PrincipalVIEW(FuncionarioDTO funcionarioDTO) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        if(funcionarioDTO.getTipo_fun().equalsIgnoreCase("COMUM")){
            itemMenuFuncionario.setVisible(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon imageicon = new ImageIcon(getClass().getResource("imagens/andrade.png")); Image image = imageicon.getImage();
        desktopPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics graphics){
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        menuBar = new javax.swing.JMenuBar();
        itemMenuCliente = new javax.swing.JMenu();
        itemCarro = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        itemMenuLoc = new javax.swing.JMenuItem();
        itemMenuFuncionario = new javax.swing.JMenuItem();
        menuAluguel = new javax.swing.JMenu();
        itemMenuAlguel = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        itemMenuCliente.setMnemonic('f');
        itemMenuCliente.setText("Cadastro");

        itemCarro.setMnemonic('o');
        itemCarro.setText("Carro");
        itemCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCarroActionPerformed(evt);
            }
        });
        itemMenuCliente.add(itemCarro);

        jMenuItem2.setText("Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        itemMenuCliente.add(jMenuItem2);

        itemMenuLoc.setText("Locadora");
        itemMenuLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuLocActionPerformed(evt);
            }
        });
        itemMenuCliente.add(itemMenuLoc);

        itemMenuFuncionario.setText("Funcionário");
        itemMenuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFuncionarioActionPerformed(evt);
            }
        });
        itemMenuCliente.add(itemMenuFuncionario);

        menuBar.add(itemMenuCliente);

        menuAluguel.setText("Aluguel");

        itemMenuAlguel.setText("Realizar Aluguel");
        itemMenuAlguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAlguelActionPerformed(evt);
            }
        });
        menuAluguel.add(itemMenuAlguel);

        menuBar.add(menuAluguel);

        menuSair.setMnemonic('e');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCarroActionPerformed
        abrirCarro();
    }//GEN-LAST:event_itemCarroActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMenuLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuLocActionPerformed
        abrirLocadora();
    }//GEN-LAST:event_itemMenuLocActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        abrirCliente();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemMenuAlguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAlguelActionPerformed
        abrirAluguel();
    }//GEN-LAST:event_itemMenuAlguelActionPerformed

    private void itemMenuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFuncionarioActionPerformed
        abrirFuncionario();
    }//GEN-LAST:event_itemMenuFuncionarioActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PrincipalVIEW().setVisible(true);
//            }
//        });
//    }
    
    void sair(){
        Object[] options = {"Sair", "Cancelar"};
        if (JOptionPane.showOptionDialog(null, "Desejar sair do Sistema?", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])!= 0) {
        } else {
            System.exit(0);
        }
    }
    
    void abrirLocadora(){
        LocadoraVIEW locadoraVIEW = new LocadoraVIEW();
        this.desktopPane.add(locadoraVIEW);
        locadoraVIEW.setVisible(true);
        locadoraVIEW.setPosicao();
    }
    
    void abrirCarro(){
        CarroVIEW carroVIEW = new CarroVIEW();
        this.desktopPane.add(carroVIEW);
        carroVIEW.setVisible(true);
        carroVIEW.setPosicao();
    }
    
    void abrirCliente(){
        ClienteVIEW clienteVIEW = new ClienteVIEW();
        this.desktopPane.add(clienteVIEW);
        clienteVIEW.setVisible(true);
        clienteVIEW.setPosicao();
    }
    
    void abrirAluguel(){
        AluguelVIEW aluguelVIEW = new AluguelVIEW();
        this.desktopPane.add(aluguelVIEW);
        aluguelVIEW.setVisible(true);
        aluguelVIEW.setPosicao();
    }
    
    void abrirFuncionario(){
        FuncionarioVIEW funcionarioVIEW = new FuncionarioVIEW();
        this.desktopPane.add(funcionarioVIEW);
        funcionarioVIEW.setVisible(true);
        funcionarioVIEW.setPosicao();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemCarro;
    private javax.swing.JMenuItem itemMenuAlguel;
    private javax.swing.JMenu itemMenuCliente;
    private javax.swing.JMenuItem itemMenuFuncionario;
    private javax.swing.JMenuItem itemMenuLoc;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuAluguel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
