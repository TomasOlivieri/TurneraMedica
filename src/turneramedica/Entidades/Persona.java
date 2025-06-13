package turneramedica.Entidades;


public class Persona {
    private final String id;
    private String nombre;
    private String apellido;
    
    protected Persona (String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public String getId (){
        return this.id;
    }
    
    public String getNombre () {
        return this.nombre;
    }
    
    public String getApellido () {
        return this.apellido;
    }
    
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido (String apellido) {
        this.apellido = apellido;
    }
}
