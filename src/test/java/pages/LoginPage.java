package pages;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarPaginaInicial(){
		DriverFactory.getDriver().get("https://srbarriga.herokuapp.com/login");		
	}
	
	public void setEmail(String email){
		escreveCampo("email", email);		
	}
	
	public void setSenha(String senha){
		escreveCampo("senha", senha);		
	}
	
	public void entrar(){
		clicaBotao( By.xpath("//div[2]//button") );
	}
}