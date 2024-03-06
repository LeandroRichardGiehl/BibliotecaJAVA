/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.LivroBancoDados;
import java.util.ArrayList;

/**
 *
 * @author richa
 */
public class LivroModel {
    private int codigo;
    private String titulo;
    private String genero;
    private String paginas;
    private String sinopse;

    public LivroModel() {
    }

    public LivroModel(String titulo, String genero, String paginas, String sinopse) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.sinopse = sinopse;
    }

    public LivroModel(int codigo, String titulo, String genero, String paginas, String sinopse) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.sinopse = sinopse;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    public void cadastrarLivro(LivroModel novoLivro) {
    LivroBancoDados novoRegistro = new LivroBancoDados();
    novoRegistro.inserirLivroDB(novoLivro);
    }

    public ArrayList<LivroModel> listarLivros() {
        return new LivroBancoDados().listarTodosLivros();
    }

    public ArrayList<LivroModel> buscarLivros(String titulo) {
        return new LivroBancoDados().buscarLivros(titulo);
    }

    public void alterarLivro(LivroModel livroAjuste) {
        LivroBancoDados ajusteDados = new LivroBancoDados();
        ajusteDados.alterarLivroDB(livroAjuste);
    }

    public void excluirLivro(int codigo) {
        LivroBancoDados bancoDados = new LivroBancoDados();
        bancoDados.excluirLivroDB(codigo);
    }
}
