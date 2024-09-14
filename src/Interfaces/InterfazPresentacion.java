package Interfaces;

import Implementaciones.PresentacionImplementacion;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import com.formdev.flatlaf.FlatIntelliJLaf;
//import com.formdev.flatlaf.FlatLaf;
import Modelos.Presentacion;


/**
 *
 * @author ulseg
 */
public class InterfazPresentacion extends javax.swing.JFrame {

    public InterfazPresentacion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void mensajeAdvertencia(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null,mensaje,titulo,0);
    }
    public void mensajeInformativo(String mensaje, String titulo){
        JOptionPane.showInternalMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void activarPresentacion(boolean activado){
        pnlPresentacionDatos.setEnabled(activado);
        txtNamePresentacion.setEnabled(activado);
        lblNombrePresentacion.setEnabled(activado);
        btnLimpiarPresentacion.setEnabled(activado);
        btnRegistroPresentacion.setEnabled(activado);
        btnBusquedaPresentacion.setEnabled(!activado);
    }
    
    public void limpiarPresentacion(){
        ///Se limpia el campo de texto
        txtNamePresentacion.setText("");
    }
    
    public void listarRegistros(){ ///Funcion para actualizar la lista acorde a los criterios seleccionados al momento
        MetodosPresentacion metodosPresentacion = new PresentacionImplementacion();
        try {
            tblPresentacion.setModel(metodosPresentacion.recuperarRegistros
            (cmbOrdenPresentacion.getSelectedIndex(),txtBuscaPresentacion.getText()));
            
        } catch (Exception ex) {
            Logger.getLogger(InterfazPresentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean validarDatos(){
        if(txtNamePresentacion.getText().equals("") || 
                txtNamePresentacion.getText().equals("Nombre de la presentación") || 
                txtNamePresentacion.getText().equals("Ingrese el nombre de la presentacion")){
            ///En caso de que no se haya registrado un nombre
            mensajeAdvertencia("El nombre de la presentación es inválido.\n"
                    + "Favor de verificar que:\n"
                    + "-> No contenga acentos\n"
                    + "-> No contenga caracteres especiales\n"
                    + "-> Haya registrado correctamente el nombre de la presentación\n","Nombre inválido");
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
        lblPresentacion = new javax.swing.JLabel();
        btnBusquedaPresentacion = new javax.swing.JButton();
        txtBuscaPresentacion = new javax.swing.JTextField();
        btnNewPresentacion = new javax.swing.JButton();
        pnlPresentacionDatos = new javax.swing.JPanel();
        lblNombrePresentacion = new javax.swing.JLabel();
        txtNamePresentacion = new javax.swing.JTextField();
        btnRegistroPresentacion = new javax.swing.JButton();
        btnEliminarPresentacion = new javax.swing.JButton();
        btnActualizarPresentacion = new javax.swing.JButton();
        btnLimpiarPresentacion = new javax.swing.JButton();
        pnlRegistrosPresentacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPresentacion = new javax.swing.JTable();
        pnlFiltradoPresentacion = new javax.swing.JPanel();
        lblFiltroPresentacion = new javax.swing.JLabel();
        cmbOrdenPresentacion = new javax.swing.JComboBox<>();
        btnDeseleccion = new javax.swing.JButton();
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

        lblPresentacion.setText("Presentación:");

        btnBusquedaPresentacion.setText("Buscar presentación");

        txtBuscaPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaPresentacionKeyPressed(evt);
            }
        });

        btnNewPresentacion.setText("Nueva Presentacion");
        btnNewPresentacion.setActionCommand("Nueva Presentación");
        btnNewPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPresentacionActionPerformed(evt);
            }
        });

        pnlPresentacionDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de la presentación"));
        pnlPresentacionDatos.setToolTipText("");
        pnlPresentacionDatos.setEnabled(false);

        lblNombrePresentacion.setText("Presentación");
        lblNombrePresentacion.setEnabled(false);

        txtNamePresentacion.setText("Tipo de presentación");
        txtNamePresentacion.setEnabled(false);
        txtNamePresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamePresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamePresentacionFocusLost(evt);
            }
        });

        btnRegistroPresentacion.setText("Registrar presentación");
        btnRegistroPresentacion.setEnabled(false);
        btnRegistroPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPresentacionActionPerformed(evt);
            }
        });

        btnEliminarPresentacion.setText("Eliminar presentación");
        btnEliminarPresentacion.setEnabled(false);
        btnEliminarPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPresentacionActionPerformed(evt);
            }
        });

        btnActualizarPresentacion.setText("Actualizar presentación ");
        btnActualizarPresentacion.setEnabled(false);
        btnActualizarPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPresentacionActionPerformed(evt);
            }
        });

        btnLimpiarPresentacion.setText("Limpiar campos");
        btnLimpiarPresentacion.setEnabled(false);
        btnLimpiarPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPresentacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPresentacionDatosLayout = new javax.swing.GroupLayout(pnlPresentacionDatos);
        pnlPresentacionDatos.setLayout(pnlPresentacionDatosLayout);
        pnlPresentacionDatosLayout.setHorizontalGroup(
            pnlPresentacionDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPresentacionDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPresentacionDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarPresentacion)
                    .addGroup(pnlPresentacionDatosLayout.createSequentialGroup()
                        .addComponent(lblNombrePresentacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamePresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPresentacionDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistroPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarPresentacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarPresentacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPresentacionDatosLayout.setVerticalGroup(
            pnlPresentacionDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPresentacionDatosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlPresentacionDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombrePresentacion)
                    .addComponent(txtNamePresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroPresentacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarPresentacion)
                .addGap(5, 5, 5)
                .addGroup(pnlPresentacionDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarPresentacion)
                    .addComponent(btnLimpiarPresentacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRegistrosPresentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registros existentes:"));

        tblPresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        tblPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPresentacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPresentacion);

        pnlFiltradoPresentacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filtrar tabla mediante"));

        lblFiltroPresentacion.setText("Orden de despliegue");

        cmbOrdenPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        cmbOrdenPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenPresentacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltradoPresentacionLayout = new javax.swing.GroupLayout(pnlFiltradoPresentacion);
        pnlFiltradoPresentacion.setLayout(pnlFiltradoPresentacionLayout);
        pnlFiltradoPresentacionLayout.setHorizontalGroup(
            pnlFiltradoPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltradoPresentacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlFiltradoPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFiltroPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOrdenPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFiltradoPresentacionLayout.setVerticalGroup(
            pnlFiltradoPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltradoPresentacionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblFiltroPresentacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbOrdenPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRegistrosPresentacionLayout = new javax.swing.GroupLayout(pnlRegistrosPresentacion);
        pnlRegistrosPresentacion.setLayout(pnlRegistrosPresentacionLayout);
        pnlRegistrosPresentacionLayout.setHorizontalGroup(
            pnlRegistrosPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrosPresentacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFiltradoPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlRegistrosPresentacionLayout.setVerticalGroup(
            pnlRegistrosPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrosPresentacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistrosPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFiltradoPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeseleccion.setText("Deseleccionar registro");
        btnDeseleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionActionPerformed(evt);
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
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPresentacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRegistrosPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeseleccion)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewPresentacion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnBusquedaPresentacion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPresentacion)
                    .addComponent(txtBuscaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaPresentacion))
                .addGap(18, 18, 18)
                .addComponent(pnlPresentacionDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlRegistrosPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeseleccion)
                    .addComponent(btnNewPresentacion)
                    .addComponent(btnInicio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPresentacionDatos.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamePresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamePresentacionFocusGained
        if(txtNamePresentacion.getText().equals("Nombre de la presentación") || 
                txtNamePresentacion.getText().equals("Ingrese el nombre de la presentación")){
            txtNamePresentacion.setText("");
        }
    }//GEN-LAST:event_txtNamePresentacionFocusGained

    private void txtNamePresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamePresentacionFocusLost
        if(txtNamePresentacion.getText().equals("")){
            txtNamePresentacion.setText("Ingrese el nombre de la presentación");
            txtNamePresentacion.setForeground(Color.gray);
        }else{
            txtNamePresentacion.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNamePresentacionFocusLost

    private void btnRegistroPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPresentacionActionPerformed
        if(validarDatos()){//SI LOS DATOS REGISTRADOS SON VALIDOS
                //INICIALIZA UN OBJETO PRESENTACION CON LOS DATOS DE LAS TEXTBOXES
            Presentacion presentacion = new Presentacion();
            presentacion.setPreNombre(txtNamePresentacion.getText());
            ///Intenta convertir el grupo en numerico para guardarlo en la base de datos
            try {
                    MetodosPresentacion metodosPresentacion = new PresentacionImplementacion();
                    metodosPresentacion.registrar(presentacion);
                    listarRegistros(); ///Se llama la funcion para actualizar la lista
            }catch(Exception r) {
            JOptionPane.showMessageDialog(null,"Error al guardar en la base de datos", "Error al guardar: "+r.getMessage(),0);
            }
            mensajeInformativo("Registro realizado con éxito", "Registro exitoso");
        }else{
            mensajeAdvertencia("Registro no realizado","Error de captura de datos");
        }
        limpiarPresentacion();
        activarPresentacion(false);
    }//GEN-LAST:event_btnRegistroPresentacionActionPerformed
    
    private void txtNamePresentacionKeyTyped(java.awt.event.KeyEvent evt) {                                         
        int key = evt.getKeyChar();

            boolean mayusculas = key >= 65 && key <= 90;
            boolean minusculas = key >= 97 && key <= 122;
            boolean espacio = key == 32;

            if (!(minusculas || mayusculas || espacio)) {
                evt.consume();
            }
    }
    
    private void btnLimpiarPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPresentacionActionPerformed
        limpiarPresentacion();//Llama a la función limpiar
    }//GEN-LAST:event_btnLimpiarPresentacionActionPerformed

    private void cmbOrdenPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenPresentacionActionPerformed
       listarRegistros();
    }//GEN-LAST:event_cmbOrdenPresentacionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       listarRegistros();
       btnBusquedaPresentacion.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPresentacionActionPerformed
        MetodosPresentacion metodosPresentacion = new PresentacionImplementacion();
        int afectadas = -1;
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?\n"
                + "Esta acción será irreversible\n"
                + "Verifique que el registro a eliminar es el deseado", 
                "Advertencia de eliminación de datos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            try {
                afectadas = metodosPresentacion.eliminarPresentacion(metodosPresentacion.recuperarId(txtNamePresentacion.getText()));
                listarRegistros();
                limpiarPresentacion();
                activarPresentacion(false);
                btnEliminarPresentacion.setEnabled(false);
                btnActualizarPresentacion.setEnabled(false);
                btnLimpiarPresentacion.setEnabled(false);
                btnNewPresentacion.setEnabled(true);
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
    }//GEN-LAST:event_btnEliminarPresentacionActionPerformed

    private void btnActualizarPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPresentacionActionPerformed
        Presentacion presentacion = new Presentacion();
        MetodosPresentacion metodosPresentacion = new PresentacionImplementacion();
        int afectadas=-1;
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar el registro?\n"
                + "Verifique que el registro a modificar es el deseado", 
                "Advertencia de modificación de datos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){         
            
            try{
               presentacion.setPreNombre(txtNamePresentacion.getText());
               System.out.println(txtNamePresentacion.getText());
               int id = metodosPresentacion.recuperarId((String)(tblPresentacion.getValueAt(tblPresentacion.getSelectedRow(), 0)));  
               //System.out.println("El id es: " + id);   Es una bandera
               presentacion.setIdPresentacion(id);
               afectadas = metodosPresentacion.modificarPresentacion(presentacion); 
               //System.out.println("Las afectadas fueron: " + afectadas); 

                //Actualiza la lista de la interfaz
                listarRegistros();
                ///Limpia los campos de informacion
                limpiarPresentacion();
                ///Desactiva los campos y regresa al estado inicial de la interfaz
                activarPresentacion(false);
            
                btnEliminarPresentacion.setEnabled(false);
                btnActualizarPresentacion.setEnabled(false);
                btnLimpiarPresentacion.setEnabled(false);
                btnNewPresentacion.setEnabled(true); 
            }catch(Exception ex){
                Logger.getLogger(InterfazPresentacion.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
    }//GEN-LAST:event_btnActualizarPresentacionActionPerformed

    private void btnDeseleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionActionPerformed
        btnNewPresentacion.setEnabled(true);
        tblPresentacion.clearSelection();
    }//GEN-LAST:event_btnDeseleccionActionPerformed

    private void tblPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPresentacionMouseClicked
        if(!tblPresentacion.isEnabled()){

        }else{
            ///Para poder seleccionar algun alumno de la lista y modificarlo o eliminarlo
            int fila = tblPresentacion.getSelectedRow();
            activarPresentacion(true);
            //Se activan solo los botones para actualizar y eliminar
            btnRegistroPresentacion.setEnabled(false);
            btnActualizarPresentacion.setEnabled(true);
            btnEliminarPresentacion.setEnabled(true);
            btnLimpiarPresentacion.setEnabled(false);
            btnNewPresentacion.setEnabled(false);

            //Se recupera la informacion hacia los campos de texto de informacion

            txtNamePresentacion.setText(tblPresentacion.getValueAt(fila,0).toString());
        }
    }//GEN-LAST:event_tblPresentacionMouseClicked

    private void txtBuscaPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaPresentacionKeyPressed
        listarRegistros();
    }//GEN-LAST:event_txtBuscaPresentacionKeyPressed

    private void btnNewPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPresentacionActionPerformed
        btnRegistroPresentacion.setEnabled(true);
        txtNamePresentacion.setEnabled(true);
        limpiarPresentacion();
    }//GEN-LAST:event_btnNewPresentacionActionPerformed

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
                new InterfazPresentacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPresentacion;
    private javax.swing.JButton btnBusquedaPresentacion;
    private javax.swing.JButton btnDeseleccion;
    private javax.swing.JButton btnEliminarPresentacion;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiarPresentacion;
    private javax.swing.JButton btnNewPresentacion;
    private javax.swing.JButton btnRegistroPresentacion;
    private javax.swing.JComboBox<String> cmbOrdenPresentacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblFiltroPresentacion;
    private javax.swing.JLabel lblNombrePresentacion;
    private javax.swing.JLabel lblPresentacion;
    private javax.swing.JPanel pnlFiltradoPresentacion;
    private javax.swing.JPanel pnlPresentacionDatos;
    private javax.swing.JPanel pnlRegistrosPresentacion;
    private javax.swing.JTable tblPresentacion;
    private javax.swing.JTextField txtBuscaPresentacion;
    private javax.swing.JTextField txtNamePresentacion;
    // End of variables declaration//GEN-END:variables
}
