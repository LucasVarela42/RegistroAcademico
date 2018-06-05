/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.dominio.base;

import java.util.List;

/**
 *
 * @author Lucas
 */
public interface IRepositorio<E>{

    E Save(E entidade);

    E Update(E entidade);

    void Delete(int Id);

    List<E> GetAll();

    E Get(int Id);

}
