package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.idao.IDoadorDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VerificarTipoUsuarioDAO {
        MySqlConnection bancoDeDados;
    Connection conexao;

    public VerificarTipoUsuarioDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }
    public String getTipoUsuario(String email, String senha) throws SQLException
    {
        String consultaSQL = "SELECT tipo FROM usuarios WHERE email = ? AND senha = ?";
        PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, senha);
        ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next()) {
                String tipoUsuario = resultado.getString("tipo");
                System.out.println("O tipo de usuário é: " + tipoUsuario);
                return tipoUsuario;
            }
            return "erro";
            
    }

}
