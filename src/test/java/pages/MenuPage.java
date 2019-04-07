package pages;

import core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta(){
		clicaLink("Contas");
		clicaLink("Adicionar");		
	}
	
	public void acessarTelaAlterarConta(){
		clicaLink("Contas");
		clicaLink("Listar");		
	}
	
	public void acessarTelaMovientacoes(){
		clicaLink("Criar Movimenta��o");
	}
	
	public void acessarTelaResumoMensal(){
		clicaLink("Resumo Mensal");
	}
	
	public void acessarTelaHome(){
		clicaLink("Home");
	}
}
