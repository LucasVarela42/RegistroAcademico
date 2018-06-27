/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.servico.features.validacao;

import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.IValidacaoRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.servico.base.Servico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ValidacaoServico extends Servico<Validacao> {

    IValidacaoRepositorio repositorio;
    IProtocoloRepositorio protocoloRepositorio;

    public ValidacaoServico(IValidacaoRepositorio repositorio, IProtocoloRepositorio protocoloRepositorio) {
        super(repositorio);
        this.repositorio = repositorio;
        this.protocoloRepositorio = protocoloRepositorio;
    }

    @Override
    public Validacao get(int id) throws SQLException {
        Validacao validacao = super.get(id);
        if (validacao == null) {
            return null;
        }
        validacao.setProtocolo(protocoloRepositorio.get(validacao.getProtocolo().getId()));
        return validacao;
    }

    @Override
    public List<Validacao> getAll() throws SQLException {
        List<Validacao> validacaos = super.getAll();
        for (Validacao validacao : validacaos) {
            validacao.setProtocolo(protocoloRepositorio.get(validacao.getProtocolo().getId()));
        }
        return validacaos;
    }

}
