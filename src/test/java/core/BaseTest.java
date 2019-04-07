package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.java.After;
import pages.LoginPage;

public class BaseTest {

	private static LoginPage loginPage = new LoginPage(); 
	
	//@Rule
	public TestName testName = new TestName(); //nome do teste q esta sendo executado
	
	@After
	public void fecha() throws IOException{
		capturaTela(testName);		
		//logica para usar o mesmo browser em varios testes conforme Propriedades.java
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
	
	@AfterClass
	public static void finaliza(){
		killDriver();
	}

	//@Before foi colocado na classe SuiteGeral.class
	//@BeforeClass
	public static void inicializa(){
		loginPage.acessarPaginaInicial();
		loginPage.setEmail("projeto@basico.com.br");
		loginPage.setSenha("projeto@basico.com.br");
		loginPage.entrar();
	}
	
	
	public static void capturaTela(TestName testName) throws IOException{
		TakesScreenshot imagem = (TakesScreenshot) getDriver();
		File arquivo = imagem.getScreenshotAs( OutputType.FILE );
		FileUtils.copyFile(arquivo, new File("target/evidencias/" + testName.getMethodName() + ".jpg"));
	}
}