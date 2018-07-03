/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.disciplina;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.dominio.features.disciplina.Disciplina;
import br.edu.ifsc.registro.dominio.features.disciplina.IDisciplinaRepositorio;
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
public class DisciplinaRepositorio implements IDisciplinaRepositorio {

    private final String INSERT = "INSERT INTO disciplina(nome, cargaHoraria, sigla, cursoId) VALUES(?,?,?,?)";
    
    private final String UPDATE = "UPDATE disciplina SET nome = ?, cargaHoraria = ?, sigla = ?, cursoId = ? WHERE id = ?";
    
    private final String GET_ALL = "SELECT "
            + "d.id, "
            + "d.nome, "
            + "d.cargaHoraria, "
            + "d.sigla, "
            + "d.cursoId, "
            + "c.nome, "
            + "c.tipoCurso "
            + "FROM disciplina as d "
            + "INNER JOIN curso as c ON c.id = d.cursoId";
    
    private final String GET = "SELECT "
            + "d.id, "
            + "d.nome, "
            + "d.cargaHoraria, "
            + "d.sigla, "
            + "d.cursoId, "
            + "c.nome, "
            + "c.tipoCurso "
            + "FROM disciplina as d "
            + "INNER JOIN curso as c ON c.id = d.cursoId "
            + "WHERE d.id = ?";
    
    private final String DELETE = "DELETE FROM disciplina WHERE id = ?";

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Disciplina save(Disciplina entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getNome(),
                entidade.getCargaHoraria(),
                entidade.getSigla(),
                entidade.getCurso().getId()
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
    public Disciplina update(Disciplina entidade) throws SQLException {
        entidade.setId(DataBase.update(UPDATE, 
                entidade.getNome(),
                entidade.getCargaHoraria(),
                entidade.getSigla(),
                entidade.getCurso().getId(),
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
    public List<Disciplina> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<Disciplina> disciplinas = new ArrayList<>();

            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("d.nome"));
                d.setCargaHoraria(rs.getInt("cargaHoraria"));
                d.setSigla(rs.getString("sigla"));
                
                Curso c = new Curso();
                c.setId(rs.getInt("cursoId"));
                c.setNome(rs.getString("c.nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                d.setCurso(c);

                disciplinas.add(d);
            }
            ConnectionDB.getConnection().commit();
            return disciplinas;
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
    public Disciplina get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Disciplina disciplina = null;

            if (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("d.nome"));
                d.setCargaHoraria(rs.getInt("cargaHoraria"));
                d.setSigla(rs.getString("sigla"));
                
                Curso c = new Curso();
                c.setId(rs.getInt("cursoId"));
                c.setNome(rs.getString("c.nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                d.setCurso(c);
                
                disciplina = d;
            }
            ConnectionDB.getConnection().commit();
            return disciplina;
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
