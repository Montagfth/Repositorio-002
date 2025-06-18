/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Services;

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
    }

    public void actualizarTabla(List<Auto> lista) {
        DefaultTableModel model = (DefaultTableModel) TblVehiculos.getModel();

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
        String anio = CbxAnioVehiculo.getSelectedItem().toString();
        String modelo = CbxModeloVehiculo.getSelectedItem().toString();
        String precio = CbxPrecioVehiculo.getSelectedItem().toString();

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
            DefaultTableModel model = (DefaultTableModel) TblVehiculos.getModel();
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
        CbxAnioVehiculo.addActionListener(e -> filtrosVehiculo());
        CbxModeloVehiculo.addActionListener(e -> filtrosVehiculo());
        CbxPrecioVehiculo.addActionListener(e -> filtrosVehiculo());
    }

    public void configuracionEventosTabla() {
        TblVehiculos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TblVehiculos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Extraer datos de la fila seleccionada
                    String marca = TblVehiculos.getValueAt(filaSeleccionada, 1).toString();
                    String modelo = TblVehiculos.getValueAt(filaSeleccionada, 2).toString();
                    String año = TblVehiculos.getValueAt(filaSeleccionada, 3).toString();
                    String precio = TblVehiculos.getValueAt(filaSeleccionada, 4).toString();

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

        PanelContenedor.removeAll();
        PanelContenedor.add(panel, BorderLayout.CENTER);
        PanelContenedor.revalidate();
        PanelContenedor.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        TxtTitulo = new javax.swing.JLabel();
        TxtSubtitulo = new javax.swing.JLabel();
        Separador01 = new javax.swing.JSeparator();
        TxtBusquedaVehiculo = new javax.swing.JTextField();
        BtnBusquedaVehiculo = new javax.swing.JButton();
        TxtInformativo01 = new javax.swing.JLabel();
        TxtInformativo02 = new javax.swing.JLabel();
        CbxAnioVehiculo = new javax.swing.JComboBox<>();
        TxtInformativo03 = new javax.swing.JLabel();
        CbxModeloVehiculo = new javax.swing.JComboBox<>();
        TxtInformativo04 = new javax.swing.JLabel();
        CbxPrecioVehiculo = new javax.swing.JComboBox<>();
        Separador02 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblVehiculos = new javax.swing.JTable();
        Separador03 = new javax.swing.JSeparator();
        BtnRetornar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
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
        BtnContinuar = new javax.swing.JButton();
        ChkBxConfirmacion = new javax.swing.JCheckBox();

        TxtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        TxtTitulo.setText("VEHICULOS DISPONIBLES");

        TxtSubtitulo.setText("Busque el vehiculo de su preferencia:");

        TxtBusquedaVehiculo.setText("Ingrese el modelo del vehiculo que busca.");

        BtnBusquedaVehiculo.setText("BUSCAR");
        BtnBusquedaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBusquedaVehiculoActionPerformed(evt);
            }
        });

        TxtInformativo01.setText("Filtrar por:");

        TxtInformativo02.setText("AÑO:");

        CbxAnioVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "2025", "2024", "2023" }));
        CbxAnioVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxAnioVehiculoActionPerformed(evt);
            }
        });

        TxtInformativo03.setText("MODELO");

        CbxModeloVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "SEDAN", "SUV", "CAMIONETA" }));
        CbxModeloVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxModeloVehiculoActionPerformed(evt);
            }
        });

        TxtInformativo04.setText("PRECIO:");

        CbxPrecioVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "MENOS DE 15,000", "15,000 - 25,000", "MAS DE 25,000" }));
        CbxPrecioVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxPrecioVehiculoActionPerformed(evt);
            }
        });

        TblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MARCA", "MODELO", "ANIO", "precio"
            }
        ));
        TblVehiculos.setToolTipText("");
        jScrollPane1.setViewportView(TblVehiculos);

        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setText("[IMAGEN AQUI]");

        Descripcion01.setText("jLabel2");

        Descripcion02.setText("jLabel3");

        Descripcion03.setText("jLabel4");

        Descripcion04.setText("jLabel5");

        Descripcion05.setText("jLabel6");

        Descripcion06.setText("jLabel7");

        Descripcion07.setText("jLabel8");

        Descripcion08.setText("jLabel9");

        Descripcion09.setText("jLabel1");

        Descripcion10.setText("jLabel2");

        BtnContinuar.setText("HACER UNA RESERVA");
        BtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnContinuarActionPerformed(evt);
            }
        });

        ChkBxConfirmacion.setText("Marque la casilla para aceptar terminos y condiciones para la operacion.");
        ChkBxConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkBxConfirmacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addComponent(ChkBxConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion09)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion10)
                .addGap(18, 18, 18)
                .addComponent(BtnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(ChkBxConfirmacion)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnRetornar)
                            .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Separador02, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Separador03, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                                    .addComponent(TxtSubtitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContenedorLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtBusquedaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                                .addComponent(TxtInformativo01)
                                                .addGap(18, 18, 18)
                                                .addComponent(TxtInformativo02)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CbxAnioVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(TxtInformativo03, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CbxModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(TxtInformativo04)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CbxPrecioVehiculo, 0, 0, Short.MAX_VALUE)
                                            .addComponent(BtnBusquedaVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                                    .addComponent(Separador01, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separador01, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBusquedaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBusquedaVehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbxPrecioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtInformativo01, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtInformativo02, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbxAnioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtInformativo03, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbxModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtInformativo04, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Separador02, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Separador03, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(BtnRetornar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostrarPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed

    private void BtnBusquedaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBusquedaVehiculoActionPerformed
        //NOTA: Sistema de busqueda que evalue si el campo de JTxtField esta lleno buscar con esa informacion
        //      o si los ComboBox estan seleccionados buscar con esos parametros.
        try {

        } catch (Exception e) {

        }
    }//GEN-LAST:event_BtnBusquedaVehiculoActionPerformed

    private void CbxPrecioVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxPrecioVehiculoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxPrecioVehiculoActionPerformed

    private void ChkBxConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkBxConfirmacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkBxConfirmacionActionPerformed

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContinuarActionPerformed
        if (ChkBxConfirmacion.isSelected()) {
            JOptionPane.showMessageDialog(null, "Gracias, se ha registrado su cita, acerquese al local.", "Tesla Inc.", JOptionPane.DEFAULT_OPTION);
            ChkBxConfirmacion.setSelected(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debe marcar la casilla antes de finalizar la operacion", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BtnContinuarActionPerformed

    private void CbxAnioVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxAnioVehiculoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxAnioVehiculoActionPerformed

    private void CbxModeloVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxModeloVehiculoActionPerformed
        filtrarAutos();
    }//GEN-LAST:event_CbxModeloVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBusquedaVehiculo;
    private javax.swing.JButton BtnContinuar;
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JComboBox<String> CbxAnioVehiculo;
    private javax.swing.JComboBox<String> CbxModeloVehiculo;
    private javax.swing.JComboBox<String> CbxPrecioVehiculo;
    private javax.swing.JCheckBox ChkBxConfirmacion;
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
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JSeparator Separador01;
    private javax.swing.JSeparator Separador02;
    private javax.swing.JSeparator Separador03;
    private javax.swing.JTable TblVehiculos;
    private javax.swing.JTextField TxtBusquedaVehiculo;
    private javax.swing.JLabel TxtInformativo01;
    private javax.swing.JLabel TxtInformativo02;
    private javax.swing.JLabel TxtInformativo03;
    private javax.swing.JLabel TxtInformativo04;
    private javax.swing.JLabel TxtSubtitulo;
    private javax.swing.JLabel TxtTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}
