package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.util.Livro;

public class TelaExibirLivro extends Tela {
	private Livro consultado;

	public TelaExibirLivro(Livro consultado) {
		this.consultado = consultado;
	}

	public Tela gerarTela() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("CONSULTA DE LIVRO\n"
				+ consultado
				+ "\n"
				+ "DIGITE 1 PARA OPCOES OU \n"
				+ "DIGITE QUALQUER OUTRO NUMERO PARA VOLTAR AO MENU PRINCIPAL\n");
		switch(entrada.nextInt()){
		case 1:
			return new TelaOpcoesLivro(consultado);
		default:
			return null;
		}
		
	}

}
