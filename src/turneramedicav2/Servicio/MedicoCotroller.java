package turneramedicav2.Servicio;

import java.io.IOException;
import java.sql.SQLException;
import turneramedicav2.Entidades.Medico;
import turneramedicav2.Persistencia.MedicoDAO;


public class MedicoCotroller {
    private final MedicoDAO persistencia;
    
    
    public MedicoCotroller () {
        this.persistencia = new MedicoDAO();
    }
    
    
    public Medico loginMedico (String user, String pass) {
        Medico retorno = null;
        int id;
        
        try {
            id = persistencia.verificarCredenciales(user, pass);
            try {
                retorno = persistencia.leerPorId(id);
            } catch (IOException | ClassNotFoundException ex) {
                System.getLogger(MedicoCotroller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (SQLException ex) {
            System.getLogger(MedicoCotroller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return retorno;
    }
}
