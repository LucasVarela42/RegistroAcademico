/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.aluno;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.aluno.IAlunoRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.infraestrutura.ConnectionDB;
import br.edu.ifsc.registro.infraestrutura.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class AlunoRepositorio implements IAlunoRepositorio {

    private final String INSERT = "INSERT INTO Aluno(nome, telefone, email, cursoId) VALUES(?,?,?,?)";

    private final String UPDATE = "UPDATE Aluno SET nome = ?, telefone = ?, email = ?, cursoId = ? WHERE id = ?";

    private final String GET_ALL = "SELECT "
            + "a.id, "
            + "a.nome, "
            + "a.telefone, "
            + "a.email, "
            + "a.cursoId, "
            + "c.nome, "
            + "c.tipoCurso "
            + "FROM aluno as a "
            + "INNER JOIN curso as c ON c.id = a.cursoId";

    private final String GET = "SELECT "
            + "a.id, "
            + "a.nome, "
            + "a.telefone, "
            + "a.email, "
            + "a.cursoId, "
            + "c.nome, "
            + "c.tipoCurso "
            + "FROM aluno as a "
            + "INNER JOIN curso as c ON c.id = a.cursoId "
            + "WHERE a.id = ?";

    private final String DELETE = "DELETE FROM Aluno WHERE id = ?";

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public Aluno save(Aluno entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getNome(),
                entidade.getTelefone(),
                entidade.getEmail(),
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
    public Aluno update(Aluno entidade) throws SQLException {
        entidade.setId(DataBase.update(UPDATE,
                entidade.getNome(),
                entidade.getTelefone(),
                entidade.getEmail(),
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
    public List<Aluno> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<Aluno> alunos = new ArrayList<>();

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));

                Curso c = new Curso();
                c.setId(rs.getInt("cursoId"));
                c.setNome(rs.getString("nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                a.setCurso(c);

                alunos.add(a);
            }
            ConnectionDB.getConnection().commit();
            return alunos;
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
    public Aluno get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Aluno aluno = null;

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));

                Curso c = new Curso();
                c.setId(rs.getInt("cursoId"));
                c.setNome(rs.getString("nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                a.setCurso(c);

                aluno = a;
            }
            ConnectionDB.getConnection().commit();
            return aluno;
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
