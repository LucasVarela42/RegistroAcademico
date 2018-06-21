/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.validacao;

import br.edu.ifsc.registro.dominio.features.aluno.Aluno;
import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.TipoCurso;
import br.edu.ifsc.registro.dominio.features.protocolo.TipoProtocolo;
import br.edu.ifsc.registro.dominio.features.validacao.IValidacaoRepositorio;
import br.edu.ifsc.registro.dominio.features.validacao.TipoValidacao;
import br.edu.ifsc.registro.dominio.features.validacao.Validacao;
import br.edu.ifsc.registro.infraestrutura.ConnectionDB;
import br.edu.ifsc.registro.infraestrutura.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ValidacaoRepositorio implements IValidacaoRepositorio {

    private final String INSERT = "INSERT INTO validacao("
            + "numero, tipoProtocolo, dataCadastro, alunoId, coordenadorId, "
            + "nota, deferido, observacao, tipoValidacao) "
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
            + "v.numero, "
            + "v.tipoProtocolo, "
            + "v.dataCadastro, "
            + "v.alunoId, "
            + "a.nome, "
            + "a.telefone, "
            + "a.email, "
            + "a.cursoId, "
            + "c.nome, "
            + "c.tipoCurso, "
            + "v.coordenadorId, "
            + "coo.nome, "
            + "coo.telefone, "
            + "coo.email, "
            + "coo.cursoId, "
            + "cur.nome, "
            + "cur.tipoCurso, "
            + "v.nota, "
            + "v.deferido, "
            + "v.observacao, "
            + "v.tipoValidacao "
            + "FROM validacao as v "
            + "INNER JOIN aluno as a ON a.id = v.alunoId "
            + "INNER JOIN curso as c ON c.id = a.cursoId "
            + "INNER JOIN coordenador as coo ON coo.id = v.coordenadorId "
            + "INNER JOIN curso as coo ON coo.id = coo.cursoId ";
    
    private final String GET = "SELECT "
            + "v.id, "
            + "v.numero, "
            + "v.tipoProtocolo, "
            + "v.dataCadastro, "
            + "v.alunoId, "
            + "a.nome, "
            + "a.telefone, "
            + "a.email, "
            + "a.cursoId, "
            + "c.nome, "
            + "c.tipoCurso, "
            + "v.coordenadorId, "
            + "coo.nome, "
            + "coo.telefone, "
            + "coo.email, "
            + "coo.cursoId, "
            + "cur.nome, "
            + "cur.tipoCurso, "
            + "v.nota, "
            + "v.deferido, "
            + "v.observacao, "
            + "v.tipoValidacao "
            + "FROM validacao as v "
            + "INNER JOIN aluno as a ON a.id = v.alunoId "
            + "INNER JOIN curso as c ON c.id = a.cursoId "
            + "INNER JOIN coordenador as coo ON coo.id = v.coordenadorId "
            + "INNER JOIN curso as coo ON coo.id = coo.cursoId "
            + "WHERE v.id = ?";
    
    private final String DELETE = "DELETE FROM validacao WHERE id = ?";

    @Override
    public Validacao save(Validacao entidade) throws SQLException {
        entidade.setId(DataBase.insert(INSERT,
                entidade.getNumero(),
                entidade.getTipoProtocolo(),
                entidade.getDataCadastro(),
                entidade.getAluno().getId(),
                entidade.getCoordenador().getId(),
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
                entidade.getNumero(),
                entidade.getTipoProtocolo(),
                entidade.getDataCadastro(),
                entidade.getAluno().getId(),
                entidade.getCoordenador().getId(),
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
                v.setNumero(rs.getString("numero"));
                v.setTipoProtocolo(TipoProtocolo.valueOf(rs.getString("tipoProtocolo")));
                v.setDataCadastro(LocalDateTime.parse(rs.getDate("dataCadastro").toString()));
                
                Aluno a = new Aluno();
                a.setId(rs.getInt("alunoId"));
                a.setNome(rs.getString("nome"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                
                Curso c = new Curso();
                c.setId(rs.getInt("a.cursoId"));
                c.setNome(rs.getString("nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                a.setCurso(c);
                
                v.setAluno(a);
                
                Coordenador coo = new Coordenador();
                coo.setId(rs.getInt("coordenadorId"));
                coo.setNome(rs.getString("nome"));
                coo.setTelefone(rs.getString("telefone"));
                coo.setEmail(rs.getString("email"));

                Curso cur = new Curso();
                cur.setId(rs.getInt("coo.cursoId"));
                cur.setNome(rs.getString("nome"));
                cur.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                coo.setCursoCoordenacao(cur);

                v.setCoordenador(coo);
                
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
                v.setNumero(rs.getString("numero"));
                v.setTipoProtocolo(TipoProtocolo.valueOf(rs.getString("tipoProtocolo")));
                v.setDataCadastro(LocalDateTime.parse(rs.getDate("dataCadastro").toString()));
                
                Aluno a = new Aluno();
                a.setId(rs.getInt("alunoId"));
                a.setNome(rs.getString("nome"));
                a.setTelefone(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                
                Curso c = new Curso();
                c.setId(rs.getInt("a.cursoId"));
                c.setNome(rs.getString("nome"));
                c.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                a.setCurso(c);
                
                v.setAluno(a);
                
                Coordenador coo = new Coordenador();
                coo.setId(rs.getInt("coordenadorId"));
                coo.setNome(rs.getString("nome"));
                coo.setTelefone(rs.getString("telefone"));
                coo.setEmail(rs.getString("email"));

                Curso cur = new Curso();
                cur.setId(rs.getInt("coo.cursoId"));
                cur.setNome(rs.getString("nome"));
                cur.setTipoCurso(TipoCurso.valueOf(rs.getString("tipoCurso")));
                coo.setCursoCoordenacao(cur);

                v.setCoordenador(coo);
                
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
