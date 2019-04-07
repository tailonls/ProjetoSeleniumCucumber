package entidades;

import java.util.Date;

public class Nota {
	
	private int valorAluguel;
	private Date dataEntrega;
	private int pontuacao;

	public int getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(int valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public int getPontuacao() {
		return this.pontuacao;
	}
	
	public void setPontuacao(int pontuacao){
		this.pontuacao = pontuacao;
		
	}
}