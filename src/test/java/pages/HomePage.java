package pages;

import core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldo(String valor){		
		String celula = obterCelula("Conta", valor, "Saldo", "tabelaSaldo").getText();
		
		return celula;
	}
}