/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.vistaverde.vistaverde.VistaVerdeIconos;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import model.Propietario;
import logic.PropietariosDB;

/**
 *
 * @author Angel Sotoy
 */
public class Inicio extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inicio.class.getName());

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        setSize(800, 700);
        setLocationRelativeTo(null);

        // Fondo general
        getContentPane().setBackground(new java.awt.Color(224, 253, 177));

        setIconImage(VistaVerdeIconos.getLogo().getImage());

        // Botones celestes
        java.awt.Color celeste = new java.awt.Color(102, 204, 255);
        jButton1.setBackground(celeste); // Registrar Propietario
        jButton2.setBackground(celeste); // Registro Pago Cuota
        jButton3.setBackground(celeste); // Configuración Cuota
        jButton4.setBackground(celeste); // Estado de Cuenta
        jButton5.setBackground(celeste); // Reporte General
        jButton6.setBackground(celeste); // Casas Morosas
        jButton8.setBackground(celeste);
        jButton9.setBackground(celeste);
        jButton10.setBackground(celeste);

        // Botón cerrar sesión en rosado con borde
        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setBorder(javax.swing.BorderFactory.createSoftBevelBorder(
                javax.swing.border.BevelBorder.RAISED,
                new java.awt.Color(255, 102, 102), // highlight outer
                new java.awt.Color(255, 102, 102) // highlight inner
        ));

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

        // Mostrar fecha actual en el título
        LocalDate hoy = LocalDate.now();

        // Formato en español: "26 de mayo de 2026"
        String fecha = hoy.getDayOfMonth() + " de "
                + hoy.getMonth().getDisplayName(java.time.format.TextStyle.FULL, new java.util.Locale("es", "GT"))
                + " de " + hoy.getYear();

        jLabel1.setText(jLabel1.getText() + "  |  " + fecha);

        //Icono Agregar propietario
        javax.swing.ImageIcon iconoAgregarpropietario = new javax.swing.ImageIcon(
                VistaVerdeIconos.getRegistropropietario().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton1.setIcon(iconoAgregarpropietario);
        jButton1.setIconTextGap(8);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Registro Pago
        javax.swing.ImageIcon iconoRegistroPago = new javax.swing.ImageIcon(
                VistaVerdeIconos.getRegistroPago().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton2.setIcon(iconoRegistroPago);
        jButton2.setIconTextGap(8);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Configuracion Cuota
        javax.swing.ImageIcon iconoConfiguracion = new javax.swing.ImageIcon(
                VistaVerdeIconos.getConfiguracionCuota().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton3.setIcon(iconoConfiguracion);
        jButton3.setIconTextGap(8);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Configuracion Cuota
        javax.swing.ImageIcon iconoEstadoCuenta = new javax.swing.ImageIcon(
                VistaVerdeIconos.getEstadoCuenta().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton4.setIcon(iconoEstadoCuenta);
        jButton4.setIconTextGap(8);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Reporte General
        javax.swing.ImageIcon iconoReporteGeneral = new javax.swing.ImageIcon(
                VistaVerdeIconos.getReporteGeneral().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton5.setIcon(iconoReporteGeneral);
        jButton5.setIconTextGap(8);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Casas Morosas
        javax.swing.ImageIcon iconoCasasMorosas = new javax.swing.ImageIcon(
                VistaVerdeIconos.getCasasMorosas().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton6.setIcon(iconoCasasMorosas);
        jButton6.setIconTextGap(8);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Cerrar Sesion
        javax.swing.ImageIcon iconnoCerrarSesion = new javax.swing.ImageIcon(
                VistaVerdeIconos.getCerrarSesion().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton7.setIcon(iconnoCerrarSesion);
        jButton7.setIconTextGap(8);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Editar
        javax.swing.ImageIcon iconoEditar = new javax.swing.ImageIcon(
                VistaVerdeIconos.geteditar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton8.setIcon(iconoEditar);
        jButton8.setIconTextGap(8);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Elimar
        javax.swing.ImageIcon iconoEliminar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getEliminar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton9.setIcon(iconoEliminar);
        jButton9.setIconTextGap(8);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        //Icono Elimar
        javax.swing.ImageIcon iconoGurdar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getGuardar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jButton10.setIcon(iconoGurdar);
        jButton10.setIconTextGap(8);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        // Cargar propietarios en la tabla
        cargarPropietariosTabla();

        // Acción para abrir ventana de registro de propietarios
        jButton1.addActionListener(e -> {
            Propietarios ventanaRegistro = new Propietarios(this); // 
            ventanaRegistro.setVisible(true);
            this.setVisible(false); // ocultar Inicio mientras registra
        });

        jButton2.addActionListener(e -> {
            Registro_de_cuota ventanaCuota = new Registro_de_cuota();
            ventanaCuota.setVisible(true);
            this.setVisible(false);
        });

        jButton3.addActionListener(e -> {
            ConfiguracionCuota ventanaConfiguracion = new ConfiguracionCuota();
            ventanaConfiguracion.setVisible(true);
            this.setVisible(false);
        });

        jButton4.addActionListener(e -> {
            EstadoDeCuenta ventanaEstado = new EstadoDeCuenta();
            ventanaEstado.setVisible(true);
            dispose();
        });

        jButton6.addActionListener(e -> {
            CasasMorosas ventanaCasas = new CasasMorosas();
            ventanaCasas.setVisible(true);
            this.setVisible(false);
        });

        // Acción para cerrar sesión
        jButton7.addActionListener(e -> {
            logic.Sesion.getInstancia().cerrarSecio();
            new Login().setVisible(true);
            dispose();
        });

        jButton8.addActionListener(e -> {
            int filaSeleccionada = jTable1.getSelectedRow();
            if (filaSeleccionada == -1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un propietario primero");
                return;
            }

            // Obtener el modelo actual
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

            // Convertir columnas a Vector
            java.util.Vector<String> columnas = new java.util.Vector<>();
            columnas.add("Número Casa");
            columnas.add("Nombre");
            columnas.add("Apellido");
            columnas.add("Telefono");
            columnas.add("Correo");
            columnas.add("Fecha Registro");

            // Crear nuevo modelo editable
            jTable1.setModel(new DefaultTableModel(modelo.getDataVector(), columnas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column != 0; // permitir editar todas menos la columna "Número Casa"
                }
            });

            javax.swing.JOptionPane.showOptionDialog(
                    this,
                    "Ya puede editar el propietario.\nLas celdas están habilitadas para edición.",
                    "Celdas habilitadas",
                    javax.swing.JOptionPane.DEFAULT_OPTION,
                    javax.swing.JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{"Cerrar"},
                    "Cerrar"
            );
        });

        jButton9.addActionListener(e -> {
            int filaSeleccionada = jTable1.getSelectedRow();
            if (filaSeleccionada == -1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un propietario primero");
                return;
            }

            // Botones en español
            Object[] opciones = {"Sí, eliminar", "No, cancelar"};
            int respuesta = javax.swing.JOptionPane.showOptionDialog(
                    this,
                    "¿Está seguro de eliminar este propietario?",
                    "Confirmar eliminación",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.WARNING_MESSAGE,
                    null,
                    opciones,
                    opciones[1]
            );

            if (respuesta == 0) {  // 0 = primera opción = "Sí, eliminar"
                int idCasa = (int) jTable1.getValueAt(filaSeleccionada, 0);
                if (PropietariosDB.eliminarPorCasa(idCasa)) {
                    javax.swing.ImageIcon iconoExito = VistaVerdeIconos.getExito();

                    javax.swing.JOptionPane.showOptionDialog(
                            this,
                            "Propietario elimando correctamente",
                            "Eliminacion Exitosa",
                            javax.swing.JOptionPane.DEFAULT_OPTION,
                            javax.swing.JOptionPane.PLAIN_MESSAGE,
                            iconoExito,
                            new Object[]{"Cerrar"},
                            "Cerrar"
                    );
                    cargarPropietariosTabla();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar propietario");
                }
            }
        });

        jButton10.addActionListener(e -> {
            if (jTable1.isEditing()) {
                jTable1.getCellEditor().stopCellEditing();
            }

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            boolean cambios = false;

            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idCasa = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                String nombre = modelo.getValueAt(i, 1).toString();
                String apellido = modelo.getValueAt(i, 2).toString();
                String telefono = modelo.getValueAt(i, 3).toString();
                String correo = modelo.getValueAt(i, 4).toString();

                Propietario p = new Propietario(idCasa, nombre, apellido, telefono, correo);
                if (PropietariosDB.actualizar(p)) {
                    cambios = true;
                }
            }

            if (cambios) {
                javax.swing.ImageIcon iconoExito = VistaVerdeIconos.getExito();

                javax.swing.JOptionPane.showOptionDialog(
                        this,
                        "Propietario Editado correctamente",
                        "Edicion Exitoso",
                        javax.swing.JOptionPane.DEFAULT_OPTION,
                        javax.swing.JOptionPane.PLAIN_MESSAGE,
                        iconoExito,
                        new Object[]{"Cerrar"},
                        "Cerrar"
                );
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se detectaron cambios");
            }
            cargarPropietariosTabla(); // refrescar tabla
        });

    }

    public void cargarPropietariosTabla() {
        // Definir columnas
        String[] columnas = {"Número Casa", "Nombre", "Apellido", "Telefono", "Correo", "Fecha Registro"};

        // Modelo no editable
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Obtener lista de propietarios desde la DB
        ArrayList<Propietario> lista = PropietariosDB.cargarTodos();

        for (Propietario p : lista) {
            Object[] fila = {
                p.getIdCasa(),
                p.getNombre(),
                p.getApellido(),
                p.getTelefono(),
                p.getCorreo(),
                p.getFechaRegistro()
            };
            modelo.addRow(fila);
        }

        jTable1.setModel(modelo);

        // Bloquear movimiento y redimensionamiento de columnas
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("Condomio Vista Verde");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N. Casa", "Nombres", "Apellidos", "Telefono", "Correo", "Fecha Registro"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton1.setText("Registrar Propietario");

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton2.setText("Registro Pago Cuota");

        jButton3.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton3.setText("Configuracion Cuota");

        jButton4.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton4.setText("Estado  de Cuenta por Casa");

        jButton5.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton5.setText("Reporte General");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton6.setText("Casas Morosas");

        jButton7.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton7.setText("Cerrar secion");

        jButton8.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton8.setText("Editar Propietario");

        jButton9.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton9.setText("Elimanar Propietario");

        jButton10.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jButton10.setText("Guardar Cambios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addContainerGap(393, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(406, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked

    }//GEN-LAST:event_jButton5MouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new Inicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
