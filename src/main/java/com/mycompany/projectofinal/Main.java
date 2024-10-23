/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectofinal;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.projectofinal.dataacces.DataAccess;
import com.mycompany.projectofinal.dto.Intent;
import com.mycompany.projectofinal.dto.Usuari;
import java.io.File;

import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;


/**
 *
 * @author Alumne
 */
public class Main extends javax.swing.JFrame {
    private DataAccess da = new DataAccess();
    private boolean logeado=false;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        initlista();
        getContentPane().setBackground(Color.decode("#10191B"));
    }
    
    
    public void initlista(){
        ArrayList<Usuari> usuaris = da.getAllUsers();
        DefaultListModel dlm = new DefaultListModel();
        for (Usuari user: usuaris){
            dlm.addElement(user.getNom());
        }
        jListClientes.setModel(dlm);
        actualizarListas();
    }
    
    public void actualizarListas(){
        jPanelListas.setVisible(logeado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelContra = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jPanelListas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListClientes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIntentos = new javax.swing.JTable();
        jLabelIntentos = new javax.swing.JLabel();
        jLabelClientes = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Login"));

        jLabelEmail.setText("Email");

        jLabelContra.setText("Contraseña");

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jButtonLogin.setText("Iniciar");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jPasswordField.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelContra, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogin)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContra)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.white);
        setResizable(false);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelListas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jListClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListClientesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListClientes);

        jTableIntentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableIntentos);

        jLabelIntentos.setText("Intentos");
        jLabelIntentos.setAlignmentX(0.5F);

        jLabelClientes.setText("Clientes");

        javax.swing.GroupLayout jPanelListasLayout = new javax.swing.GroupLayout(jPanelListas);
        jPanelListas.setLayout(jPanelListasLayout);
        jPanelListasLayout.setHorizontalGroup(
            jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelListasLayout.setVerticalGroup(
            jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListasLayout.createSequentialGroup()
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClientes)
                    .addComponent(jLabelIntentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        String imagePath = "src/main/java/com/mycompany/projectofinal/logo2.png";

        // Verificar que el archivo exista
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            jLabelIcon.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
            System.out.println("Imagen cargada correctamente desde " + imagePath);
        } else {/*Comento el codigo que genera  netbeans ya que siempre da una excepcion
            jLabelIcon.setForeground(new java.awt.Color(255, 255, 255));
            jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/projectofinal/logo2.jpg"))); // NOI18N
            jLabelIcon.setText("logo");
            */        
            jLabelIcon.setForeground(new java.awt.Color(255, 255, 255));
            jLabelIcon.setText("logo");
        }

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelListas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelListas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListClientesValueChanged
         // Verifica que el evento no sea un ajuste final de la selección
        if (!evt.getValueIsAdjusting()) {
            // Obtener el valor seleccionado de jList1
            String selectedUser = (String) jListClientes.getSelectedValue();

            // Verificar que se haya seleccionado un elemento
            if (selectedUser != null) {
                // Llamar al método que obtiene los intentos pendientes del usuario seleccionado
                ArrayList<Intent> attempts = da.getAttemptsPendingReview(selectedUser);

                // Crear un modelo para la JTable
                DefaultTableModel model = new DefaultTableModel();

                // Agregar columnas al modelo
                model.setColumnIdentifiers(new Object[] {"Id", "IdUsuario", "IdEjercicio", "Timestamp Inicio", "Timestamp Fin", "Video File"});


                // Llenar el modelo con los datos de los intentos
                for (Intent attempt : attempts) {
                    model.addRow(attempt.toArrayString());
                }

                // Asignar el modelo a la JTable
                jTableIntentos.setModel(model);
            }
        }   
    }//GEN-LAST:event_jListClientesValueChanged

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        Usuari user= da.getUser(jTextFieldEmail.getText());
        if (user != null){
            char[] passToVery=jPasswordField.getPassword();
            String passString=user.getPasswordHash();
            var result = BCrypt.verifyer().verify(passToVery, passString);
            if(result.verified){
                if(user.isInstructor()){
                    logeado=true;
                    actualizarListas();
                    JOptionPane.showMessageDialog(this, "Logeado instructor: "+ user.getNom());
                    jDialog1.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Logeado usuario: "+ user.getNom()+" De momento sin implementar");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Correo incorrecto");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog1.pack();
        jDialog1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelContra;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelIntentos;
    private javax.swing.JList<String> jListClientes;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelListas;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableIntentos;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
