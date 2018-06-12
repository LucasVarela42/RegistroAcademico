/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.curso;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
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
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class CursoRepositorio implements ICursoRepositorio {

    private final String INSERT = "INSERT INTO Curso(nome, tipoCurso) VALUES(?,?)";
    private final String UPDATE = "UPDATE Curso SET nome = ?, tipoCurso = ? WHERE id = ?";
    private final String GET_ALL = "SELECT * FROM Curso";
    private final String GET = "SELECT * FROM Curso WHERE id = ?";
    private final String DELETE = "DELETE FROM Curso WHERE id = ?;";

    @Override
    public Curso save(Curso entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT, entidade.getNome(), entidade.getTipoCurso().toString()));
        return entidade;
    }

    @Override
    public Curso update(Curso entidade) throws SQLException {
        entidade.setId(DataBase.update(UPDATE, entidade.getNome(), entidade.getTipoCurso().toString(), entidade.getId()));
        return entidade;
    }

    @Override
    public void delete(int id) throws SQLException {
        DataBase.update(DELETE, id);
    }

    @Override
    public List<Curso> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<Curso> cursos = new ArrayList<>();

            while (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("Id"));
                c.setNome(rs.getString("nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                cursos.add(c);
            }

            ConnectionDB.getConnection().commit();
            return cursos;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

    @Override
    public Curso get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Curso curso = null;
            
            while (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt("Id"));
                curso.setNome(rs.getString("nome"));
                curso.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
            }
            
            ConnectionDB.getConnection().commit();
            return curso;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

}
