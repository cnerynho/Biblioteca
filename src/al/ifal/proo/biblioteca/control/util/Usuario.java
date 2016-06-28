package al.ifal.proo.biblioteca.control.util;

import al.ifal.proo.biblioteca.view.telas.Tela;

public abstract class Usuario implements IUser{

	private int ID;
	private String nome;
	private String cpf;
	private String endereco;
	private int tipoUsuario;
	private int tipoCliente;

	public Usuario(int iD, String nome, String cpf, String endereco, int tipoUsuario,
			int tipoCliente) {
		ID = iD;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.tipoUsuario = tipoUsuario;
		this.tipoCliente = tipoCliente;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	

	@Override
	public String toString() {
		return "Usuario |" + ID + "|   Nome = " + nome + ", CPF = " + cpf + ", Endereco = " + endereco;
	}
	
	public abstract Tela getTela();
	

}
