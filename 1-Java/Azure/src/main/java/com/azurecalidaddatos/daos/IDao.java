package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.ModeloBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface IDao<T extends ModeloBase> {
    public void insert(T t) throws SQLException, BusinessException;
    public void insert(T t, Connection connection) throws SQLException, BusinessException;
    public void update(T t) throws SQLException, BusinessException;
    public void update(T t, Connection connection) throws SQLException, BusinessException;
    public void delete(T t) throws SQLException, BusinessException;
    public void delete(T t, Connection connection) throws SQLException, BusinessException;
    public T getById(T t) throws SQLException, BusinessException;
    public List<T> getObjectsByNombre(String nombre) throws SQLException, BusinessException;
    public List<T> getObjectsByNombre(String nombre, Connection connection) throws SQLException, BusinessException;
    public T getByNombre(String nombre) throws SQLException, BusinessException;
    public T getByNombre(String nombre, Connection connection) throws SQLException, BusinessException;
    public List<T> getAll() throws SQLException, BusinessException;
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, T t) throws SQLException, BusinessException;
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, String nombre) throws SQLException, BusinessException;
}
