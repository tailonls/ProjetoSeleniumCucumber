package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ResumoMensalPage extends BasePage {
	
	public void clicarApagarMovimentacao(String string){
		obterCelula("Descri��o", string, "A��es", "tabelaExtrato").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
	public String obterMensagemSucesso(){
		return obtemValorTexto(By.xpath(".//div[@class='alert alert-success']"));
	}
}