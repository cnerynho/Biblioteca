package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.Controlador;

public class TelaUsuarioCliente extends Tela  {

	public Tela gerarTela() {
		
		Controlador controller = new Controlador();
		Tela tela = null;
		
		while(controller.getIsLogged()){
			tela = menu();
			while(tela != null){
				tela = tela.gerarTela();
			}
		}
		
		return tela;
		
	}

	private Tela menu() {
		Scanner entrada = new Scanner(System.in);
		Controlador controller = new Controlador();
		Tela tela = null;
		
		while(controller.getIsLogged()){
			
			System.out.println(	  "ESCOLHA UMA DAS OP��ES:\n"
								+ "1 - 	CONSULTAR ITENS\n"
								+ "2 - 	CONSULTAR ITENS LOCADOS\n"
								+ "3 -	ALTERAR SENHA\n"
								+ "4 -	LOGOUT\n"
								+ "5 -	SAIR DO SISTEMA\n");
			
			switch(entrada.nextInt()){
				case 1:
					tela = new TelaConsultaItens();
					break;
				case 2:
					tela = new TelaConsultaItensLocados(controller.getUsuario());
					break;
				case 3:
					tela = new TelaAlterarSenha(controller.getUsuario());
					break;
				case 5:
					controller.Exit();
				case 4:
					controller.LogOut();
					return null;
					
			}
		}
		
		return tela;
	}


}
