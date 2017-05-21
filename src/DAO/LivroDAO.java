/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Conexao;
import java.sql.ResultSet;

/**
 *
 * @author Tiago
 */
public class LivroDAO {

    private final Conexao c = new Conexao();
    private String sql;
    private ResultSet res;

    public LivroDAO() {
    }

    public ResultSet getAcervo() {
        sql = "select DISTINCT livro.idlivro as id, livro.nome as nome, sinopse, imagem, qtd_paginas as paginas, autor, genero.nome as genero from livro INNER JOIN genero ON livro.genero_idgenero = genero.idgenero";
        res = c.executarConsulta(sql);
        return res;
    }

    public ResultSet getAcervoPorGenero(String generoLivro) {
        sql = "SELECT DISTINCT livro.idlivro as id, livro.nome as nome, sinopse, imagem, qtd_paginas as paginas, autor, genero.nome as genero FROM livro INNER JOIN genero ON livro.genero_idgenero = genero.idgenero WHERE genero.nome ='" + generoLivro + "';";
        res = c.executarConsulta(sql);
        return res;
    }

    public ResultSet getGeneros() {
        sql = "SELECT nome FROM genero;";
        res = c.executarConsulta(sql);
        return res;
    }

    public ResultSet getLivrosLidos(int idUsuario) {
        sql = "SELECT livro.idlivro as id FROM livro INNER JOIN usuario_has_livro ON livro.idlivro = usuario_has_livro.livro_idlivro WHERE usuario_has_livro.usuario_idusuario = '" + idUsuario + "'";
        res = c.executarConsulta(sql);
        return res;
    }

    public void setLivroLido(int idUsuario, int idLivro) {
        sql = "INSERT INTO usuario_has_livro (usuario_idusuario, livro_idlivro) VALUES ('" + idUsuario + "', '" + idLivro + "');";
        c.executarSql(sql);
    }

}
