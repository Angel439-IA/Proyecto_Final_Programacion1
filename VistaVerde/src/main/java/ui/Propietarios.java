/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.vistaverde.vistaverde.VistaVerdeIconos;
import model.Propietario;
import logic.PropietariosDB;
import logic.Validaciones;

/**
 *
 * @author Angel Sotoy
 */
public class Propietarios extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Propietarios.class.getName());

    /**
     * Creates new form Propietarios
     */
    private Inicio ventanaInicio;

    public Propietarios(Inicio inicio) {
        this.ventanaInicio = inicio;
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Fondo general de la ventana
        getContentPane().setBackground(new java.awt.Color(224, 253, 177));

        setIconImage(VistaVerdeIconos.getLogo().getImage());

        // Botón Registrar 
        jButton1.setBackground(new java.awt.Color(102, 204, 255));

        jButton2.addActionListener(e -> {
            if (ventanaInicio != null) {
                ventanaInicio.setVisible(true);
            } else {
                new Inicio().setVisible(true);
            }
            dispose();
        });

        // Ajustes de tamaño
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 25));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 25));
        jTextField3.setPreferredSize(new java.awt.Dimension(200, 25));
        jTextField4.setPreferredSize(new java.awt.Dimension(200, 25));

        jComboBox1.setPreferredSize(new java.awt.Dimension(120, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 35));

        jLabel2.setPreferredSize(new java.awt.Dimension(100, 25));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 25));
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 25));
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 25));
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 25));

        // Escalar el logo a tamaño pequeño para ponerlo junto al título
        java.awt.Image imgEscalada = VistaVerdeIconos.getLogo().getImage()
                .getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        javax.swing.ImageIcon logoChico = new javax.swing.ImageIcon(imgEscalada);

        // Logo a la izquierda, texto a la derecha
        jLabel1.setIcon(logoChico);
        jLabel1.setIconTextGap(10);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Nombre
        javax.swing.ImageIcon iconoNombre = new javax.swing.ImageIcon(
                VistaVerdeIconos.getNombre().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel2.setIcon(iconoNombre);
        jLabel2.setIconTextGap(8);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Nombre
        javax.swing.ImageIcon iconoApellido = new javax.swing.ImageIcon(
                VistaVerdeIconos.getNombre().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel3.setIcon(iconoApellido);
        jLabel3.setIconTextGap(8);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Casa
        javax.swing.ImageIcon iconoNumeroCasa = new javax.swing.ImageIcon(
                VistaVerdeIconos.getNumeroCasa().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel7.setIcon(iconoNumeroCasa);
        jLabel7.setIconTextGap(8);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Telefono
        javax.swing.ImageIcon iconoNumeroTelefono = new javax.swing.ImageIcon(
                VistaVerdeIconos.getNumeroTelefono().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel4.setIcon(iconoNumeroTelefono);
        jLabel4.setIconTextGap(8);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Correo
        javax.swing.ImageIcon iconoCorreo = new javax.swing.ImageIcon(
                VistaVerdeIconos.getCorreo().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel5.setIcon(iconoCorreo);
        jLabel5.setIconTextGap(8);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Registrar
        javax.swing.ImageIcon iconoRegistrar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getRegistropropietario().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton1.setIcon(iconoRegistrar);
        jButton1.setIconTextGap(8);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon Regresar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getRegresar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton2.setIcon(Regresar);
        jButton2.setIconTextGap(8);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBox1.removeAllItems();

        for (int i = 1; i <= 30; i++) {
            jComboBox1.addItem(String.valueOf(i));
        }

        jButton1.addActionListener(e
                -> {
            String nombre = jTextField1.getText().trim();
            String apellido = jTextField2.getText().trim();
            String telefono = jTextField3.getText().trim();
            String correo = jTextField4.getText().trim();
            //String fechaRegistro = jTextField5.getText().trim();
            int idCasa = jComboBox1.getSelectedIndex() + 1;

            // Validar campos vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                javax.swing.JOptionPane.showOptionDialog(this,
                        "Todos los campos son obligatorios",
                        "Campos Obligatorios",
                        javax.swing.JOptionPane.DEFAULT_OPTION,
                        javax.swing.JOptionPane.ERROR_MESSAGE,
                        null,
                        new Object[]{"Cerrar"},
                        "Cerrar"
                );
                return;
            }

            if (!Validaciones.validarNombre(nombre)) {
                javax.swing.JOptionPane.showMessageDialog(this, "El nombre solo puede tener letras y espacios");
                return;
            }

            if (!Validaciones.validarTelefono(telefono)) {
                javax.swing.JOptionPane.showMessageDialog(this, "El telefono solo debe tener numeros");
                return;
            }

            if (!Validaciones.validarCorreo(correo)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Correo Electronico invalidado");
                return;
            }

            // Guardar en la base
            Propietario p = new Propietario(idCasa, nombre, apellido, telefono, correo);
            if (PropietariosDB.guardar(p)) {
                javax.swing.ImageIcon iconoExito = VistaVerdeIconos.getExito();

                javax.swing.JOptionPane.showOptionDialog(
                        this,
                        "Propietario registrado correctamente",
                        "Registro Exitoso",
                        javax.swing.JOptionPane.DEFAULT_OPTION,
                        javax.swing.JOptionPane.PLAIN_MESSAGE,
                        iconoExito,
                        new Object[]{"Cerrar"},
                        "Cerrar"
                );

                // Refrescar la tabla en Inicio
                if (ventanaInicio != null) {
                    ventanaInicio.cargarPropietariosTabla();
                    dispose();
                    ventanaInicio.setVisible(true);
                }

                // Cerrar esta ventana y volver al menú Inicio
                dispose();
                ventanaInicio.setVisible(true);
            } else {
                javax.swing.JOptionPane.showOptionDialog(
                        this, "Error al registrar propietario",
                        "Erro de registro",
                        javax.swing.JOptionPane.DEFAULT_OPTION,
                        javax.swing.JOptionPane.ERROR_MESSAGE,
                        null,
                        new Object[]{"Cerrar"},
                        "Cerrar"
                );
            }
        });
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Propietarios");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Numero De Telefono");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Correo Electronico");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel7.setText("Numero de Casa");

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(30, 30, 30));
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, 0, 256, Short.MAX_VALUE)
                    .addComponent(jTextField4))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jButton1)
                        .addGap(117, 117, 117)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:   

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Propietarios(new Inicio()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
