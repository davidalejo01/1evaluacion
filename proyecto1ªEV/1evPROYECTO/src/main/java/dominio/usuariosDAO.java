/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import datos.usuarios;
import static dominio.conexion.close;
import static dominio.conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class usuariosDAO {
    private static final String SQL_SELECT ="SELECT * from usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios ( uNombre , uContraseña, uTipo) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET uContraseña=?, uNombre=?, uTipo=? WHERE idUsuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE idUsuario=?";
    
    //METODO QUE NOS LISTA TODAS LAS PERSONA DE NUESTRO SISTEMA
    public List<usuarios>  seleccionar() throws SQLException{
        
        //iNICIALIZO MIS variables
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        usuarios persona =null;
        List<usuarios> personas = new ArrayList<>();
        
        conn = getConnection();
        ps = conn.prepareStatement(SQL_SELECT);
        rs = ps.executeQuery();
        
        while(rs.next()){
            int idUsuario = rs.getInt("idUsuario");//entre comillas es igual que en sql
            String uNombre = rs.getString("uNombre");
            String uContraseña = rs.getString("uContraseña");
            int uTipo = rs.getInt("uTipo");
            
            personas.add(new usuarios(idUsuario, uNombre, uContraseña, uTipo));
        }
        close(rs);
        close(ps);
        close(conn);
        
        return personas;
    }
    
    //IMPORTANTE SEGUIR LOS PASOS (1º, 2º, 3º, 4º)
    //METODO QUE INSERTA UNA PERSONA EN MI TABLA O EN MI SISTEMA
    public int insertar(usuarios persona){
        
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
            stmt.setString(1, persona.getuNombre());         //lo del "1," es la posicion en la que vamos aporner el nombre
            stmt.setString(2, persona.getuContraseña());
            stmt.setInt(3, persona.getuTipo());
            
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
    
    //IMPORTANTE SEGUIR LOS PASOS (1º, 2º, 3º, 4º)
    public int actualizar(usuarios persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registrar = 0;
        
        try {
            //1. HACER LA CONECXION
            conn = getConnection();
            
            //2. PREPARAR LA INTRUCCION PARA EJECUTARLA CON LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            //3. ASIGNAR LOS VALORES A LOS ? DE LA CONSULTA
            stmt.setString(1, persona.getuContraseña()); 
            stmt.setString(2, persona.getuNombre());
            stmt.setInt(3, persona.getuTipo());
            stmt.setInt(4, persona.getIdUsuario());
            
            //4. EJECUTAR LA QUERY
            registrar = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrar;
    }
    
    public int eliminar(usuarios persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registrar = 0;
        
        try {
            //1. HACER LA CONECXION
            conn = getConnection();
            
            //2. PREPARAR LA INTRUCCION PARA EJECUTARLA CON LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_DELETE);
            
            //3. ASIGNAR LOS VALORES A LOS ? DE LA CONSULTA
            
            stmt.setInt(1, persona.getIdUsuario());  //el "1," es la posicion de la interrogacion
            
            //4. EJECUTAR LA QUERY
            registrar = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrar;
    }
}
