/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;

import com.mycompany.cruddao.Dominio.Funcionario;
import com.mycompany.cruddao.control.funcionarioControl;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class main {

     public static void obtenerfuncionarios(funcionarioControl funcionarioControl) {
        try {
            List<Funcionario> funcionarios = funcionarioControl.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay Datos");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("Nun_id: " + funcionario.getFun_id());
                    System.out.println("Nombre: " + funcionario.getNombre());
                    System.out.println("Apellido: " + funcionario.getApellido());
                    System.out.println("Tipo_iden: " + funcionario.getTipo_iden());
                    System.out.println("Num_ident: " + funcionario.getNum_ident());
                    System.out.println("Sexo_id: " + funcionario.getSexo_id());
                    System.out.println("Estado_id: " + funcionario.getEstado_id());
                    System.out.println("Fecha_nac: " + funcionario.getFecha_nac());
                    //System.out.println("datos_conta: " + funcionario.getDatos_conta());
                    System.out.println("---------------------");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void crearfuncionario(funcionarioControl funcionarioControl) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            System.out.println("--------------- ");

            System.out.println("Digite el apellido: ");
            String apellido = sc.nextLine();
            System.out.println("el apellido es: " + apellido);
            System.out.println("--------------- ");

            System.out.println("Digite el tipo de identificaciòn: ");
            int tipo_iden = sc.nextInt();
            System.out.println("El tipo de identificaion es: " + tipo_iden);
            System.out.println("---------------------");

            System.out.println("Digite el numero de identificaciòn: ");
            String num_ident = sc.nextLine();
            System.out.println("Numero de identificacion es: " + num_ident);
            System.out.println("--------------- ");

            System.out.println("Digite el sexo: ");
            int sexo_id = sc.nextInt();
            System.out.println("El sexo es: " + sexo_id);
            System.out.println("--------------- ");
            
             System.out.println("Digite estado Civil: ");
            int estado_id = sc.nextInt();
            System.out.println("El estado civil es: " + estado_id);
            System.out.println("--------------- ");
            
             System.out.println("Digite fecha de nacimiento yyyy-mm-dd: ");
            String fecha_nac = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + fecha_nac);
            System.out.println("--------------- ");
            
             System.out.println("Digite datos de contacto: ");
            int datos_conta = sc.nextInt();
            System.out.println("los datos de contacto son: " + datos_conta);
            System.out.println("--------------- ");

            Funcionario funcionario = new Funcionario();
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setTipo_iden(tipo_iden);
            funcionario.setNum_ident(num_ident);
            funcionario.setSexo_id(sexo_id);
            funcionario.setEstado_id(estado_id);
            funcionario.setFecha_nac(fecha_nac);
            //funcionario.setDatos_conta(datos_conta);
            funcionarioControl.crear(funcionario);
            System.out.println("Funcionario creado con exito: ");
            obtenerfuncionarios(funcionarioControl);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void obtenerfuncionario(funcionarioControl funcionarioControl) {

        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el id: ");
            int fun_id = sc.nextInt();
            System.out.println("id: " + fun_id);
            System.out.println("-------------------------- ");
            
            Funcionario funcionario = funcionarioControl.obtenerFuncionario(fun_id);
            System.out.println("Listar funcionario = " + funcionario);
            System.out.println("-------------------------------------------- ");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static void editfuncionario(funcionarioControl funcionarioControl) {
        try{
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Digite ID del Funcionario: " );
                int fun_id = sc.nextInt();
                sc.nextLine();
                System.out.println("id es: " + fun_id);
                Funcionario funcionarioExits = funcionarioControl.obtenerFuncionario(fun_id);
                if(funcionarioExits == null){
                    System.out.println("No existe el funcionario ");
                    return;
                }
                
                
                 System.out.println("Digite el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            System.out.println("--------------- ");

            System.out.println("Digite el apellido: ");
            String apellido = sc.nextLine();
            System.out.println("el apellido es: " + apellido);
            System.out.println("--------------- ");

            System.out.println("Digite el tipo de identificaciòn: ");
            int tipo_iden = sc.nextInt();
            System.out.println("El tipo de identificaion es: " + tipo_iden);
            System.out.println("---------------------");

            System.out.println("Digite el numero de identificaciòn: ");
            String num_ident = sc.nextLine();
            System.out.println("Numero de identificacion es: " + num_ident);
            System.out.println("--------------- ");

            System.out.println("Digite el sexo: ");
            int sexo_id = sc.nextInt();
            System.out.println("El sexo es: " + sexo_id);
            System.out.println("--------------- ");
            
             System.out.println("Digite estado Civil: ");
            int estado_id = sc.nextInt();
            System.out.println("El estado civil es: " + estado_id);
            System.out.println("--------------- ");
            
             System.out.println("Digite fecha de nacimiento yyyy-mm-dd: ");
            String fecha_nac = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + fecha_nac);
            System.out.println("--------------- ");
            
             System.out.println("Digite datos de contacto: ");
            int datos_conta = sc.nextInt();
            System.out.println("los datos de contacto son: " + datos_conta);
            System.out.println("--------------- ");

            Funcionario funcionario = new Funcionario();
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setTipo_iden(tipo_iden);
            funcionario.setNum_ident(num_ident);
            funcionario.setSexo_id(sexo_id);
            funcionario.setEstado_id(estado_id);
            funcionario.setFecha_nac(fecha_nac);
            //funcionario.setDatos_conta(datos_conta);
            funcionarioControl.actualizarFuncionario(fun_id, funcionario);
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
    }
    
    public static void eliminarFuncionario(funcionarioControl funcionarioControl) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el ID del funcionario: ");
            int fun_id = sc.nextInt();
            System.out.println("El id del funcionario es:" + fun_id);
            Funcionario funcionarioExists = funcionarioControl.obtenerFuncionario(fun_id);
            if(funcionarioExists == null) {
                System.out.println("No existe el funcionario" );
                return;
            } 
            
            funcionarioControl.eliminarFuncionario(fun_id);
            System.out.println("Funcionario eliminado");
            obtenerfuncionario(funcionarioControl);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        funcionarioControl funcionarioControl = new funcionarioControl();
       
        var opcion = -1;
        var scanner = new Scanner(System.in);
        while(opcion != 0){
            System.out.println("----------------------------------");
            System.out.println("ELIGE UNA OPCIÓN");
            System.out.println("----------------------------------");
            
            System.out.println("1. Listar funcionarios "  );        
            System.out.println("2. Crear funcionarios");
            System.out.println("3. Listar por Id");
            System.out.println("4. Editar funcionario");
            System.out.println("5. Eliminar funcionario");
            
            System.out.println("----------------------------------");
            
            opcion = Integer.parseInt(scanner.nextLine());
            switch(opcion){
                case 0:
                    System.out.println("Ha salido de la aplicación ");
                    break;
                case 1:
                    obtenerfuncionario(funcionarioControl);
                    break;
                case 2:
                    crearfuncionario(funcionarioControl);
                    break;
                case 3:
                    obtenerfuncionario(funcionarioControl);
                    break;
                case 4:
                    editfuncionario(funcionarioControl);
                    break;
                case 5:
                    eliminarFuncionario(funcionarioControl);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    
    }
}
