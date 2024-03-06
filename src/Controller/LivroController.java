/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.LivroModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author richa
 */
public class LivroController {
        public void cadastrarLivro(String titulo, String genero, String paginas, String sinopse) {
        if ((titulo != null && titulo.length() > 0) && (genero != null && genero.length() > 0)
                && (paginas != null && paginas.length() > 0) && (sinopse != null && sinopse.length() > 0)
            ){

            LivroModel novoLivro = new LivroModel(titulo, genero, paginas, sinopse);
            novoLivro.cadastrarLivro(novoLivro);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }
    }

    public ArrayList<LivroModel> listarLivrosController() {
        LivroModel livro = new LivroModel();
        return livro.listarLivros();
    }

    public ArrayList<LivroModel> buscarLivrosController(String titulo) {
        LivroModel livro = new LivroModel();
        return livro.buscarLivros(titulo);
    }

    public void alterarLivro(String codigo, String titulo, String genero, String paginas, String sinopse) {
        if ((titulo != null && titulo.length() > 0) && (genero != null && genero.length() > 0)
                && (paginas != null && paginas.length() > 0) && (sinopse != null && sinopse.length() > 0)
                && (codigo != null && codigo.length() > 0)
            ){

            int codigoInt = Integer.parseInt(codigo);

            LivroModel ajusteLivro = new LivroModel(codigoInt, titulo, genero, paginas, sinopse);
            ajusteLivro.alterarLivro(ajusteLivro);
            JOptionPane.showMessageDialog(null, "Ajuste realizado");

        } else {
            JOptionPane.showMessageDialog(null, "Informações incorretas!");
        }
    }

    public void excluirLivroController(String codigo) {
        try {
            int codigoLivro = Integer.parseInt(codigo);
            LivroModel livro = new LivroModel();
            livro.excluirLivro(codigoLivro);
            System.out.println("Livro excluído com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de código inválido.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }
    }
}
