package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.Agendamento;
import br.cefetmg.projeto4.idao.IAgendamentoDAO;

public class AgendamentoDAO implements IAgendamentoDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public AgendamentoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Agendamento agendamento) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO agendamentos (data, horario, id_donatario) VALUES (?, ?, ?)");

            stmt.setString(1, agendamento.getData());
            stmt.setString(2, agendamento.getHorario());
            stmt.setInt(3, agendamento.getDonatario());

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
    public boolean alterar(Agendamento agendamento) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public boolean remover(Agendamento agendamento) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<Agendamento> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
}
