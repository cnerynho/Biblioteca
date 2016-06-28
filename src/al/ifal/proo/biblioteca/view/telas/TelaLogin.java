package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class TelaLogin extends Tela  {

	public Tela gerarTela() {
		Usuario user = null;
		String usuario;
		String senha;
		Scanner entrada = new Scanner(System.in);
		Controlador controller = new Controlador();

		
		while(user == null){
			System.out.println("TELA DE LOGIN, PRESSIONE ENTER PARA CONTINUAR...");
			entrada.nextLine();
			System.out.println("Digite seu CPF:");
			usuario = entrada.nextLine();
			System.out.println("Digite sua senha:");
			senha = entrada.nextLine();		
			
			user = controller.AutenticarLoggin(usuario, senha);
			
			
			if (user == null) {
				System.out.println("Erro ao efetuar Login!\nTente Novamente!");
			}
			
		}


		
		return user.getTela();

	}

}
