package br.edu.ifsc.registro.dominio.features.coordenador;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.base.Pessoa;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Coordenador extends Pessoa {

    private Curso coordenacao;

    public Curso getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(Curso coordenacao) {
        this.coordenacao = coordenacao;
    }
    
    @Override
    public void validar(){
        
    }
}
