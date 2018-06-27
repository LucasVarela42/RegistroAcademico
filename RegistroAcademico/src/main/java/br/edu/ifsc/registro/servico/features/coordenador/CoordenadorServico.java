/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.coordenador;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.servico.base.Servico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class CoordenadorServico extends Servico<Coordenador> {

    ICoordenadorRepositorio repositorio;
    ICursoRepositorio cursoRepositorio;

    public CoordenadorServico(ICoordenadorRepositorio repositorio, ICursoRepositorio cursoRepositorio) {
        super(repositorio);
        this.repositorio = repositorio;
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public Coordenador get(int id) throws SQLException {
        Coordenador coordenador = super.get(id);
        if (coordenador == null) {
            return null;
        }
        coordenador.setCursoCoordenacao(cursoRepositorio.get(coordenador.getCursoCoordenacao().getId()));
        return coordenador;
    }

    @Override
    public List<Coordenador> getAll() throws SQLException {
        List<Coordenador> coordenadors = super.getAll();
        for (Coordenador coordenador : coordenadors) {
            coordenador.setCursoCoordenacao(cursoRepositorio.get(coordenador.getCursoCoordenacao().getId()));
        }
        return coordenadors;
    }

}
