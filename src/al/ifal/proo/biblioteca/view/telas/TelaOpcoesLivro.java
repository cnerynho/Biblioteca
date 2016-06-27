package al.ifal.proo.biblioteca.view.telas;

import al.ifal.proo.biblioteca.control.Controlador;
import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.util.Livro;

public class TelaOpcoesLivro extends Tela {

	private Livro consultado;
	
	public TelaOpcoesLivro(Livro consultado) {
		this.consultado = consultado;
	}

	public Tela gerarTela() {
		Controlador controller = new Controlador();
		UserController usuarioC = new UserController();
		switch(controller.getUsuario().getTipoUsuario()){
		case usuarioC.CLIENTE:
			return menuCliente();
		case usuarioC.FUNCIONARIO:
			return menuFuncionario();
		case usuarioC.GERENTE:
			return menuGerente();
		}
		
		

		return null;
	}

}
