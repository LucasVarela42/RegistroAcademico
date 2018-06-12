/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.registro.infraestrutura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public final class DataBase {

    private static Connection conexao = ConnectionDB.getConnection();

    private static Connection getConnection() {
        return conexao;
    }

    public static int insert(String insertSql, Object... parametros) throws SQLException {
        int id = 0;
        try (PreparedStatement pstmt
                = getConnection().prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }
            pstmt.execute();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }

            getConnection().commit();
        } catch (SQLException ex) {
            getConnection().rollback();
            throw ex;
        }
        return id;
    }

    public static int update(String updateSql, Object... parametros) throws SQLException {
        return insert(updateSql, parametros);
    }

    public static void delete(String deleteSql, Integer id) throws SQLException {
        try (PreparedStatement pstmt = getConnection().prepareStatement(deleteSql)) {
            pstmt.setInt(1, id);
            pstmt.execute();
            getConnection().commit();
        } catch (SQLException ex) {
            getConnection().rollback();
            throw ex;
        }
    }
}
