package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Emprestimo;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class EmprestimoDeItem {

	public void novoEmprestimo(Usuario usuario, Item item) throws ControllerException {
		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;
		Date data = new Date(new java.util.Date().getTime());

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("insert into emprestimos(usuario_id, data_inicio, livro_id)" + "values('"
					+ usuario.getID() + "','" + data + "','" + item.getiD() + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}

	public void alterarEmprestimo(Emprestimo emprestimo) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("update emprestimos set(usuario_id, item_id, data_inicio, data_devolucao)" + "values('"
					+ emprestimo.getUser().getID() + "','" + emprestimo.getItem().getiD() + "','"
					+ emprestimo.getDataQueLocou() + "','" + emprestimo.getDataQueDevolveu() + "')");
		} catch (SQLException e) {
			throw new ControllerException("Erro ao incluir os dados na tabela");
		}

	}
}
