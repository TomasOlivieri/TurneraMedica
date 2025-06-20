package turneramedicav2.Entidades;

public class Medico extends Persona{
    
    private String user;
    private String pass;
    private int costo;
    
    
    public Medico(int id, String nombre, String apellido, String user, String pass, int costo) {
        super(id, nombre, apellido);
        this.user = user;
        this.pass = pass;
        this.costo = costo;
    }
    
    
    public String getUser (){
        return this.user;
    }
    
    public String getPass (){
        return this.pass;
    }
    
    public int getCosto () {
        return this.costo;
    }
    
    public void setUser (String user) {
        this.user = user;
    }
    
    public void setPass (String pass) {
        this.pass = pass;
    }
    
    public void setCosto (int costo) {
        this.costo = costo;
    }
}
