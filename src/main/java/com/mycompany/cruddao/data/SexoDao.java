/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.data;

import com.mycompany.cruddao.util.conexionUtil;
import com.mycompany.cruddao.Dominio.Sexo;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SexoDao {
    private static final String GET_SEXO = "select * from sexo";
    private static final String GET_SEXO_BY_ID = "select * from sexo where sex_id = ?";
    
    
    public List<Sexo> obtenersexo() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sexo> sexos = new ArrayList<>();
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_SEXO);
            resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next()) {
                Sexo sexo = new Sexo();
                sexo.setSex_id(resultSet.getInt("sex_id"));
                sexo.setSexo(resultSet.getString("sexo"));
                
                sexos.add(sexo);
            }
            return sexos;
            
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

public Sexo obtenerSexo(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Sexo sexo = null;
        
        try {
            connection = conexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_SEXO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
          
                sexo  = new Sexo();
                sexo.setSex_id(resultSet.getInt("sex_id"));
                sexo.setSexo(resultSet.getString("sexo"));
               
            }
            return sexo;
            
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



