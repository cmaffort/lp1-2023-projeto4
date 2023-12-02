package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import br.cefetmg.projeto4.dto.MantecaoDTO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.EstagiarioDTO;
import br.cefetmg.projeto4.idao.IMantecaoDAO;

public class MantecaoDAO implements IMantecaoDAO {
    private final Connection conexao;

    public MantecaoDAO() throws SQLException {
        conexao = MysqlConnection.getConexao();
    }

    @Override
    public boolean inserir(MantecaoDTO mantecao) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT IGNORE INTO mantecao (data, estado, id_donatario, id_arrumador) VALUES (?, ?, (SELECT id FROM usuarios WHERE email = ?), (SELECT id FROM usuarios WHERE email = ?));");

            statement.setString(1, mantecao.getData());
            statement.setString(2, mantecao.getEstado());
            statement.setString(3, mantecao.getEmailDonatario());
            statement.setString(4, mantecao.getEmailArrumador());

            int rowsAffected = statement.executeUpdate();

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
    public boolean alterar(MantecaoDTO mantecao) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public boolean remover(MantecaoDTO mantecao) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<MantecaoDTO> listar() throws SQLException, ClassNotFoundException {
        try {
            List<MantecaoDTO> manutencoes = new ArrayList<>();

            try (
                DonatarioDAO donatarioDAO = new DonatarioDAO();
                EstagiarioDAO estagiarioDAO = new EstagiarioDAO()
            ) {
                PreparedStatement stmt = conexao.prepareStatement("SELECT mantecao.*, arrumador.email AS email_arrumador, donatario.email AS email_donatario FROM mantecao JOIN usuarios AS arrumador ON mantecao.id_arrumador = arrumador.id JOIN usuarios AS donatario ON mantecao.id_donatario = donatario.id;");
                ResultSet resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    String data = resultSet.getString("data");
                    String estado = resultSet.getString("estado");
                    String emailArrumador = resultSet.getString("email_arrumador");
                    String emailDonatario = resultSet.getString("email_donatario");

                    DonatarioDTO donatario = (DonatarioDTO) donatarioDAO.selecionar(emailDonatario).orElseThrow();
                    EstagiarioDTO arrumador = (EstagiarioDTO) estagiarioDAO.selecionar(emailArrumador).orElseThrow();
                    
                    MantecaoDTO mantecao = new MantecaoDTO(data, estado, donatario, arrumador);

                    manutencoes.add(mantecao);
                }

                resultSet.close();
                stmt.close();
            }

            return manutencoes;
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