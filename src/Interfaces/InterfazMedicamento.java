package Interfaces;

import Implementaciones.MedicamentoImplementacion;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import com.formdev.flatlaf.FlatIntelliJLaf;
//import com.formdev.flatlaf.FlatLaf;
import Modelos.Medicamento;


/**
 *
 * @author ulseg
 */
public class InterfazMedicamento extends javax.swing.JFrame {

    public InterfazMedicamento() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void mensajeAdvertencia(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null,mensaje,titulo,0);
    }
    public void mensajeInformativo(String mensaje, String titulo){
        JOptionPane.showInternalMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void activarMedicamento(boolean activado){
        pnlMedicamentoDatos.setEnabled(activado);
        txtNameMedicamento.setEnabled(activado);
        lblNombreMedicamento.setEnabled(activado);
        txtDescripcionMedicamento.setEnabled(activado);
        lblDescripcionMedicamento.setEnabled(activado);
        btnLimpiarMedicamento.setEnabled(activado);
        btnRegistroMedicamento.setEnabled(activado);
        btnBusquedaMedicamento.setEnabled(!activado);
    }
    
    public void limpiarMedicamento(){
        ///Se limpia el campo de texto
        txtNameMedicamento.setText("");
        txtDescripcionMedicamento.setText("");
    }
    
    public void listarRegistrosMedicamento(){ ///Funcion para actualizar la lista acorde a los criterios seleccionados al momento
        MetodosMedicamento metodosMedicamento = new MedicamentoImplementacion();
        try {
            tblMedicamento.setModel(metodosMedicamento.recuperarRegistrosMedicamento
            (cmbOrdenMedicamento.getSelectedIndex(),txtBuscaMedicamento.getText()));
            
        } catch (Exception ex) {
            Logger.getLogger(InterfazMedicamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean validarDatos(){
        // Validación del nombre del principio activo
        if (txtNameMedicamento.getText().equals("") || 
                txtNameMedicamento.getText().equals("Nombre del medicamento") || 
                txtNameMedicamento.getText().equals("Ingrese el nombre del medicamento")) {
            mensajeAdvertencia("El nombre del medicamento es inválido.\n"
                    + "Favor de verificar que:\n"
                    + "-> No contenga acentos\n"
                    + "-> No contenga caracteres especiales\n"
                    + "-> Haya registrado correctamente el nombre del medicamento\n", "Nombre inválido");
            return false;
        }

        // Validación de la descripción del principio activo
        if (txtDescripcionMedicamento.getText().equals("") || 
                txtDescripcionMedicamento.getText().equals("Descripción del medicamento") || 
                txtDescripcionMedicamento.getText().equals("Ingrese la descripción del medicamento")) {
            mensajeAdvertencia("La descripción del medicamento es inválida.\n"
                    + "Favor de verificar que:\n"
                    + "-> No esté vacía\n"
                    + "-> Haya registrado correctamente la descripción del medicamento\n", "Descripción inválida");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblMedicamento = new javax.swing.JLabel();
        btnBusquedaMedicamento = new javax.swing.JButton();
        txtBuscaMedicamento = new javax.swing.JTextField();
        btnNewMedicamento = new javax.swing.JButton();
        pnlMedicamentoDatos = new javax.swing.JPanel();
        lblNombreMedicamento = new javax.swing.JLabel();
        txtNameMedicamento = new javax.swing.JTextField();
        btnRegistroMedicamento = new javax.swing.JButton();
        btnEliminarMedicamento = new javax.swing.JButton();
        btnActualizarMedicamento = new javax.swing.JButton();
        btnLimpiarMedicamento = new javax.swing.JButton();
        lblDescripcionMedicamento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionMedicamento = new javax.swing.JTextArea();
        pnlFiltradoMedicamento = new javax.swing.JPanel();
        lblFiltroMedicamento = new javax.swing.JLabel();
        cmbOrdenMedicamento = new javax.swing.JComboBox<>();
        pnlRegistrosMedicamento = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamento = new javax.swing.JTable();
        btnDeseleccionMedicamento = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblMedicamento.setText("Medicamento:");

        btnBusquedaMedicamento.setText("Buscar medicamento");

        txtBuscaMedicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaMedicamentoKeyPressed(evt);
            }
        });

        btnNewMedicamento.setText("Nuevo Medicamento");
        btnNewMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMedicamentoActionPerformed(evt);
            }
        });

        pnlMedicamentoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del medicamento\n"));
        pnlMedicamentoDatos.setToolTipText("");
        pnlMedicamentoDatos.setEnabled(false);

        lblNombreMedicamento.setText("Medicamento:");
        lblNombreMedicamento.setEnabled(false);

        txtNameMedicamento.setText("Nombre del medicamento");
        txtNameMedicamento.setEnabled(false);
        txtNameMedicamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameMedicamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameMedicamentoFocusLost(evt);
            }
        });

        btnRegistroMedicamento.setText("Registrar medicamento");
        btnRegistroMedicamento.setEnabled(false);
        btnRegistroMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroMedicamentoActionPerformed(evt);
            }
        });

        btnEliminarMedicamento.setText("Eliminar medicamento");
        btnEliminarMedicamento.setEnabled(false);
        btnEliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMedicamentoActionPerformed(evt);
            }
        });

        btnActualizarMedicamento.setText("Actualizar medicamento ");
        btnActualizarMedicamento.setEnabled(false);
        btnActualizarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMedicamentoActionPerformed(evt);
            }
        });

        btnLimpiarMedicamento.setText("Limpiar campos");
        btnLimpiarMedicamento.setEnabled(false);
        btnLimpiarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMedicamentoActionPerformed(evt);
            }
        });

        lblDescripcionMedicamento.setText("Descripción:");
        lblDescripcionMedicamento.setEnabled(false);

        txtDescripcionMedicamento.setColumns(20);
        txtDescripcionMedicamento.setLineWrap(true);
        txtDescripcionMedicamento.setRows(5);
        txtDescripcionMedicamento.setText("Descripción del medicamento");
        txtDescripcionMedicamento.setToolTipText("");
        txtDescripcionMedicamento.setEnabled(false);
        txtDescripcionMedicamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionMedicamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionMedicamentoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionMedicamento);

        pnlFiltradoMedicamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filtrar tabla mediante"));

        lblFiltroMedicamento.setText("Orden de despliegue");

        cmbOrdenMedicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        cmbOrdenMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenMedicamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltradoMedicamentoLayout = new javax.swing.GroupLayout(pnlFiltradoMedicamento);
        pnlFiltradoMedicamento.setLayout(pnlFiltradoMedicamentoLayout);
        pnlFiltradoMedicamentoLayout.setHorizontalGroup(
            pnlFiltradoMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltradoMedicamentoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlFiltradoMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFiltroMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOrdenMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFiltradoMedicamentoLayout.setVerticalGroup(
            pnlFiltradoMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltradoMedicamentoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblFiltroMedicamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbOrdenMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMedicamentoDatosLayout = new javax.swing.GroupLayout(pnlMedicamentoDatos);
        pnlMedicamentoDatos.setLayout(pnlMedicamentoDatosLayout);
        pnlMedicamentoDatosLayout.setHorizontalGroup(
            pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedicamentoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarMedicamento)
                    .addGroup(pnlMedicamentoDatosLayout.createSequentialGroup()
                        .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreMedicamento)
                            .addComponent(lblDescripcionMedicamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNameMedicamento)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarMedicamento)
                    .addComponent(btnEliminarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(pnlFiltradoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlMedicamentoDatosLayout.setVerticalGroup(
            pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedicamentoDatosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltradoMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMedicamentoDatosLayout.createSequentialGroup()
                        .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreMedicamento)
                            .addComponent(txtNameMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistroMedicamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMedicamentoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMedicamentoDatosLayout.createSequentialGroup()
                                .addComponent(btnEliminarMedicamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizarMedicamento))
                            .addComponent(lblDescripcionMedicamento)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarMedicamento)))
                .addContainerGap())
        );

        pnlRegistrosMedicamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registros existentes:"));

        tblMedicamento.setAutoCreateRowSorter(true);
        tblMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Medicamento", "Descripción"
            }
        ));
        tblMedicamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblMedicamento.setAutoscrolls(false);
        tblMedicamento.setShowGrid(false);
        tblMedicamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblMedicamentoFocusGained(evt);
            }
        });
        tblMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedicamento);

        javax.swing.GroupLayout pnlRegistrosMedicamentoLayout = new javax.swing.GroupLayout(pnlRegistrosMedicamento);
        pnlRegistrosMedicamento.setLayout(pnlRegistrosMedicamentoLayout);
        pnlRegistrosMedicamentoLayout.setHorizontalGroup(
            pnlRegistrosMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrosMedicamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlRegistrosMedicamentoLayout.setVerticalGroup(
            pnlRegistrosMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrosMedicamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeseleccionMedicamento.setText("Deseleccionar registro");
        btnDeseleccionMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionMedicamentoActionPerformed(evt);
            }
        });

        btnInicio.setText("Regresar al menú principal");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeseleccionMedicamento)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewMedicamento))
                    .addComponent(pnlRegistrosMedicamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBusquedaMedicamento))
                    .addComponent(pnlMedicamentoDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedicamento)
                    .addComponent(txtBuscaMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaMedicamento))
                .addGap(18, 18, 18)
                .addComponent(pnlMedicamentoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRegistrosMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewMedicamento)
                    .addComponent(btnDeseleccionMedicamento)
                    .addComponent(btnInicio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMedicamentoDatos.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameMedicamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameMedicamentoFocusGained
        if(txtNameMedicamento.getText().equals("Nombre del medicamento") || 
                txtNameMedicamento.getText().equals("Ingrese el nombre del medicamento")){
            txtNameMedicamento.setText("");
        }
    }//GEN-LAST:event_txtNameMedicamentoFocusGained

    private void txtNameMedicamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameMedicamentoFocusLost
        if(txtNameMedicamento.getText().equals("")){
            txtNameMedicamento.setText("Ingrese el nombre del medicamento");
            txtNameMedicamento.setForeground(Color.gray);
        }else{
            txtNameMedicamento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNameMedicamentoFocusLost

    private void btnRegistroMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroMedicamentoActionPerformed
        if(validarDatos()){//SI LOS DATOS REGISTRADOS SON VALIDOS
                //INICIALIZA UN OBJETO PRESENTACION CON LOS DATOS DE LAS TEXTBOXES
            Medicamento medicamento = new Medicamento();
            medicamento.setMdmNombre(txtNameMedicamento.getText());
            medicamento.setMdmDescripcion(txtDescripcionMedicamento.getText());
            ///Intenta convertir el grupo en numerico para guardarlo en la base de datos
            try {
                    MetodosMedicamento metodosMedicamento = new MedicamentoImplementacion();
                    metodosMedicamento.registrarMedicamento(medicamento);
                    listarRegistrosMedicamento(); ///Se llama la funcion para actualizar la lista de principio activo
            }catch(Exception r) {
            JOptionPane.showMessageDialog(null,"Error al guardar en la base de datos", "Error al guardar: "+r.getMessage(),0);
            }
            mensajeInformativo("Registro realizado con éxito", "Registro exitoso");
        }else{
            mensajeAdvertencia("Registro no realizado","Error de captura de datos");
        }
        limpiarMedicamento();
        activarMedicamento(false);
    }//GEN-LAST:event_btnRegistroMedicamentoActionPerformed
        
    private void btnLimpiarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMedicamentoActionPerformed
        limpiarMedicamento();//Llama a la función limpiar
    }//GEN-LAST:event_btnLimpiarMedicamentoActionPerformed

    private void cmbOrdenMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenMedicamentoActionPerformed
       listarRegistrosMedicamento();
    }//GEN-LAST:event_cmbOrdenMedicamentoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       listarRegistrosMedicamento();
       btnBusquedaMedicamento.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMedicamentoActionPerformed
        MetodosMedicamento metodosMedicamento = new MedicamentoImplementacion();
        int afectadas = -1;
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?\n"
                + "Esta acción será irreversible\n"
                + "Verifique que el registro a eliminar es el deseado", 
                "Advertencia de eliminación de datos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            try {
                afectadas = metodosMedicamento.eliminarMedicamento(metodosMedicamento.recuperarIdMedicamento(txtNameMedicamento.getText()));
                listarRegistrosMedicamento();
                limpiarMedicamento();
                activarMedicamento(false);
                btnEliminarMedicamento.setEnabled(false);
                btnActualizarMedicamento.setEnabled(false);
                btnLimpiarMedicamento.setEnabled(false);
                btnNewMedicamento.setEnabled(true);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,
                        "El registro que intenta borrar está siendo utilizado en otra interfaz.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if(afectadas== -1){
                mensajeAdvertencia("El registro no se ha eliminado debido a un"
                        + " error"  ,"Error de eliminación");
            }else{
                mensajeInformativo("Registro eliminado\n"
                + "Filas afectadas con la eliminacion: " + afectadas,"El registro se ha eliminado");
            }
        }    
    }//GEN-LAST:event_btnEliminarMedicamentoActionPerformed

    private void btnActualizarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMedicamentoActionPerformed
        Medicamento medicamento = new Medicamento();
        MetodosMedicamento metodosMedicamento = new MedicamentoImplementacion();
        int afectadas=-1;
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar el registro?\n"
                + "Verifique que el registro a modificar es el deseado", 
                "Advertencia de modificación de datos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){         
            
            try{
               medicamento.setMdmNombre(txtNameMedicamento.getText());
               medicamento.setMdmDescripcion(txtDescripcionMedicamento.getText());
               System.out.println(txtNameMedicamento.getText());
               System.out.println(txtDescripcionMedicamento.getText());
               int id = metodosMedicamento.recuperarIdMedicamento((String)(tblMedicamento.getValueAt(tblMedicamento.getSelectedRow(), 0)));  
               //System.out.println("El id es: " + id);   Es una bandera
               medicamento.setIdMedicamento(id);
               afectadas = metodosMedicamento.modificarMedicamento(medicamento); 
               //System.out.println("Las afectadas fueron: " + afectadas); 

                //Actualiza la lista de la interfaz
                listarRegistrosMedicamento();
                ///Limpia los campos de informacion
                limpiarMedicamento();
                ///Desactiva los campos y regresa al estado inicial de la interfaz
                activarMedicamento(false);
            
                btnEliminarMedicamento.setEnabled(false);
                btnActualizarMedicamento.setEnabled(false);
                btnLimpiarMedicamento.setEnabled(false);
                btnNewMedicamento.setEnabled(true); 
            }catch(Exception ex){
                Logger.getLogger(InterfazMedicamento.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
    }//GEN-LAST:event_btnActualizarMedicamentoActionPerformed

    private void btnDeseleccionMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionMedicamentoActionPerformed
        btnNewMedicamento.setEnabled(true);
        tblMedicamento.clearSelection();
    }//GEN-LAST:event_btnDeseleccionMedicamentoActionPerformed

    private void txtBuscaMedicamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaMedicamentoKeyPressed
        listarRegistrosMedicamento();
    }//GEN-LAST:event_txtBuscaMedicamentoKeyPressed

    private void btnNewMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMedicamentoActionPerformed
        btnRegistroMedicamento.setEnabled(true);
        txtNameMedicamento.setEnabled(true);
        txtDescripcionMedicamento.setEnabled(true);
        limpiarMedicamento();
    }//GEN-LAST:event_btnNewMedicamentoActionPerformed

    private void tblMedicamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblMedicamentoFocusGained
        tblMedicamento.enableInputMethods(false);
    }//GEN-LAST:event_tblMedicamentoFocusGained

    private void txtDescripcionMedicamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionMedicamentoFocusGained
        if(txtDescripcionMedicamento.getText().equals("Descripción del medicamento") ||
            txtDescripcionMedicamento.getText().equals("Ingrese la descripción del medicamento")){
            txtDescripcionMedicamento.setText("");
        }
    }//GEN-LAST:event_txtDescripcionMedicamentoFocusGained

    private void txtDescripcionMedicamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionMedicamentoFocusLost
        if(txtDescripcionMedicamento.getText().equals("")){
            txtDescripcionMedicamento.setText("Ingrese la descripción del medicamento");
            txtDescripcionMedicamento.setForeground(Color.gray);
        }else{
            txtDescripcionMedicamento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtDescripcionMedicamentoFocusLost

    private void tblMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicamentoMouseClicked
        if(!tblMedicamento.isEnabled()){

        }else{
            ///Para poder seleccionar algun alumno de la lista y modificarlo o eliminarlo
            int fila = tblMedicamento.getSelectedRow();
            activarMedicamento(true);
            //Se activan solo los botones para actualizar y eliminar
            btnRegistroMedicamento.setEnabled(false);
            btnActualizarMedicamento.setEnabled(true);
            btnEliminarMedicamento.setEnabled(true);
            btnLimpiarMedicamento.setEnabled(false);
            btnNewMedicamento.setEnabled(false);

            //Se recupera la informacion hacia los campos de texto de informacion

            txtNameMedicamento.setText(tblMedicamento.getValueAt(fila,0).toString());
            txtDescripcionMedicamento.setText(tblMedicamento.getValueAt(fila,1).toString());
        }
    }//GEN-LAST:event_tblMedicamentoMouseClicked

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        try{
            Home inicio = new Home();
            inicio.setVisible(true);
            // Cerrar la ventana
            dispose();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error",
                "Error",0);

        }
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //FlatLaf.registerCustomDefaultsSource("propiedades");
        //FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazMedicamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarMedicamento;
    private javax.swing.JButton btnBusquedaMedicamento;
    private javax.swing.JButton btnDeseleccionMedicamento;
    private javax.swing.JButton btnEliminarMedicamento;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiarMedicamento;
    private javax.swing.JButton btnNewMedicamento;
    private javax.swing.JButton btnRegistroMedicamento;
    private javax.swing.JComboBox<String> cmbOrdenMedicamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDescripcionMedicamento;
    private javax.swing.JLabel lblFiltroMedicamento;
    private javax.swing.JLabel lblMedicamento;
    private javax.swing.JLabel lblNombreMedicamento;
    private javax.swing.JPanel pnlFiltradoMedicamento;
    private javax.swing.JPanel pnlMedicamentoDatos;
    private javax.swing.JPanel pnlRegistrosMedicamento;
    private javax.swing.JTable tblMedicamento;
    private javax.swing.JTextField txtBuscaMedicamento;
    private javax.swing.JTextArea txtDescripcionMedicamento;
    private javax.swing.JTextField txtNameMedicamento;
    // End of variables declaration//GEN-END:variables
}
