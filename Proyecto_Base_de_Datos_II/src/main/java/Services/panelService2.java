/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Services;

import Panels.panelInformativo;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Database.*;
import DatabaseModels.*;
import Interfaces.*;
import Model.*;
import View.loginPrototipo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabrizio
 */
public class panelService2 extends javax.swing.JPanel {

    /**
     * Creates new form panelService2
     */
    public panelService2() {
        initComponents();
        //cargaDatosPrueba();
        configuracionEventosTabla();
        cargaAutopartes();

        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                TblAutopartes.clearSelection();
                Descripcion01.setText("SELECCIONE UN ELEMENTO PARA VER SUS DETALLES");
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

    public void cargaAutopartes() {
        try {
            DAOAutopartes daoAu = new DAOAutopartesIMPLEMENT();
            DefaultTableModel model = (DefaultTableModel) TblAutopartes.getModel();
            model.setRowCount(0);

            daoAu.Listar("").forEach((u) -> model.addRow(new Object[]{u.getID_Autoparte(), u.getNombre_Autoparte(), u.getCategoria_Autoparte(), u.getStock_Autoparte(), u.getPrecio_Autoparte()}));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarTabla(List<Autopartes> listaAutopartes) {
        DefaultTableModel model = (DefaultTableModel) TblAutopartes.getModel();
        model.setRowCount(0);

        for (Autopartes a : listaAutopartes) {
            Object[] fila = {a.getID_Autoparte(), a.getNombre_Autoparte(), a.getCategoria_Autoparte(), a.getStock_Autoparte(), a.getPrecio_Autoparte()};

            model.addRow(fila);
        }
    }

    public void configuracionEventosTabla() {
        //Evento de seleccion dinamica para evitar el uso de botones.
        TblAutopartes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = TblAutopartes.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Extraer datos de la fila seleccionada
                    String nombre = TblAutopartes.getValueAt(filaSeleccionada, 1).toString();
                    String categoria = TblAutopartes.getValueAt(filaSeleccionada, 2).toString();
                    String stock = TblAutopartes.getValueAt(filaSeleccionada, 3).toString();
                    String precio = TblAutopartes.getValueAt(filaSeleccionada, 4).toString();

                    // Actualizar etiquetas
                    Descripcion01.setText("Nombre: " + nombre);
                    Descripcion02.setText("Categoría: " + categoria);
                    Descripcion03.setText("Stock: " + stock);
                    Descripcion04.setText("Precio: S/. " + precio);

                    //Adecuar a las dimensiones del panel, caso contrario se distorcionara junto con el jframe.
                    //Acortar informacion
                    Descripcion05.setText("Batería de alto rendimiento de iones de litio.");
                    Descripcion06.setText("Compatible con modelos Tesla S, 3, X y Y.");
                    Descripcion07.setText("Código de pieza: TESLA-BAT-85KW-LONGRANGE");
                    Descripcion08.setText("Estado: Nuevo | Garantía de fábrica: 8 años");
                    Descripcion09.setText("Disponibilidad: En almacén principal");
                    Descripcion10.setText("Autonomía estimada: hasta 600 km por carga");
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
        DefaultTableModel modelo = (DefaultTableModel) TblRepuestos.getModel();
        modelo.setRowCount(0); // Limpia las filas existentes

        modelo.addRow(new Object[]{"001", "Pastilla Freno", "Frenos", "25", "120.00"});
        modelo.addRow(new Object[]{"002", "Amortiguador Delantero", "Suspensión", "15", "350.00"});
        modelo.addRow(new Object[]{"003", "Filtro de Aceite", "Motor", "40", "45.50"});
        modelo.addRow(new Object[]{"004", "Bujía", "Encendido", "60", "22.90"});

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
        LblCategoriasAutoparte = new javax.swing.JLabel();
        CbxCategoriaAutoparte = new javax.swing.JComboBox<>();
        JSeparador02 = new javax.swing.JSeparator();
        JSPRegistroAutoparte = new javax.swing.JScrollPane();
        TblAutopartes = new javax.swing.JTable();
        JSeparador03 = new javax.swing.JSeparator();
        BtnRetornar = new javax.swing.JButton();
        PnlDescripcionAutoparte = new javax.swing.JPanel();
        LblProductoImagen = new javax.swing.JLabel();
        PnlProductoDescripcion = new javax.swing.JPanel();
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
        BtnSolictarAutoparte = new javax.swing.JButton();

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        LblTitulo.setText("REPUESTOS & AUTOPARTES");

        LblSubtitulo.setText("Seleccione alguna categoria en los campos para la busqueda de la pieza:");

        LblCategoriasAutoparte.setText("CATEGORIAS:");

        CbxCategoriaAutoparte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FRENOS", "LUCES", "LLANTAS", "ELECTRONICA" }));
        CbxCategoriaAutoparte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxCategoriaAutoparteActionPerformed(evt);
            }
        });

        TblAutopartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID:", "NOMBRE:", "CATEGORIA:", "STOCK:", "PRECIO:"
            }
        ));
        JSPRegistroAutoparte.setViewportView(TblAutopartes);

        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        PnlDescripcionAutoparte.setBackground(new java.awt.Color(255, 255, 255));

        LblProductoImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblProductoImagen.setText("[IMAGEN REPUESTO] (DINAMICO)");

        Descripcion01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Descripcion01.setText("SELECCIONE UN ELEMENTO PARA VER SUS DETALLES");

        Descripcion02.setText(" ");

        Descripcion03.setText(" ");

        Descripcion04.setText(" ");

        Descripcion05.setText(" ");

        Descripcion06.setText(" ");

        Descripcion07.setText(" ");

        Descripcion08.setText(" ");

        Descripcion09.setText(" ");

        Descripcion10.setText(" ");

        BtnSolictarAutoparte.setText("SOLICITAR PIEZA");
        BtnSolictarAutoparte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSolictarAutoparteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlProductoDescripcionLayout = new javax.swing.GroupLayout(PnlProductoDescripcion);
        PnlProductoDescripcion.setLayout(PnlProductoDescripcionLayout);
        PnlProductoDescripcionLayout.setHorizontalGroup(
            PnlProductoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlProductoDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlProductoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Descripcion01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Descripcion10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlProductoDescripcionLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(BtnSolictarAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        PnlProductoDescripcionLayout.setVerticalGroup(
            PnlProductoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlProductoDescripcionLayout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion09)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Descripcion10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSolictarAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PnlDescripcionAutoparteLayout = new javax.swing.GroupLayout(PnlDescripcionAutoparte);
        PnlDescripcionAutoparte.setLayout(PnlDescripcionAutoparteLayout);
        PnlDescripcionAutoparteLayout.setHorizontalGroup(
            PnlDescripcionAutoparteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDescripcionAutoparteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PnlDescripcionAutoparteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PnlProductoDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblProductoImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PnlDescripcionAutoparteLayout.setVerticalGroup(
            PnlDescripcionAutoparteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDescripcionAutoparteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LblProductoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlProductoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PnlContenedorGeneralLayout = new javax.swing.GroupLayout(PnlContenedorGeneral);
        PnlContenedorGeneral.setLayout(PnlContenedorGeneralLayout);
        PnlContenedorGeneralLayout.setHorizontalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addComponent(LblCategoriasAutoparte)
                        .addGap(18, 18, 18)
                        .addComponent(CbxCategoriaAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSeparador01)
                    .addComponent(LblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addComponent(JSeparador02)
                    .addComponent(JSPRegistroAutoparte)
                    .addComponent(BtnRetornar)
                    .addComponent(JSeparador03)
                    .addComponent(LblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(PnlDescripcionAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        PnlContenedorGeneralLayout.setVerticalGroup(
            PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblSubtitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JSeparador01, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PnlContenedorGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CbxCategoriaAutoparte, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(LblCategoriasAutoparte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(JSeparador02, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JSPRegistroAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JSeparador03, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlContenedorGeneralLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(PnlDescripcionAutoparte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(BtnRetornar)
                .addContainerGap())
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

    private void CbxCategoriaAutoparteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxCategoriaAutoparteActionPerformed
        //Filtro por el cbox
        String categoriaSeleccionada = CbxCategoriaAutoparte.getSelectedItem().toString();

        String categoriaFiltro = categoriaSeleccionada.equalsIgnoreCase("TODOS") ? "" : categoriaSeleccionada;

        try {
            DAOAutopartes daoAu = new DAOAutopartesIMPLEMENT();
            List<Autopartes> lista = daoAu.Listar(categoriaFiltro);
            actualizarTabla(lista);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_CbxCategoriaAutoparteActionPerformed


    private void BtnSolictarAutoparteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSolictarAutoparteActionPerformed

        int fila = TblAutopartes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una autoparte para ver sus detalles", "Tesla Inc.", JOptionPane.WARNING_MESSAGE);
        }

        int response = JOptionPane.showConfirmDialog(null, "¿Esta seguro de solictar la pieza?", "Tesla Inc.", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {

            try {
                int idAutoparte = (int) TblAutopartes.getValueAt(fila, 0); // Asegúrate que la primera columna sea el ID
                String dniCliente = Sesion.clienteLogueado.getDNI_Cliente(); // Método que devuelve el DNI del cliente autenticado

                ReservaServDos reserva = new ReservaServDos();
                reserva.setID_Autoparte(idAutoparte);
                reserva.setDNI_Cliente(dniCliente);

                DAOReservaServDos daoRsD = new DAOReservaServDosIMPLEMENT();
                daoRsD.registrar(reserva);

                JOptionPane.showMessageDialog(null, "Se ha solicitado correctamente.", "Tesla Inc.", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


            /*
                  try {
                //Pensar en las columnas que vera el administrador.
                int idAutoparte = Integer.parseInt(TblRepuestos.getValueAt(fila, 0).toString());
                int idCliente = 
                
                
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
             */
        } else {
            //Not to programm here.
        }


    }//GEN-LAST:event_BtnSolictarAutoparteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JButton BtnSolictarAutoparte;
    private javax.swing.JComboBox<String> CbxCategoriaAutoparte;
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
    private javax.swing.JScrollPane JSPRegistroAutoparte;
    private javax.swing.JSeparator JSeparador01;
    private javax.swing.JSeparator JSeparador02;
    private javax.swing.JSeparator JSeparador03;
    private javax.swing.JLabel LblCategoriasAutoparte;
    private javax.swing.JLabel LblProductoImagen;
    private javax.swing.JLabel LblSubtitulo;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PnlContenedorGeneral;
    private javax.swing.JPanel PnlDescripcionAutoparte;
    private javax.swing.JPanel PnlProductoDescripcion;
    private javax.swing.JTable TblAutopartes;
    // End of variables declaration//GEN-END:variables
}
