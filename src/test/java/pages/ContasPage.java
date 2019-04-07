package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome){
		escreveCampo("nome", nome);		
	}

	public void salva(){
		clicaBotao( By.xpath("//button[@class='btn btn-primary']") );
	}

	public void clicarApagarConta(String string){
		obterCelula("Conta", string, "A��es", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();		
	}
	
	public void clicarAlterarConta(String string){
		obterCelula("Conta", string, "A��es", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public String obterMensagemSucesso(){
		return obtemValorTexto(By.xpath(".//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro(){
		return obtemValorTexto(By.xpath(".//div[@class='alert alert-danger']"));	
	}
	
	public String obterMensagemGenerica(){
		return obtemValorTexto(By.xpath("//div[starts-with(@class, 'alert alert-')]"));	
	}
}