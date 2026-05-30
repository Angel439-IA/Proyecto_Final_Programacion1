/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import logic.ConexionDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author cuasl
 */
public class Rep_general extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Rep_general.class.getName());

    /**
     * Creates new form Rep_general
     */
    public Rep_general() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);
        logic.ConexionDB.iniciarDB();

        cargarImagen(Icon1, "/imagenes/finanzas.png");
        cargarImagen(Icon2, "/imagenes/Iconovistaverde.png");
        mostrar("v_estado_mes_actual");
        mostrarPieReporte();
    }

    public void mostrarPieReporte() {
        String sqlRecaudado
                = "SELECT COALESCE(SUM(monto_pagado), 0) AS total_recaudado "
                + "FROM pago "
                + "WHERE mes = CAST(strftime('%m', 'now') AS INTEGER) "
                + "AND anio = CAST(strftime('%Y', 'now') AS INTEGER)";

        String sqlEsperado
                = "SELECT "
                + "((SELECT monto FROM cuota ORDER BY fecha_vigencia DESC, id_cuota DESC LIMIT 1) * "
                + "(SELECT COUNT(*) FROM propietario)) AS total_esperado";

        try {
            Connection con = ConexionDB.getConxion();

            double totalRecaudado = 0;
            double totalEsperado = 0;

            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(sqlRecaudado);

            if (rs1.next()) {
                totalRecaudado = rs1.getDouble("total_recaudado");
            }

            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(sqlEsperado);

            if (rs2.next()) {
                totalEsperado = rs2.getDouble("total_esperado");
            }

            double pendiente = totalEsperado - totalRecaudado;

            lblRecaudadoMes.setText("Total recaudado del mes: Q" + String.format("%.2f", totalRecaudado));
            lblEsperadoMes.setText("Total esperado del mes: Q" + String.format("%.2f", totalEsperado));
            lblPendienteMes.setText("Pendiente por recaudar: Q" + String.format("%.2f", pendiente));

            rs1.close();
            rs2.close();
            st1.close();
            st2.close();

        } catch (SQLException e) {
            System.out.println("Error al mostrar pie del reporte: " + e.getMessage());
        }
    }

    private void cargarImagen(JLabel destino, String ruta) {
        ImageIcon original = new ImageIcon(getClass().getResource(ruta));
        Image img = original.getImage().getScaledInstance(
                destino.getWidth(),
                destino.getHeight(),
                Image.SCALE_SMOOTH
        );
        destino.setIcon(new ImageIcon(img));
    }

    public void mostrar(String tabla) {
        String sql = "SELECT * FROM " + tabla;

        try {
            java.sql.Connection con = logic.ConexionDB.getConxion();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            DefaultTableModel modelo = new DefaultTableModel();
            java.sql.ResultSetMetaData metaData = rs.getMetaData();
            int columnas = metaData.getColumnCount();

            // Nombres legibles para v_estado_mes_actual (7 columnas)
            String[] nombresLegibles = {
                "N. Casa", "Propietario", "Teléfono", "Correo",
                "Estado Mes Actual", "Monto Pagado", "Fecha Pago"
            };

            if (columnas == nombresLegibles.length) {
                for (String nombre : nombresLegibles) {
                    modelo.addColumn(nombre);
                }
            } else {
                for (int i = 1; i <= columnas; i++) {
                    modelo.addColumn(metaData.getColumnName(i));
                }
            }

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }

            jTable1.setModel(modelo);

            // Ajuste de ancho de columnas
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(55);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);

            jTable1.setRowHeight(22);

            rs.close();
            st.close();

        } catch (java.sql.SQLException e) {
            System.out.println("Error al mostrar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botback = new javax.swing.JLabel();
        lblRecaudadoMes = new javax.swing.JLabel();
        lblEsperadoMes = new javax.swing.JLabel();
        lblPendienteMes = new javax.swing.JLabel();
        Icon2 = new javax.swing.JLabel();
        Icon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro General");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Fondo.getAccessibleContext().setAccessibleName("");

        jPanel1.setBackground(new java.awt.Color(224, 253, 177));
        jPanel1.setForeground(new java.awt.Color(224, 253, 177));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(247, 220, 247));

        titulo1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("¡ Bienvenido, este es el Reporte General! ");
        titulo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        botback.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        botback.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botback.setText("Regresar ");
        botback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botback, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botback, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        lblRecaudadoMes.setText("Total recaudado del mes: Q0.00");

        lblEsperadoMes.setText("jLabel2");

        lblPendienteMes.setText("jLabel3");

        Icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Iconovistaverde.png"))); // NOI18N
        Icon2.setPreferredSize(new java.awt.Dimension(45, 55));

        Icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/finanzas.png"))); // NOI18N
        Icon1.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEsperadoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPendienteMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRecaudadoMes, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addGap(77, 77, 77)
                        .addComponent(Icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRecaudadoMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEsperadoMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPendienteMes))
                    .addComponent(Icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botbackMouseClicked
        Inicio e = new Inicio();
        e.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_botbackMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new Rep_general().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Icon1;
    private javax.swing.JLabel Icon2;
    private javax.swing.JLabel botback;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEsperadoMes;
    private javax.swing.JLabel lblPendienteMes;
    private javax.swing.JLabel lblRecaudadoMes;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
