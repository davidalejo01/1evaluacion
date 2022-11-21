/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class envios {
    private int idEnvios;
    private String eEmpresa;
    private String eDomicilio;
    private Date eFecha;

    public envios(int idEnvios, String eEmpresa, String eDomicilio, Date eFecha) {
        this.idEnvios = idEnvios;
        this.eEmpresa = eEmpresa;
        this.eDomicilio = eDomicilio;
        this.eFecha = eFecha;
    }

    public envios(String eEmpresa, String eDomicilio, Date eFecha) {
        this.eEmpresa = eEmpresa;
        this.eDomicilio = eDomicilio;
        this.eFecha = eFecha;
    }

    public envios() {
    }

    public int getIdEnvios() {
        return idEnvios;
    }

    public void setIdEnvios(int idEnvios) {
        this.idEnvios = idEnvios;
    }

    public String geteEmpresa() {
        return eEmpresa;
    }

    public void seteEmpresa(String eEmpresa) {
        this.eEmpresa = eEmpresa;
    }

    public String geteDomicilio() {
        return eDomicilio;
    }

    public void seteDomicilio(String eDomicilio) {
        this.eDomicilio = eDomicilio;
    }

    public Date geteFecha() {
        return eFecha;
    }

    public void seteFecha(Date eFecha) {
        this.eFecha = eFecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idEnvios;
        hash = 31 * hash + Objects.hashCode(this.eEmpresa);
        hash = 31 * hash + Objects.hashCode(this.eDomicilio);
        hash = 31 * hash + Objects.hashCode(this.eFecha);
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
        final envios other = (envios) obj;
        if (this.idEnvios != other.idEnvios) {
            return false;
        }
        if (!Objects.equals(this.eEmpresa, other.eEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.eDomicilio, other.eDomicilio)) {
            return false;
        }
        if (!Objects.equals(this.eFecha, other.eFecha)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "envios{" + "idEnvios=" + idEnvios + ", eEmpresa=" + eEmpresa + ", eDomicilio=" + eDomicilio + ", eFecha=" + eFecha + '}';
    }
    
}
