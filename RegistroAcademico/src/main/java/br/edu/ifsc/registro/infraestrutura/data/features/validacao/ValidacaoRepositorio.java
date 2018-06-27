/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.validacao;

import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
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
            +"nota, deferido, observacao, tipoValidacao, protocoloId) "
            + "VALUES(?,?,?,?,?)";
    
    private final String UPDATE = "UPDATE validacao SET "
            + "nota = ?, "
            + "deferido = ?, "
            + "observacao = ?, "
            + "tipoValidacao = ?, "
            + "protocoloId = ? "
            + "WHERE id = ?";
    
    private final String GET_ALL = "SELECT "
            + "id, "
            + "nota, "
            + "deferido, "
            + "observacao, "
            + "tipoValidacao, "
            + "protocoloId "
            + "FROM validacao";
    
    private final String GET = "SELECT "
            + "id, "
            + "nota, "
            + "deferido, "
            + "observacao, "
            + "tipoValidacao, "
            + "protocoloId "
            + "FROM validacao "
            + "WHERE id = ?";
    
    private final String DELETE = "DELETE FROM validacao WHERE id = ?";

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Validacao save(Validacao entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getNota(),
                entidade.isDeferido(),
                entidade.getObservacao(),
                entidade.getTipoValidacao().toString(),
                entidade.getProtocolo().getId()
        ));
        return entidade;
    }

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Validacao update(Validacao entidade) throws SQLException {
        entidade.setId(DataBase.update(UPDATE,
                entidade.getNota(),
                entidade.isDeferido(),
                entidade.getObservacao(),
                entidade.getTipoValidacao().toString(),
                entidade.getProtocolo().getId(),
                entidade.getId()
        ));
        return entidade;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
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
                
                Protocolo p = new Protocolo();
                p.setId(rs.getInt("protocoloId"));
                v.setProtocolo(p);
                
                validacaos.add(v);
            }
            ConnectionDB.getConnection().commit();
            return validacaos;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
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
                
                Protocolo p = new Protocolo();
                p.setId(rs.getInt("protocoloId"));
                v.setProtocolo(p);
                
                validacao = v;
            }
            ConnectionDB.getConnection().commit();
            return validacao;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

    /**
     *
     * @param id
     * @throws SQLException
     */
    @Override
    public void delete(int id) throws SQLException {
        DataBase.delete(DELETE, id);
    }

}
