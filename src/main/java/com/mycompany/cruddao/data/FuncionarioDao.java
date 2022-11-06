/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.data;

import com.mycompany.cruddao.Dominio.Funcionario;
import com.mycompany.cruddao.util.conexionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao {
     private static final String GET_FUNCIONARIOS = "select * from funcionario";

    private static final String CREATE_FUNCIONARIO = "insert into funcionario (nombre, apellido,tipo_iden,"
            + "num_ident,sexo_id, estado_id, fecha_nac) values (?,?,?,?,?,?,?)";

    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionario where fun_id = ?";

    private static final String UPDATE_FUNCIONARIO = "update funcionario set nombre = ?, apellido = ?, "
            + "tipo_iden = ?, num_ident = ?, sexo_id = ?, estado_id = ?, fecha_nac = ? where fun_id = ?";

    private static final String DELETE_FUNCIONARIO = "delete from funcionario where fun_id = ? ";

    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getNombre());
            preparedStatement.setString(2, funcionario.getApellido());
            preparedStatement.setInt(3, funcionario.getTipo_iden());
            preparedStatement.setString(4, funcionario.getNum_ident());
            preparedStatement.setInt(5, funcionario.getSexo_id());
            preparedStatement.setInt(6, funcionario.getEstado_id());
            preparedStatement.setDate(7,java.sql.Date.valueOf(funcionario.getFecha_nac()));
            //reparedStatement.setInt(8, funcionario.getDatos_conta());
            
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFun_id(resultSet.getInt("fun_id"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setTipo_iden(resultSet.getInt("tipo_iden"));
                funcionario.setNum_ident(resultSet.getString("num_ident"));
                funcionario.setSexo_id(resultSet.getInt("sexo_id"));
                funcionario.setEstado_id(resultSet.getInt("Estado_id"));
                funcionario.setFecha_nac(resultSet.getString("fecha_nac"));
                //funcionario.setDatos_conta(resultSet.getInt("datos_conta"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
            
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public Funcionario obtenerFuncionario(int fun_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, fun_id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
          
                funcionario  = new Funcionario();
                funcionario.setFun_id(resultSet.getInt("fun_id"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setTipo_iden(resultSet.getInt("tipo_iden"));
                funcionario.setNum_ident(resultSet.getString("num_ident"));
                funcionario.setSexo_id(resultSet.getInt("sexo_id"));
                funcionario.setEstado_id(resultSet.getInt("Estado_id"));
                funcionario.setFecha_nac(resultSet.getString("fecha_nac"));
                //funcionario.setDatos_conta(resultSet.getInt("datos_conta"));
            }
            return funcionario;
            
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public void actualizarFuncionario(int fun_id, Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
           preparedStatement.setString(1, funcionario.getNombre());
            preparedStatement.setString(2, funcionario.getApellido());
            preparedStatement.setInt(3, funcionario.getTipo_iden());
            preparedStatement.setString(4, funcionario.getNum_ident());
            preparedStatement.setInt(5, funcionario.getSexo_id());
            preparedStatement.setInt(6, funcionario.getEstado_id());
            preparedStatement.setDate(7, java.sql.Date.valueOf(funcionario.getFecha_nac()));
            //preparedStatement.setInt(8, funcionario.getDatos_conta());
            preparedStatement.setInt(8, funcionario.getFun_id());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int fun_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, fun_id);
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            } 
        }
    }
}
