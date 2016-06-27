
package al.ifal.proo.biblioteca.model.conexao;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EditarItens {
    public int cadastrarItem(String nome, int idSetor, int tipoItem) throws ControllerException {

		IConexao banco = new ConexaoMySQL();
		Connection conexao = banco.getConexao();
		Statement stmt;

		try {
			stmt = conexao.createStatement();
		} catch (SQLException e) {
			throw new ControllerException("Erro ao criar o Statement!");
		}

		try {
			stmt.executeUpdate("update itens set(Nome, id_Setor, Disponivel, tipo_item)" + "values('" + nome + "','"
					+ idSetor + "','" + 1 + "','" + tipoItem + "')", Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt.getGeneratedKeys();
			result.next();
			int iD = result.getInt(1);
			return iD;
		} catch (SQLException e) {
			throw new ControllerException("erro ao incluir os dados na tabela");
		}
	}
}
