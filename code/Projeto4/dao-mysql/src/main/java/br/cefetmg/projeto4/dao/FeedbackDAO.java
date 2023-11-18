package br.cefetmg.projeto4.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.FeedbackDTO;
import br.cefetmg.projeto4.idao.IFeedbackDAO;

public class FeedbackDAO implements IFeedbackDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public FeedbackDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(FeedbackDTO feedback) throws SQLException, ClassNotFoundException {
        try {
            String sql = "INSERT INTO `feedbacks`(`id_donatario`, `estrelas`, `descricao`) VALUES ((SELECT `id` FROM `usuarios` WHERE `email` = ?), ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            DonatarioDTO donatario = feedback.getDonatario();

            stmt.setString(1, donatario.getEmail());
            stmt.setInt(2, feedback.getEstrelas());
            stmt.setString(3, feedback.getDescricao());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Inserção realizada com sucesso");
                return true;
            } else {
                System.out.println("Erro na inserção");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remover(FeedbackDTO feedback) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<FeedbackDTO> listar() throws SQLException, ClassNotFoundException {
        try {
            List<FeedbackDTO> feedbacks = new ArrayList<>();
            DonatarioDAO donatarioDAO = new DonatarioDAO();
    
            String sqlFeedbacks = "SELECT feedbacks.*, usuarios.* FROM feedbacks JOIN usuarios ON feedbacks.id_donatario = usuarios.id;";
            try (Statement stmt = conexao.createStatement();
                 ResultSet resultSet = stmt.executeQuery(sqlFeedbacks)) {
    
                String sqlDoacoes = "SELECT doacoes.computador FROM usuarios JOIN donatarios ON usuarios.id = donatarios.id_cadastro JOIN doacoes ON donatarios.id_doacao = doacoes.id WHERE usuarios.email = ?";
                try (PreparedStatement stmt2 = conexao.prepareStatement(sqlDoacoes)) {
                    while (resultSet.next()) {
                        int estrelas = resultSet.getInt("estrelas");
                        String descricao = resultSet.getString("descricao");
                        String email = resultSet.getString("email");
                        DonatarioDTO donatario = (DonatarioDTO) donatarioDAO.selecionar(email).orElseThrow();
    
                        stmt2.setString(1, email);
    
                        String computador;
                        try (ResultSet resultSet2 = stmt2.executeQuery()) {
                            if (!resultSet2.next())
                                throw new SQLException("Failed to select computador");
    
                            computador = resultSet2.getString("computador");
                        }
    
                        FeedbackDTO feedback = new FeedbackDTO(estrelas, descricao, computador, donatario);
                        feedbacks.add(feedback);
                    }
                }
            }
    
            return feedbacks;
        } catch (NoSuchElementException e) {
            throw new SQLException("Usuario nao encontrado", e);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}