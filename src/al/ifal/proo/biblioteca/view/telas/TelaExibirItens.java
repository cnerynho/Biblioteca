package al.ifal.proo.biblioteca.view.telas;

import java.util.ArrayList;
import java.util.Scanner;

import al.ifal.proo.biblioteca.control.util.Item;

public class TelaExibirItens extends Tela {

	private ArrayList<Item> itens;

	public TelaExibirItens(ArrayList<Item> itens) {
		this.itens = itens;
	}


	public Tela gerarTela() {
		System.out.println("Exibindo Itens:\n\n\n");
		
		for(Item item:itens){
			
			System.out.println(item+"\n");
			
		}
		Scanner entrada = new Scanner(System.in);
		int consulta;
		while(true){
			System.out.println("\n DIGITE O ID DO ITEM PARA MAIS OPCOES DELE, OU 0 PARA SAIR");
			consulta = entrada.nextInt();
			if(consulta == 0){
				return null;
			}
			
			for(Item item:itens){
				
				if(item.getiD()==consulta){
					return new TelaExibirItem(item);
				}
				
			}
			
			System.out.println("ID NÃO ENCONTRADO, TENTE NOVAMENTE!");
			
		
		}
		
	}

}
