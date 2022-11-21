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
public class usuarios {
    private int idUsuario;
    private String uNombre;
    private String  uContraseña;
    private int uTipo;

    public usuarios(int idUsuario, String uNombre, String uContraseña, int uTipo) {
        this.idUsuario = idUsuario;
        this.uNombre = uNombre;
        this.uContraseña = uContraseña;
        this.uTipo = uTipo;
    }

    public usuarios(String uNombre, String uContraseña, int uTipo) {
        this.uNombre = uNombre;
        this.uContraseña = uContraseña;
        this.uTipo = uTipo;
    }

    public usuarios(String uNombre, String uContraseña) {
        this.uNombre = uNombre;
        this.uContraseña = uContraseña;
    }

    public usuarios() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getuNombre() {
        return uNombre;
    }

    public void setuNombre(String uNombre) {
        this.uNombre = uNombre;
    }

    public String getuContraseña() {
        return uContraseña;
    }

    public void setuContraseña(String uContraseña) {
        this.uContraseña = uContraseña;
    }

    public int getuTipo() {
        return uTipo;
    }

    public void setuTipo(int uTipo) {
        this.uTipo = uTipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idUsuario;
        hash = 79 * hash + Objects.hashCode(this.uNombre);
        hash = 79 * hash + Objects.hashCode(this.uContraseña);
        hash = 79 * hash + this.uTipo;
        return hash;
    }

    /*@Override
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
        final usuarios other = (usuarios) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.uTipo != other.uTipo) {
            return false;
        }
        if (!Objects.equals(this.uNombre, other.uNombre)) {
            return false;
        }
        if (!Objects.equals(this.uContraseña, other.uContraseña)) {
            return false;
        }
        return true;
    }*/
    @Override
    public boolean equals(Object object) {
        if(uNombre.equals(((usuarios) object).getuNombre())) {
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "usuarios{" + "idUsuario=" + idUsuario + ", uNombre=" + uNombre + ", uContrase\u00f1a=" + uContraseña + ", uTipo=" + uTipo + '}';
    }
    
    
}
