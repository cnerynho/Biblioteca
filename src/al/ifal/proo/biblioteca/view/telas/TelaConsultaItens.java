package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

public class TelaConsultaItens extends Tela {


	public Tela gerarTela() {
		
		Scanner entrada = new Scanner(System.in);
		
		while(true){
			System.out.println(	  "ESCOLHA UMA DAS OPÇÕES:\n"
					+ "1 - 	CONSULTAR LIVROS\n"
					+ "2 - 	CONSULTAR REVISTAS\n"
					+ "3 -	CONSULTAR TCC\n"
					+ "4 -	CONSULTAR TODOS\n"
					+ "5 -	VOLTAR AO MENU PRINCIPAL\n");
			switch(entrada.nextInt()){
			case 1:
				return new TelaConsultarLivros();
			case 2:
				return new TelaConsultarRevistas();
			case 3:
				return new TelaCon
			case 4:
			case 5:
			}
		}

	}



}
