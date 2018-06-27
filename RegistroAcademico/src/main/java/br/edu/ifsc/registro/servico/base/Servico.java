/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.base;

import br.edu.ifsc.registro.dominio.base.Entidade;
import br.edu.ifsc.registro.dominio.base.IRepositorio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 * @param <T>
 */
public abstract class Servico<T extends Entidade> {

    IRepositorio<T> repositorio;

    /**
     *
     * @param repositorio
     */
    public Servico(IRepositorio<T> repositorio) {
        this.repositorio = repositorio;
    }

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public T add(T entidade) throws SQLException, Exception {
        entidade.validar();
        return repositorio.save(entidade);
    }

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public T update(T entidade) throws SQLException, Exception {
        entidade.validar();
        return repositorio.update(entidade);
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public T get(int id) throws SQLException {
        return repositorio.get(id);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<T> getAll() throws SQLException {
        return repositorio.getAll();
    }

    /**
     *
     * @param entidade
     * @throws SQLException
     */
    public void delete(T entidade) throws SQLException {
        repositorio.delete(entidade.getId());
    }
}
