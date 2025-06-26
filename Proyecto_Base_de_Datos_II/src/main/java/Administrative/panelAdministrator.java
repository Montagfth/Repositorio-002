/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Administrative;

import Interfaces.DAOEmpleado;
import Model.DAOEmpleadosIMPLEMENT;
import javax.swing.table.DefaultTableModel;
import Interfaces.*;
import DatabaseModels.*;
import Model.DAOClienteIMPLEMENT;
import Model.DAOReservaServDosIMPLEMENT;
import Model.DAOReservaServTresIMPLEMENT;
import Model.DAOReservaServUnoIMPLEMENT;
import Modificaciones.DialogEditarCliente;
import Modificaciones.DialogEditarEmpleado;
import Modificaciones.DialogEditarReservaAuto;
import Modificaciones.DialogEditarReservaAutoparte;
import Modificaciones.DialogEditarReservaServMantenimiento;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabrizio
 */
public class panelAdministrator extends javax.swing.JPanel {

    /**
     * Creates new form panelAdministrator
     */
    public panelAdministrator() {
        initComponents();
        cargarEmpleados();
        cargarClientes();
        //Experimental
        cargarOperacionesAuto();
        cargarSolicitudesAutoparte();
        cargarReservaServicioTres();
    }

    public void cargarReservaServicioTres() {

        try {
            DAOReservaServTres daoRsT = new DAOReservaServTresIMPLEMENT();
            List<ReservaServTres> listarReservaServTres = daoRsT.listarReservaServTres();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"ID", "Tipo Vehiculo", "Servicio", "DNI Cliente", "Fecha de Cita", "Precio", "DNI Empleado"});

            for (ReservaServTres r : listarReservaServTres) {
                model.addRow(new Object[]{
                    r.getIdReserva(),
                    r.getTipoVehiculo(),
                    r.getServicioSolicitado(),
                    r.getDniCliente(),
                    r.getFechaCita(),
                    r.getPrecio(),
                    r.getDniEmpleado() == null ? "No asignado" : r.getDniEmpleado()
                });
            }

            TblServicioTres.setModel(model);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cargarSolicitudesAutoparte() {
        try {
            DAOReservaServDos daoRsD = new DAOReservaServDosIMPLEMENT();
            List<ReservaServDos> listarReservServDos = daoRsD.listarReservasServDos();

            DefaultTableModel model = (DefaultTableModel) TblServicioDos.getModel();
            model.setRowCount(0);

            for (ReservaServDos r : listarReservServDos) {
                model.addRow(new Object[]{
                    r.getID_ReservaServDos(),
                    r.getID_Autoparte(),
                    r.getDNI_Cliente(),
                    r.getEstado_ReservaServDos(),
                    r.getFecha_ReservaServDos()
                });
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Por evaluar
    public void cargarOperacionesAuto() {
        try {
            DAOReservaServUno daoRsun = new DAOReservaServUnoIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblServicioUno.getModel();
            model.setRowCount(0);
            daoRsun.listarReservaServUno().forEach((u) -> model.addRow(new Object[]{u.getID_ReservaServUno(), u.getID_Auto(), u.getDNI_Cliente(),u.getEstado_ReservaServUno(), u.getFecha_ReservaServUno()}));

        } catch (Exception e) {
            System.out.println("Error en la carga de operaciones del servicio 1");
        }
    }

    public void cargarEmpleados() {
        try {
            DAOEmpleado daoA = new DAOEmpleadosIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblEmpleados.getModel();
            model.setRowCount(0);
            daoA.listarEmpleado("").forEach((u) -> model.addRow(new Object[]{u.getID_Empleado(), u.getNombre_Empleado(), u.getDNI_Empleado(),
                u.getTelefono_Empleado(), u.getFechaContratacion_Empleado()}));

        } catch (Exception e) {
            System.out.println("Error en la carga de empleados: " + e.getMessage());
        }
        //Bloque de tabla por analizar:
        //TblClientes.setEnabled(false);
    }

    public void cargarClientes() {
        try {
            DAOCliente daoCl = new DAOClienteIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblClientes.getModel();
            model.setRowCount(0);
            daoCl.listarCliente("").forEach((u) -> model.addRow(new Object[]{u.getID_Cliente(), u.getNombre_Cliente(), u.getSegundoNombre_Cliente(),
                u.getApellido_Cliente(), u.getDNI_Cliente(), u.getCorreo_Cliente(), u.getTelefono_Cliente(), u.getSegundoTelefono_Cliente()}));

        } catch (Exception e) {
            System.out.println("Error en la carga de clientes: " + e.getMessage());
        }
        //Bloque de tabla por analizar:
        //TblClientes.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblServicioUno = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblServicioDos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblServicioTres = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblEmpleados = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblClientes = new javax.swing.JTable();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        btModficar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        btnEliminar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnEliminar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        btnEliminar4 = new javax.swing.JButton();
        btnModificar4 = new javax.swing.JButton();
        btnEliminar5 = new javax.swing.JButton();
        btnModificar5 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("GESTION DE SERVICIOS");

        jLabel2.setText("Panel de informacion de los registros que se hicieron de las operaciones en el sistema.");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AUTOS:");

        TblServicioUno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_ReservaServUno", "ID_Auto", "DNI_Cliente", "Estado_ReservaServUno", "Fecha_ReservaServUno"
            }
        ));
        jScrollPane1.setViewportView(TblServicioUno);

        TblServicioDos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_ReservaDos", "ID_Autoparte", "DNI_Cliente", "Estado_ReservaDos", "Fecha_ReservaDos"
            }
        ));
        jScrollPane2.setViewportView(TblServicioDos);

        TblServicioTres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TblServicioTres);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("AUTOPARTES");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MANTENIMIENTO");

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        TblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "DNI", "Telefono", "Contratacion"
            }
        ));
        jScrollPane4.setViewportView(TblEmpleados);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EMPLEADOS:");

        TblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Segundo Nombre", "Apellido", "DNI", "Correo", "Telef. Principal", "TELEF. SECUNDARIO"
            }
        ));
        jScrollPane5.setViewportView(TblClientes);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CLIENTES:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MANIPULACION DE DATOS:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Para la eliminacion de algun registro:");

        btModficar.setText("MODIFICAR");
        btModficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModficarActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Seleccione una fila para modificarla:");

        btnEliminar2.setText("ELIMINAR");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        btnModificar2.setText("MODIFICAR");
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnEliminar3.setText("ELIMINAR");
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });

        btnModificar3.setText("MODIFICAR");
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnEliminar4.setText("ELIMINAR");
        btnEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar4ActionPerformed(evt);
            }
        });

        btnModificar4.setText("MODIFICAR");
        btnModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar4ActionPerformed(evt);
            }
        });

        btnEliminar5.setText("ELIMINAR");
        btnEliminar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar5ActionPerformed(evt);
            }
        });

        btnModificar5.setText("MODIFICAR");
        btnModificar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btModficar))
                            .addComponent(jSeparator10))
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                    .addComponent(jSeparator4)))
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                                        .addComponent(btnEliminar2)
                                        .addGap(236, 236, 236)
                                        .addComponent(btnModificar2))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(btnEliminar3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar3))
                            .addComponent(jSeparator12)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8)
                            .addComponent(jSeparator9)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(btnEliminar4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar5))
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(btnModificar4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar5))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEliminar)
                                    .addComponent(btModficar)
                                    .addComponent(btnEliminar3)
                                    .addComponent(btnModificar3)))
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEliminar2)
                                    .addComponent(btnModificar2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEliminar4)
                                    .addComponent(btnEliminar5))
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificar4)
                                    .addComponent(btnModificar5)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
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

    private void btModficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModficarActionPerformed
        int fila = TblServicioUno.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila primero", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idReserva = (int) TblServicioUno.getValueAt(fila, 0);
        String estadoActual = TblServicioUno.getValueAt(fila, 2).toString();
        String fechaActual = TblServicioUno.getValueAt(fila, 3).toString();

        //Accionador del jdialog
        DialogEditarReservaAuto dialog = new DialogEditarReservaAuto(null, idReserva, estadoActual, fechaActual);
        dialog.setVisible(true);

        cargarOperacionesAuto();
    }//GEN-LAST:event_btModficarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = TblServicioUno.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                int idReserva = (int) TblServicioUno.getValueAt(fila, 0);
                DAOReservaServUno daorsu = new DAOReservaServUnoIMPLEMENT();
                daorsu.eliminar(idReserva);

                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
                cargarOperacionesAuto();

            } catch (Exception e) {
                System.out.println("Error al eliminar fila." + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        int fila = TblServicioDos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                int idReserva = (int) TblServicioUno.getValueAt(fila, 0);
                DAOReservaServUno daorsu = new DAOReservaServUnoIMPLEMENT();
                daorsu.eliminar(idReserva);

                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
                cargarSolicitudesAutoparte();

            } catch (Exception e) {
                System.out.println("Error al eliminar fila." + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        int fila = TblServicioDos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila primero", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idReserva = (int) TblServicioDos.getValueAt(fila, 0);
        String estadoActual = TblServicioDos.getValueAt(fila, 3).toString();
        String fechaActual = TblServicioDos.getValueAt(fila, 4).toString();

        //Accionador del jdialog
        DialogEditarReservaAutoparte dialog = new DialogEditarReservaAutoparte(null, idReserva, estadoActual, fechaActual);
        dialog.setVisible(true);

        cargarSolicitudesAutoparte();
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        int fila = TblServicioTres.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) TblServicioTres.getValueAt(fila, 0);
        String fechaActual = TblServicioTres.getValueAt(fila, 4).toString();

        DialogEditarReservaServMantenimiento dialog = new DialogEditarReservaServMantenimiento(null, id, fechaActual);
        dialog.setVisible(true);

        cargarReservaServicioTres();
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed

        int fila = TblServicioTres.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila primero", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el registro?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int idReserva = (int) TblServicioTres.getValueAt(fila, 0);
                DAOReservaServTres daorst = new DAOReservaServTresIMPLEMENT();
                daorst.eliminar(idReserva);

                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "Tesla Inc", JOptionPane.INFORMATION_MESSAGE);
                cargarReservaServicioTres();

            } catch (Exception e) {
                System.out.println("Error al eliminar" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminar3ActionPerformed

    private void btnModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar4ActionPerformed
        int fila = TblEmpleados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila primero.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idEmpleado = (int) TblEmpleados.getValueAt(fila, 0);
        String nombre = TblEmpleados.getValueAt(fila, 1).toString();
        String dni = TblEmpleados.getValueAt(fila, 2).toString();
        String telefono = TblEmpleados.getValueAt(fila, 3).toString();

        DialogEditarEmpleado dialog = new DialogEditarEmpleado(null, idEmpleado, nombre, dni, telefono);
        dialog.setVisible(true);
        cargarEmpleados(); // Método que recarga la tabla después de modificar
    }//GEN-LAST:event_btnModificar4ActionPerformed

    private void btnEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar4ActionPerformed
        int fila = TblEmpleados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila primero.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
                null, "¿Está seguro de eliminar este empleado?", "Tesla Inc.",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                int idEmpleado = (int) TblEmpleados.getValueAt(fila, 0);
                DAOEmpleado dao = new DAOEmpleadosIMPLEMENT();
                dao.eliminarEmpleado(idEmpleado);

                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
                cargarEmpleados(); // Método que recarga la tabla
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage(), "Tesla Inc.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminar4ActionPerformed

    private void btnModificar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar5ActionPerformed

        int fila = TblClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente c = new Cliente();
        c.setID_Cliente((int) TblClientes.getValueAt(fila, 0));
        c.setNombre_Cliente(TblClientes.getValueAt(fila, 1).toString());
        c.setSegundoNombre_Cliente(TblClientes.getValueAt(fila, 2).toString());
        c.setApellido_Cliente(TblClientes.getValueAt(fila, 3).toString());
        c.setDNI_Cliente(TblClientes.getValueAt(fila, 4).toString());
        c.setCorreo_Cliente(TblClientes.getValueAt(fila, 5).toString());
        c.setTelefono_Cliente(TblClientes.getValueAt(fila, 6).toString()); //Analizar
        c.setSegundoTelefono_Cliente(TblClientes.getValueAt(fila, 7).toString()); //Analizar

        DialogEditarCliente dialog = new DialogEditarCliente(null, c);
        dialog.setVisible(true);
        cargarClientes();
    }//GEN-LAST:event_btnModificar5ActionPerformed

    private void btnEliminar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar5ActionPerformed
        int fila = TblClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente primero.");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este cliente?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            try {
                int idCliente = (int) TblClientes.getValueAt(fila, 0);
                DAOCliente dao = new DAOClienteIMPLEMENT();
                dao.eliminar(idCliente);
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                cargarClientes();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminar5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JTable TblClientes;
    private javax.swing.JTable TblEmpleados;
    private javax.swing.JTable TblServicioDos;
    private javax.swing.JTable TblServicioTres;
    private javax.swing.JTable TblServicioUno;
    private javax.swing.JButton btModficar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnEliminar4;
    private javax.swing.JButton btnEliminar5;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnModificar4;
    private javax.swing.JButton btnModificar5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
