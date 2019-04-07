package runners;

import static core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import core.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import pages.HomePage;
import pages.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "steps", tags = {
		"@contas" }, plugin = "pretty", monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false, strict = false)
public class Contas extends BaseTest {

	@BeforeClass
	public static void resetar() {

		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();

		loginPage.acessarPaginaInicial();
		loginPage.setEmail("projeto@basico.com.br");
		loginPage.setSenha("projeto@basico.com.br");
		loginPage.entrar();

		homePage.clicaLink(By.linkText("reset"));
		killDriver();
	}
}