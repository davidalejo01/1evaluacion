/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.proyectofinaltercer;

import archivos.manejoArchivos;
import datos.clientes;
import datos.envios;
import datos.productos;
import datos.usuarios;
import dominio.clientesDAO;
import dominio.enviosDAO;
import dominio.productosDAO;
import dominio.usuariosDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class Principal {
    static usuarios uNuevo = new usuarios();
    public static void main(String[] args) throws SQLException {
        
        //String productostxt = "productos.txt";
        //manejoArchivos.crearArchivo(productostxt);
        ArrayList<clientes>cliente=new ArrayList<>();
        ArrayList<usuarios>usuario=new ArrayList<>();
        
        //meterproducto();
        //metercliente();
        //actualizarcliente(cliente);
        //eliminarcliente(cliente);
        menu1();
        //actualizarusuario(usuario);
        //eliminarusuario(usuario);
                
    }
    
    public static void menu1() throws SQLException{
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while(!salir){
        System.out.println(" \\    //  ========       //\\         //=====\\     ||\\    //||  ========   ");
        System.out.println("  \\  //      ||         //  \\       //       \\    || \\  // ||     ||      ");
        System.out.println("   \\//       ||        //    \\     ||         ||  ||  \\//  ||     ||      ");
        System.out.println("   //\\       ||       //======\\    ||         ||  ||       ||     ||      ");
        System.out.println("  //  \\      ||      //        \\    \\       //    ||       ||     ||      ");
        System.out.println(" //    \\  ========  //          \\    \\=====//     ||       ||  ========   ");
        System.out.println("");
        System.out.println("");       
        esperar(3);
        System.out.println("//=====================\\");
        System.out.println("||                     ||");
        System.out.println("|| 1. INICIO DE SESION ||");
        System.out.println("|| 2. REGISTRARME      ||");
        System.out.println("|| 3. SALIR            ||");
        System.out.println("||                     ||");
        System.out.println("\\=====================//");
        try{
        System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("HAS SELECCIONADO INICIO DE SESION");
                    menu2();
                    salir = true;
                    break;
                case 2:
                    System.out.println("HAS SELECCIONADO REGISTRARTE");
                    registroUsuarios();
                    salir = true;
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
            } catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }
    public static void menu2() throws SQLException{
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while(!salir){
        System.out.println("//=====================\\");
        System.out.println("||                     ||");
        System.out.println("|| 1. ADMINISTRADOR    ||");
        System.out.println("|| 2. CLIENTE          ||");
        System.out.println("|| 3. SALIR            ||");
        System.out.println("||                     ||");
        System.out.println("\\=====================//");
        try{
        System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("HAS SELECCIONADO ADMINISTRADOR");
                    loginAdmin();
                    salir = true;
                    break;
                case 2:
                    System.out.println("HAS SELECCIONADO CLIENTE");
                    loginCliente();
                    salir = true;
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
            } catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    public static void menu6(){
        Scanner sn = new Scanner(System.in);
            ArrayList<usuarios>usuario=new ArrayList<>();
            ArrayList<clientes>cliente=new ArrayList<>();
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
            while(!salir){
            System.out.println("SELECCIONA UNA OPCIÓN");
            System.out.println("//==========================\\");
            System.out.println("||                           ||");
            System.out.println("|| 1.ENVIO A DOMICILIO       ||");
            System.out.println("|| 2.FINALIZAR COMPRA        ||");
            System.out.println("||                           ||");
            System.out.println("\\==========================//");
            try{
        System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("HAS SELECCIONADO ENVIO DOMICILIO");
                    registroenvio();
                    salir = true;
                    break;
                case 2:
                    System.out.println("HAS SELECCIONADO FINALIZAR COMPRA, GRACIAS");
                    salir = true;
                    break;    
                default:
                    System.out.println("Solo números entre 1 y 2");
            }
            } catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sn.next();
            }
            }
    }
    public static void menu3() throws SQLException{
            Scanner sn = new Scanner(System.in);
            ArrayList<usuarios>usuario=new ArrayList<>();
            ArrayList<clientes>cliente=new ArrayList<>();
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
            while(!salir){
            System.out.println("¿QUE QUIERES HACER?");
            System.out.println("//=====================\\");
            System.out.println("||                     ||");
            System.out.println("|| 1.ELIMINAR CLIENTE  ||");
            System.out.println("|| 2.MODIFICAR CLIENTE ||");
            System.out.println("|| 3.ELIMINAR ADMIN    ||");
            System.out.println("|| 4.MODIFICAR ADMIN   ||");
            System.out.println("|| 5.SALIR             ||");
            System.out.println("||                     ||");
            System.out.println("\\=====================//");
            try{
        System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("HAS SELECCIONADO ELIMINAR CLIENTE");
                    eliminarcliente(cliente);
                    salir = true;
                    break;
                case 2:
                    System.out.println("HAS SELECCIONADO MODIFICAR CLIENTE");
                    actualizarcliente(cliente);
                    salir = true;
                    break;
                case 3:
                    System.out.println("HAS SELECCIONADO ELIMINAR ADMINISTRADOR");
                    eliminarusuario(usuario);
                    salir = true;
                    break;
                case 4:
                    System.out.println("HAS SELECCIONADO MODIFICAR ADMINISTRADOR");
                    actualizarusuario(usuario);
                    salir = true;
                    break;
                case 5:
                    System.out.println("HAS SELECCIONADO SALIR GRACIAS");
                    salir = true;
                    break;    
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
            } catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sn.next();
            }
            }
        }
    public static void menu4() throws SQLException{
        Scanner sn = new Scanner(System.in);
            ArrayList<usuarios>usuario=new ArrayList<>();
            ArrayList<clientes>cliente=new ArrayList<>();
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
            while(!salir){
            System.out.println("¿QUE QUIERES HACER?");
            System.out.println("//=====================\\");
            System.out.println("||                     ||");
            System.out.println("|| 1.ELIMINAR CUENTA   ||");
            System.out.println("|| 2.MODIFICAR CUENTA  ||");
            System.out.println("|| 3.AÑADIR PRODUCTO   ||");
            System.out.println("|| 4.SALIR             ||");
            System.out.println("||                     ||");
            System.out.println("\\=====================//");
            try{
        System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("HAS SELECCIONADO ELIMINAR CLIENTE");
                    eliminarcliente(cliente);
                    salir = true;
                    break;
                case 2:
                    System.out.println("HAS SELECCIONADO MODIFICAR CLIENTE");
                    actualizarcliente(cliente);
                    salir = true;
                    break;
                case 3:
                    System.out.println("HAS SELECCIONADO AÑADIR PRODUCTO");
                    meterproducto();
                    salir = true;
                    break;
                case 4:
                    System.out.println("HAS SELECCIONADO SALIR GRACIAS");
                    salir = true;
                    break;    
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
            } catch(InputMismatchException e){
                System.out.println("Debes insertar un número");
                sn.next();
            }
            }
    }
    //--------------------------------------------------------------------------REGISTRAR----------------------------------------------------------------------------------------------
    // registrar el usuario admin
    public static void registroUsuarios() throws SQLException{
        //scanner
        Scanner dato = new Scanner(System.in);
        Scanner dato1 = new Scanner(System.in);
        Scanner dato2 = new Scanner(System.in);
        Scanner dato3 = new Scanner(System.in);
        //conexion
        usuariosDAO usuariodao=new usuariosDAO();
        usuarios guardarusuario = new usuarios("", "",0);
        boolean existe = false;
        ArrayList<usuarios>nombreprov = new ArrayList<>();//añadir el array de usuario
        String nombreu;
        String contra = "";
        String conadmin = "";
        int tipo = 0;
        boolean acceder = false;
        do{
        try {//recorrer lo que hay dentro del array 
            nombreprov = (ArrayList<usuarios>) usuariodao.seleccionar();
            nombreprov.forEach(user -> {
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        do{
        System.out.println("\nIntroduce un nombre de usuario ");
        nombreu = dato.nextLine();
            //comparar el valor añadido a lo que tengo en la bbdd 
         for (usuarios s : nombreprov) {
                if (s.getuNombre().equals(nombreu)) {
                    nombreprov = (ArrayList<usuarios>) usuariodao.seleccionar();
                    guardarusuario = s;
                    existe = true;
                    System.out.println("ya existe un usuario con el mismo nombre");
                   //vuelve a ejecutar la peticion del nombre de usuario ya que habia ya uno en nuestra bbdd
                }
            }   
        
        if(!existe){
            System.out.println("no hay ningun nombre de usuario igual enhorabuena... ");
            
        }
        }while(nombreprov.contains(new usuarios(nombreu,"",0)));
        do{
                System.out.println("Ahora introduce una contraseña para " + nombreu +" (min 3 caracteres, Max 40 caracteres)");
                contra = dato1.nextLine();
                if (contra.length()<3 || contra.length()>40){
                    System.out.println("Contraseña no valida");
                }
            }while(contra.length()<3 || contra.length()>40);
            do{
            System.out.println("Asignale un tipo");
            System.out.println("//=====================\\");
            System.out.println("||                     ||");
            System.out.println("|| 0. ADMINISTRADOR    ||");
            System.out.println("|| 1. CLIENTE          ||");
            System.out.println("|| 2. SALIR            ||");
            System.out.println("||                     ||");
            System.out.println("\\=====================//");
            
            tipo = dato2.nextInt();
            if(tipo == 0){
                System.out.println("ASIGNASTE EL TIPO " + tipo);
                System.out.println("Introduce la contraseña administrativa");
                conadmin = dato3.nextLine();
                if(conadmin.equals("duketo01")){
                    System.out.println("Usuario Admin creado");
                    acceder = true;
                }else{
                    System.out.println("No es la contraseña correcta");
                }
            }else if(tipo == 1){
                System.out.println("ASIGNASTE EL TIPO " + tipo);
                System.out.println("prosigue con el registro");
                acceder = false;
                registrocliente();
                System.out.println("cliente creado Muchas gracias");
                
                System.exit(0);
            }else if(tipo == 2){
                    System.out.println("Gracias por usuar la app");
                    }else{
                    System.out.println("tipo incorrecto");
                    }
            }while(tipo <0 || tipo > 2);
        }while(acceder != true);
            usuarios usuario = new usuarios(0,nombreu,contra,tipo);
            nombreprov.add(new usuarios(0,nombreu,contra,tipo));
            usuariodao.insertar(usuario);
            System.exit(0);
    }
    //REGISTRO DE CLIENTE
    public static void registrocliente() throws SQLException{
        clientesDAO clientedao=new clientesDAO();
        Scanner dato = new Scanner(System.in);
        clientes guardarcliente = new clientes("", "",0);
        System.out.println("\nIntroduzca el nombre de cliente(No podras modificarlo): ");
        guardarcliente.setcNombre(dato.nextLine());
        System.out.println("\nIntroduzca el CIF de cliente: ");
        guardarcliente.setcCif(dato.nextLine());
        System.out.println("\nIntroduzca el Telefono de contacto del cliente: ");
        guardarcliente.setcTelefono(dato.nextInt());

        clientedao.insertar(guardarcliente);
        menu1();
    }
    //--------------------------------------------------------------------------LOGIN------------------------------------------------------------------------------------------------------------------
    public static void loginAdmin() throws SQLException{
        
        Scanner dato = new Scanner(System.in);
        Scanner dato2 = new Scanner(System.in);
        ArrayList<usuarios>nombreprov = new ArrayList<>();//añadir el array de usuario
        usuariosDAO usuariodao=new usuariosDAO();
        usuarios guardarusuario = new usuarios("", "",0);
        
        boolean existe = false;
        String nombreu="";
        String contraAdmin="";
     
            try {//recorrer lo que hay dentro del array 
            nombreprov = (ArrayList<usuarios>) usuariodao.seleccionar();
            nombreprov.forEach(user -> {
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            do{
        System.out.println("\nIntroduce tu nombre de usuario ");
        nombreu = dato.nextLine();
            //comparar el valor añadido a lo que tengo en la bbdd 
        System.out.println("\nIntroduce tu contraseña ");
        contraAdmin = dato2.nextLine();
         for (usuarios s : nombreprov) {
                if (s.getuNombre().equals(nombreu)&&s.getuContraseña().equals(contraAdmin)) {
                    nombreprov = (ArrayList<usuarios>) usuariodao.seleccionar();
                    guardarusuario = s;
                    existe = true;
                    System.out.println("usuario encontrado");
                    menu3();
                    System.exit(0);
                }else{
                   
                    System.out.println("usuario no encontrado");
                     existe = false;
                }
            }
         
        
        }while(existe == false);
            
    }
    //--------------------------------------------------------------------------USUARIOS---------------------------------------------------------------------------------------------------------------
    public static void loginCliente()throws SQLException{
         
        Scanner dato = new Scanner(System.in);
        ArrayList<clientes>clientesprov = new ArrayList<>();//añadir el array de usuario
        clientesDAO usuariodao=new clientesDAO();
        clientes guardarcliente = new clientes("", "",0);
        
        boolean existe = false;
        String cifc="";
     
            try {//recorrer lo que hay dentro del array 
            clientesprov = (ArrayList<clientes>) usuariodao.seleccionar();
            clientesprov.forEach(user -> {
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            do{
        System.out.println("\nIntroduce tu CIF para logearte ");
        cifc = dato.nextLine();
         for (clientes s : clientesprov) {
                if (s.getcCif().equals(cifc)) {
                    clientesprov = (ArrayList<clientes>) usuariodao.seleccionar();
                    guardarcliente = s;
                    existe = true;
                    System.out.println("usuario encontrado");
                    menu4();
                }else{
                    existe = false;
                    System.out.println("usuario no encontrado");
                }
            }
        }while(existe == false);
    }
    public static void actualizarusuario(ArrayList<usuarios>usuariosact){
        Scanner dato = new Scanner(System.in);
        String contraseñau;
        String nombreu;
        boolean existe = false;
        usuariosDAO usuariodao = new usuariosDAO();
        usuarios guardarusuarios = null;
        try {
            usuariosact = (ArrayList<usuarios>) usuariodao.seleccionar();
            usuariosact.forEach(user -> {
                System.out.println("user = " + user);
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        do{
        System.out.println("\nIntroduce el nombre de usuario para actualizar: ");
        nombreu = dato.nextLine();
        for (usuarios s : usuariosact) {
                if (s.getuNombre().equals(nombreu)) {
                    guardarusuarios = s;
                    existe = true;
                    break;
                }
            }
        if(!existe){
            System.out.println("no se ha encontrado ese administrador vuelve a intentarlo");
        }
        }while(!existe);
        
        System.out.println("\nActualize el nombre del administrador: ");
        nombreu = dato.nextLine();
        guardarusuarios.setuNombre(nombreu);
        System.out.println("\nActualiza la contraseña del administrador: ");
        contraseñau = dato.nextLine();
        guardarusuarios.setuContraseña(contraseñau);
        usuariodao.actualizar(guardarusuarios);
        
    }
    public static void eliminarusuario(ArrayList<usuarios>usuariosact) throws SQLException{
        Scanner teclado = new Scanner(System.in);      
        usuariosDAO usuariodao=new usuariosDAO();
        usuarios usuariosins = new usuarios("", "", 0);
        String nombre;
        boolean existe = false;
       
        try {
            usuariosact = (ArrayList<usuarios>) usuariodao.seleccionar();
            usuariosact.forEach(produc -> {
                System.out.println(produc);
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("\nIntroduzca el nombre del producto de baño a eliminar: ");
        nombre=teclado.nextLine();
        for(usuarios p: usuariosact){
            if(p.getuNombre().equals(nombre)){
                usuariosins = p;
                existe = true;
                System.out.println("Existe");
                break;
            }
        }
        if(!existe){
            System.out.println("No existe ese nombre");
        }
       
        usuariodao.eliminar(usuariosins);
       
        System.out.println("\nPRODUCTO ELIMINADO\n");
    }
    //------------------------------------------------------------------------FIN-USUARIOS---------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------CLIENTES---------------------------------------------------------------------------------------------------------------
   
    
    public static void actualizarcliente(ArrayList<clientes>clienteact){
        Scanner dato = new Scanner(System.in);
        String nombrecliente;
        String cif;
        boolean existe = false;
        int telefono;
        clientesDAO clientedao = new clientesDAO();
        clientes guardarcliente = null;
        try {
            clienteact = (ArrayList<clientes>) clientedao.seleccionar();
            clienteact.forEach(client -> {
                System.out.println("client = " + client);
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        do{
        System.out.println("\nIntroduce el CIF del cliente para actualizar: ");
        nombrecliente = dato.nextLine();
        for (clientes s : clienteact) {
                if (s.getcCif().equals(nombrecliente)) {
                    guardarcliente = s;
                    existe = true;
                    break;
                }
            }
        if(!existe){
            System.out.println("no se ha encontrado ese cliente vuelve a intentarlo");
        }
        }while(!existe);
        
        System.out.println("\nActualize el nombre de cliente: ");
        cif = dato.nextLine();
        guardarcliente.setcNombre(cif);
        System.out.println("\nActualiza el Telefono de contacto del cliente: ");
        telefono = dato.nextInt();
        guardarcliente.setcTelefono(telefono);
        clientedao.actualizar(guardarcliente);
        
    }
    public static void eliminarcliente(ArrayList<clientes>clienteact) throws SQLException{
        Scanner teclado = new Scanner(System.in);      
        clientesDAO productoDao=new clientesDAO();
        clientes productosIns = new clientes("", "", 0);
        String nombre;
        boolean existe = false;
       
        try {
            clienteact = (ArrayList<clientes>) productoDao.seleccionar();
            clienteact.forEach(produc -> {
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
       
            System.out.println("\nIntroduzca el CIF para eliminar cuenta de cliente: ");
        nombre=teclado.nextLine();
       
        for(clientes p: clienteact){
            if(p.getcCif().equals(nombre)){
                productosIns = p;
                existe = true;
                System.out.println("Existe");
                break;
            }
        }
       
        if(!existe){
            System.out.println("No existe ese CIF");
        }
       
        productoDao.eliminar(productosIns);
       
        System.out.println("\nCLIENTE ELIMINADO\n");
                System.exit(0);

    }
    //--------------------------------------------------------------------FIN--CLIENTES---------------------------------------------------------------------------------------------------------------
    //-----------Productos------
    public static void meterproducto(){
        Scanner dato = new Scanner(System.in);
        productosDAO productodao=new productosDAO();
        productos guardarproducto = new productos("", "",0,0);
        int stoq = 10;
        LocalDateTime fechatiempo;
        fechatiempo = LocalDateTime.now();
        System.out.println("\nIntroduzca el nombre de producto: ");
        guardarproducto.setpNombre(dato.nextLine());
        System.out.println("\nIntroduzca la descripcion: ");
        guardarproducto.setpDescripcion(dato.nextLine());
        System.out.println("\nIntroduzca el Precio: ");
        guardarproducto.setpPrecio(dato.nextDouble());
        do{
            System.out.println("\nIntroduzca la cantidad que quiera: ");
            guardarproducto.setpStock(dato.nextInt());
            if(guardarproducto.getpStock()>stoq){
                System.out.println("no tenemos el stock suficiente");

            }else{
                productodao.insertar(guardarproducto);
                System.out.println("el producto se ha guardado");
                String productostxt = "productos.txt";
                manejoArchivos.agregarArchivo(productostxt, guardarproducto.getpNombre(),guardarproducto.getpDescripcion(), guardarproducto.getpPrecio(), fechatiempo);
                menu6();
            }
        }while(guardarproducto.getpStock()>stoq);
    }
    public static void registroenvio(){
        Scanner dato = new Scanner(System.in);
        enviosDAO papaya = new enviosDAO();
        envios guardarenvio = new envios();
        System.out.println("\nIntroduce el nombre de la empresa de envios que quieras: ");
        guardarenvio.seteEmpresa(dato.nextLine());
        System.out.println("\nIntroduce tu domicilio: ");
        guardarenvio.seteDomicilio(dato.nextLine());
        System.out.println("\nIntroduzca la fecha en la que quieras recibir tu producto: ");
            System.out.println("Introduzca el día: ");
            int dia=dato.nextInt();
            System.out.println("Introduzca el mes: ");
            int mes=dato.nextInt()-1;
            System.out.println("Introduzca el año: ");
            int anio=dato.nextInt()-1900;
            Date introducirfecha =new Date(anio,mes,dia);  
            guardarenvio.seteFecha(introducirfecha);
            
            papaya.insertar(guardarenvio);
            System.exit(0);
    }
        
   
}
