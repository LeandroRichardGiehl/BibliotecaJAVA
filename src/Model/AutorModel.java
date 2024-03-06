/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AutorBancoDados;
import DAO.UsuarioBancoDados;
import java.util.ArrayList;

/**
 *
 * @author richa
 */
public class AutorModel {
    private int codigo;
    private String nome;
    private String nacionalidade;

    public AutorModel() {
    }

    public AutorModel(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public AutorModel(int codigo, String nome, String nacionalidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    
        public void cadastrarAutor(AutorModel novoAutor) {
        AutorBancoDados novoRegistro = new AutorBancoDados();
        novoRegistro.inserirAutorDB(novoAutor);

    }

    public ArrayList<AutorModel> listarAutores() {
        return new AutorBancoDados().listarTodosAutores();
    }

    public ArrayList<AutorModel> buscarAutores(String nome) {
        return new AutorBancoDados().buscarAutor(nome);
    }

    public void alterarAutor(AutorModel autorAjuste) {
        AutorBancoDados ajusteDados = new AutorBancoDados();
        ajusteDados.alterarAutorDB(autorAjuste);
    }

    public void excluirAutor(int codigo) {
        AutorBancoDados bancoDados = new AutorBancoDados();
        bancoDados.excluirAutorDB(codigo);
    }
}
