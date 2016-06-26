package al.ifal.proo.biblioteca.control.util;

public class Setor {

	private int iD;
	private String localizacao;
	private String descricao;

	public Setor(int iD,String localizacao, String descricao) {
		this.iD = iD;
		this.localizacao = localizacao;
		this.descricao = descricao;

	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
