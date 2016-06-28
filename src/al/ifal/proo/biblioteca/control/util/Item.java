package al.ifal.proo.biblioteca.control.util;

public abstract class Item {

	private int iD;
	private String nome;
	private Setor setor;
	private boolean isDisponivel;
	private int tipo;

	public Item(int iD, String nome, Setor setor, boolean isDisponivel,int tipo) {
		super();
		this.iD = iD;
		this.nome = nome;
		this.setor = setor;
		this.isDisponivel = isDisponivel;
		this.tipo = tipo;
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
	
	public int getTipo(){
		return tipo;
	}

	public String toStringItem() {
		if (isDisponivel) {
			return "|"+ iD + "|  Nome = " + nome + ", Setor = " + setor.getiD() + ", Disponivel ";
		} else {
			return "|"+ iD + "|  Nome = " + nome + ", Setor = " + setor.getiD() + ", INDISPONIVEL ";

		}
	}

}
