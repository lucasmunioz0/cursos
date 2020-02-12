package com.azurecalidaddatos.models;

import java.time.LocalDate;

public class FacIncidente extends ModeloBase{
    private CausaIncidente causaIncidente;
    private DescripcionIncidente descripcionIncidente;
    private EstadoIncidente estadoIncidente;
    private Incidente incidente;
    private Informador informador;
    private MitigacionIncidente mitigacionIncidente;
    private ObjetoSistema objetoSistema;
    private SistemaOrigen sistemaOrigen;
    private SucesoIncidente sucesoIncidente;
    private TicketDerivado ticketDerivado;
    private TipoIncidente tipoIncidente;
    private Integer cantidad;
    private LocalDate fechaIncidente;

    public FacIncidente() {
    }
    
    public FacIncidente(CausaIncidente causaIncidente, DescripcionIncidente descripcionIncidente, EstadoIncidente estadoIncidente, Incidente incidente, Informador informador, MitigacionIncidente mitigacionIncidente, ObjetoSistema objetoSistema, SistemaOrigen sistemaOrigen, SucesoIncidente sucesoIncidente, TicketDerivado ticketDerivado, TipoIncidente tipoIncidente, Integer cantidad, LocalDate fechaIncidente) {
        this.causaIncidente = causaIncidente;
        this.descripcionIncidente = descripcionIncidente;
        this.estadoIncidente = estadoIncidente;
        this.incidente = incidente;
        this.informador = informador;
        this.mitigacionIncidente = mitigacionIncidente;
        this.objetoSistema = objetoSistema;
        this.sistemaOrigen = sistemaOrigen;
        this.sucesoIncidente = sucesoIncidente;
        this.ticketDerivado = ticketDerivado;
        this.tipoIncidente = tipoIncidente;
        this.cantidad = cantidad;
        this.fechaIncidente = fechaIncidente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaIncidente() {
        return fechaIncidente;
    }

    public void setFechaIncidente(LocalDate fechaIncidente) {
        this.fechaIncidente = fechaIncidente;
    }

    public CausaIncidente getCausaIncidente() {
        return causaIncidente;
    }

    public void setCausaIncidente(CausaIncidente causaIncidente) {
        this.causaIncidente = causaIncidente;
    }

    public DescripcionIncidente getDescripcionIncidente() {
        return descripcionIncidente;
    }

    public void setDescripcionIncidente(DescripcionIncidente descripcionIncidente) {
        this.descripcionIncidente = descripcionIncidente;
    }

    public EstadoIncidente getEstadoIncidente() {
        return estadoIncidente;
    }

    public void setEstadoIncidente(EstadoIncidente estadoIncidente) {
        this.estadoIncidente = estadoIncidente;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public Informador getInformador() {
        return informador;
    }

    public void setInformador(Informador informador) {
        this.informador = informador;
    }

    public MitigacionIncidente getMitigacionIncidente() {
        return mitigacionIncidente;
    }

    public void setMitigacionIncidente(MitigacionIncidente mitigacionIncidente) {
        this.mitigacionIncidente = mitigacionIncidente;
    }

    public ObjetoSistema getObjetoSistema() {
        return objetoSistema;
    }

    public void setObjetoSistema(ObjetoSistema objetoSistema) {
        this.objetoSistema = objetoSistema;
    }

    public SistemaOrigen getSistemaOrigen() {
        return sistemaOrigen;
    }

    public void setSistemaOrigen(SistemaOrigen sistemaOrigen) {
        this.sistemaOrigen = sistemaOrigen;
    }

    public SucesoIncidente getSucesoIncidente() {
        return sucesoIncidente;
    }

    public void setSucesoIncidente(SucesoIncidente sucesoIncidente) {
        this.sucesoIncidente = sucesoIncidente;
    }

    public TicketDerivado getTicketDerivado() {
        return ticketDerivado;
    }

    public void setTicketDerivado(TicketDerivado ticketDerivado) {
        this.ticketDerivado = ticketDerivado;
    }

    public TipoIncidente getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(TipoIncidente tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }
}
