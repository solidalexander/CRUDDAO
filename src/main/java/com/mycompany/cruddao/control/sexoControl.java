/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.control;

import com.mycompany.cruddao.Dominio.Sexo;
import com.mycompany.cruddao.data.SexoDao;
import java.sql.SQLException;
import java.util.List;

public class sexoControl {
    SexoDao sexoDao;
    
    public sexoControl() {
        sexoDao = new SexoDao();
    }
    
    
    public List<Sexo> obtenerSexos() throws SQLException {
        return sexoDao.obtenersexo();
    }
    
    public Sexo obtenerSexo(int id) throws SQLException {
        return sexoDao.obtenerSexo(id);
    }
    
 }


