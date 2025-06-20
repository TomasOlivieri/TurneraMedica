package turneramedicav2.Entidades;


public class Persona {
    private final int id;
    private String nombre;
    private String apellido;
    
    protected Persona (int id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido (String apellido) {
        this.apellido = apellido;
    }
    
    public int getId () {
        return this.id;
    }
    
    public String getNombre () {
        return this.nombre;
    }
    
    public String getApellido () {
        return this.apellido;
    }
}
