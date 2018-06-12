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
 */
public interface IRepositorio<E>{

    E save(E entidade) throws SQLException;

    E update(E entidade) throws SQLException;

    List<E> getAll() throws SQLException;

    E get(int id) throws SQLException;

    void delete(int id) throws SQLException;

}
