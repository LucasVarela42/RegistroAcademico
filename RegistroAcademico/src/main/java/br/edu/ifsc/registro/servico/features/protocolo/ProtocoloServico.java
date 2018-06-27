/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.protocolo;

import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.servico.base.Servico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ProtocoloServico extends Servico<Protocolo> {

    IProtocoloRepositorio repositorio;
    IAlunoRepositorio alunoRepositorio;
    ICoordenadorRepositorio coordenadorRepositorio;

    public ProtocoloServico(IProtocoloRepositorio repositorio, IAlunoRepositorio alunoRepositorio, ICoordenadorRepositorio coordenadorRepositorio) {
        super(repositorio);
        this.repositorio = repositorio;
        this.alunoRepositorio = alunoRepositorio;
        this.coordenadorRepositorio = coordenadorRepositorio;
    }

    @Override
    public Protocolo get(int id) throws SQLException {
        Protocolo protocolo = super.get(id);
        if (protocolo == null) {
            return null;
        }
        protocolo.setAluno(alunoRepositorio.get(protocolo.getAluno().getId()));
        protocolo.setCoordenador(coordenadorRepositorio.get(protocolo.getCoordenador().getId()));
        return protocolo;
    }

    @Override
    public List<Protocolo> getAll() throws SQLException {
        List<Protocolo> protocolos = super.getAll();
        for (Protocolo protocolo : protocolos) {
            protocolo.setAluno(alunoRepositorio.get(protocolo.getAluno().getId()));
            protocolo.setCoordenador(coordenadorRepositorio.get(protocolo.getCoordenador().getId()));
        }
        return protocolos;
    }

}
