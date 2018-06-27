/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.apresentacao;

import br.edu.ifsc.registro.infraestrutura.ConnectionDB;
import java.sql.Connection;

/**
 *
 * @author Lucas
 */
public class TesteConexao {
    private static final Connection conexao = ConnectionDB.getConnection();
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        try {
            conexao.commit();
            conexao.close();
            System.out.println("Teste feito com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
