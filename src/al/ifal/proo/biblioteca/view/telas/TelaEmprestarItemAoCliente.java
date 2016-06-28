package al.ifal.proo.biblioteca.view.telas;

import java.util.Scanner;

import al.ifal.proo.biblioteca.control.controllers.UserController;
import al.ifal.proo.biblioteca.control.exceptions.ControllerException;
import al.ifal.proo.biblioteca.control.util.Item;
import al.ifal.proo.biblioteca.control.util.Usuario;

public class TelaEmprestarItemAoCliente extends Tela {

	private Item item;

	public TelaEmprestarItemAoCliente(Item item) {
		this.item = item;
	}

	public Tela gerarTela() {
		
		Scanner entrada = new Scanner(System.in);
		
		Usuario usuario = null;
		UserController userC = new UserController();
		
		System.out.println("Digite o CPF do cliente\n"
				+ "Ou Digite SAIR para voltar ao menu principal\n");
		
		String opcao;
		while(true){
			opcao = entrada.nextLine();
			if(opcao.equals("SAIR")){
				return null;
			}else {
				try{
					usuario = userC.consultarUsuarioPeloCPF(opcao);
					userC.emprestarItem(usuario, item);
					System.out.println("Emprestimo efetivado");
				} catch (ControllerException e){
					System.out.println("Valor incorreto para CPF, tente novamente!");
				}
			}
		}
		
	}

}
