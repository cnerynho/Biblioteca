package al.ifal.proo.biblioteca.view.telas;

import java.util.ArrayList;
import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.ItemController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;

public class TelaConsultarItensGeral extends Tela {

	public Tela gerarTela() {

		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao<1 || opcao > 3){
			
			System.out.println("ESCOLHA UMA DAS OPÇÕES:\n"
					+ "1 - 	CONSULTAR POR ID\n"
					+ "2 - 	CONSULTAR POR NOME\n"
					+ "3 -	VOLTAR AO MENU PRINCIPAL\n");
			opcao = entrada.nextInt();
		}

			switch(opcao){
			case 1:
				return consultarPorID();
			case 2:
				return consultarPorNome();
			case 3:
				return null;
			
		}
		return null;
	}
	
	private Tela consultarPorID() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o ID do ITEM que deseja Consultar");
		ItemController consulta = new ItemController();
		int iD = entrada.nextInt();
		try {
			Item consultado = consulta.consultarItemPeloID(iD);
			return new TelaExibirItem(consultado);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	private Tela consultarPorNome() {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o Nome do ITEM que deseja Consultar");
		ItemController consulta = new ItemController();
		String nome = entrada.nextLine();
		try {
			ArrayList<Item> consultados = consulta.consultarItemPeloNome(nome);
			return new TelaExibirItens(consultados);
		} catch (ControllerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}	

}
