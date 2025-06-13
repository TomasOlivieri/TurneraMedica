package turneramedica.Controller;

import java.sql.SQLException;
import java.util.List;
import turneramedica.Entidades.Medico;
import turneramedica.Persistencia.DAOMedico;


public class MedicoController {
    private DAOMedico daomedico;
    
    public MedicoController () {
        this.daomedico = new DAOMedico();
    }
    
    public List<Medico> obtenerTodosLosMedicos() throws ClassNotFoundException, SQLException {
        return daomedico.buscarTodos();
    }
}
