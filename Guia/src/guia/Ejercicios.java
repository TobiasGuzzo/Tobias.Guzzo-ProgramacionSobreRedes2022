/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guzzo
 */
public class Ejercicios {
    PrintStream ps;
    InputStreamReader is;
    BufferedReader br;
    File archivo;
    FileOutputStream fos;
    PrintStream fps;
    FileReader fr;


public Ejercicios(){

ps= new  PrintStream(System.out);

}
String entrada1(){
        int Byte = -1;
        int dato = -1;
        
        String texto = "";
        try{
            while(  (Byte = System.in.read()) != '\n'  )
            {
                texto = texto + (char)Byte;
            }
        } catch (IOException ex) {
            Logger.getLogger(Ejercicios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return texto;
        }
    }

    String entrada2(){
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );

        String texto,textoArreglado = "";

        try {
            ps.print(">");

            texto = br.readLine();

            char[] textoVec = texto.toCharArray();
            for (int i = 0; i < textoVec.length; i++) {
                if (textoVec[i] == 65533 ) {
                    textoVec[i] = '\u00f1';
                }
            }

            for (int i = 0; i < textoVec.length; i++) {
                textoArreglado += textoVec[i];
            }
        } catch (IOException ex) {
         Logger.getLogger(Ejercicios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return textoArreglado;
        }
    }
    
    
    //-----------aca se empieza a hacer los primero ejercicios-----------
    
     public void ejercicio1a(){
        ps.println("Ingrese el sueldo de una hora de trabajo:");
        int SueldoXhora = Integer.parseInt(entrada1());
        ps.println("Ingrese la cantidad de horas trabajadas:");
        int cantHoras = Integer.parseInt(entrada1());
        ps.println("Sueldo Bruto del trabajador: $" + (SueldoXhora * cantHoras));
    }

    public void ejercicio1b(){
        ps.println("Escriba dos angulos de un triangulo:");
        int anguloA = Integer.parseInt(entrada1());
        int anguloB = Integer.parseInt(entrada1());
        int anguloC = anguloA + anguloB;
        ps.print("Lado restante: ");
        ps.println((180 - anguloC) + "°");
    }

    public void ejercicio1c(){
        ps.println("Ingrese el area de un cuadrado (en m²)");
        double area = Integer.parseInt(entrada1())*1.0;
        ps.print("Perimetro del cuadrado: ");
        ps.println((Math.sqrt(area))*4 + "m");
    }

    public void ejercicio1d(){
        ps.println("Ingrese la temperatura (en Fahrenheit)");
        int temp = Integer.parseInt(entrada1());
        ps.print("Temperatura en grados centigrados: ");
        ps.println((temp - 32) * 5/9 + "°C");
    }

    public void ejercicio1e(){
        ps.println("Ingrese un tiempo en Segundos");
        int tiempo = Integer.parseInt(entrada1());
        ps.println("Tiempo en dias: " + (tiempo/86400));
        ps.println("Tiempo en horas: " + (tiempo/3600));
        ps.println("Tiempo en minutos: " + (tiempo/60));
        ps.println("Tiempo en segundos: " + tiempo);
    }

    public void ejercicio1f(){
        ps.println("Ingrese el precio del producto");
        double precio = Double.parseDouble(entrada1());
        ps.println("Planes disponibles:");
        double plan1 = precio - (precio * 0.10);//900
        ps.println("Plan 1: \n    Al contado: $" + plan1);
        double plan2 = precio + (precio * 0.10);//1100
        ps.println("Plan 2: \n    Al contado: $" + (plan2/2) + " + 2 cuotas: $" + ((plan2/2)/2) + " c/u");
        double plan3 = precio + (precio * 0.15);//1150
        ps.println("Plan 3: \n    Al contado: $" + (plan3/4) + " + 5 cuotas: $" + (plan3 - (plan3/4)) /5 + " c/u");
        double plan4 = precio + (precio * 0.25);//1250
        ps.println("Plan 4 - 8 cuotas totales: \n    4 cuotas: $" + (plan4 * 0.60)/4 + " c/u + 4 cuotas: $" + (plan4 -(plan4 * 0.60))/4 + " c/u");
    }

public void ejercicio1g(){
// falta el ejercicio 1g
// hasta el momento no se puede desarrollar 
}
  //---------------aca empizan los ejercicios 2-----------//

public void ejercicio2a(){
        ps.println("Ingrese tres apellidos:");
        String ape1 = entrada2();
        String ape2 = entrada2();
        String ape3 = entrada2();

        String[] apellidos = {ape1, ape2, ape3};
        Arrays.sort(apellidos);
        ps.println("Apellidos ordenados alfabeticamente:");
        for (String i : apellidos) {
            ps.println("-"+i);
        }
    }

    public void ejercicio2b(){
        ps.println("Ingrese 4 numeros:");
        int numero1 = Integer.parseInt(entrada2());
        int numero2 = Integer.parseInt(entrada2());
        int numero3 = Integer.parseInt(entrada2());
        int numero4 = Integer.parseInt(entrada2());

        int[] aux = {numero1, numero2, numero3, numero4};

        Arrays.sort(aux);

        ps.print("El menor numero es ");
        ps.println(aux[0]);
    }

    public void ejercicio2c(){
        ps.println("Ingrese un numero para saber si es par o impar:");

        int n = Integer.parseInt(entrada2());
        if (n % 2 == 0) {
            ps.println("El numero es par");
        }else{
            ps.println("El numero es impar");
        }
    }
     public void ejercicio2d(){
        ps.println("Ingrese dos numeros reales:");
        
        int n1 = Integer.parseInt(entrada2());
        int n2 = Integer.parseInt(entrada2()); 
        
        if(n1 >= n2){
            if(n1 % n2 == 0){
                ps.println(n1 + " es divisible por " + n2);
            }else{
                ps.println(n1 + " no es divisible por " + n2);
            }
            
        }else if(n1 <= n2){
            if(n2 % n1 == 0){
                ps.println(n2 + " es divisible por " + n1);
            }else{
                ps.println(n2 + " no es divisible por " + n1);
            }            
        } 
    }

    public void ejercicio2e(){
    // no se pudo hacer el ejercicio2e
    }

    public void ejercicio2f(){
        //no se pudo hacer ejercicio2f
    }

    public void ejercicio2g(){
        ps.println("Ingrese un numero para mostrar su tabla de multiplicar:");
        int numero = Integer.parseInt(entrada2());
        if( numero >= 1){
            for (int i = 1; i <= 10; i++) {
                ps.println( numero + " * " + i + " = " + numero*i);
            }
        }else{
            ps.println("Ingrese un numero natural!");
        }
    }
     public void ejercicio2h(){
        ps.println("Ingrese un numero para determinar si es primo o no:");

        int n = Integer.parseInt(entrada2());

        for(int i = 2; i < n; i++) {
            if(n%i==0)
                ps.println(n + " no es un numero primo");
                break;
        }
        ps.println(n + " es un numero primo");
    }
    
    
//-------- A ca empiezan los ejercicios 3----

public void ejercicio3a(){
// no se pudo ahcer el ejercicio

}
   public void ejercicio3b(){
    // no se pudo ahcer el ejercicio
    }
 public void ejercicio3c(){ //EL ARCHIVO 'numeros.txt' SE VA A CREAR EN EL ESCRITORIO ('C:\Users\{usuario}\Desktop\primos.dat')

    //no se pudo ahcer el ejercicio3c
    }
 public void ejercicio3d(){
     //no se puedo hacer el ejercicio3d
    }
 public void ejercicio3e(){ //Este ejercicio es redundante
     //no se pudo hacer el ejercicio3e
    }

public void ejercicio3f(){
// no se pudo hacer el ejercicio3f    

}
 public void ejercicio3g(){

   //no se pudo hacer el ejercicio3g//



}
}
