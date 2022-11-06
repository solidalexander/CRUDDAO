/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.control;

import com.mycompany.cruddao.Dominio.Tipo_iden;
import com.mycompany.cruddao.data.Tipo_idenDao;
import java.sql.SQLException;
import java.util.List;


public class tipo_idenControl {
    Tipo_idenDao tipo_idenDao;
    
    
    public tipo_idenControl() {
        tipo_idenDao = new Tipo_idenDao();
    }
    
    
    public List<Tipo_iden> obtenerTipo_idens() throws SQLException {
        return tipo_idenDao.obtenertipo_iden();
    }
    
    public Tipo_iden obtenerTipo_iden(int id) throws SQLException {
        return tipo_idenDao.obtenerTipo_iden(id);
    }
     
}
