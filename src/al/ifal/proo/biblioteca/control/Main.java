package al.ifal.proo.biblioteca.control;

import al.ifal.proo.biblioteca.model.user.Usuario;
import al.ifal.proo.biblioteca.view.View;

class Main {
	
	public static boolean isLogged = false;
	public static boolean isExit = false;
	public static Usuario USER;
	
	public static void main(String[] args) {
		

		View view = new View();
		view.telaInicial();

		do {
			
			while (!isLogged) {
				view.telaLogin();
			}
			
			while (isLogged){
				view.telaUsuario(USER.getNivelAcesso());
			}
			
			
		} while (!isExit);
		
	}

}
