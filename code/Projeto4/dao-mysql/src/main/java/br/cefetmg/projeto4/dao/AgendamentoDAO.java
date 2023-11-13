package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.AgendamentoComUsuarioDTO;
import br.cefetmg.projeto4.dto.AgendamentoDTO;
import br.cefetmg.projeto4.idao.IAgendamentoDAO;

public class AgendamentoDAO implements IAgendamentoDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public AgendamentoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO agendamentos (data, horario, id_donatario) VALUES (?, ?, ?)");

            stmt.setString(1, agendamento.getData());
            stmt.setString(2, agendamento.getHorario());
            stmt.setInt(3, agendamento.getIdDonatario());

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
    public boolean alterar(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public boolean remover(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<AgendamentoComUsuarioDTO> listar() throws SQLException, ClassNotFoundException {
        try {
            List<AgendamentoComUsuarioDTO> agendamentos = new ArrayList<>();

            String sql = "SELECT agendamentos.*, usuarios.* FROM agendamentos JOIN usuarios ON agendamentos.id_donatario = usuarios.id;";
            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                AgendamentoComUsuarioDTO agendamento = new AgendamentoComUsuarioDTO(data, horario, nome, email);

                agendamentos.add(agendamento);
            }

            resultSet.close();
            stmt.close();

            return agendamentos;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
