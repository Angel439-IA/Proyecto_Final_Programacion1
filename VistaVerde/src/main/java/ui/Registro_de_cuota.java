/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import com.vistaverde.vistaverde.VistaVerdeIconos;
import java.awt.HeadlessException;
import java.io.IOException;
import logic.PagoDB;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import javax.mail.MessagingException;
import logic.ConfiguracionCuotaDB;
import logic.EmailSender;

/**
 *
 * @author d4nil
 */
public class Registro_de_cuota extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Registro_de_cuota.class.getName());

    /**
     * Creates new form Registro_de_cuota
     */
    private double montoVigente = 0.0;
    private boolean limpiando = false;

    public Registro_de_cuota() {
        initComponents();
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(224, 253, 177));
        jPanel1.setBorder(null);
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        configurarComboBoxes();
        configurarCamposReadOnly();
        cargarMontoVigente();
        cargarMontoVigente();
        txtFechaPago.setText(LocalDate.now().toString());

        setIconImage(VistaVerdeIconos.getLogo().getImage());

        java.awt.Image imgEscalada = VistaVerdeIconos.getLogo().getImage()
                .getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        javax.swing.ImageIcon logoChico = new javax.swing.ImageIcon(imgEscalada);

        jLabel8.setIcon(logoChico);
        jLabel8.setIconTextGap(10);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon NumeroCasa = new javax.swing.ImageIcon(
                VistaVerdeIconos.getNumeroCasa().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel2.setIcon(NumeroCasa);
        jLabel2.setIconTextGap(8);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon NombrePropiertario = new javax.swing.ImageIcon(
                VistaVerdeIconos.getNombre().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        lblPropietario.setIcon(NombrePropiertario);
        lblPropietario.setIconTextGap(8);
        lblPropietario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblPropietario.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon Calendario = new javax.swing.ImageIcon(
                VistaVerdeIconos.getCalendario().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel7.setIcon(Calendario);
        jLabel7.setIconTextGap(8);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon MontoPaga = new javax.swing.ImageIcon(
                VistaVerdeIconos.getMonto().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel6.setIcon(MontoPaga);
        jLabel6.setIconTextGap(8);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon Tardio = new javax.swing.ImageIcon(
                VistaVerdeIconos.getTardio().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        jLabel3.setIcon(Tardio);
        jLabel3.setIconTextGap(8);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon Guardar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getGuardar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        btnGuardar.setIcon(Guardar);
        btnGuardar.setIconTextGap(8);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon Cancelar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getRegresar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        btnGuardar1.setIcon(Cancelar);
        btnGuardar1.setIconTextGap(8);
        btnGuardar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.ImageIcon Limpiar = new javax.swing.ImageIcon(
                VistaVerdeIconos.getLimpiar().getImage()
                        .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)
        );
        btnCancelar.setIcon(Limpiar);
        btnCancelar.setIconTextGap(8);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    }

    private void configurarCamposReadOnly() {
        txtIdPropietario1.setEditable(false);
        txtIdPropietario1.setBackground(new java.awt.Color(240, 240, 240));
        txtMonto.setEditable(false);
        txtMonto.setBackground(new java.awt.Color(240, 240, 240));
        txtFechaPago.setEditable(false);
        txtFechaPago.setBackground(new java.awt.Color(240, 240, 240));
    }

    private void cargarMontoVigente() {
        montoVigente = ConfiguracionCuotaDB.obtenerMontoVigente();
        txtMonto.setText(String.format("%.2f", montoVigente));
    }

    private void configurarComboBoxes() {
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "-- Mes --",
            "01", "02", "03", "04", "05", "06",
            "07", "08", "09", "10", "11", "12"
        }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "-- Año --", "2025", "2026", "2027"
        }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "-- Seleccione --",
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
        }));
    }

//Actualizar campo Fecha
    private void actualizarFechaPago() {
        if (limpiando) {
            return;
        }
        try {
            if (cmbMes.getSelectedIndex() == 0 || jComboBox2.getSelectedIndex() == 0) {
                txtFechaPago.setText("");
                return;
            }
            int mes = cmbMes.getSelectedIndex();
            int anio = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            int dia = LocalDate.now().getDayOfMonth();
            LocalDate fecha = LocalDate.of(anio, mes, 1);
            int maxDia = fecha.lengthOfMonth();
            if (dia > maxDia) {
                dia = maxDia;
            }
            txtFechaPago.setText(LocalDate.of(anio, mes, dia).toString());
        } catch (Exception e) {
            txtFechaPago.setText("");
        }
    }

    private void limpiarCampos() {
        limpiando = true;
        jComboBox1.setSelectedIndex(0);
        txtIdPropietario1.setText("");
        cmbMes.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        txtFechaPago.setText("");
        txtMonto.setText(String.format("%.2f", montoVigente));
        chkPagoTardio.setSelected(false);
        limpiando = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPropietario = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaPago = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        txtIdPropietario1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        chkPagoTardio = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 253, 177));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Numero de Casa");

        lblPropietario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblPropietario.setForeground(new java.awt.Color(30, 30, 30));
        lblPropietario.setText("Nombre del Propietario");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Mes");

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cmbMes.addActionListener(this::cmbMesActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Año");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Monto Pagado");

        txtMonto.setToolTipText("");
        txtMonto.addActionListener(this::txtMontoActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Fecha de Pago");

        txtFechaPago.addActionListener(this::txtFechaPagoActionPerformed);

        btnGuardar.setBackground(new java.awt.Color(102, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(30, 30, 30));
        btnGuardar.setText("Guardar Pago");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(30, 30, 30));
        btnCancelar.setText("Limpiar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnGuardar1.setBackground(new java.awt.Color(255, 204, 204));
        btnGuardar1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(30, 30, 30));
        btnGuardar1.setText("Regresar");
        btnGuardar1.addActionListener(this::btnGuardar1ActionPerformed);

        txtIdPropietario1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtIdPropietario1.addActionListener(this::txtIdPropietario1ActionPerformed);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2026", "2027" }));
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        chkPagoTardio.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        chkPagoTardio.setForeground(new java.awt.Color(30, 30, 30));
        chkPagoTardio.setText("PagoTardio");
        chkPagoTardio.addActionListener(this::chkPagoTardioActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Registro Couta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(txtIdPropietario1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(82, 82, 82)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(105, 105, 105)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(chkPagoTardio)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel3)))))
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(124, 124, 124)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(lblPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPropietario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkPagoTardio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            if (jComboBox1.getSelectedIndex() == 0
                    || jComboBox1.getSelectedItem().toString().equals("-- Seleccione --")) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un número de casa antes de guardar.",
                        "Casa no seleccionada",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombrePropietario = txtIdPropietario1.getText();
            if (nombrePropietario.equals("Sin propietario registrado") || nombrePropietario.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No se puede registrar el pago. La casa seleccionada no tiene un propietario asignado.",
                        "Acción denegada",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cmbMes.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un mes.",
                        "Mes no seleccionado",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (jComboBox2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un año.",
                        "Año no seleccionado",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idCasa = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int mes = Integer.parseInt(cmbMes.getSelectedItem().toString());
            int anio = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            double monto = Double.parseDouble(txtMonto.getText().trim().replace(",", "."));
            int pagoTardio = chkPagoTardio.isSelected() ? 1 : 0;
            int idPropietario = logic.PagoDB.obtenerPropietarioPorCasa(idCasa);

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaPago = sdf.format(new java.util.Date());

            int idCuota = 1; // puedes obtenerlo dinámicamente si lo necesitas

            model.Pago nuevoPago = new model.Pago(
                    idCasa, idPropietario, mes, anio, monto, fechaPago, idCuota, pagoTardio
            );

            boolean exito = logic.PagoDB.GuardarPago(nuevoPago);
            if (exito) {
                JOptionPane.showMessageDialog(this,
                        "Pago registrado correctamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                String correoPropietario = logic.PagoDB.obtenerCorreoPorCasa(idCasa);
                try {
                    String asunto = "Comprobante de Pago - Casa " + idCasa;
                    String cuerpoHtml = "<html>"
                            + "<body style='font-family: Arial, sans-serif; color: #333;'>"
                            + "<h2 style='color: green;'>CONDOMINIO VISTA VERDE</h2>"
                            + "<p>Estimado <b>" + nombrePropietario + "</b>,</p>"
                            + "<p>Se ha registrado su pago exitosamente.</p>"
                            + "<p><b>Detalles del pago:</b></p>"
                            + "<ul>"
                            + "<li>Casa: <b>" + idCasa + "</b></li>"
                            + "<li>Mes: <b>" + mes + "</b></li>"
                            + "<li>Año: <b>" + anio + "</b></li>"
                            + "<li>Monto: <b>Q" + monto + "</b></li>"
                            + "<li>Pago tardío: <b>" + (pagoTardio == 1 ? "Sí" : "No") + "</b></li>"
                            + "</ul>"
                            + "<br>"
                            + "<p>Gracias por cumplir con sus obligaciones.</p>"
                            + "<img src='cid:logoVistaVerde' alt='Logo Condominio' style='width:200px;height:auto;'/>"
                            + "</body></html>";

                    EmailSender.enviarCorreo(correoPropietario, asunto, cuerpoHtml);
                } catch (MessagingException | IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,
                            "El pago se guardó, pero ocurrió un error al enviar el correo.\n" + ex.getMessage(),
                            "Error de correo",
                            JOptionPane.WARNING_MESSAGE);
                }

                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "No se pudo registrar. Verifica que la casa exista o que no haya un pago duplicado para ese mes y año.",
                        "Error al Guardar",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingresa valores numéricos válidos en Casa, Año y Monto.",
                    "Error de Formato",
                    JOptionPane.WARNING_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this,
                    "Ocurrió un error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        // TODO add your handling code here:
        actualizarFechaPago();
    }//GEN-LAST:event_cmbMesActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtFechaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPagoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed

        new Inicio().setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void txtIdPropietario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPropietario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPropietario1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        if (limpiando) {
            return;
        }

        String seleccionado = jComboBox1.getSelectedItem() != null
                ? jComboBox1.getSelectedItem().toString() : "";

        // Si es la opción vacía, limpiar el campo de propietario
        if (seleccionado.equals("-- Seleccione --")) {
            txtIdPropietario1.setText("");
            return;
        }

        try {
            int idCasa = Integer.parseInt(seleccionado);
            String nombrePropietario = logic.PagoDB.obtenerNombrePropietarioPorCasa(idCasa);
            txtIdPropietario1.setText(nombrePropietario);
        } catch (Exception e) {
            txtIdPropietario1.setText("Error al obtener propietario");
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        actualizarFechaPago();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void chkPagoTardioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPagoTardioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkPagoTardioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> new Registro_de_cuota().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JCheckBox chkPagoTardio;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JTextField txtFechaPago;
    private javax.swing.JTextField txtIdPropietario1;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
