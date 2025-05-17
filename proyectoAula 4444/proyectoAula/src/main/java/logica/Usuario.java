
package logica;


public class Usuario extends Persona {
    private String usuario;
    private String contrasena;

    public Usuario(String usuario, String contrasena) {
        
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    
   
    public Usuario(String usuario, String contrasena, String nombre, String numero, String id) {
        super( nombre, numero, id);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }
        
     @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }   
    
        
    
}
