package al.ifal.proo.biblioteca.control.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Emprestimo;
import al.ifal.proo.biblioteca.control.util.Setor;
import al.ifal.proo.biblioteca.model.conexao.CadastrarSetor;
import al.ifal.proo.biblioteca.model.conexao.ConsultarEmprestimo;
import al.ifal.proo.biblioteca.model.conexao.ConsultarSetor;
import al.ifal.proo.biblioteca.model.conexao.EditarSetor;
import al.ifal.proo.biblioteca.model.conexao.EmprestimoDeItem;
public class UtilController {

	public void cadastrarSetor(String localizacao, String descricao) throws ControllerException {

		if (localizacao.equals("")) {
			throw new ControllerException("Faltou Digitar a localizacao");
		}

		CadastrarSetor cadastro = new CadastrarSetor();

		cadastro.CadastrarNovoSetor(localizacao, descricao);

	}


	public Setor consultarSetorID(int iD) throws ControllerException {

		ConsultarSetor consulta = new ConsultarSetor();
		ResultSet rs = consulta.consultaID(iD);

		try {
			if (rs.next()) {
				return new Setor(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			throw new ControllerException("Consulta vazia");
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta do Setor");
		} catch (ControllerException e) {
			throw e;
		}

	}
        
    public void editarSetor(String localizacao, String descricao) throws ControllerException {

		if (localizacao.equals("")) {
			throw new ControllerException("Faltou Digitar a localizacao");
		}

		EditarSetor editar = new EditarSetor();

		editar.edicaoSetor(localizacao, descricao);

	}

	public Emprestimo consultarEmprestimos(int idEmprestimo) throws ControllerException {
		
		ConsultarEmprestimo consulta = new ConsultarEmprestimo();
		UserController userC = new UserController();
		ResultSet rs = consulta.consultarEmprestimo(idEmprestimo);
		ItemController itemC = new ItemController();

		try {
			if (rs.next()) {
				if(rs.getDate(5)==null){
					return new Emprestimo(rs.getInt(1),userC.consultarUsuarioPeloID(rs.getInt(2)),itemC.consultarItemPeloID(rs.getInt(3)),rs.getDate(4));
				}else{
					return new Emprestimo(rs.getInt(1),userC.consultarUsuarioPeloID(rs.getInt(2)),itemC.consultarItemPeloID(rs.getInt(3)),rs.getDate(4),rs.getDate(5));
				}
			}
		} catch (SQLException e) {
			throw new ControllerException("Erro ao fazer a Consulta");
		}
	
		return null;
	}

	public void devolverItem(Emprestimo emprestimo) throws ControllerException {
		emprestimo.getItem().setDisponivel(true);
		ItemController itemC = new ItemController();
		itemC.alterarItem(emprestimo.getItem());
		EmprestimoDeItem empI = new EmprestimoDeItem();
		
		emprestimo.setDataQueDevolveu(new Date(new java.util.Date().getTime()));
		
		empI.alterarEmprestimo(emprestimo);
		
	}

}
