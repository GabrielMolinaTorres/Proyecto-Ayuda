
package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenTrabajo {
    
    private String serial;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    private EstadoOrden estado;
    private double costoTrabajo;
    private Persona cliente; 
    private List<Material> materiales = new ArrayList<Material>();
   

    public OrdenTrabajo(String serial, LocalDate fechaCreacion, LocalDate fechaLimite, EstadoOrden estado, double costoTrabajo, Persona cliente, List<Material> materiales ) {
        this.serial = serial;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
        this.costoTrabajo= costoTrabajo;
        this.cliente= cliente;
        this.materiales = materiales;
        
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }


    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public double getCostoTrabajo() {
        return costoTrabajo;
    }

    public void setCostoTrabajo(double costoTrabajo) {
        this.costoTrabajo = costoTrabajo;
    }

    public List<Material> getCantMateriales() {
        return materiales;
    }

    public void setCantMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    
    
}
