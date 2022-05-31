/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.pkg1.io;
import java.util.*;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author PC ARI 06
 */
public class Tp11Io extends Lectura{
    StringTokenizer st ;

    public void check(){
        String str = "7 + 5";
      
        char[] aux = str.toCharArray();
            String signo = "" ;
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] == '+' || aux[i] == '-'|| aux[i] == '*' || aux[i] == '/') {
                    signo = String.valueOf(aux[i]);
                }
            }
            
           
        StringTokenizer st = new StringTokenizer (str,signo) ;
        int valor1=Integer.parseInt(st.nextToken()); 
        int valor2=Integer.parseInt(st.nextToken());
        int resultado ;
        

        switch (signo) {
            case "+":
                resultado = valor1 + valor2;
                break;
            case "-":
                resultado = valor1 - valor2;
             break;
             case "*":
                resultado = valor1 * valor2;
            break;
             case "/": 
                resultado = valor1 / valor2;
            break;
             default: 
                 System.err.println("no se eligio ninguna opcion");
         }
    }
}

