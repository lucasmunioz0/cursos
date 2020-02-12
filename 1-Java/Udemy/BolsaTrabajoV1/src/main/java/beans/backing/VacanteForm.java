package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm extends Object {

    @Inject
    private Candidato candidato;
    private boolean comentarioEnviado;

    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando el objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {
        if (this.candidato.getNombre().equals("Juan")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;//este es un mensaje global
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }

    public void codigoPostalListener(ValueChangeEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = context.getViewRoot();
        String nuevoCodigoPostal = (String) event.getNewValue();
        int coloniaId = 0;
        String nuevaCiudad = "";
        if ("5005".equals(nuevoCodigoPostal)) {
            coloniaId = 1;
            nuevaCiudad = "Villa Allende";
        }
        UIInput coloniaInput = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
        coloniaInput.setValue(coloniaId);
        coloniaInput.setSubmittedValue(coloniaId);
        
        UIInput ciudadInput = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        ciudadInput.setValue(nuevaCiudad);
        ciudadInput.setSubmittedValue(nuevaCiudad);
        
        context.renderResponse();
    }
    
    public void ocultarComentario(ActionEvent event){
        comentarioEnviado = !comentarioEnviado;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }
}