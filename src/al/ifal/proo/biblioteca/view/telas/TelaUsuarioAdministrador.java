package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;

public class TelaUsuarioAdministrador extends Tela  {

	public void gerarTela() {
		Scanner entrada = new Scanner(System.in);
		Controlador controller = new Controlador();
		Tela tela;
		
		
		while(controller.getIsLogged()){
			
			System.out.println(	  "ESCOLHA UMA DAS OPÇÕES:\n"
								+ "1 - 	CONSULTAR LIVROS\n"
								+ "2 - 	CADASTRAR NOVOS LIVROS\n"
								+ "3 - 	DEVOLVER LIVRO\n"
								+ "4 - 	CADASTRAR NOVOS USUARIOS\n"
								+ "5 -	LOGOUT.\n"
								+ "6 -	SAIR DO SISTEMA.\n");
			
			switch(entrada.nextInt()){
				case 1:
					tela = new TelaConsultaLivro();
					break;
				case 2:
					tela = new TelaCadastroLivros();
					break;
				case 3:
					tela = new TelaDevolverLivros();
					break;
				case 4:
					tela = new TelaCadastroUsuario();					
					break;
				case 6:
					controller.Exit();
				case 5:
					controller.LogOut();
					break;
					
			}
		}
		
		
	}


}
