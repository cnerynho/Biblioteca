package al.ifal.proo.biblioteca.control.util;

public abstract class Usuario {

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

}
