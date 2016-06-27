package al.ifal.proo.biblioteca.model.conexao;

import al.ifal.proo.biblioteca.control.util.Setor;

public class ItemVO {

	private int iD;
	private String nome;
	private Setor setor;
	private boolean isDisponivel;
	private int tipoItem;
	
	public ItemVO(int iD, String nome, Setor setor, boolean isDisponivel, int tipoItem) {
		super();
		this.iD = iD;
		this.nome = nome;
		this.setor = setor;
		this.isDisponivel = isDisponivel;
		this.tipoItem = tipoItem;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}

	public int getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(int tipoItem) {
		this.tipoItem = tipoItem;
	}
	
}
