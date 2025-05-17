
package interfaz;


public interface Gestionable {
    
    void agregar();
    void eliminar();
    void mostrar();
    void cambiarEstadoOrden(String serial);
    void facturarOrden(String serial);
    
}
