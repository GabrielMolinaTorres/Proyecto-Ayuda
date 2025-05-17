
package logica;


public class Material {
    private String nombre;
    private double costo;
    private  String numeroSerie;
    private int unidad;

   

    public Material(String nombre, double costo, String numeroSerie, int unidad) {
        this.nombre = nombre;
        this.costo = costo;
        this.numeroSerie = numeroSerie;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }
    
    
        
}
