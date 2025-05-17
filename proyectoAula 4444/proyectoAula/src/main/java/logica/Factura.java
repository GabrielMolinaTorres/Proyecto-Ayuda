
package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String serialFactura;
    private LocalDate fechaEmision;
    private List<Material> materiales = new ArrayList <Material>();

    public Factura(String serialFactura, LocalDate fechaEmision, List<Material>materiales) {
        this.serialFactura = serialFactura;
        this.fechaEmision = fechaEmision;
        this.materiales = materiales;
    }

    public String getSerialFactura() {
        return serialFactura;
    }

    public void setSerialFactura(String serialFactura) {
        this.serialFactura = serialFactura;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }
    
    
    
        
    
}
