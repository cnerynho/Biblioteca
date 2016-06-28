package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;

public class CadastrarUsuarios {
	
	public void CadastrarUsuario(String nome, String cpf, String senha, String endereco, int tipoUsuario, int tipoCliente) throws ControllerException{
		
		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("insert into usuarios(nome, cpf, senha, Endereco, tipo_usuario, tipo_cliente)"
					+ "values('" + nome + "','" + cpf + "','" + senha + "','" + endereco + "','" + tipoUsuario + "','"
					+ tipoCliente + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}
}
