package core;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
//______________ Escrever em campos __________________________________________
	
	public void escreveCampo(By by, String texto){
		getDriver().findElement( by ).clear();
		getDriver().findElement( by ).sendKeys(texto); 
	}
	
	public void escreveCampo(String id, String texto){
		escreveCampo(By.id(id), texto);
	}

//______________ Obter valores dos campos ____________________________________
	
	public String obterValorCampo(String id){
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	public String obtemValorCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);	
		return combo.getFirstSelectedOption().getText();
	}
	
	public String obtemValorBotao(String id){
		return getDriver().findElement( By.id(id) ).getAttribute("value");
	}
	
	public String obtemValorLink(String id){
		return getDriver().findElement( By.id(id) ).getText();		
	}
	
	public String obtemValorTexto(String id){
		return obtemValorTexto(By.id(id));
	}
	
	public String obtemValorTexto(By by){
		return getDriver().findElement( by ).getText();
	}

//______________ Clicar Botão/Link____________________________________________

	public void clicaBotao(By by){
		getDriver().findElement( by ).click();
	}
	
	public void clicaBotao(String id){
		clicaBotao( By.id(id) );
	}
	
	public void clicaLink(By by){
		getDriver().findElement( by ).click();
	}
	
	public void clicaLink(String id){
		clicaLink( By.id(id) );
	}

//______________ RADIOS ____________________________________________
	
	public void clicarRadio(By by){
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id){
		clicarRadio( By.id(id) );
	}
	
	public boolean verificaRadioClicado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
//______________ Selecionar combos____________________________________________
	
	public void selecionaCombo(String id, String valor){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);	
		combo.selectByVisibleText(valor);
	}

//______________ ALERTS ____________________________________________
	
	public String obtemTextoAlert(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String obtemTextoEAceitaAlert(){
		Alert alert = getDriver().switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}
	
	public void escreveAlertPrompt(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
//______________ FRAMES ____________________________________________
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocaJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
//______________ Java Script _________________________________________
		
	public Object executaJavaScript(String cmd, Object... param){
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		return js.executeScript(cmd, param);	
	}
	
//______________ TABELAS ____________________________________________
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		
		//Procurar coluna do registro		
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//Encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//Procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//Clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" +idLinha+ "]/td[" +idColunaBotao+ "]"));
		return celula;
	}

//-------------
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}