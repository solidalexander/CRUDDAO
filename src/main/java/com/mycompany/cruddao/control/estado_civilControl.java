/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.control;

import com.mycompany.cruddao.Dominio.Estado_civil;
import com.mycompany.cruddao.data.Estado_civilDao;
import java.sql.SQLException;
import java.util.List;


public class estado_civilControl {
    Estado_civilDao estado_civilDao;
    
    public estado_civilControl() {
        estado_civilDao = new Estado_civilDao();
    }
    
    
    public List<Estado_civil> obtenerEstado_civils() throws SQLException {
        return estado_civilDao.obtenerestado_civil();
    }
    
    public Estado_civil obtenerEstado_civil(int id) throws SQLException {
        return estado_civilDao.obtenerEstado_civil(id);
    }
    
}
