package com.azurecalidaddatos.business;

import com.azurecalidaddatos.daos.Conexion;
import com.azurecalidaddatos.daos.DaoCausaIncidente;
import com.azurecalidaddatos.daos.DaoDescripcionIncidente;
import com.azurecalidaddatos.daos.DaoEstadoIncidente;
import com.azurecalidaddatos.daos.DaoFacIncidente;
import com.azurecalidaddatos.daos.DaoIncidente;
import com.azurecalidaddatos.daos.DaoInformador;
import com.azurecalidaddatos.daos.DaoMitigacionIncidente;
import com.azurecalidaddatos.daos.DaoObjetoSistema;
import com.azurecalidaddatos.daos.DaoSistemaOrigen;
import com.azurecalidaddatos.daos.DaoSucesoIncidente;
import com.azurecalidaddatos.daos.DaoTicketDerivado;
import com.azurecalidaddatos.daos.DaoTipoIncidente;
import com.azurecalidaddatos.daos.IDao;
import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.CausaIncidente;
import com.azurecalidaddatos.models.DescripcionIncidente;
import com.azurecalidaddatos.models.EstadoIncidente;
import com.azurecalidaddatos.models.FacIncidente;
import com.azurecalidaddatos.models.Incidente;
import com.azurecalidaddatos.models.Informador;
import com.azurecalidaddatos.models.MitigacionIncidente;
import com.azurecalidaddatos.models.ObjetoSistema;
import com.azurecalidaddatos.models.SistemaOrigen;
import com.azurecalidaddatos.models.SucesoIncidente;
import com.azurecalidaddatos.models.TicketDerivado;
import com.azurecalidaddatos.models.TipoIncidente;
import com.azurecalidaddatos.utils.Result;
import java.sql.Connection;
import java.sql.SQLException;

public class IncidenteBus {
    private static final IDao<Incidente> daoIncidente = new DaoIncidente();
    private static final IDao<SistemaOrigen> daoSistemaOrigen = new DaoSistemaOrigen();
    private static final IDao<TipoIncidente> daoTipoIncidente = new DaoTipoIncidente();
    private static final IDao<EstadoIncidente> daoEstadoIncidente = new DaoEstadoIncidente();
    private static final IDao<SucesoIncidente> daoSucesoIncidente = new DaoSucesoIncidente();
    private static final IDao<ObjetoSistema> daoObjetoSistema = new DaoObjetoSistema();
    private static final IDao<CausaIncidente> daoCausaIncidente = new DaoCausaIncidente();
    private static final IDao<TicketDerivado> daoTicketDerivado = new DaoTicketDerivado();
    private static final IDao<DescripcionIncidente> daoDescripcionIncidente = new DaoDescripcionIncidente();
    private static final IDao<MitigacionIncidente> daoMitigacionIncidente = new DaoMitigacionIncidente();
    private static final IDao<Informador> daoInformador = new DaoInformador();
    private static final IDao<FacIncidente> daoFacIncidente = new DaoFacIncidente();
    
    public Result<Boolean> insertarIncidente(FacIncidente facIncidente) throws SQLException{
        final Result<Boolean> result = new Result();
        Connection conn = null;
        validarInsert(result, facIncidente);
        try {
            conn = Conexion.getConnection();
            conn.setAutoCommit(false);
            daoIncidente.insert(facIncidente.getIncidente());
            facIncidente.setIncidente(daoIncidente.getByNombre(facIncidente.getIncidente().getNombre()));
            daoCausaIncidente.insert(facIncidente.getCausaIncidente());
            facIncidente.setCausaIncidente(daoCausaIncidente.getByNombre(facIncidente.getCausaIncidente().getNombre()));
            daoTicketDerivado.insert(facIncidente.getTicketDerivado());
            facIncidente.setTicketDerivado(daoTicketDerivado.getByNombre(facIncidente.getTicketDerivado().getNombre()));
            daoDescripcionIncidente.insert(facIncidente.getDescripcionIncidente());
            facIncidente.setDescripcionIncidente(daoDescripcionIncidente.getByNombre(facIncidente.getDescripcionIncidente().getNombre()));
            daoMitigacionIncidente.insert(facIncidente.getMitigacionIncidente());
            facIncidente.setMitigacionIncidente(daoMitigacionIncidente.getByNombre(facIncidente.getMitigacionIncidente().getNombre()));
            daoInformador.insert(facIncidente.getInformador());
            facIncidente.setInformador(daoInformador.getByNombre(facIncidente.getInformador().getNombre()));
            
            daoFacIncidente.insert(facIncidente);
            
            conn.commit();
        } catch (SQLException | BusinessException ex) {
            result.agregarMensajeError(ex.toString());
            if(conn != null) 
                conn.rollback();
        } finally {
            if(conn != null) 
                conn.close();
        }
        
        return result;
    }
    
    public void validarInsert(Result<Boolean> result, FacIncidente facIncidente){
        
    }
}
