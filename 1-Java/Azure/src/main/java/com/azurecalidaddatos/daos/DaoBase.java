package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.ModeloBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class DaoBase<T extends ModeloBase> implements IDao<T>{    
    @Override
    public void insert(T modelobase) throws SQLException, BusinessException {
        insert(modelobase, null);
    }
    
    @Override
    public void update(T modeloBase) throws SQLException, BusinessException {
        update(modeloBase, null);
    }

    @Override
    public void delete(T modeloBase) throws SQLException, BusinessException {
        delete(modeloBase, null);
    }
    
    @Override
    public List<T> getObjectsByNombre(String nombre) throws SQLException, BusinessException {
        return getObjectsByNombre(nombre, null);
    }

    @Override
    public T getByNombre(String nombre) throws SQLException, BusinessException {
        return getByNombre(nombre, null);
    }

    @Override
    public abstract T getByNombre(String nombre, Connection connection) throws SQLException, BusinessException;
    
    @Override
    public abstract void insert(T t, Connection connection) throws SQLException, BusinessException;
    
    @Override
    public abstract void update(T t, Connection connection) throws SQLException, BusinessException;    

    @Override
    public abstract void delete(T t, Connection connection) throws SQLException, BusinessException;
    
    @Override
    public abstract T getById(T t) throws SQLException, BusinessException;
    
    @Override
    public abstract List<T> getObjectsByNombre(String nombre, Connection connection) throws SQLException, BusinessException;

    @Override
    public abstract List<T> getAll() throws SQLException, BusinessException;

    @Override
    public abstract PreparedStatement generarPreparedStatement(Connection conn, String consulta, T t) throws SQLException, BusinessException;

    @Override
    public abstract PreparedStatement generarPreparedStatement(Connection conn, String consulta, String nombre) throws SQLException, BusinessException;
}