/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Conexao;
import Controller.Util;
import Model.ConquistaModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void setPontos(int pontos, int idUsuario) {
        sql = "UPDATE usuario SET pontos = '" + pontos + "' where usuario.idusuario ='" + idUsuario + "'";
        c.executarSql(sql);
    }

    public int getPontos(int idUsuario) {
        int pontos = 0;
        sql = "SELECT usuario.pontos as pontos from usuario WHERE  usuario.idusuario = '" + idUsuario + "'";
        ResultSet res = c.executarConsulta(sql);
        try {
            if (res.next()) {
                pontos = res.getInt("pontos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pontos;
    }

    public int getQTDLivrosGenero(int idUsuario, String genero) {
        int qtd = 0;
        sql = "SELECT COUNT(idlivro) as quantidade FROM usuario_has_livro INNER JOIN usuario ON usuario.idusuario = usuario_has_livro.usuario_idusuario INNER JOIN livro ON livro.idlivro = usuario_has_livro.livro_idlivro INNER JOIN genero ON genero.idgenero = livro.genero_idgenero WHERE usuario_has_livro.usuario_idusuario = '" + idUsuario + "' AND genero.nome = '" + genero + "'";
        ResultSet res = c.executarConsulta(sql);
        try {
            if (res.next()) {
                qtd = res.getInt("quantidade");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qtd;
    }

    public ConquistaModel getConquista(String genero) {
        sql = "select * from conquista INNER JOIN genero ON conquista.genero_idgenero = genero.idgenero WHERE genero.nome = '" + genero + "'";
        ResultSet res = c.executarConsulta(sql);
        ConquistaModel cm = null;
        try {
            if (res.next()) {
                cm = new ConquistaModel(res.getInt("idconquista"), res.getString("nome"), res.getString("imagem"), res.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cm;
    }

    public void setConquista(int idUsuario, int idConquista) {
        sql = "insert INTO usuario_has_conquista (usuario_idusuario,conquista_idconquista) VALUES ('" + idUsuario + "','" + idConquista + "')";
        c.executarSql(sql);
    }

    public ResultSet getTop10() {
        sql = "select usuario.idusuario, usuario.nome, usuario.pontos from usuario ORDER by usuario.pontos DESC LIMIT 10";
        ResultSet res = c.executarConsulta(sql);
        return res;
    }

    public ResultSet getMyConquistas(int idUsuario) {
        sql = "select conquista.nome, conquista.imagem from conquista INNER JOIN usuario_has_conquista on conquista.idconquista = usuario_has_conquista.conquista_idconquista INNER JOIN usuario ON usuario.idusuario = usuario_has_conquista.usuario_idusuario WHERE usuario.idusuario ='" + idUsuario + "'";
        ResultSet res = c.executarConsulta(sql);
        return res;
    }
}
