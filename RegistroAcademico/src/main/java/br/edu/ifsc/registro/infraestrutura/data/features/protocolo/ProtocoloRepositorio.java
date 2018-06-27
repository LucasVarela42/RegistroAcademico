/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.protocolo;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.protocolo.IProtocoloRepositorio;
import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.protocolo.TipoProtocolo;
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
public class ProtocoloRepositorio implements IProtocoloRepositorio {

    private final String INSERT = "INSERT INTO protocolo("
            + "numero, tipoProtocolo, dataCadastro, alunoId, coordenadorId) "
            + "VALUES(?,?,?,?,?)";

    private final String UPDATE = "UPDATE protocolo SET "
            + "numero = ?, "
            + "tipoProtocolo = ?, "
            + "dataCadastro = ?, "
            + "alunoId = ?, "
            + "coordenadorId = ? "
            + "WHERE id = ?";

    private final String GET_ALL = "SELECT "
            + "id, "
            + "numero, "
            + "tipoProtocolo, "
            + "dataCadastro, "
            + "alunoId, "
            + "coordenadorId "
            + "FROM protocolo";

    private final String GET = "SELECT "
            + "id, "
            + "numero, "
            + "tipoProtocolo, "
            + "dataCadastro, "
            + "alunoId, "
            + "coordenadorId "
            + "FROM protocolo "
            + "WHERE id = ?";

    private final String DELETE = "DELETE FROM protocolo WHERE id = ?";

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Protocolo save(Protocolo entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getNumero(),
                entidade.getTipoProtocolo().toString(),
                entidade.getDataCadastro(),
                entidade.getAluno().getId(),
                entidade.getCoordenador().getId()
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
    public Protocolo update(Protocolo entidade) throws SQLException {
        entidade.setId(DataBase.insert(UPDATE,
                entidade.getNumero(),
                entidade.getTipoProtocolo().toString(),
                entidade.getDataCadastro(),
                entidade.getAluno().getId(),
                entidade.getCoordenador().getId(),
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
    public List<Protocolo> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<Protocolo> protocolos = new ArrayList<>();

            while (rs.next()) {
                Protocolo p = new Protocolo();
                p.setId(rs.getInt("id"));
                p.setNumero(rs.getString("numero"));
                p.setTipoProtocolo(TipoProtocolo.valueOf(rs.getString("tipoProtocolo")));
                p.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());

                Aluno a = new Aluno();
                a.setId(rs.getInt("alunoId"));
                p.setAluno(a);

                Coordenador c = new Coordenador();
                c.setId(rs.getInt("coordenadorId"));
                p.setCoordenador(c);

                protocolos.add(p);
            }
            ConnectionDB.getConnection().commit();
            return protocolos;
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
    public Protocolo get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Protocolo protocolo = null;

            if (rs.next()) {
                Protocolo p = new Protocolo();
                p.setId(rs.getInt("id"));
                p.setNumero(rs.getString("numero"));
                p.setTipoProtocolo(TipoProtocolo.valueOf(rs.getString("tipoProtocolo")));
                p.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());

                Aluno a = new Aluno();
                a.setId(rs.getInt("alunoId"));
                p.setAluno(a);

                Coordenador c = new Coordenador();
                c.setId(rs.getInt("coordenadorId"));
                p.setCoordenador(c);

                protocolo = p;
            }
            ConnectionDB.getConnection().commit();
            return protocolo;
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
