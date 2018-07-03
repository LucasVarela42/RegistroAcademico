/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao;

import java.util.List;

/**
 *
 * @author Lucas
 */
public abstract class ControllerFormulario<T> {

    /**
     *
     */
    public abstract void adicionar();

    /**
     *
     */
    public abstract void editar(T obj);

    /**
     *
     */
    public abstract void remover(T obj);

    public abstract List<T> carregarLista();

    public abstract void atribuirSelecionado(T obj);
    
    public abstract String ObtemTipoCadastro();

}
