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

    public Servico(IRepositorio<T> repositorio) {
        this.repositorio = repositorio;
    }

    public T add(T entidade) throws SQLException, Exception {
        entidade.validar();
        return repositorio.save(entidade);
    }

    public T update(T entidade) throws SQLException, Exception {
        entidade.validar();
        return repositorio.update(entidade);
    }

    public T get(int id) throws SQLException {
        return repositorio.get(id);
    }

    public List<T> getAll() throws SQLException {
        return repositorio.getAll();
    }

    public void delete(T entidade) throws SQLException {
        repositorio.delete(entidade.getId());
    }
}
