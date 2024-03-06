/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.LivroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author richa
 */
public class LivroBancoDados {
        public void inserirLivroDB(LivroModel novoLivro) {

        String sql = "INSERT INTO livro (titulo, genero, paginas, sinopse) values (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoDB().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoLivro.getTitulo());
            stmt.setString(2, novoLivro.getGenero());
            stmt.setString(3, novoLivro.getPaginas());
            stmt.setString(4, novoLivro.getSinopse());

            stmt.execute();
            System.out.println("Registro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }

    public ArrayList<LivroModel> listarTodosLivros() {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        LivroModel livro = null;
        ArrayList<LivroModel> listarLivros = null;

        String sql = "SELECT * FROM ROOT.LIVRO";

        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listarLivros = new ArrayList<>();
                while (rs.next()) {
                    livro = new LivroModel();
                    livro.setCodigo(rs.getInt("codigo"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setGenero(rs.getString("genero"));
                    livro.setPaginas(rs.getString("paginas"));
                    livro.setSinopse(rs.getString("sinopse"));
                    listarLivros.add(livro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        System.out.println("Lista" + listarLivros);
        return listarLivros;
    }

    public ArrayList<LivroModel> buscarLivros(String titulo) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        LivroModel livro = null;
        ArrayList<LivroModel> listarLivros = null;

        String sql = "SELECT * FROM ROOT.LIVRO WHERE titulo LIKE '%"
                + titulo + "%' ORDER BY titulo";

        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listarLivros = new ArrayList<>();
                while (rs.next()) {
                    livro = new LivroModel();
                    livro.setCodigo(rs.getInt("codigo"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setGenero(rs.getString("genero"));
                    livro.setPaginas(rs.getString("paginas"));
                    livro.setSinopse(rs.getString("sinopse"));
                    listarLivros.add(livro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao selecionar contatos!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        return listarLivros;
    }

    public void alterarLivroDB(LivroModel livroAjuste) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.LIVRO SET titulo=?, genero=?, paginas=?, sinopse=? WHERE codigo=?";

        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livroAjuste.getTitulo());
            stmt.setString(2, livroAjuste.getGenero());
            stmt.setString(3, livroAjuste.getPaginas());
            stmt.setString(4, livroAjuste.getSinopse());
            stmt.setInt(5, livroAjuste.getCodigo());
            stmt.execute();
            System.out.println("Alteração do registro realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar a alteração no registro!");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }

    public void excluirLivroDB(int codigo) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.LIVRO where codigo=?";

        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
            System.out.println("Exlusão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar a exclusão do registro.");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }

    }
}
