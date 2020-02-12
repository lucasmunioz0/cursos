package com.eduit.javaspring.clase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("dataSQLRepository")
@Scope("singleton")
public class DataRepository {
    private Conexion conexion;

    @Autowired
    public DataRepository(@Qualifier("mysqlConexion") Conexion conexion){
        this.conexion = conexion;
    }

    public void save(String data){
        conexion.connect();
        conexion.execute("save");
        conexion.close();
    }
}
