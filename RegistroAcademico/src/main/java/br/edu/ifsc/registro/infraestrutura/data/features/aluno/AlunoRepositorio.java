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

//    nome ;
//    telefone ;
//    email ;
//    curso ;
    private final String INSERT = "INSERT INTO Aluno(nome, telefone, email) VALUES(?,?)";
    private final String UPDATE = "UPDATE Aluno SET nome = ?, telefone = ?, email = ?, WHERE id = ?";
    private final String GET_ALL = "SELECT * FROM Aluno";
    private final String GET = "SELECT * FROM Aluno WHERE id = ?";
    private final String DELETE = "DELETE FROM Aluno WHERE id = ?";

    @Override
    public Aluno save(Aluno entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT, entidade.getNome(), entidade.getTelefone(), entidade.getEmail()));
        return entidade;
    }

    @Override
    public Aluno update(Aluno entidade) throws SQLException {
        entidade.setId(DataBase.insert(UPDATE, entidade.getNome(), entidade.getTelefone(), entidade.getEmail(), entidade.getId()));
        return entidade;
    }

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

                /*
                a.setCurso(rs.getString("curso"));
                VER COM A GALERA
                 */
                alunos.add(a);
            }

            ConnectionDB.getConnection().commit();
            return alunos;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

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

                /*
                a.setCurso(rs.getString("curso"));
                VER COM A GALERA
                 */
            }

            ConnectionDB.getConnection().commit();
            return aluno;
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
