package al.ifal.proo.biblioteca.control;

import al.ifal.proo.biblioteca.control.util.Usuario;

public class Controlador {
	
	public static boolean isLogged = false;
	public static boolean isExit = false;
	public static Usuario USER;

	public boolean AutenticarLoggin(Usuario usuario) {
		
		
		return false;
	}

	public boolean getIsLogged() {
		return isLogged;
	}

	public void Exit() {
		isExit = true;

	}

	public void LogOut() {
		isLogged = false;

	}

	public Usuario getUsuario() {
		return USER;
	}
}
