package al.ifal.proo.biblioteca.control.controllers;

import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.model.conexao.CadastrarSetor;

public class UtilController {

	public void cadastrarSetor(String localizacao, String descricao) throws ControllerException {

		if (localizacao.equals("")) {
			throw new ControllerException("Faltou Digitar a localizacao");
		}
		
		CadastrarSetor cadastro = new CadastrarSetor();
		
		cadastro.CadastrarNovoSetor(localizacao, descricao);

	}

}
