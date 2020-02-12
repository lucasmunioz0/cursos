package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {
    @Inject
    private Candidato candidato;
    private Logger log = LogManager.getRootLogger();

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String enviar(){
        log.info("Entrando al método enviar");
        return candidato.getNombre().equals("Lucas")? "exito" : "fallo";
    }
}