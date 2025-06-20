package turneramedicav2.Servicio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import turneramedicav2.Entidades.Paciente;
import turneramedicav2.Persistencia.PacienteDAO;


public class PacienteController {
    
    private PacienteDAO persistencia;
    
    public PacienteController (PacienteDAO persistencia) {
        this.persistencia = persistencia;
    }
    
    public void guardarPaciente (Paciente p) {
        try {
            persistencia.grabar(p);
        } catch (SQLException ex) {
            System.getLogger(PacienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void eliminarPaciente (Paciente p) {
        try {
            persistencia.eliminar(p);
        } catch (SQLException ex) {
            System.getLogger(PacienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void modificarPaciente (Paciente p) {
        try {
            persistencia.modificar(p);
        } catch (SQLException ex) {
            System.getLogger(PacienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public List<Paciente> leerTodos (Paciente p) {
        List<Paciente> retorno = null;
        try {
            retorno = persistencia.leerTodos();
        } catch (SQLException ex) {
            System.getLogger(PacienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return retorno;
    }
    
    public Paciente leerPorId (int id) {
        Paciente retorno = null;
        try {
            retorno = persistencia.leerPorId(id);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.getLogger(PacienteController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return retorno;
    }
}