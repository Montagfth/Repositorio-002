/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Services;

import Comentarios.DialogComentarios;
import Panels.panelInformativo;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Model.*;
import Interfaces.*;
import java.util.ArrayList;
import java.util.List;
import Database.*;
import DatabaseModels.*;
import Interfaces.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Fabrizio
 */
public class panelService1 extends javax.swing.JPanel {

    private final DAOAutos daoA = new DAOAutoIMPLEMENT();

    /**
     * Creates new form panelAutos
     */
    public panelService1() {
        initComponents();
        configuracionEventosTabla();
        //cargaDatosPrueba();
        cargaAutos();
        
        //Desseleccionador de filas:
        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                TblAuto.clearSelection();
                Descripcion01.setText("SELECCIONE UN AUTO PARA VER LOS DETALLES");
                Descripcion02.setText(" ");
                Descripcion03.setText(" ");
                Descripcion04.setText(" ");
                Descripcion05.setText(" ");
                Descripcion06.setText(" ");
                Descripcion07.setText(" ");
                Descripcion08.setText(" ");
                Descripcion09.setText(" ");
                Descripcion10.setText(" ");
            }
        });

    }

    public void actualizarTabla(List<Auto> lista) {
        DefaultTableModel model = (DefaultTableModel) TblAuto.getModel();

        model.setRowCount(0);

        for (Auto a : lista) {
            model.addRow(new Object[]{
                a.getID_Auto(),
                a.getMarca_Auto(),
                a.getModelo_Auto(),
                a.getAnio_Auto(),
                a.getPrecio_Auto()
            });
        }
    }

    public void filtrarAutos() {
        /*
               String anio = CbxAnioVehiculo.getSelectedItem().toString();
        String modelo = CbxModeloVehiculo.getSelectedItem().toString();
        String precio = CbxPrecioVehiculo.getSelectedItem().toString();

        List<String> condiciones = new ArrayList<>();

        if (!anio.equals("TODOS")) {
            condiciones.add("Anio_Auto = ?");
        }

        if (!modelo.equals("TODOS")) {
            condiciones.add("Modelo_Auto llke ?");
        }

        if (!precio.equals("TODOS")) {
            switch (precio) {
                case "MENOS DE 15,000":
                    condiciones.add("Precio_Auto < 15,000");
                    break;

                case "15,000 - 25,000":
                    condiciones.add("Precio_Auto between 15,000 and 25,000");
                    break;

                case "MAS DE 25,000":
                    condiciones.add("Precio_Auto > 25,000");
                default:
                    throw new AssertionError();
            }
        }

        String sql = "select * from Auto;";

        if (!condiciones.isEmpty()) {
            sql += " where " + String.join(" and ", condiciones);
        }

        try {
            act
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         */
        String anio = CbxAnioAuto.getSelectedItem().toString();
        String modelo = CbxModeloAuto.getSelectedItem().toString();
        String precio = CbxPrecioAuto.getSelectedItem().toString();

        anio = anio.equals("TODOS") ? "" : anio;
        modelo = modelo.equals("TODOS") ? "" : modelo;
        precio = precio.equals("TODOS") ? "" : precio;

        try {
            List<Auto> lista = daoA.listarFiltrado(anio, modelo, precio);
            actualizarTabla(lista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargaAutos() {
        try {
            DAOAutos daoA = new DAOAutoIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblAuto.getModel();
            model.setRowCount(0);
            daoA.Listar("").forEach((u) -> model.addRow(new Object[]{u.getID_Auto(), u.getMarca_Auto(), u.getModelo_Auto(), u.getAnio_Auto(), u.getPrecio_Auto()}));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filtradoGeneral() {
        //NOTA: Codigo implementable, pero la base de datos debe estar en ejecucion:
        /*
            String año = cbxAño.getSelectedItem().toString();
    String tipo = cbxTipo.getSelectedItem().toString();
    String precio = cbxPrecio.getSelectedItem().toString();
        
    String sql = "SELECT * FROM vehiculos WHERE 1=1";

    if (!año.equals("Todos")) {
        sql += " AND año = '" + año + "'";
    }

    if (!tipo.equals("Todos")) {
        sql += " AND tipo = '" + tipo + "'";
    }

    if (!precio.equals("Todos")) {
        switch (precio) {
            case "Menos de 15,000" -> sql += " AND precio < 15000";
            case "15,000 - 25,000" -> sql += " AND precio BETWEEN 15000 AND 25000";
            case "Más de 25,000" -> sql += " AND precio > 25000";
        }
    }

    // Ejecutar la consulta
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tu_bd", "usuario", "clave");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculos.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getInt("año"),
                rs.getDouble("precio"),
                rs.getString("tipo")
            });
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar: " + e.getMessage());
    }
         */
    }

    public void filtrosVehiculo() {
        CbxAnioAuto.addActionListener(e -> filtrosVehiculo());
        CbxModeloAuto.addActionListener(e -> filtrosVehiculo());
        CbxPrecioAuto.addActionListener(e -> filtrosVehiculo());
    }

    public void configuracionEventosTabla() {
        TblAuto.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TblAuto.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Extraer datos de la fila seleccionada
                    String marca = TblAuto.getValueAt(filaSeleccionada, 1).toString();
                    String modelo = TblAuto.getValueAt(filaSeleccionada, 2).toString();
                    String año = TblAuto.getValueAt(filaSeleccionada, 3).toString();
                    String precio = TblAuto.getValueAt(filaSeleccionada, 4).toString();

                    // Actualizar etiquetas
                    Descripcion01.setText("Marca: " + marca);
                    Descripcion02.setText("Modelo: " + modelo);
                    Descripcion03.setText("Año: " + año);
                    Descripcion04.setText("Precio: S/" + precio);
                    Descripcion05.setText("Batería de alto rendimiento");
                    Descripcion06.setText("Compatible con carga rápida y regenerativa");
                    Descripcion07.setText("TESLA-98765");
                    Descripcion08.setText("Estado: Nuevo | Garantía: 8 años");
                    Descripcion09.setText("Disponibilidad: Disponible");
                    Descripcion10.setText("Autonomía estimada: 600 km por carga completa");

                    /*
                                        if (TblVehiculos.getValueAt(filaSeleccionada, 1).toString() == "01") {
                        Descripcion05.setText("Batería de alto rendimiento");
                        Descripcion06.setText("Compatible con carga rápida y regenerativa");
                        Descripcion07.setText("TESLA-98765");
                        Descripcion08.setText("Estado: Nuevo | Garantía: 8 años");
                        Descripcion09.setText("Disponibilidad: Disponible");
                        Descripcion10.setText("Autonomía estimada: 600 km por carga completa");

                    } else if (TblVehiculos.getValueAt(filaSeleccionada, 1).toString() == "02") {
                        Descripcion05.setText("Batería de alto rendimiento");
                        Descripcion06.setText("Compatible con carga rápida y regenerativa");
                        Descripcion07.setText("TESLA-243152");
                        Descripcion08.setText("Estado: Nuevo | Garantía: 8 años");
                        Descripcion09.setText("Disponibilidad: Disponible");
                        Descripcion10.setText("Autonomía estimada: 800 km por carga completa");

                    } else if (TblVehiculos.getValueAt(filaSeleccionada, 1).toString() == "03") {
                        Descripcion05.setText("Batería de alto rendimiento");
                        Descripcion06.setText("Compatible con carga rápida y regenerativa");
                        Descripcion07.setText("TESLA-79675");
                        Descripcion08.setText("Estado: Nuevo | Garantía: 8 años");
                        Descripcion09.setText("Disponibilidad: Disponible");
                        Descripcion10.setText("Autonomía estimada: 1000 km por carga completa");
                    }
                     */

 /*
                    // Cambiar imagen
                    //NOTA: Por evaluar.
                    String rutaImagen = obtenerRutaImagen(nombre);
                    ImageIcon icono = new ImageIcon(rutaImagen);
                    Icon iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    lblImagen.setIcon(iconoEscalado);
                     */
                }
            }
        });
    }

    /*
        public void cargaDatosPrueba() {
        //Datos de prueba, no utilizar al momento de la implementacio de la base de datos SQL original.
        DefaultTableModel modelo = (DefaultTableModel) TblVehiculos.getModel();
        modelo.setRowCount(0); // Limpia las filas existentes

        modelo.addRow(new Object[]{"001", "Tesla", "01", "2025", "12000"});
        modelo.addRow(new Object[]{"002", "Tesla", "02", "2015", "35000"});
        modelo.addRow(new Object[]{"003", "Tesla", "03", "2005", "4550"});
        modelo.addRow(new Object[]{"004", "Tesla", "04", "2013", "22390"});

    }
     */
    public void mostrarPaneles(JPanel panel) {
        panel.setSize(1194, 694);
        panel.setLocation(0, 0);

        PnlContenedorGeneral.removeAll();
        PnlContenedorGeneral.add(panel, BorderLayout.CENTER);
        PnlContenedorGeneral.revalidate();
        PnlContenedorGeneral.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlContenedorGeneral = new javax.swing.JPanel();
        LblTitulo = new javax.swing.JLabel();
        LblSubtitulo = new javax.swing.JLabel();
        JSeparador01 = new javax.swing.JSeparator();
        LblFiltroAuto = new javax.swing.JLabel();
        LblAnioAuto = new javax.swing.JLabel();
        CbxAnioAuto = new javax.swing.JComboBox<>();
        LblModeloAuto = new javax.swing.JLabel();
        CbxModeloAuto = new javax.swing.JComboBox<>();
        LblPrecioAuto = new javax.swing.JLabel();
        CbxPrecioAuto = new javax.swing.JComboBox<>();
        JSeparador02 = new javax.swing.JSeparator();
        JSPRegistroAuto = new javax.swing.JScrollPane();
        TblAuto = new javax.swing.JTable();
        JSeparador03 = new javax.swing.JSeparator();
        BtnRetornar = new javax.swing.JButton();
        PnlDescripcionAuto = new javax.swing.JPanel();
        lblImagenDinamica = new javax.swing.JLabel();
        PnlConedorDescripcion = new javax.swing.JPanel();
        Descripcion01 = new javax.swing.JLabel();
        Descripcion02 = new javax.swing.JLabel();
        Descripcion03 = new javax.swing.JLabel();
        Descripcion04 = new javax.swing.JLabel();
        Descripcion05 = new javax.swing.JLabel();
        Descripcion06 = new javax.swing.JLabel();
        Descripcion07 = new javax.swing.JLabel();
        Descripcion08 = new javax.swing.JLabel();
        Descripcion09 = new javax.swing.JLabel();
        Descripcion10 = new javax.swing.JLabel();
        BtnReservarAuto = new javax.swing.JButton();
        BtnComentarAuto = new javax.swing.JButton();
        ChkBxConfirmacionReservaAuto = new javax.swing.JCheckBox();

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        LblTitulo.setText("VEHICULOS DISPONIBLES");

        LblSubtitulo.setText("Busque el vehiculo de su preferencia:");

        LblFiltroAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFiltroAuto.setText("FILTRAR:");

        LblAnioAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblAnioAuto.setText("AÑO:");

        CbxAnioAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "2025", "2024", "2023" }));
        CbxAnioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxAnioAutoActionPerformed(evt);
            }
        });

        LblModeloAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblModeloAuto.setText("MODELO");

        CbxModeloAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "SEDAN", "SUV", "CAMIONETA" }));
        CbxModeloAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxModeloAutoActionPerformed(evt);
            }
        });

        LblPrecioAuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblPrecioAuto.setText("PRECIO:");

        CbxPrecioAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "MENOS DE 15,000", "15,000 - 25,000", "MAS DE 25,000" }));
        CbxPrecioAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxPrecioAutoActionPerformed(evt);
            }
        });

        TblAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID:", "MARCA:", "MODELO:", "ANIO:", "PRECIO:"
            }
        ));
        TblAuto.setToolTipText("");
        JSPRegistroAuto.setViewportView(TblAuto);

        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        PnlDescripcionAuto.setBackground(new java.awt.Color(255, 255, 255));

        lblImagenDinamica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagenDinamica.setText("[IMAGEN AQUI]");

        Descripcion01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Descripcion01.setText("SELECCIONE ALGUN MODELO PARA VER SU IMAGEN & DESCRIPCION");

        Descripcion02.setText(" ");

        Descripcion03.setText(" ");

        Descripcion04.setText(" ");

        Descripcion05.setText(" ");

        Descripcion06.setText(" ");

        Descripcion07.setText(" ");

        Descripcion08.setText(" ");

        Descripcion09.setText(" ");

        Descripcion10.setText(" ");

        BtnReservarAuto.setText("HACER UNA RESERVA");
        BtnReservarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReservarAutoActionPerformed(evt);
            }
        });

        BtnComentarAuto.setText("COMENTAR");
        BtnComentarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnComentarAutoActionPerformed(evt);
            }
        });

        ChkBxConfirmacionReservaAuto.setText("Marque la casilla para aceptar terminos y condiciones para la operacion.");
        ChkBxConfirmacionReservaAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkBxConfirmacionReservaAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlConedorDescripcionLayout = new javax.swing.GroupLayout(PnlConedorDescripcion);
        PnlConedorDescripcion.setLayout(PnlConedorDescripcionLayout);
        PnlConedorDescripcionLayout.setHorizontalGroup(
            PnlConedorDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlConedorDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlConedorDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkBxConfirmacionReservaAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PnlConedorDescripcionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnReservarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnComentarAuto)
                        .addGap(36, 36, 36))
                    .addComponent(Descripcion10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PnlConedorDescripcionLayout.setVerticalGroup(
            PnlConedorDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlConedorDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Descripcion01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion03)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion04)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion05)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion06)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion07)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion08)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Descripcion09)
                .addGap(5, 5, 5)
                .addComponent(Descripcion10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlConedorDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReservarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnComentarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChkBxConfirmacionReservaAuto)
                .addContainerGap())
        );

        javax.swing.GroupLayout PnlDescripcionAutoLayout = new javax.swing.GroupLayout(PnlDescripcionAuto);
        PnlDescripcionAuto.setLayout(PnlDescripcionAutoLayout);
        PnlDescripcionAutoLayout.setHorizontalGroup(
            PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDescripcionAutoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PnlConedorDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImagenDinamica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PnlDescripcionAutoLayout.setVerticalGroup(
            PnlDescripcionAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDescripcionAutoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lblImagenDinamica, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlConedorDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnRetornar)
                                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JSeparador03, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                                    .addComponent(JSeparador01, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblSubtitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlContenedorGeneralLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(JSPRegistroAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(LblFiltroAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblModeloAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxModeloAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbxPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlDescripcionAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblFiltroAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxAnioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblModeloAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxModeloAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxPrecioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JSPRegistroAuto, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRetornar)
                .addContainerGap())
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(PnlDescripcionAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlContenedorGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostrarPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed

    private void CbxPrecioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxPrecioAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxPrecioAutoActionPerformed

    private void ChkBxConfirmacionReservaAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkBxConfirmacionReservaAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkBxConfirmacionReservaAutoActionPerformed

    private void BtnReservarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReservarAutoActionPerformed
        if (!ChkBxConfirmacionReservaAuto.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe aceptar los terminos y condiciones para continuar", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = TblAuto.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vehiculo en la tabla para continuar.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idAuto = (int) TblAuto.getValueAt(fila, 0);

        try {
            ReservaServUno rsuno = new ReservaServUno();
            rsuno.setID_Auto(idAuto);
            DAOReservaServUno daoRsuno = new DAOReservaServUnoIMPLEMENT();
            daoRsuno.registrar(rsuno);

            JOptionPane.showMessageDialog(null, "Reserva regisrada correctamente", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Se ha registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        /*
           if (ChkBxConfirmacion.isSelected()) {
            JOptionPane.showMessageDialog(null, "Gracias, se ha registrado su cita, acerquese al local.", "Tesla Inc.", JOptionPane.DEFAULT_OPTION);
            ChkBxConfirmacion.setSelected(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debe marcar la casilla antes de finalizar la operacion", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        }
         */

    }//GEN-LAST:event_BtnReservarAutoActionPerformed

    private void CbxAnioAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxAnioAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxAnioAutoActionPerformed

    private void CbxModeloAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxModeloAutoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxModeloAutoActionPerformed

    private void BtnComentarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnComentarAutoActionPerformed

        int filaSeleccionada = TblAuto.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un vehiculo para comentar", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idVehiculo = Integer.parseInt(TblAuto.getValueAt(filaSeleccionada, 0).toString());

        DialogComentarios dialog = new DialogComentarios(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                 idVehiculo
        );
        dialog.setVisible(true);

    }//GEN-LAST:event_BtnComentarAutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnComentarAuto;
    private javax.swing.JButton BtnReservarAuto;
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JComboBox<String> CbxAnioAuto;
    private javax.swing.JComboBox<String> CbxModeloAuto;
    private javax.swing.JComboBox<String> CbxPrecioAuto;
    private javax.swing.JCheckBox ChkBxConfirmacionReservaAuto;
    private javax.swing.JLabel Descripcion01;
    private javax.swing.JLabel Descripcion02;
    private javax.swing.JLabel Descripcion03;
    private javax.swing.JLabel Descripcion04;
    private javax.swing.JLabel Descripcion05;
    private javax.swing.JLabel Descripcion06;
    private javax.swing.JLabel Descripcion07;
    private javax.swing.JLabel Descripcion08;
    private javax.swing.JLabel Descripcion09;
    private javax.swing.JLabel Descripcion10;
    private javax.swing.JScrollPane JSPRegistroAuto;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JLabel LblAnioAuto;
    private javax.swing.JLabel LblFiltroAuto;
    private javax.swing.JLabel LblModeloAuto;
    private javax.swing.JLabel LblPrecioAuto;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PnlConedorDescripcion;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlDescripcionAuto;
    private javax.swing.JTable TblAuto;
    private javax.swing.JLabel lblImagenDinamica;
    // End of variables declaration//GEN-END:variables
}
