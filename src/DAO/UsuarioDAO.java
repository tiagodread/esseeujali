/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Conexao;
import Controller.Util;
import java.sql.ResultSet;

/**
 *
 * @author Tiago
 */
public class UsuarioDAO {

    private final Conexao c = new Conexao();
    private ResultSet res;
    private String sql;

    Util util = new Util();

    public UsuarioDAO() {

    }

    public ResultSet logar(String login, String senha) {
        senha = Util.md5(senha);
        sql = "SELECT * FROM usuario WHERE login = '" + login + "' AND senha = '" + senha + "'";
        res = c.executarConsulta(sql);
        return res;
    }
}
