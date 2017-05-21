/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tiago
 */
public class LivroModel {

    private int id;
    private String nome;
    private String sinopse;
    private String imagem;
    private int paginas;
    private String autor;
    private String genero;
    private boolean lido;

    public LivroModel(int id, String nome, String sinopse, String imagem, int paginas, String autor, String genero, boolean lido) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.imagem = imagem;
        this.paginas = paginas;
        this.autor = autor;
        this.genero = genero;
        this.lido = lido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
