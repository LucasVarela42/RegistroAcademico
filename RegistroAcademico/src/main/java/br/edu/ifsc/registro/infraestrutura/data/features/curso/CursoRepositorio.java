/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.curso;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.infraestrutura.DataBase;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class CursoRepositorio implements ICursoRepositorio {
    
    private final String INSERT = "INSERT INTO Curso(nome, tipoCurso) VALUES(?,?)";

    @Override
    public Curso Save(Curso entidade){
        try {
            entidade.setId(DataBase.insert(INSERT, entidade.getNome(), entidade.getTipoCurso().toString()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(entidade.toString());
        return entidade;
    }

    @Override
    public Curso Update(Curso entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso Get(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
