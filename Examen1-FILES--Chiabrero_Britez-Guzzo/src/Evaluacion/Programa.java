/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluacion;

import java.io.File;
import java.io.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 * REALIZAR EL MENU INFINITO CON LAS OPCIONES PARA EL USUARIO QUE LLEVEN A CADA ACCION 
 * 
 * @author 
 */
/**
 * Indicamos la variable Date y File
 * @author Soft-01
 */
public class Programa {
    
    private static final Logger LOG = Logger.getLogger(Programa.class.getName());
    Date d;
    File f;
    
    /**
     * 
     */
    public Programa() {
        
        
    }
    
    /**
     * 
     */
    public void iniciar()
    {        
            char op = Datos.menu();    
            switch (op) {
                case '1':
                    
                case '2':

                case '3':
                    //SALIR
                    System.exit( 0 );
                    break;
                default:
                   Datos.menu(); 
            }         
        
    }
    
    
    
}