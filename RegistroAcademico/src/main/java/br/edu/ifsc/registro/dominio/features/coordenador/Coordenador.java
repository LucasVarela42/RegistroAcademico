package br.edu.ifsc.registro.dominio.features.coordenador;

import br.edu.ifsc.registro.dominio.features.curso.Curso;
import br.edu.ifsc.registro.dominio.base.Pessoa;

/**
 *
 * @author Edoardo Colares, Lucas Varela, Matheus de Medeiros
 */
public class Coordenador extends Pessoa {

    private Curso cursoCoordenacao;

    public Curso getCursoCoordenacao() {
        return cursoCoordenacao;
    }

    public void setCursoCoordenacao(Curso cursoCoordenacao) {
        this.cursoCoordenacao = cursoCoordenacao;
    }

    @Override
    public void validar() throws Exception {
        super.validar();
        if (cursoCoordenacao == null) {
            throw new Exception("O coordenador deve ser vinculado a um curso.");
        }
    }
}
