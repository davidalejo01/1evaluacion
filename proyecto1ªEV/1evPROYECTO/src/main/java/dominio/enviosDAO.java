/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import datos.envios;
import static dominio.conexion.close;
import static dominio.conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class enviosDAO {
    private static final String SQL_SELECT ="SELECT * from envios";
    private static final String SQL_INSERT = "INSERT INTO envios (eEmpresa , eDomicilio , eFecha) VALUES(?,?,?)";
    
    //METODO QUE NOS LISTA TODAS LAS PERSONA DE NUESTRO SISTEMA
    public List<envios>  seleccionar() throws SQLException{
        
        //iNICIALIZO MIS variables
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        envios objeto =null;
        List<envios> objetos = new ArrayList<>();
        
        conn = getConnection();
        ps = conn.prepareStatement(SQL_SELECT);
        rs = ps.executeQuery();
        
        while(rs.next()){
            int idEnvios = rs.getInt("idEnvios");//entre comillas es igual que en sql
            String eEmpresa = rs.getString("eEmpresa");
            String eDomicilio = rs.getString("eDomicilio");
            Date eFecha = rs.getDate("eFecha");
            objetos.add(new envios(idEnvios, eEmpresa,eDomicilio, eFecha));
        }
        close(rs);
        close(ps);
        close(conn);
        
        return objetos;
    }
    
    //IMPORTANTE SEGUIR LOS PASOS (1º, 2º, 3º, 4º)
    //METODO QUE INSERTA UNA PERSONA EN MI TABLA O EN MI SISTEMA
    public int insertar(envios objeto){
        
        //DECLARO EN INICIALIZO MIS VARIABLES
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            //1. HACER LA CONECXION
            conn = getConnection();
            
            //2. PREPARAR LA INTRUCCION PARA EJECUTARLA CON LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_INSERT);
            
            //3. ASIGNAR LOS VALORES A LOS ? DE LA CONSULTA
            stmt.setString(1, objeto.geteEmpresa());
            stmt.setString(2, objeto.geteDomicilio());   
            stmt.setDate(3, objeto.geteFecha());         //lo del "1," es la posicion en la que vamos aporner el nombre
            
            
            //4. EJECUTAR LA QUERY
            registros = stmt.executeUpdate();   //4.1 PRIMERO ESTA LINEA
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);     //4.2 SEGUNDO ESTO
        } finally {
            try {
                close(stmt);                    //4.3 TERCERO ESTE
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out); //4.4 CUARTO ESTE
            }
        }
        return registros;
    }
    
    
    }

