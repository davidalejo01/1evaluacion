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
public class clientes {
    private int idClientes;
    private String cNombre;
    private String  cCif;
    private int cTelefono;

    public clientes(int idClientes, String cNombre, String cCif, int cTelefono) {
        this.idClientes = idClientes;
        this.cNombre = cNombre;
        this.cCif = cCif;
        this.cTelefono = cTelefono;
    }

    public clientes(String cNombre, String cCif, int cTelefono) {
        this.cNombre = cNombre;
        this.cCif = cCif;
        this.cTelefono = cTelefono;
    }

    public clientes() {
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getcCif() {
        return cCif;
    }

    public void setcCif(String cCif) {
        this.cCif = cCif;
    }

    public int getcTelefono() {
        return cTelefono;
    }

    public void setcTelefono(int cTelefono) {
        this.cTelefono = cTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idClientes;
        hash = 71 * hash + Objects.hashCode(this.cNombre);
        hash = 71 * hash + Objects.hashCode(this.cCif);
        hash = 71 * hash + this.cTelefono;
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
        final clientes other = (clientes) obj;
        if (this.idClientes != other.idClientes) {
            return false;
        }
        if (this.cTelefono != other.cTelefono) {
            return false;
        }
        if (!Objects.equals(this.cNombre, other.cNombre)) {
            return false;
        }
        if (!Objects.equals(this.cCif, other.cCif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clientes{" + "idClientes=" + idClientes + ", cNombre=" + cNombre + ", cCif=" + cCif + ", cTelefono=" + cTelefono + '}';
    }

    
}
