package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.MantecaoDTO;
import br.cefetmg.projeto4.idao.IMantecaoDAO;

public class MantecaoDAO implements IMantecaoDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public MantecaoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
}