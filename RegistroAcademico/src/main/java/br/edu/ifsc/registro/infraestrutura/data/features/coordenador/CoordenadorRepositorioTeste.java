/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura.data.features.coordenador;

import br.edu.ifsc.registro.dominio.features.coordenador.Coordenador;
import br.edu.ifsc.registro.dominio.features.coordenador.ICoordenadorRepositorio;
import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.features.curso.ICursoRepositorio;
import br.edu.ifsc.registro.infraestrutura.data.features.curso.CursoRepositorio;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class CoordenadorRepositorioTeste {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ICoordenadorRepositorio repositorio;
        repositorio = new CoordenadorRepositorio();

        ICursoRepositorio cursoRepositorio;
        cursoRepositorio = new CursoRepositorio();

        try {
            //INSERIR
            Curso c = new Curso();
            c = cursoRepositorio.get(4);

            Coordenador coordenador = new Coordenador();
            coordenador.setNome("Juliano");
            coordenador.setTelefone("888888888");
            coordenador.setEmail("juliano@juliano.com");
            coordenador.setCursoCoordenacao(c);
            coordenador = repositorio.save(coordenador);

            //ATUALIZAR
            coordenador.setNome("Juliano Gonçalves");
            coordenador = repositorio.update(coordenador);

            //GETALL
            List<Coordenador> coordenadors = repositorio.getAll();
            for (Coordenador a : coordenadors) {
                System.out.println(a.toString());
            }

            //GETBYID
            coordenador = repositorio.get(coordenador.getId());
            System.out.println(coordenador.toString());

            //DELETAR
            repositorio.delete(coordenador.getId());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
