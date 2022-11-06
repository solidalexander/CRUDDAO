/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.control;

import com.mycompany.cruddao.Dominio.Funcionario;
import com.mycompany.cruddao.data.FuncionarioDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class funcionarioControl {
      private final FuncionarioDao funcionarioDao ;
    
    public funcionarioControl() {
        funcionarioDao = new FuncionarioDao();
    }
    
    public void crear(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }
    
    public Funcionario obtenerFuncionario(int fun_id) throws SQLException {
        return funcionarioDao.obtenerFuncionario(fun_id);
    }
    
    public void actualizarFuncionario(int fun_id, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(fun_id, funcionario);
    }
    
    public void eliminarFuncionario(int fun_id) throws SQLException {
        funcionarioDao.eliminarFuncionario(fun_id);
    }

  
}
