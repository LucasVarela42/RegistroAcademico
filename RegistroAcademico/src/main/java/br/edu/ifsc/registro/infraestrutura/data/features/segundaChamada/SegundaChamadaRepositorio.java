/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.segundaChamada;

import br.edu.ifsc.registro.dominio.features.protocolo.Protocolo;
import br.edu.ifsc.registro.dominio.features.segundaChamada.ISegundaChamadaRepositorio;
import br.edu.ifsc.registro.dominio.features.segundaChamada.SegundaChamadaAtividadeAvaliativa;
import br.edu.ifsc.registro.dominio.features.segundaChamada.TurnoEnum;
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
public class SegundaChamadaRepositorio implements ISegundaChamadaRepositorio {

    private final String INSERT = "INSERT INTO segundaChamada("
            + "localProva, turno, motivoProva, dataAvaliacao, justificativaProfessor, professorAplicadorProva, protocoloId) "
            + "VALUES(?,?,?,?,?,?,?)";


    private final String UPDATE = "UPDATE segundaChamada SET "
            + "localProva = ?, "
            + "turno = ?, "
            + "motivoProva = ?, "
            + "dataAvaliacao = ?, "
            + "justificativaProfessor = ?, "
            + "professorAplicadorProva = ?, "
            + "protocoloId = ? "
            + "WHERE id = ?";

    private final String GET_ALL = "SELECT "
            + "id, "
            + "localProva, "
            + "turno, "
            + "motivoProva, "
            + "dataAvaliacao, "
            + "justificativaProfessor, "
            + "professorAplicadorProva, "
            + "protocoloId "
            + "FROM segundaChamada";

    private final String GET = "SELECT "
            + "id, "
            + "localProva, "
            + "turno, "
            + "motivoProva, "
            + "dataAvaliacao, "
            + "justificativaProfessor, "
            + "professorAplicadorProva, "
            + "protocoloId "
            + "FROM segundaChamada "
            + "WHERE id = ?";

    private final String DELETE = "DELETE FROM segundaChamada WHERE id = ?";

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public SegundaChamadaAtividadeAvaliativa save(SegundaChamadaAtividadeAvaliativa entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getLocalProva(),
                entidade.getTurno().toString(),
                entidade.getMotivoProva(),
                entidade.getDataAvaliacao(),
                entidade.getJustificativaProfessor(),
                entidade.getProfessorAplicadorProva(),
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
    public SegundaChamadaAtividadeAvaliativa update(SegundaChamadaAtividadeAvaliativa entidade) throws SQLException {
        entidade.setId(DataBase.update(UPDATE,
                entidade.getLocalProva(),
                entidade.getTurno().toString(),
                entidade.getMotivoProva(),
                entidade.getDataAvaliacao(),
                entidade.getJustificativaProfessor(),
                entidade.getProfessorAplicadorProva(),
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
    public List<SegundaChamadaAtividadeAvaliativa> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<SegundaChamadaAtividadeAvaliativa> segundaChamadas = new ArrayList<>();

            while (rs.next()) {
                SegundaChamadaAtividadeAvaliativa sc = new SegundaChamadaAtividadeAvaliativa();
                sc.setId(rs.getInt("id"));
                sc.setLocalProva(rs.getString("localProva"));
                sc.setTurno(TurnoEnum.valueOf(rs.getString("turno")));
                sc.setMotivoProva(rs.getString("motivoProva"));
                sc.setDataAvaliacao(rs.getDate("dataAvaliacao").toLocalDate());
                sc.setJustificativaProfessor(rs.getString("justificativaProfessor"));
                sc.setProfessorAplicadorProva(rs.getString("professorAplicadorProva"));

                Protocolo p = new Protocolo();
                p.setId(rs.getInt("protocoloId"));
                sc.setProtocolo(p);

                segundaChamadas.add(sc);
            }
            ConnectionDB.getConnection().commit();
            return segundaChamadas;
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
    public SegundaChamadaAtividadeAvaliativa get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            SegundaChamadaAtividadeAvaliativa segundaChamada = null;

            if (rs.next()) {
                SegundaChamadaAtividadeAvaliativa sc = new SegundaChamadaAtividadeAvaliativa();
                sc.setId(rs.getInt("id"));
                sc.setLocalProva(rs.getString("localProva"));
                sc.setTurno(TurnoEnum.valueOf(rs.getString("turno")));
                sc.setMotivoProva(rs.getString("motivoProva"));
                sc.setDataAvaliacao(rs.getDate("dataAvaliacao").toLocalDate());
                sc.setJustificativaProfessor(rs.getString("justificativaProfessor"));
                sc.setProfessorAplicadorProva(rs.getString("professorAplicadorProva"));

                Protocolo p = new Protocolo();
                p.setId(rs.getInt("protocoloId"));
                sc.setProtocolo(p);

                segundaChamada = sc;
            }
            ConnectionDB.getConnection().commit();
            return segundaChamada;
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
