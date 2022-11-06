/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.Dominio;



/**
 *
 * @author Alexander
 */
public class Funcionario {
    private int fun_id;
    private String nombre;
    private String apellido;
    private int tipo_iden;
    private String num_ident;
    private int sexo_id;
    private int estado_id;
    private String fecha_nac;
    //private int datos_conta;

    public int getFun_id() {
        return fun_id;
    }

    public void setFun_id(int fun_id) {
        this.fun_id = fun_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTipo_iden() {
        return tipo_iden;
    }

    public void setTipo_iden(int tipo_iden) {
        this.tipo_iden = tipo_iden;
    }

    public String getNum_ident() {
        return num_ident;
    }

    public void setNum_ident(String num_ident) {
        this.num_ident = num_ident;
    }

    public int getSexo_id() {
        return sexo_id;
    }

    public void setSexo_id(int sexo_id) {
        this.sexo_id = sexo_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

   /* public int getDatos_conta() {
        return datos_conta;
    }

    public void setDatos_conta(int datos_conta) {
        this.datos_conta = datos_conta;
    }*/

    @Override
    public String toString() {
        return " " + nombre + " " + apellido  ;
    }
    
    
    
}
