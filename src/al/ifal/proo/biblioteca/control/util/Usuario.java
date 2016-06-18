package al.ifal.proo.biblioteca.control.util;

public abstract class Usuario implements IUser {

	private int ID;
	private String nome;
	private int cpf;
	private Endereco endereco;
	private String senha;
	private String tipoUsuario;
	private String tipoCliente;

	public Usuario(int iD, String nome, int cpf, Endereco endereco, String senha, String tipoUsuario,
			String tipoCliente) {
		ID = iD;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.senha = senha;
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

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
