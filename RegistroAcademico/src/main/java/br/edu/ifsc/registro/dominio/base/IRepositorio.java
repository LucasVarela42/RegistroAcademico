/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.base;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 * @param <E>
 */
public interface IRepositorio<E>{

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    E save(E entidade) throws SQLException;

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    E update(E entidade) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<E> getAll() throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    E get(int id) throws SQLException;

    /**
     *
     * @param id
     * @throws SQLException
     */
    void delete(int id) throws SQLException;

}
