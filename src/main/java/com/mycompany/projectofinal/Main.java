/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectofinal;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.projectofinal.TablasAbstractas.TablasIntentos;
import com.mycompany.projectofinal.dataacces.DataAccess;
import com.mycompany.projectofinal.dto.Intent;
import com.mycompany.projectofinal.dto.Review;
import com.mycompany.projectofinal.dto.Usuari;
import java.awt.BorderLayout;
import java.io.File;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.table.TableRowSorter;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * Clase principal del projecto
 * @author Felip
 */
public class Main extends javax.swing.JFrame {
    private final DataAccess da = new DataAccess();
    private boolean logeado=false;
    private int IdUsuario;//Guardara el id del usuario logeado
    private int IdIntento;//Guardara el id del intento seleccionado
    private String usuarioSeleccionado;//Guardara el nombre del usuario seleccionado
    
    private TableRowSorter<TablasIntentos> sorter;
    private EmbeddedMediaPlayerComponent mp;
    private TablasIntentos model;
    private boolean isPlaying;

    /**
     * 
     * Inicia todos los componentes de la ventana
     */
    public Main() {
        initComponents();
        initlista();
        initVideoPlayer();
        
        jLabelWeb.setCursor(new Cursor(Cursor.HAND_CURSOR));//Cambia el cursor a la mano cuando esta encima del enlace
        
        //Estos botones seran visibles dependiendo de si el intento tiene review o no.
        jButtonModificar.setVisible(false);
        jButtonEscribir.setVisible(false);
    }


    /**
     * Inicia el componente lista con los nombres de los usuarios.
     */
    public void initlista(){
        ArrayList<Usuari> usuaris = da.getUsuarios();
        DefaultListModel dlm = new DefaultListModel();
        for (Usuari user: usuaris){
            dlm.addElement(user.getNom());
        }
        jListClientes.setModel(dlm);
        actualizarPanel();
    }

    /**
     * Inicia el componente jTableIntentos con los intentos sin review de todos los usuarios.
     */
    public void initTabla(){
        // Llamar al método que obtiene los intentos pendientes 
        ArrayList<Intent> attempts = da.getIntentosSinReview();

        // Crear un modelo para la JTable
        model = new TablasIntentos(attempts);
                
        // IMPLEMENTACIÓN SORTER
        sorter = new TableRowSorter<>(model);
        jTableIntentos.setRowSorter(sorter);

        // ORDENACIÓN POR DEFECTO
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // orden deseado
        sorter.setSortKeys(sortKeys);

        // Asignar el modelo a la JTable
        jTableIntentos.setModel(model);
        TablasIntentos.configurarTabla(jTableIntentos);
                
        // Seleccionar automáticamente la primera fila de la JTable
        if (jTableIntentos.getRowCount() > 0) {
            jTableIntentos.changeSelection(0, 0, false, false); // Selecciona la primera fila
            
            playVideo(0, model);
        }
    }

    /**
     * Inicia el componente de video.
     */
    public void initVideoPlayer(){
        mp = new EmbeddedMediaPlayerComponent();
        mp.setSize(jPanelVideo.getWidth(), jPanelVideo.getHeight());
        jPanelVideo.add(mp, BorderLayout.CENTER);
    }

    /**
     * Ejecuta el video del intento seleccionado.
     * 
     * @param row la fila seleccionada
     * @param model el modelo de la tabla de intentos
     */
    public void playVideo(int row, TablasIntentos model){
        Intent intento = model.getIntent(row);
        String path = "src/main/java/videos/" + intento.getVideofile();

        mp.mediaPlayer().media().play(path);
        isPlaying = true;
        jButtonPausa.setText("Pausar");
    }

    /**
     * Muestra u oculta el panel dependiendo del estado de logeo.
     */
    public void actualizarPanel(){
        jPanelListas.setVisible(logeado);
    }

    /**
     * Recarga la tabla con los intentos actualizados del usuario seleccionado.
     */
    private void recargarTabla() {
        // Obtener los intentos actualizados del usuario seleccionado
        ArrayList<Intent> attempts = da.getIntentosDeUsuario(usuarioSeleccionado);

        // Crear un nuevo modelo con los datos actualizados
        model = new TablasIntentos(attempts);

        // IMPLEMENTACIÓN SORTER
        sorter = new TableRowSorter<>(model);
        jTableIntentos.setRowSorter(sorter);

        // ORDENACIÓN POR DEFECTO
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

        // Asignar el modelo actualizado a la JTable
        jTableIntentos.setModel(model);
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogInicio = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelContra = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jDialogEscribir = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabelValoracion = new javax.swing.JLabel();
        jButtonEscribir1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComentario = new javax.swing.JTextArea();
        jLabelValoracion1 = new javax.swing.JLabel();
        jSpinnerValoracion = new javax.swing.JSpinner();
        jLabelID = new javax.swing.JLabel();
        jDialogEditar = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabelValoracion2 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaComentarioEditar = new javax.swing.JTextArea();
        jLabelValoracion3 = new javax.swing.JLabel();
        jSpinnerValoracionEditar = new javax.swing.JSpinner();
        jLabelID1 = new javax.swing.JLabel();
        jDialogEliminar = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabelEliminar = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jDialogAbout = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jPanelListas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListClientes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIntentos = new javax.swing.JTable();
        jLabelIntentos = new javax.swing.JLabel();
        jLabelClientes = new javax.swing.JLabel();
        jPanelVideo = new javax.swing.JPanel();
        jButtonPausa = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEscribir = new javax.swing.JButton();
        jLabelIcon = new javax.swing.JLabel();
        jLabelWeb = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
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

        javax.swing.GroupLayout jDialogInicioLayout = new javax.swing.GroupLayout(jDialogInicio.getContentPane());
        jDialogInicio.getContentPane().setLayout(jDialogInicioLayout);
        jDialogInicioLayout.setHorizontalGroup(
            jDialogInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogInicioLayout.setVerticalGroup(
            jDialogInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jDialogEscribir.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escribir Review"));

        jLabelValoracion.setText("Valoracion");

        jButtonEscribir1.setText("Subir");
        jButtonEscribir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscribir1ActionPerformed(evt);
            }
        });

        jTextAreaComentario.setColumns(20);
        jTextAreaComentario.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComentario);

        jLabelValoracion1.setText("Comentario");

        jSpinnerValoracion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabelID.setText("ID: x (Intento seleccionado)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEscribir1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValoracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValoracion)
                    .addComponent(jSpinnerValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValoracion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEscribir1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogEscribirLayout = new javax.swing.GroupLayout(jDialogEscribir.getContentPane());
        jDialogEscribir.getContentPane().setLayout(jDialogEscribirLayout);
        jDialogEscribirLayout.setHorizontalGroup(
            jDialogEscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEscribirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogEscribirLayout.setVerticalGroup(
            jDialogEscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEscribirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogEditar.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Editar Review"));

        jLabelValoracion2.setText("Valoracion");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jTextAreaComentarioEditar.setColumns(20);
        jTextAreaComentarioEditar.setRows(5);
        jScrollPane4.setViewportView(jTextAreaComentarioEditar);

        jLabelValoracion3.setText("Comentario");

        jSpinnerValoracionEditar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabelID1.setText("ID: x (Intento seleccionado)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEditar)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelValoracion2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValoracion3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerValoracionEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabelID1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelID1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValoracion2)
                    .addComponent(jSpinnerValoracionEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValoracion3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogEditarLayout = new javax.swing.GroupLayout(jDialogEditar.getContentPane());
        jDialogEditar.getContentPane().setLayout(jDialogEditarLayout);
        jDialogEditarLayout.setHorizontalGroup(
            jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogEditarLayout.setVerticalGroup(
            jDialogEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogEliminar.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Eliminar Intento"));

        jLabelEliminar.setText("<html> Estas seguro que quieres  <br>eliminar el intento x? </html>");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEliminar)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabelEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar)))
        );

        javax.swing.GroupLayout jDialogEliminarLayout = new javax.swing.GroupLayout(jDialogEliminar.getContentPane());
        jDialogEliminar.getContentPane().setLayout(jDialogEliminarLayout);
        jDialogEliminarLayout.setHorizontalGroup(
            jDialogEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEliminarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDialogEliminarLayout.setVerticalGroup(
            jDialogEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEliminarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane5.setEnabled(false);
        jScrollPane5.setFocusable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Autor: Felip Torres Reines\n\n\nLogo generado con chatgpt");
        jTextArea1.setFocusable(false);
        jScrollPane5.setViewportView(jTextArea1);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogAboutLayout = new javax.swing.GroupLayout(jDialogAbout.getContentPane());
        jDialogAbout.getContentPane().setLayout(jDialogAboutLayout);
        jDialogAboutLayout.setHorizontalGroup(
            jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAboutLayout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jDialogAboutLayout.setVerticalGroup(
            jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.white);
        setResizable(false);

        jButtonInicio.setText("Login");
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
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
        jTableIntentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIntentosMouseClicked(evt);
            }
        });
        jTableIntentos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableIntentosPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTableIntentos);

        jLabelIntentos.setText("Intentos");
        jLabelIntentos.setAlignmentX(0.5F);

        jLabelClientes.setText("Clientes");

        jPanelVideo.setBorder(javax.swing.BorderFactory.createTitledBorder("Video player"));

        javax.swing.GroupLayout jPanelVideoLayout = new javax.swing.GroupLayout(jPanelVideo);
        jPanelVideo.setLayout(jPanelVideoLayout);
        jPanelVideoLayout.setHorizontalGroup(
            jPanelVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanelVideoLayout.setVerticalGroup(
            jPanelVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonPausa.setText("Pausar");
        jButtonPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausaActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Editar review");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar intento");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonEscribir.setText("Escribir review");
        jButtonEscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListasLayout = new javax.swing.GroupLayout(jPanelListas);
        jPanelListas.setLayout(jPanelListasLayout);
        jPanelListasLayout.setHorizontalGroup(
            jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListasLayout.createSequentialGroup()
                        .addComponent(jButtonEscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPausa))
                    .addGroup(jPanelListasLayout.createSequentialGroup()
                        .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelListasLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelListasLayout.setVerticalGroup(
            jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListasLayout.createSequentialGroup()
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClientes)
                    .addComponent(jLabelIntentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanelVideo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPausa)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonEscribir))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        String imagePath = "src/main/java/com/mycompany/projectofinal/logo2.jpg";

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

        jLabelWeb.setForeground(new java.awt.Color(0, 204, 255));
        jLabelWeb.setText("<html>\n\n<a href='https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley'>WEB</a>\n\n</html>"); // NOI18N
        jLabelWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelWebMouseClicked(evt);
            }
        });

        jMenu2.setText("File");

        jMenu4.setText(" Exit and Help");

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenu2.add(jMenu4);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelListas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonInicio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelListas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonInicio, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de cambio de selección en la lista de clientes.
     * 
     * @param evt el evento de cambio de selección
     */
    private void jListClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // Verifica que el evento no sea un ajuste final de la selección
        if (!evt.getValueIsAdjusting()) {
            // Obtener el valor seleccionado de jList1
            usuarioSeleccionado = (String) jListClientes.getSelectedValue();

            // Verificar que se haya seleccionado un elemento
            if (usuarioSeleccionado != null) {
                recargarTabla();
                
                // Seleccionar automáticamente la primera fila de la JTable
                if (jTableIntentos.getRowCount() > 0) {
                    jTableIntentos.changeSelection(0, 5, false, false); // Selecciona la primera fila y 5 columna que es la del video
                    
                    playVideo(0, model);
                }
            }
        }   
    }

    /**
     * Maneja el evento de acción en el campo de texto de email.
     * 
     * @param evt el evento de acción
     */
    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Maneja el evento de acción del botón de login.
     * 
     * @param evt el evento de acción
     */
    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        Usuari user = da.getUsuario(jTextFieldEmail.getText());
        // Compruebo que esté registrado
        if (user != null) {
            // Compruebo la contraseña
            char[] passToVery = jPasswordField.getPassword();
            String passString = user.getPasswordHash();
            var result = BCrypt.verifyer().verify(passToVery, passString);
            if (result.verified) {
                // Compruebo si es instructor
                if (user.isInstructor()) {
                    // Logeado a true y muestro todo lo que debe ver un instructor
                    logeado = true;
                    actualizarPanel();
                    initTabla();
                    IdUsuario = user.getId();
                    JOptionPane.showMessageDialog(this, "Logeado instructor: " + user.getNom());
                    jButtonInicio.setText("Sing out");
                    jDialogInicio.dispose();
                } else { // Es un usuario normal, lo cual aún no hay que implementar
                    JOptionPane.showMessageDialog(this, "Logeado usuario: " + user.getNom() + " De momento sin implementar");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
                logeado = false;
                actualizarPanel();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Correo incorrecto");
            logeado = false;
            actualizarPanel();
        }
    }

    /**
     * Maneja el evento de acción del botón de inicio (login/sing out).
     * 
     * @param evt el evento de acción
     */
    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {
        if (logeado) { // Si está logeado deslogea y actualiza al estado inicial
            logeado = false;
            actualizarPanel();
            jButtonInicio.setText("Login");
        } else { // Si no está logeado abre el modal para logearte
            jDialogInicio.pack();
            jDialogInicio.setVisible(true);  
        }
    }

    /**
     * Maneja el evento de clic en la etiqueta de la web.
     * 
     * @param evt el evento de clic
     */
    private void jLabelWebMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley"));
        } catch (URISyntaxException | IOException ex) {
            System.out.println("Algo fue mal");
        }        
    }

    /**
     * Maneja el evento de clic en la tabla de intentos.
     * 
     * @param evt el evento de clic
     */
    private void jTableIntentosMouseClicked(java.awt.event.MouseEvent evt) {
        // Obtener la fila y columna de la celda que fue clickeada
        int row = jTableIntentos.rowAtPoint(evt.getPoint());
        
        // Ejecuta el video
        playVideo(row, model);
            
        // Coge el id del intento seleccionado
        IdIntento = (int) jTableIntentos.getValueAt(row, 0);
        
        // Coge el estado
        String estado = jTableIntentos.getValueAt(row, 3).toString();
        
        // Si el estado es pendiente muestra el botón para escribir una review
        if (estado.equals("Pendiente")) {
            jButtonModificar.setVisible(false);
            jButtonEscribir.setVisible(true);
        } else { // De lo contrario muestra el de editar
            jButtonEscribir.setVisible(false);
            jButtonModificar.setVisible(true);
        }
    }

    /**
     * Maneja el evento de cambio de propiedad en la tabla de intentos.
     * 
     * @param evt el evento de cambio de propiedad
     */
    private void jTableIntentosPropertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * Maneja el evento de acción del botón de pausa.
     * 
     * @param evt el evento de acción
     */
    private void jButtonPausaActionPerformed(java.awt.event.ActionEvent evt) {
        if (isPlaying) {
            mp.mediaPlayer().controls().pause();
            isPlaying = false;
            jButtonPausa.setText("Despausar");
        } else {
            mp.mediaPlayer().controls().start();
            isPlaying = true;
            jButtonPausa.setText("Pausar");
        }
    }

    /**
     * Maneja el evento de acción del botón para escribir una review.
     * 
     * @param evt el evento de acción
     */
    private void jButtonEscribirActionPerformed(java.awt.event.ActionEvent evt) {
        jLabelID.setText("ID: " + IdIntento + " (Intento seleccionado)");
        jDialogEscribir.pack();
        jDialogEscribir.setVisible(true);  
    }

    /**
     * Maneja el evento de acción del botón para modificar una review.
     * 
     * @param evt el evento de acción
     */
    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {
        jLabelID1.setText("ID: " + IdIntento + " (Intento seleccionado)");
        Review rev = da.getReview(IdIntento);
        jSpinnerValoracionEditar.setValue(rev.getValoracio());
        jTextAreaComentarioEditar.setText(rev.getComentari());
        jDialogEditar.pack();
        jDialogEditar.setVisible(true);  
    }

    /**
     * Maneja el evento de acción del botón para eliminar un intento.
     * 
     * @param evt el evento de acción
     */
    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        jLabelEliminar.setText("<html> Estas seguro que quieres  <br>eliminar el intento " + IdIntento + "? </html>");
        jDialogEliminar.pack();
        jDialogEliminar.setVisible(true);  
    }

    /**
     * Maneja el evento de acción del botón para confirmar la escritura de una review.
     * 
     * @param evt el evento de acción
     */
    private void jButtonEscribir1ActionPerformed(java.awt.event.ActionEvent evt) {
        int Valoracion = (int) jSpinnerValoracion.getValue();
        String comentario = jTextAreaComentario.getText();
        da.insertReview(IdIntento, IdUsuario, Valoracion, comentario);
        if (usuarioSeleccionado != null) recargarTabla(); else initTabla();
        jDialogEscribir.dispose();
    }

    /**
     * Maneja el evento de acción del botón para aceptar la eliminación de un intento.
     * 
     * @param evt el evento de acción
     */
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        da.eliminarIntento(IdIntento);
        if (usuarioSeleccionado != null) recargarTabla(); else initTabla();
        jDialogEliminar.dispose();
    }

    /**
     * Maneja el evento de acción del botón para editar una review.
     * 
     * @param evt el evento de acción
     */
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {
        Review rev = da.getReview(IdIntento);
        int Valoracion = (int) jSpinnerValoracionEditar.getValue();
        String comentario = jTextAreaComentarioEditar.getText();
        da.updateReview(rev.getId(), Valoracion, comentario);
        recargarTabla();
        jDialogEditar.dispose();
    }

    /**
     * Maneja el evento de acción del botón para cancelar la eliminación de un intento.
     * 
     * @param evt el evento de acción
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        jDialogEliminar.dispose();
    }

    /**
     * Maneja el evento de acción del menú para mostrar el diálogo "About".
     * 
     * @param evt el evento de acción
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        jDialogAbout.pack();
        jDialogAbout.setVisible(true);
    }

    /**
     * Maneja el evento de acción del botón para cerrar el diálogo "About".
     * 
     * @param evt el evento de acción
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jDialogAbout.dispose();
    }

    /**
     * El método principal para ejecutar la aplicación.
     * 
     * @param args los argumentos de la línea de comandos
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
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEscribir;
    private javax.swing.JButton jButtonEscribir1;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonPausa;
    private javax.swing.JDialog jDialogAbout;
    private javax.swing.JDialog jDialogEditar;
    private javax.swing.JDialog jDialogEliminar;
    private javax.swing.JDialog jDialogEscribir;
    private javax.swing.JDialog jDialogInicio;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelContra;
    private javax.swing.JLabel jLabelEliminar;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelID1;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelIntentos;
    private javax.swing.JLabel jLabelValoracion;
    private javax.swing.JLabel jLabelValoracion1;
    private javax.swing.JLabel jLabelValoracion2;
    private javax.swing.JLabel jLabelValoracion3;
    private javax.swing.JLabel jLabelWeb;
    private javax.swing.JList<String> jListClientes;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelListas;
    private javax.swing.JPanel jPanelVideo;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinnerValoracion;
    private javax.swing.JSpinner jSpinnerValoracionEditar;
    private javax.swing.JTable jTableIntentos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaComentario;
    private javax.swing.JTextArea jTextAreaComentarioEditar;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
