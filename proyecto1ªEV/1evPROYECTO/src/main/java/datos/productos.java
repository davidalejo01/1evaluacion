/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class productos {
    private int idProductos;
    private String pNombre;
    private String  pDescripcion;
    private double pPrecio;
    private int pStock;

    public productos(int idProductos, String pNombre, String pDescripcion, double pPrecio, int pStock) {
        this.idProductos = idProductos;
        this.pNombre = pNombre;
        this.pDescripcion = pDescripcion;
        this.pPrecio = pPrecio;
        this.pStock = pStock;
    }

    public productos(String pNombre, String pDescripcion, double pPrecio, int pStock) {
        this.pNombre = pNombre;
        this.pDescripcion = pDescripcion;
        this.pPrecio = pPrecio;
        this.pStock = pStock;
    }

    public productos() {
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getpDescripcion() {
        return pDescripcion;
    }

    public void setpDescripcion(String pDescripcion) {
        this.pDescripcion = pDescripcion;
    }

    public double getpPrecio() {
        return pPrecio;
    }

    public void setpPrecio(double pPrecio) {
        this.pPrecio = pPrecio;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idProductos;
        hash = 67 * hash + Objects.hashCode(this.pNombre);
        hash = 67 * hash + Objects.hashCode(this.pDescripcion);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.pPrecio) ^ (Double.doubleToLongBits(this.pPrecio) >>> 32));
        hash = 67 * hash + this.pStock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final productos other = (productos) obj;
        if (this.idProductos != other.idProductos) {
            return false;
        }
        if (Double.doubleToLongBits(this.pPrecio) != Double.doubleToLongBits(other.pPrecio)) {
            return false;
        }
        if (this.pStock != other.pStock) {
            return false;
        }
        if (!Objects.equals(this.pNombre, other.pNombre)) {
            return false;
        }
        if (!Objects.equals(this.pDescripcion, other.pDescripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "productos{" + "idProductos=" + idProductos + ", pNombre=" + pNombre + ", pDescripcion=" + pDescripcion + ", pPrecio=" + pPrecio + ", pStock=" + pStock + '}';
    }

    
}
