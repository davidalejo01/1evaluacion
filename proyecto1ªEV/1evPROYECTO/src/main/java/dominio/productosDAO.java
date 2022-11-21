/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import datos.productos;
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
public class productosDAO {
    private static final String SQL_SELECT ="SELECT * from productos";
    private static final String SQL_INSERT = "INSERT INTO productos (pNombre , pDescripcion , pPrecio ,pStock) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE idProductos=?";
    
    //METODO QUE NOS LISTA TODAS LAS PERSONA DE NUESTRO SISTEMA
    public List<productos>  seleccionar() throws SQLException{
        
        //iNICIALIZO MIS variables
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        productos objeto =null;
        List<productos> objetos = new ArrayList<>();
        
        conn = getConnection();
        ps = conn.prepareStatement(SQL_SELECT);
        rs = ps.executeQuery();
        
        while(rs.next()){
            int idProductos = rs.getInt("idProductos");//entre comillas es igual que en sql
            String pNombre = rs.getString("pNombre");
            String pDescripcion = rs.getString("pDescripcion");
            double pPrecio = rs.getDouble("pPrecio");
            int pStock = rs.getInt("pStock");
            objetos.add(new productos(idProductos, pNombre, pDescripcion, pPrecio,pStock));
        }
        close(rs);
        close(ps);
        close(conn);
        
        return objetos;
    }
    
    //IMPORTANTE SEGUIR LOS PASOS (1º, 2º, 3º, 4º)
    //METODO QUE INSERTA UNA PERSONA EN MI TABLA O EN MI SISTEMA
    public int insertar(productos objeto){
        
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
            stmt.setString(1, objeto.getpNombre());         //lo del "1," es la posicion en la que vamos aporner el nombre
            stmt.setString(2, objeto.getpDescripcion());
            stmt.setDouble(3, objeto.getpPrecio());
            stmt.setInt(4, objeto.getpStock());
            
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
