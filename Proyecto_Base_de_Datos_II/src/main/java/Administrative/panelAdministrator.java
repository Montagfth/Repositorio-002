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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        cargarOperacionesAuto();
        cargarSolicitudesAutoparte();
        cargarReservaServicioTres();

        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                TblServicioUno.clearSelection();
                TblEmpleados.clearSelection();
                TblServicioUno.clearSelection();
                TblServicioDos.clearSelection();
                TblServicioTres.clearSelection();
            }
        });
    }

    //Carga de campos insertados en la base de datos MySQL:
    public void cargarReservaServicioTres() {

        try {
            DAOReservaServTres daoRsT = new DAOReservaServTresIMPLEMENT();
            List<ReservaServTres> listarReservaServTres = daoRsT.listarReservaServTres();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"ID SERVICIO:", "Tipo Vehiculo", "Servicio", "DNI Cliente", "Fecha de Cita", "Precio", "DNI Empleado"});

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

    public void cargarOperacionesAuto() {

        try {
            DAOReservaServUno daoRsun = new DAOReservaServUnoIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblServicioUno.getModel();
            model.setRowCount(0);
            daoRsun.listarReservaServUno().forEach((u) -> model.addRow(new Object[]{u.getID_ReservaServUno(), u.getID_Auto(), u.getDNI_Cliente(), u.getEstado_ReservaServUno(), u.getFecha_ReservaServUno()}));

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
        LblTitulo = new javax.swing.JLabel();
        LblSubtitulo = new javax.swing.JLabel();
        JSeparador01 = new javax.swing.JSeparator();
        LblRegistroAutos = new javax.swing.JLabel();
        JSeparador02 = new javax.swing.JSeparator();
        JSPRegistroAutos = new javax.swing.JScrollPane();
        TblServicioUno = new javax.swing.JTable();
        JSeparador03 = new javax.swing.JSeparator();
        BtnEliminarAuto = new javax.swing.JButton();
        BtnModificarAuto = new javax.swing.JButton();
        LblRegistroAutopartes = new javax.swing.JLabel();
        JSeparador04 = new javax.swing.JSeparator();
        JSPRegistroAutopartes = new javax.swing.JScrollPane();
        TblServicioDos = new javax.swing.JTable();
        JSeparador05 = new javax.swing.JSeparator();
        BtnEliminarAutoparte = new javax.swing.JButton();
        BtnModificarAutoparte = new javax.swing.JButton();
        LblMantenimientos = new javax.swing.JLabel();
        JSeparador06 = new javax.swing.JSeparator();
        JSPRegistroMantenimiento = new javax.swing.JScrollPane();
        TblServicioTres = new javax.swing.JTable();
        JSeparador07 = new javax.swing.JSeparator();
        BtnEliminarMantenimiento = new javax.swing.JButton();
        BtnModificarMantenimiento = new javax.swing.JButton();
        JSeparador08 = new javax.swing.JSeparator();
        LblEmpleados = new javax.swing.JLabel();
        JSeparador09 = new javax.swing.JSeparator();
        JSPRegistroEmpleados = new javax.swing.JScrollPane();
        TblEmpleados = new javax.swing.JTable();
        BtnEliminarEmpleado = new javax.swing.JButton();
        BtnModificarEmpleado = new javax.swing.JButton();
        LblClientes = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        JSPRegistroCliente = new javax.swing.JScrollPane();
        TblClientes = new javax.swing.JTable();
        BtnEliminarCliente = new javax.swing.JButton();
        BtnModificarCliente = new javax.swing.JButton();

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        LblTitulo.setText("GESTION DE SERVICIOS");

        LblSubtitulo.setText("Panel de informacion de los registros que se hicieron de las operaciones en el sistema.");

        LblRegistroAutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblRegistroAutos.setText("AUTOS:");

        TblServicioUno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SERVICIO:", "ID Auto: ", "DNI Cliente:", "Condicion:", "Fecha Operacion:"
            }
        ));
        JSPRegistroAutos.setViewportView(TblServicioUno);

        BtnEliminarAuto.setText("ELIMINAR");
        BtnEliminarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarAutoActionPerformed(evt);
            }
        });

        BtnModificarAuto.setText("MODIFICAR");
        BtnModificarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarAutoActionPerformed(evt);
            }
        });

        LblRegistroAutopartes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblRegistroAutopartes.setText("AUTOPARTES");

        TblServicioDos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SERVICIO:", "ID Autoparte:", "DNI Cliente:", "Condicion:", "Fecha Operacion:"
            }
        ));
        JSPRegistroAutopartes.setViewportView(TblServicioDos);

        BtnEliminarAutoparte.setText("ELIMINAR");
        BtnEliminarAutoparte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarAutoparteActionPerformed(evt);
            }
        });

        BtnModificarAutoparte.setText("MODIFICAR");
        BtnModificarAutoparte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarAutoparteActionPerformed(evt);
            }
        });

        LblMantenimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMantenimientos.setText("MANTENIMIENTO");

        TblServicioTres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JSPRegistroMantenimiento.setViewportView(TblServicioTres);

        BtnEliminarMantenimiento.setText("ELIMINAR");
        BtnEliminarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarMantenimientoActionPerformed(evt);
            }
        });

        BtnModificarMantenimiento.setText("MODIFICAR");
        BtnModificarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarMantenimientoActionPerformed(evt);
            }
        });

        LblEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblEmpleados.setText("EMPLEADOS:");

        TblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID:", "Nombre:", "DNI:", "Telefono:", "Fecha de Contratacion:"
            }
        ));
        JSPRegistroEmpleados.setViewportView(TblEmpleados);

        BtnEliminarEmpleado.setText("ELIMINAR");
        BtnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarEmpleadoActionPerformed(evt);
            }
        });

        BtnModificarEmpleado.setText("MODIFICAR");
        BtnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarEmpleadoActionPerformed(evt);
            }
        });

        LblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblClientes.setText("CLIENTES:");

        TblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID:", "Nombre:", "Segundo Nombre:", "Apellido:", "DNI:", "Correo:", "Telef. Principal:", "Telef. Secundario:"
            }
        ));
        JSPRegistroCliente.setViewportView(TblClientes);

        BtnEliminarCliente.setText("ELIMINAR");
        BtnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarClienteActionPerformed(evt);
            }
        });

        BtnModificarCliente.setText("MODIFICAR");
        BtnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblSubtitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JSeparador08, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparador02)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(BtnEliminarAuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(BtnModificarAuto))
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LblRegistroAutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(JSPRegistroAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(JSeparador03))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(BtnEliminarAutoparte)
                                .addGap(210, 210, 210)
                                .addComponent(BtnModificarAutoparte))
                            .addComponent(JSeparador05)
                            .addComponent(LblRegistroAutopartes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JSPRegistroAutopartes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(JSeparador04))
                        .addGap(12, 12, 12)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JSeparador07, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JSeparador06)
                                    .addComponent(LblMantenimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JSPRegistroMantenimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                                .addComponent(BtnEliminarMantenimiento)
                                .addGap(176, 176, 176)
                                .addComponent(BtnModificarMantenimiento))))
                    .addComponent(JSeparador01, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparador09)
                            .addComponent(JSPRegistroEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(BtnEliminarEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnModificarEmpleado))
                            .addComponent(LblEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(411, 411, 411)
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelContenedorLayout.createSequentialGroup()
                                .addComponent(BtnEliminarCliente)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JSPRegistroCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenedorLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnModificarCliente, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(18, 18, 18))
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblRegistroAutos)
                    .addComponent(LblRegistroAutopartes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMantenimientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSeparador04, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSeparador06, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSPRegistroAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JSPRegistroMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JSPRegistroAutopartes, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSeparador07, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSeparador05, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEliminarAuto)
                    .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnModificarAuto)
                        .addComponent(BtnEliminarAutoparte))
                    .addComponent(BtnModificarAutoparte)
                    .addComponent(BtnEliminarMantenimiento)
                    .addComponent(BtnModificarMantenimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparador08, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblEmpleados)
                    .addComponent(LblClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSeparador09, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSPRegistroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(JSPRegistroEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminarEmpleado)
                    .addComponent(BtnModificarEmpleado)
                    .addComponent(BtnModificarCliente)
                    .addComponent(BtnEliminarCliente))
                .addContainerGap())
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

    //Accionamiento de botones y funciones:

    private void BtnModificarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarAutoActionPerformed

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
    }//GEN-LAST:event_BtnModificarAutoActionPerformed

    private void BtnEliminarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarAutoActionPerformed

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
    }//GEN-LAST:event_BtnEliminarAutoActionPerformed

    private void BtnEliminarAutoparteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarAutoparteActionPerformed

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
    }//GEN-LAST:event_BtnEliminarAutoparteActionPerformed

    private void BtnModificarAutoparteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarAutoparteActionPerformed

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
    }//GEN-LAST:event_BtnModificarAutoparteActionPerformed

    private void BtnModificarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarMantenimientoActionPerformed

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
    }//GEN-LAST:event_BtnModificarMantenimientoActionPerformed

    private void BtnEliminarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarMantenimientoActionPerformed

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
    }//GEN-LAST:event_BtnEliminarMantenimientoActionPerformed

    private void BtnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarEmpleadoActionPerformed

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
    }//GEN-LAST:event_BtnModificarEmpleadoActionPerformed

    private void BtnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarEmpleadoActionPerformed

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
    }//GEN-LAST:event_BtnEliminarEmpleadoActionPerformed

    private void BtnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarClienteActionPerformed

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
    }//GEN-LAST:event_BtnModificarClienteActionPerformed

    private void BtnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarClienteActionPerformed

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
    }//GEN-LAST:event_BtnEliminarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminarAuto;
    private javax.swing.JButton BtnEliminarAutoparte;
    private javax.swing.JButton BtnEliminarCliente;
    private javax.swing.JButton BtnEliminarEmpleado;
    private javax.swing.JButton BtnEliminarMantenimiento;
    private javax.swing.JButton BtnModificarAuto;
    private javax.swing.JButton BtnModificarAutoparte;
    private javax.swing.JButton BtnModificarCliente;
    private javax.swing.JButton BtnModificarEmpleado;
    private javax.swing.JButton BtnModificarMantenimiento;
    private javax.swing.JScrollPane JSPRegistroAutopartes;
    private javax.swing.JScrollPane JSPRegistroAutos;
    private javax.swing.JScrollPane JSPRegistroCliente;
    private javax.swing.JScrollPane JSPRegistroEmpleados;
    private javax.swing.JScrollPane JSPRegistroMantenimiento;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JSeparator JSeparador04;
    private javax.swing.JSeparator JSeparador05;
    private javax.swing.JSeparator JSeparador06;
    private javax.swing.JSeparator JSeparador07;
    private javax.swing.JSeparator JSeparador08;
    private javax.swing.JSeparator JSeparador09;
    private javax.swing.JLabel LblClientes;
    private javax.swing.JLabel LblEmpleados;
    private javax.swing.JLabel LblMantenimientos;
    private javax.swing.JLabel LblRegistroAutopartes;
    private javax.swing.JLabel LblRegistroAutos;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JTable TblClientes;
    private javax.swing.JTable TblEmpleados;
    private javax.swing.JTable TblServicioDos;
    private javax.swing.JTable TblServicioTres;
    private javax.swing.JTable TblServicioUno;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
