package al.ifal.proo.biblioteca.control.util;

public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento = "";
	private int numero;
	private int cep;

	public Endereco(String rua, String bairro, String cidade, String estado, String complemento, int numero, int cep) {

		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

}
