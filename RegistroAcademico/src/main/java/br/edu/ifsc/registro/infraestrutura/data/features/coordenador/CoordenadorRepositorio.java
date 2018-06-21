/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.coordenador;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
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
 * @author admin
 */
public class CoordenadorRepositorio implements ICoordenadorRepositorio {

    private final String INSERT = "INSERT INTO Coordenador(nome, telefone, email, cursoId) VALUES(?,?,?,?)";

    private final String UPDATE = "UPDATE Coordenador SET nome = ?, telefone = ?, email = ?, cursoId = ? WHERE id = ?";

    private final String GET_ALL = "SELECT "
            + "coo.id, "
            + "coo.nome, "
            + "coo.telefone, "
            + "coo.email, "
            + "coo.cursoId, "
            + "cur.nome, "
            + "cur.tipoCurso "
            + "FROM coordenador as coo "
            + "INNER JOIN curso as cur ON cur.id = coo.cursoId";

    private final String GET = "SELECT "
            + "coo.id, "
            + "coo.nome, "
            + "coo.telefone, "
            + "coo.email, "
            + "coo.cursoId, "
            + "cur.nome, "
            + "cur.tipoCurso "
            + "FROM coordenador as coo "
            + "INNER JOIN curso as cur ON cur.id = coo.cursoId "
            + "WHERE coo.id = ?";

    private final String DELETE = "DELETE FROM Coordenador WHERE id = ?";

    @Override
    public Coordenador save(Coordenador entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getNome(),
                entidade.getTelefone(),
                entidade.getEmail(),
                entidade.getCursoCoordenacao().getId()
        ));
        return entidade;
    }

    @Override
    public Coordenador update(Coordenador entidade) throws SQLException {
        entidade.setId(DataBase.update(UPDATE,
                entidade.getNome(),
                entidade.getTelefone(),
                entidade.getEmail(),
                entidade.getCursoCoordenacao().getId(),
                entidade.getId()
        ));
        return entidade;
    }

    @Override
    public List<Coordenador> getAll() throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            List<Coordenador> coordenadors = new ArrayList<>();

            while (rs.next()) {
                Coordenador coo = new Coordenador();
                coo.setId(rs.getInt("id"));
                coo.setNome(rs.getString("nome"));
                coo.setTelefone(rs.getString("telefone"));
                coo.setEmail(rs.getString("email"));

                Curso cur = new Curso();
                cur.setId(rs.getInt("cursoId"));
                cur.setNome(rs.getString("nome"));
                cur.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                coo.setCursoCoordenacao(cur);

                coordenadors.add(coo);
            }
            ConnectionDB.getConnection().commit();
            return coordenadors;
        } catch (SQLException ex) {
            ConnectionDB.getConnection().rollback();
            throw ex;
        }
    }

    @Override
    public Coordenador get(int id) throws SQLException {
        try (PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(GET)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Coordenador coordenador = null;

            while (rs.next()) {
                Coordenador coo = new Coordenador();
                coo.setId(rs.getInt("id"));
                coo.setNome(rs.getString("nome"));
                coo.setTelefone(rs.getString("telefone"));
                coo.setEmail(rs.getString("email"));

                Curso cur = new Curso();
                cur.setId(rs.getInt("cursoId"));
                cur.setNome(rs.getString("nome"));
                cur.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                coo.setCursoCoordenacao(cur);

                coordenador = coo;
            }
            ConnectionDB.getConnection().commit();
            return coordenador;
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
