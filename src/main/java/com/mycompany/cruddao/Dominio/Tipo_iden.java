/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruddao.Dominio;


public class Tipo_iden {
    private int id;
    private String tipo_iden;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_iden() {
        return tipo_iden;
    }

    public void setTipo_iden(String tipo_iden) {
        this.tipo_iden = tipo_iden;
    }

    @Override
    public String toString() {
        return id + "  -  " + tipo_iden;
    }

   

   
    
    
}
