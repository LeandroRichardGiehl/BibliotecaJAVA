/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AutorModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author richa
 */
public class AutorController {
    public void cadastrarAutor(String nome, String nacionalidade) {
        if ((nome != null && nome.length() > 0) && (nacionalidade != null && nacionalidade.length() > 0)
            ){

            AutorModel novoAutor = new AutorModel(nome, nacionalidade);
            novoAutor.cadastrarAutor(novoAutor);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }
    }

    public ArrayList<AutorModel> listarAutoresController() {
        AutorModel autor = new AutorModel();
        return autor.listarAutores();
    }

    public ArrayList<AutorModel> buscarAutoresController(String nome) {
        AutorModel autor = new AutorModel();
        return autor.buscarAutores(nome);
    }

    public void alterarAutor(String codigo, String nome, String nacionalidade) {
        if ((nome != null && nome.length() > 0) && (nacionalidade != null && nacionalidade.length() > 0)
                && (codigo != null && codigo.length() > 0)
            ){

            int codigoInt = Integer.parseInt(codigo);

            AutorModel ajusteAutor = new AutorModel(codigoInt, nome, nacionalidade);
            ajusteAutor.alterarAutor(ajusteAutor);
            JOptionPane.showMessageDialog(null, "Ajuste realizado");

        } else {
            JOptionPane.showMessageDialog(null, "Informações incorretas!");
        }
    }

    public void excluirAutorController(String codigo) {
        try {
            int codigoAutor = Integer.parseInt(codigo);
            AutorModel autor = new AutorModel();
            autor.excluirAutor(codigoAutor);
            System.out.println("Autor excluído com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de código inválido.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir autor: " + e.getMessage());
        }
    }
}
