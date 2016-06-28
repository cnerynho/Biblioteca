package al.ifal.proo.biblioteca.model.conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class EmprestimoDeItem {

    public void novoEmprestimo(Usuario usuario, Item item) throws ControllerException{
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
			stmt.executeUpdate("insert into emprestimos(usuario_id, data_inicio, livro_id)"
					+ "values('" + usuario.getID() + "','" + data + "','" + item.getiD() + "')");
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
    }
}
