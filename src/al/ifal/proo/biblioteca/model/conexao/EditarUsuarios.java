package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class EditarUsuarios {

	public void editarUsuario(Usuario usuario) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("update usuarios set(nome, cpf, senha, Endereco, tipo_usuario, tipo_cliente)"
					+ "values('" + usuario.getNome() + "','" + usuario.getCpf() + "','" + usuario.getSenha() + "','"
					+ usuario.getEndereco() + "','" + usuario.getTipoUsuario() + "','" + usuario.getTipoCliente()
					+ " where id = " + usuario.getID() + "') ");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}
}
