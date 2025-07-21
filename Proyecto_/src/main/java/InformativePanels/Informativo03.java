/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package InformativePanels;

import Panels.panelInformativo;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Fabrizio
 */
public class Informativo03 extends javax.swing.JPanel {

    /**
     * Creates new form Informativo03
     */
    public Informativo03() {
        initComponents();
    }

    public void mostrarPaneles(JPanel panel) {
        
        PanelContenedor.removeAll();
        PanelContenedor.add(panel, BorderLayout.CENTER);
        PanelContenedor.revalidate();
        PanelContenedor.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        TxtTitulo = new javax.swing.JLabel();
        TxtInformativo01 = new javax.swing.JLabel();
        Separador01 = new javax.swing.JSeparator();
        TxtInformativo02 = new javax.swing.JLabel();
        TxtInformativo03 = new javax.swing.JLabel();
        Separador02 = new javax.swing.JSeparator();
        TxtInformativo04 = new javax.swing.JLabel();
        TxtInformativo05 = new javax.swing.JLabel();
        TxtInformativo06 = new javax.swing.JLabel();
        Separador03 = new javax.swing.JSeparator();
        TxtInformativo07 = new javax.swing.JLabel();
        TxtInformativo08 = new javax.swing.JLabel();
        TxtInformativo09 = new javax.swing.JLabel();
        Separador04 = new javax.swing.JSeparator();
        TxtInformativo10 = new javax.swing.JLabel();
        TxtInformativo11 = new javax.swing.JLabel();
        BtnRetornar = new javax.swing.JButton();
        Separador2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        TxtTitulo.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        TxtTitulo.setText("AÑO 2008 | LANZAMIENTO DE ROADSTER");

        TxtInformativo01.setText("Tesla lanza su primer automóvil comercial: el \"Tesla Roadster\", un deportivo eléctrico.");

        TxtInformativo02.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TxtInformativo02.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TxtInformativo02.setText("· BASADO EN:");

        TxtInformativo03.setText("- Lotus Elise, pero con tren motriz 100% eléctrico.");

        TxtInformativo04.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TxtInformativo04.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TxtInformativo04.setText("· ESPECIFICACIONES CLAVE:");

        TxtInformativo05.setText("- 0-100 km/h en 3.9 segundos.");

        TxtInformativo06.setText("- Autonomía de hasta 393 km con una sola carga.");

        TxtInformativo07.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TxtInformativo07.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TxtInformativo07.setText("· IMPORTANCIA HISTORICA:");

        TxtInformativo08.setText("- Demuestra que los autos eléctricos pueden ser rápidos, atractivos y funcionales.");

        TxtInformativo09.setText("- Pone a Tesla en el radar global.");

        TxtInformativo10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TxtInformativo10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TxtInformativo10.setText("· PRODUCCION LIMITADA:");

        TxtInformativo11.setText("- Cerca de 2,450 unidades vendidas hasta 2012.");

        BtnRetornar.setText("RETORNAR");
        BtnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetornarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6.png"))); // NOI18N

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Separador01, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtTitulo)
                            .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnRetornar)
                                .addGroup(PanelContenedorLayout.createSequentialGroup()
                                    .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtInformativo02)
                                        .addComponent(TxtInformativo03)
                                        .addComponent(TxtInformativo04)
                                        .addComponent(TxtInformativo05)
                                        .addComponent(TxtInformativo06)
                                        .addComponent(TxtInformativo07)
                                        .addComponent(TxtInformativo08)
                                        .addComponent(TxtInformativo09)
                                        .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Separador04, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Separador03, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Separador02, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtInformativo01, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                                        .addComponent(TxtInformativo10)
                                        .addComponent(TxtInformativo11))
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel1))))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContenedorLayout.createSequentialGroup()
                .addComponent(TxtTitulo)
                .addGap(18, 18, 18)
                .addComponent(Separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtInformativo01)
                .addGap(18, 18, 18)
                .addComponent(Separador01, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelContenedorLayout.createSequentialGroup()
                        .addComponent(TxtInformativo02)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo03)
                        .addGap(18, 18, 18)
                        .addComponent(Separador02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(TxtInformativo04)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo05)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo06)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Separador03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(TxtInformativo07)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo08)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo09)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Separador04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(TxtInformativo10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtInformativo11))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(BtnRetornar)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetornarActionPerformed
        mostrarPaneles(new panelInformativo());
    }//GEN-LAST:event_BtnRetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetornar;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JSeparator Separador01;
    private javax.swing.JSeparator Separador02;
    private javax.swing.JSeparator Separador03;
    private javax.swing.JSeparator Separador04;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JLabel TxtInformativo01;
    private javax.swing.JLabel TxtInformativo02;
    private javax.swing.JLabel TxtInformativo03;
    private javax.swing.JLabel TxtInformativo04;
    private javax.swing.JLabel TxtInformativo05;
    private javax.swing.JLabel TxtInformativo06;
    private javax.swing.JLabel TxtInformativo07;
    private javax.swing.JLabel TxtInformativo08;
    private javax.swing.JLabel TxtInformativo09;
    private javax.swing.JLabel TxtInformativo10;
    private javax.swing.JLabel TxtInformativo11;
    private javax.swing.JLabel TxtTitulo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
