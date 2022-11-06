/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.data;


import com.mycompany.cruddao.util.conexionUtil;
import com.mycompany.cruddao.Dominio.Tipo_iden;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Tipo_idenDao {
    
    private static final String GET_TIPO_IDEN = "select * from tipo_ident";
    private static final String GET_TIPO_IDEN_BY_ID = "select * from tipo_ident where id = ?";
    
    


public List<Tipo_iden> obtenertipo_iden() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tipo_iden> tipo_idens = new ArrayList<>();
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPO_IDEN);
            resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next()) {
                Tipo_iden tipo_iden = new Tipo_iden();
                tipo_iden.setId(resultSet.getInt("ident_id"));
                tipo_iden.setTipo_iden(resultSet.getString("tipo_ident"));
                
                tipo_idens.add(tipo_iden);
            }
            return tipo_idens;
            
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

public Tipo_iden obtenerTipo_iden(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tipo_iden tipo_iden = null;
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPO_IDEN_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
          
                tipo_iden  = new Tipo_iden();
                tipo_iden.setId(resultSet.getInt("ident_id"));
                tipo_iden.setTipo_iden(resultSet.getString("tipo_ident"));
               
            }
            return tipo_iden;
            
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