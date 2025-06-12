package turneramedica.Entidades;


public class Medico extends Persona{
    int costo;

    public Medico(String id, String nombre, String apellido, int costo) {
        super(id, nombre, apellido);
        this.costo = costo;
    }
}
