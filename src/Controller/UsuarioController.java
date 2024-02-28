package Controller;

import Model.UsuarioModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioController {

    public void cadastrarUsuario(String nome, String cpf, String email, String endereco, String dataNascimento) {
        if ((nome != null && nome.length() > 0) && (cpf != null && cpf.length() > 0)
                && (email != null && email.length() > 0) && (endereco != null && endereco.length() > 0)
                && (dataNascimento != null && dataNascimento.length() > 0)) {

            UsuarioModel novoUsuario = new UsuarioModel(nome, cpf, email, endereco, dataNascimento);
            novoUsuario.cadastrarUsuario(novoUsuario);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }
    }

    public ArrayList<UsuarioModel> listarUsuariosController() {
        UsuarioModel usuario = new UsuarioModel();
        return usuario.listarUsuarios();
    }

    public ArrayList<UsuarioModel> buscarUsuarioController(String nome) {
        UsuarioModel usuario = new UsuarioModel();
        return usuario.buscarUsuarios(nome);
    }

    public void alterarUsuario(String codigo, String nome, String cpf, String email, String endereco, String dataNascimento) {
        if ((nome != null && nome.length() > 0) && (cpf != null && cpf.length() > 0)
                && (email != null && email.length() > 0) && (endereco != null && endereco.length() > 0)
                && (dataNascimento != null && dataNascimento.length() > 0) && (codigo != null && codigo.length() > 0)) {

            int codigoInt = Integer.parseInt(codigo);

            UsuarioModel ajusteUsuario = new UsuarioModel(codigoInt, nome, cpf, email, endereco, dataNascimento);
            ajusteUsuario.alterarUsuario(ajusteUsuario);
            JOptionPane.showMessageDialog(null, "Ajuste realizado");

        } else {
            JOptionPane.showMessageDialog(null, "Informações incorretas!");
        }
    }

    public void excluirUsuarioController(String codigo) {
        try {
            int codigoUsuario = Integer.parseInt(codigo);
            UsuarioModel usuario = new UsuarioModel();
            usuario.excluirUsuario(codigoUsuario);
            System.out.println("Usuário excluído com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de código inválido.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }
}
