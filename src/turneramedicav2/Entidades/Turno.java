package turneramedicav2.Entidades;

import java.util.Date;

public class Turno {
    private Medico medico;
    private Paciente paciente;
    private Date fecha;
    
    public Turno (Medico medico, Paciente paciente, Date fecha) {
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
    }
    
    
    public Medico getMedico () {
        return this.medico;
    }
    
    public Paciente getPaciente () {
        return this.paciente;
    }
    
    public Date getFecha () {
        return this.fecha;
    }
    
    
    public void setMedico (Medico medico) {
        this.medico = medico;
    }
    
    public void setPaciente (Paciente paciente) {
        this.paciente = paciente;
    }
    
    public void setFecha (Date fecha) {
        this.fecha = fecha;
    }
}
