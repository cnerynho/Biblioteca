package al.ifal.proo.biblioteca.control.util;

public class Resvista extends Item {

	private int ano;
	private int numero;
	
	public Resvista(int iD, String nome, Setor setor, boolean isDisponivel, int ano, int numero) {
		super(iD, nome, setor, isDisponivel);
		this.ano = ano;
		this.numero = numero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
