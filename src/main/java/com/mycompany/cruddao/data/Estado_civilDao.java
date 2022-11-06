/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.data;

import com.mycompany.cruddao.util.conexionUtil;
import com.mycompany.cruddao.Dominio.Estado_civil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estado_civilDao {
    
    private static final String GET_ESTADO_CIVIL = "select * from estado_civil";
    private static final String GET_ESTADO_CIVIL_BY_ID = "select * from estado_civil"
            + " where estado_id = ?";
    
     public List<Estado_civil> obtenerestado_civil() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Estado_civil> estado_civils = new ArrayList<>();
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ESTADO_CIVIL);
            resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next()) {
                Estado_civil estado_civil = new Estado_civil();
                estado_civil.setEstado_id(resultSet.getInt("estado_id"));
                estado_civil.setEstado(resultSet.getString("estado"));
                
                estado_civils.add(estado_civil);
            }
            return estado_civils;
            
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

public Estado_civil obtenerEstado_civil(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Estado_civil estado_civil = null;
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ESTADO_CIVIL_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
          
                estado_civil  = new Estado_civil();
                estado_civil.setEstado_id(resultSet.getInt("estado_id"));
                estado_civil.setEstado(resultSet.getString("estado"));
               
            }
            return estado_civil;
            
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
}
    

