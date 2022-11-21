/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author david
 */
public class manejoArchivos {
    public static void crearArchivo(String nombre){ 
        File archivo = new File(nombre);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    //Este metodo agraga texto en el archivo, no sobreescribe
    public static void agregarArchivo(String nombre, String contenido, String contenedor, Double presio, LocalDateTime fechatiempo){ //1º
        PrintWriter salida = null;
        File archivo = new File(nombre);
        
        try {
            salida = new PrintWriter(new FileWriter(nombre, true));
            salida.print("Nombre del producto: "+contenido);
            
            salida.print(" Descripcion: " + contenedor);
            salida.print(" Precio: " + presio);
            salida.print(" Fecha: "+fechatiempo+"\n");
            System.out.println("");
        } catch (IOException ex) {
            
        }finally { 
            salida.close();
        }
        
    }
}
