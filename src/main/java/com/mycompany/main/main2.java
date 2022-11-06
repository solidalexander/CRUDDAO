/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.cruddao.Dominio.Funcionario;
import com.mycompany.cruddao.control.funcionarioControl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.cruddao.control.tipo_idenControl;
import com.mycompany.cruddao.control.sexoControl;
import com.mycompany.cruddao.control.estado_civilControl;
import com.mycompany.cruddao.Dominio.Tipo_iden;
import com.mycompany.cruddao.Dominio.Sexo;
import com.mycompany.cruddao.Dominio.Estado_civil;
import com.mycompany.cruddao.data.Tipo_idenDao;
import com.mycompany.cruddao.data.Estado_civilDao;

/**
 *
 * @author Alexander
 */
public class main2 extends javax.swing.JFrame {

    private final funcionarioControl funcionarioControl;
    private final tipo_idenControl tipo_idenControl1;
    private final sexoControl sexoControl1;
    private final estado_civilControl estado_civilControl1;
    private final String[] COLUMNS = {"ID", "NOMBRE", "APELLIDO", "TIPO_IDEN", "NUM_IDENT", "SEXO_ID","ESTADO_ID","FECHA_NAC"};
    private final static String SELECCIONE = " -- SELECCIONE --";
    public main2() {
        initComponents();
        txtFunidEdit.setEditable(false);
        funcionarioControl = new funcionarioControl();
        tipo_idenControl1 = new tipo_idenControl();
        sexoControl1 = new sexoControl();
        estado_civilControl1 = new estado_civilControl();
        listfuncionarios();
        listtipo_iden ();
        listsexo();
        listestado_civil();
        addListener();
    }
     private void listtipo_iden() {

        cbxTipoide.removeAllItems();
        Tipo_iden tipo_iden1 = new Tipo_iden();
        //Tipo_iden tipo_ident = new Tipo_ident();
        tipo_iden1.setTipo_iden(SELECCIONE);
        tipo_iden1.setId(0);
        cbxTipoide.addItem(tipo_iden1);
        tblfuncionarios.removeAll();
        
        try{ 
            List<Tipo_iden> tipo_idens = tipo_idenControl1.obtenerTipo_idens();
             if (tipo_idens.isEmpty()) {
                return;
            }
            for (Tipo_iden tipo_iden : tipo_idens) {
                cbxTipoide.addItem(tipo_iden);
            }
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        
     }

     private void listsexo() {

        cbxSexo.removeAllItems();
        Sexo sexo1 = new Sexo();
        //Tipo_iden tipo_ident = new Tipo_ident();
        sexo1.setSexo(SELECCIONE);
        sexo1.setSex_id(0);
        cbxSexo.addItem(sexo1);
        tblfuncionarios.removeAll();
        
        try{ 
            List<Sexo> sexos = sexoControl1.obtenerSexos();
             if (sexos.isEmpty()) {
                return;
            }
            for (Sexo sexo : sexos) {
                cbxSexo.addItem(sexo);
            }
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }      
    }
     
     private void listestado_civil() {

        cbxEstadoci.removeAllItems();
        Estado_civil estado_civil1 = new Estado_civil();       
        estado_civil1.setEstado(SELECCIONE);
        estado_civil1.setEstado_id(0);
        cbxEstadoci.addItem(estado_civil1);
        tblfuncionarios.removeAll();
        
        try{ 
            List<Estado_civil> estado_civils = estado_civilControl1.obtenerEstado_civils();
             if (estado_civils.isEmpty()) {
                return;
            }
            for (Estado_civil estado_civil : estado_civils) {
                cbxEstadoci.addItem(estado_civil);
            }
            
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
      
    }
    

    private void listfuncionarios() {

        cbxFuncionarios.removeAllItems();
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombre(SELECCIONE);
        funcionario1.setApellido("");
        cbxFuncionarios.addItem(funcionario1);
        tblfuncionarios.removeAll();
       
        
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblfuncionarios.setModel(defaultTableModel);
        try {
            List<Funcionario> funcionarios = funcionarioControl.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getFun_id(), row, 0);
                defaultTableModel.setValueAt(funcionario.getNombre(), row, 1);
                defaultTableModel.setValueAt(funcionario.getApellido(), row, 2);
                defaultTableModel.setValueAt(funcionario.getTipo_iden(), row, 3);
                defaultTableModel.setValueAt(funcionario.getNum_ident(), row, 4);
                defaultTableModel.setValueAt(funcionario.getSexo_id(), row, 5);
                defaultTableModel.setValueAt(funcionario.getEstado_id(), row, 6);
                defaultTableModel.setValueAt(funcionario.getFecha_nac(), row, 7);
                //defaultTableModel.setValueAt(funcionario.getDatos_conta(), row, 8);
                row++;

                cbxFuncionarios.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addListener() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario selectedfuncionario = (Funcionario) event.getItem();
            if (selectedfuncionario.getNombre().equals(SELECCIONE)) {
                txtFunidEdit.setText("");
                txtNomEdit.setText("");
                txtApellidoEdit.setText("");
                txtNumeidEdit.setText("");
                txtFechanacEdit.setText("");
                txtEstadoEdit.setText("");
                txtSexoEdit.setText("");
                txtDatoscontaEdit.setText("");

            } else {
                txtFunidEdit.setText(String.valueOf(selectedfuncionario.getFun_id()));
                txtNomEdit.setText(selectedfuncionario.getNombre());
                txtApellidoEdit.setText(selectedfuncionario.getApellido());
                txtTipoideEdit.setText(Integer.toString((selectedfuncionario.getTipo_iden())));
                txtNumeidEdit.setText((selectedfuncionario.getNum_ident()));
                txtFechanacEdit.setText(selectedfuncionario.getFecha_nac());
                txtEstadoEdit.setText(Integer.toString((selectedfuncionario.getEstado_id())));
                txtSexoEdit.setText(Integer.toString ((selectedfuncionario.getSexo_id())));
                //txtDatoscontaEdit.setText(Integer.toString ((selectedfuncionario.getDatos_conta())));
            }
            System.out.println("selectedfuncionario = " + selectedfuncionario);
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpfuncionarios = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jpfuncionario1 = new javax.swing.JPanel();
        lblNom = new javax.swing.JLabel();
        lblApell = new javax.swing.JLabel();
        lblTipoide = new javax.swing.JLabel();
        lblNumident = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblFechanac = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtApell = new javax.swing.JTextField();
        txtNumide = new javax.swing.JTextField();
        txtFechanac = new javax.swing.JTextField();
        BTNguardar = new javax.swing.JButton();
        cbxTipoide = new javax.swing.JComboBox<>();
        cbxSexo = new javax.swing.JComboBox<>();
        cbxEstadoci = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblfuncionarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPeditar = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblFunidEdit = new javax.swing.JLabel();
        lblNomEdit = new javax.swing.JLabel();
        lblApellidoEdit = new javax.swing.JLabel();
        lblTipoideEdit = new javax.swing.JLabel();
        lblNumeidEdit = new javax.swing.JLabel();
        lblFechanacEdit = new javax.swing.JLabel();
        lblEstadoEdit = new javax.swing.JLabel();
        lblSexoEdit = new javax.swing.JLabel();
        lblDatoscontaEdit = new javax.swing.JLabel();
        txtNomEdit = new javax.swing.JTextField();
        txtFunidEdit = new javax.swing.JTextField();
        txtApellidoEdit = new javax.swing.JTextField();
        txtTipoideEdit = new javax.swing.JTextField();
        txtNumeidEdit = new javax.swing.JTextField();
        txtFechanacEdit = new javax.swing.JTextField();
        txtEstadoEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        txtDatoscontaEdit = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("GESTION DE FUNCIONARIOS");

        jpfuncionario1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblNom.setText("NOMBRE");

        lblApell.setText("APELLIDO");

        lblTipoide.setText("TIPO IDENT");

        lblNumident.setText("NUM IDENT");

        lblSexo.setText("SEXO");

        lblEstado.setText("ESTADO CIVIL");

        lblFechanac.setText("FECHA NACIMIENTO");

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        txtApell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellActionPerformed(evt);
            }
        });

        txtNumide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumideActionPerformed(evt);
            }
        });

        txtFechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechanacActionPerformed(evt);
            }
        });

        BTNguardar.setBackground(new java.awt.Color(255, 102, 102));
        BTNguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTNguardar.setText("GUARDAR");
        BTNguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNguardarActionPerformed(evt);
            }
        });

        cbxTipoide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoideActionPerformed(evt);
            }
        });

        cbxEstadoci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadociActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpfuncionario1Layout = new javax.swing.GroupLayout(jpfuncionario1);
        jpfuncionario1.setLayout(jpfuncionario1Layout);
        jpfuncionario1Layout.setHorizontalGroup(
            jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpfuncionario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpfuncionario1Layout.createSequentialGroup()
                        .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpfuncionario1Layout.createSequentialGroup()
                                    .addComponent(lblNom)
                                    .addGap(70, 70, 70))
                                .addGroup(jpfuncionario1Layout.createSequentialGroup()
                                    .addComponent(txtNom)
                                    .addGap(18, 18, 18)))
                            .addComponent(lblApell))
                        .addGap(6, 6, 6)
                        .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpfuncionario1Layout.createSequentialGroup()
                                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoide)
                                    .addComponent(cbxTipoide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechanac)
                                    .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpfuncionario1Layout.createSequentialGroup()
                                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumide, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumident))
                                .addGap(41, 41, 41)
                                .addComponent(cbxEstadoci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtApell, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpfuncionario1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 408, Short.MAX_VALUE))
                    .addGroup(jpfuncionario1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                        .addComponent(BTNguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        jpfuncionario1Layout.setVerticalGroup(
            jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpfuncionario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(lblTipoide)
                    .addComponent(lblFechanac))
                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpfuncionario1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipoide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumident)
                            .addComponent(lblApell)
                            .addComponent(lblSexo)
                            .addComponent(lblEstado)))
                    .addGroup(jpfuncionario1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BTNguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jpfuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstadoci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tblfuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblfuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpfuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpfuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpfuncionarios.addTab("CREAR FUNCIONARIO", jPanel2);

        jPeditar.setBorder(javax.swing.BorderFactory.createTitledBorder("EDITAR LOS SIGUIENTES CAMPOS"));

        lblFuncionarios.setText("FUNCIONARIOS");

        cbxFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionariosActionPerformed(evt);
            }
        });

        lblFunidEdit.setText("ID");

        lblNomEdit.setText("NOMBRE");

        lblApellidoEdit.setText("APELLIDO");

        lblTipoideEdit.setText("TIPO ID");

        lblNumeidEdit.setText("NUM ID");

        lblFechanacEdit.setText("FECHA  NACIMIENTO ");

        lblEstadoEdit.setText("ESTADO CIVIL ");

        lblSexoEdit.setText("SEXO");

        lblDatoscontaEdit.setText("DATOS CONTACTO");

        txtNomEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEditActionPerformed(evt);
            }
        });

        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPeditarLayout = new javax.swing.GroupLayout(jPeditar);
        jPeditar.setLayout(jPeditarLayout);
        jPeditarLayout.setHorizontalGroup(
            jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPeditarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPeditarLayout.createSequentialGroup()
                        .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFunidEdit)
                            .addComponent(lblNomEdit)
                            .addComponent(txtFunidEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(txtNomEdit))
                        .addGap(18, 18, 18)
                        .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblApellidoEdit)
                            .addComponent(lblTipoideEdit)
                            .addComponent(txtApellidoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txtTipoideEdit))
                        .addGap(18, 18, 18)
                        .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumeidEdit)
                            .addComponent(lblFechanacEdit)
                            .addComponent(txtNumeidEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtFechanacEdit))
                        .addGap(18, 18, 18)
                        .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPeditarLayout.createSequentialGroup()
                                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstadoEdit)
                                    .addComponent(txtEstadoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDatoscontaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPeditarLayout.createSequentialGroup()
                                        .addComponent(txtDatoscontaEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(88, 88, 88))
                            .addGroup(jPeditarLayout.createSequentialGroup()
                                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSexoEdit)
                                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPeditarLayout.createSequentialGroup()
                        .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFuncionarios))
                        .addContainerGap())))
        );
        jPeditarLayout.setVerticalGroup(
            jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPeditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFuncionarios)
                .addGap(1, 1, 1)
                .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFunidEdit)
                    .addComponent(lblApellidoEdit)
                    .addComponent(lblNumeidEdit)
                    .addComponent(lblEstadoEdit)
                    .addComponent(lblDatoscontaEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFunidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatoscontaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomEdit)
                    .addComponent(lblTipoideEdit)
                    .addComponent(lblFechanacEdit)
                    .addComponent(lblSexoEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPeditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoideEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechanacEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPeditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPeditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jpfuncionarios.addTab("EDITAR FUNCIONARIO", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpfuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfuncionarios)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtApellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellActionPerformed

    private void txtNumideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumideActionPerformed

    private void txtFechanacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechanacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechanacActionPerformed

    private void BTNguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNguardarActionPerformed
        
        if(txtNom.getText().trim().length()== 0){
            JOptionPane.showMessageDialog(null,"Digite nombre");
            txtNom.requestFocus();
            return;
            
        }
         if(txtApell.getText().trim().length()== 0){
            JOptionPane.showMessageDialog(null,"Digite apellido");
            txtApell.requestFocus();
            return;
        }
        
        
        if((cbxTipoide.getSelectedIndex() )== 0){
            JOptionPane.showMessageDialog(null,"Seleccione una opción");
            cbxTipoide.requestFocus();
            return;
        }
         if(txtNumide.getText().trim().length()== 0){
            JOptionPane.showMessageDialog(null,"Digite número identificación");
            txtNom.requestFocus();
            return;
        }  
         if(txtFechanac.getText().trim().length()== 0){
            JOptionPane.showMessageDialog(null,"Digite fecha nacimiento");
            txtFechanac.requestFocus();
            return;
        }
         if((cbxEstadoci.getSelectedIndex())== 0){
            JOptionPane.showMessageDialog(null,"Seleccione una opción");
            cbxEstadoci.requestFocus();
            return;
        }
     
         if((cbxSexo.getSelectedIndex() )== 0){
            JOptionPane.showMessageDialog(null,"Seleccione una Opción");
            cbxSexo.requestFocus();
            return;
        }
         
         Funcionario funcionario = new Funcionario();
         funcionario.setNombre(txtNom.getText().trim());
         funcionario.setApellido(txtApell.getText().trim());
         funcionario.setTipo_iden(cbxTipoide.getSelectedIndex() );
         funcionario.setNum_ident(txtNumide.getText().trim());
         funcionario.setSexo_id(cbxSexo.getSelectedIndex());
         funcionario.setEstado_id(cbxEstadoci.getSelectedIndex() );
         funcionario.setFecha_nac(txtFechanac.getText().trim());
         
         try {
            funcionarioControl.crear(funcionario);
            txtNom.setText("");
            txtApell.setText("");
           listtipo_iden();
           listsexo();
           listestado_civil();
            txtNumide.setText("");
            txtFechanac.setText("");
           
            
            listfuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Funcionario no pudo ser creado");
        }
         
    }//GEN-LAST:event_BTNguardarActionPerformed

    private void cbxFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncionariosActionPerformed
         /* jTPanels.addTab("Crear Carro", jP);

        jPEdit.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));

        lblCarros.setText("Carros");

        cbxFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void cbxFuncionariosactionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionariosActionPerformed(evt);
            }
        });*/

       /* lblFunidEdit.setText("ID");

        lblNomEdit.setText("NOMBRE");

        lblApellidoEdit.setText("APELLIDO");

        lblTipoideEdit.setText("TIPO ID");

        lblNumeidEdit.setText("NUMERO ID");

        lblFechanacEdit.setText("FECHA NACIMIENTO");
        
        lblEstadoEdit.setText("ESTADO CIVIL");
        
        lblSexoEdit.setText("SEXO");
        
        /*lblDatoscontaEdit.setText("TRANSMISION");*/

       /* btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });*/
    }//GEN-LAST:event_cbxFuncionariosActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        
      if (txtFunidEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar un funcionario de la Lista");
            txtFunidEdit.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
         funcionario.setNombre(txtNom.getText().trim());
         funcionario.setApellido(txtApell.getText().trim());
         funcionario.setTipo_iden(cbxTipoide.getSelectedIndex() );
         funcionario.setNum_ident(txtNumide.getText().trim());
         funcionario.setSexo_id(cbxSexo.getSelectedIndex());
         funcionario.setEstado_id(cbxEstadoci.getSelectedIndex() );
         funcionario.setFecha_nac(txtFechanac.getText().trim());

        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el Funcionario", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {

            try { 
                funcionarioControl.actualizarFuncionario(Integer.parseInt(txtFunidEdit.getText()));
                txtNomEdit.setText("");
            txtApellidoEdit.setText("");
           listtipo_iden();
           listsexo();
           listestado_civil();
            txtNumeidEdit.setText("");
            txtFechanacEdit.setText("");
                listfuncionarios();
                
                JOptionPane.showMessageDialog(null, "Se ha Actualizado el funcionario con éxito");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fué posible actualizar el funcionario");
            }
        }
           
         
         
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtNomEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEditActionPerformed

    private void cbxTipoideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoideActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoideActionPerformed

    private void cbxEstadociActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadociActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadociActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
   if (txtFunidEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar un funcionario de la Lista");
            txtFunidEdit.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Está seguro de borrar Funcionario", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {
            try {
                funcionarioControl.eliminarFuncionario(Integer.parseInt(txtFunidEdit.getText()));
                txtFunidEdit.setText("");
                txtNomEdit.setText("");
                txtApellidoEdit.setText("");
                txtTipoideEdit.setText("");
                txtNumeidEdit.setText("");
                txtFechanacEdit.setText("");
                listfuncionarios();
                JOptionPane.showMessageDialog(null, "Se eliminó Funcionario correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo Eliminar Funcionario");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNguardar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JComboBox<Estado_civil> cbxEstadoci;
    private javax.swing.JComboBox<com.mycompany.cruddao.Dominio.Funcionario> cbxFuncionarios;
    private javax.swing.JComboBox<Sexo> cbxSexo;
    private javax.swing.JComboBox<Tipo_iden> cbxTipoide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPeditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpfuncionario1;
    private javax.swing.JTabbedPane jpfuncionarios;
    private javax.swing.JLabel lblApell;
    private javax.swing.JLabel lblApellidoEdit;
    private javax.swing.JLabel lblDatoscontaEdit;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoEdit;
    private javax.swing.JLabel lblFechanac;
    private javax.swing.JLabel lblFechanacEdit;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblFunidEdit;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblNomEdit;
    private javax.swing.JLabel lblNumeidEdit;
    private javax.swing.JLabel lblNumident;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTipoide;
    private javax.swing.JLabel lblTipoideEdit;
    private javax.swing.JTable tblfuncionarios;
    private javax.swing.JTextField txtApell;
    private javax.swing.JTextField txtApellidoEdit;
    private javax.swing.JTextField txtDatoscontaEdit;
    private javax.swing.JTextField txtEstadoEdit;
    private javax.swing.JTextField txtFechanac;
    private javax.swing.JTextField txtFechanacEdit;
    private javax.swing.JTextField txtFunidEdit;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNomEdit;
    private javax.swing.JTextField txtNumeidEdit;
    private javax.swing.JTextField txtNumide;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTipoideEdit;
    // End of variables declaration//GEN-END:variables
}
