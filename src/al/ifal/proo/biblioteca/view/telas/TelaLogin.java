package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;

public class TelaLogin extends Tela  {

	public void gerarTela() {
		String usuario;
		String senha;
		System.out.println("TELA DE LOGIN, PRESSIONE ENTER PARA CONTINUAR...");
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		System.out.println("Digite seu usuario:");
		usuario = entrada.nextLine();
		System.out.println("Digite sua senha:");
		senha = entrada.nextLine();
		Controlador controller = new Controlador();

		if (controller.AutenticarLoggin(usuario, senha)) {
			System.out.println("login efetuado com sucesso!");
		} else {
			System.out.println("Erro, Usuario ou senha Incorretos");
		}

	}

}
