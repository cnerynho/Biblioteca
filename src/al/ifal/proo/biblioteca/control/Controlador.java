package al.ifal.proo.biblioteca.control;

import al.ifal.proo.biblioteca.model.user.Usuario;

public class Controlador {
	
	public boolean AutenticarLoggin(String usuario, String senha){
		if(usuario.equals("")&&senha.equals("")){
			Main.USER = new Usuario(0, usuario, senha, 1);
			Main.isLogged = true;
			return true;
		} else{
			return false;
		}
	}

	public boolean getIsLogged() {
		return Main.isLogged;
	}

	public void Exit() {
		Main.isExit = true;
		
	}

	public void LogOut() {
		Main.isLogged = false;
		
	}
}
