/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.validacao;

import br.edu.ifsc.registro.dominio.features.validacao.IValidacaoRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.TipoValidacao;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.infraestrutura.ConnectionDB;
import br.edu.ifsc.registro.infraestrutura.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ValidacaoRepositorio implements IValidacaoRepositorio {

    private final String INSERT = "INSERT INTO validacao("
            +"nota, deferido, observacao, tipoValidacao) "
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    
    private final String UPDATE = "UPDATE validacao SET "
            + "numero = ?, "
            + "tipoProtocolo = ?, "
            + "dataCadastro = ?, "
            + "alunoId = ?, "
            + "coordenadorId = ?, "
            + "nota = ?, "
            + "deferido = ?, "
            + "observacao = ?, "
            + "tipoValidacao = ? "
            + "WHERE id = ?";
    
    private final String GET_ALL = "SELECT "
            + "v.id, "
            + "v.nota, "
            + "v.deferido, "
            + "v.observacao, "
            + "v.tipoValidacao "
            + "FROM validacao as v";
    
    private final String GET = "SELECT "
            + "v.id, "
            + "v.nota, "
            + "v.deferido, "
            + "v.observacao, "
            + "v.tipoValidacao "
            + "FROM validacao as v "
            + "WHERE v.id = ?";
    
    private final String DELETE = "DELETE FROM validacao WHERE id = ?";

    @Override
    public Validacao save(Validacao entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
               
                entidade.getNota(),
                entidade.isDeferido(),
                entidade.getObservacao(),
                entidade.getTipoValidacao()
        ));
        return entidade;
    }

    @Override
    public Validacao update(Validacao entidade) throws SQLException {
        entidade.setId(DataBase.insert(UPDATE, 
                
                entidade.getNota(),
                entidade.isDeferido(),
                entidade.getObservacao(),
                entidade.getTipoValidacao(),
                entidade.getId()
        ));
        return entidade;
    }

    @Override
    public List<Validacao> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<Validacao> validacaos = new ArrayList<>();

            while (rs.next()) {
                Validacao v = new Validacao();
                v.setId(rs.getInt("id"));
                v.setNota(rs.getDouble("nota"));
                v.setDeferido(rs.getBoolean("deferido"));
                v.setObservacao(rs.getString("observacao"));
                v.setTipoValidacao(TipoValidacao.valueOf(rs.getString("tipoValidacao")));
                
                validacaos.add(v);
            }
            ConnectionDB.getConnection().commit();
            return validacaos;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

    @Override
    public Validacao get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Validacao validacao = null;

            if (rs.next()) {
                Validacao v = new Validacao();
                v.setId(rs.getInt("id"));
                v.setNota(rs.getDouble("nota"));
                v.setDeferido(rs.getBoolean("deferido"));
                v.setObservacao(rs.getString("observacao"));
                v.setTipoValidacao(TipoValidacao.valueOf(rs.getString("tipoValidacao")));
                
                validacao = v;
            }
            ConnectionDB.getConnection().commit();
            return validacao;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        DataBase.delete(DELETE, id);
    }

}
