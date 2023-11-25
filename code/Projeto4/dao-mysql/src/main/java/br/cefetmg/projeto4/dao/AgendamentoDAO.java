package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import br.cefetmg.projeto4.dto.AgendamentoDTO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.idao.IAgendamentoDAO;

public class AgendamentoDAO implements IAgendamentoDAO {
    private final Connection conexao;

    public AgendamentoDAO() throws SQLException {
        conexao = MysqlConnection.getConexao();
    }

    @Override
    public boolean inserir(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO agendamentos (data, horario, id_donatario) VALUES (?, ?, (SELECT id FROM usuarios WHERE email = ?))");

            stmt.setString(1, agendamento.getData());
            stmt.setString(2, agendamento.getHorario());
            stmt.setString(3, agendamento.getDonatario().getEmail());

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
    public List<AgendamentoDTO> listar() throws SQLException, ClassNotFoundException {
        try {
            List<AgendamentoDTO> agendamentos = new ArrayList<>();

            try (DonatarioDAO donatarioDAO = new DonatarioDAO()) {
                String sql = "SELECT agendamentos.*, usuarios.email FROM agendamentos JOIN usuarios ON agendamentos.id_donatario = usuarios.id;";
                Statement stmt = conexao.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);

                while (resultSet.next()) {
                    String data = resultSet.getString("data");
                    String horario = resultSet.getString("horario");
                    String email = resultSet.getString("email");

                    DonatarioDTO donatario = (DonatarioDTO) donatarioDAO.selecionar(email).orElseThrow();

                    AgendamentoDTO agendamento = new AgendamentoDTO(data, horario, donatario);

                    agendamentos.add(agendamento);
                }

                resultSet.close();
                stmt.close();
            }

            return agendamentos;
        } catch (NoSuchElementException e) {
            throw new SQLException("Usuario nao encontrado", e);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void close() throws SQLException {
        conexao.close();
    }
}
