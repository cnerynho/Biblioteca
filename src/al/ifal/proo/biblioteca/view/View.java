package al.ifal.proo.biblioteca.view;

import al.ifal.proo.biblioteca.view.telas.Tela;
import al.ifal.proo.biblioteca.view.telas.TelaInicial;
import al.ifal.proo.biblioteca.view.telas.TelaLogin;
import al.ifal.proo.biblioteca.view.telas.TelaUsuarioAdministrador;

public class View {

	public void telaInicial() {
		TelaInicial tela = new TelaInicial();
		tela.gerarTela();

	}

	public void telaLogin() {

		Tela tela = new TelaLogin();
		tela.gerarTela();
	}

	public void telaUsuario(int nivelAcesso) {
		Tela tela = null;

		switch (nivelAcesso) {
		case 1:
			tela = new TelaUsuarioAdministrador();
			break;
		case 2:

			break;
		}
		
		tela.gerarTela();
		
	}

}
