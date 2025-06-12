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
}
