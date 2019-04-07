package steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import core.BasePage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.ContasPage;
import pages.LoginPage;

public class CadastroContasStep extends BasePage {
	
	private static LoginPage loginPage = new LoginPage();
	private static ContasPage contasPage = new ContasPage();

	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		loginPage.acessarPaginaInicial();
		
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String arg1) throws Throwable {
		loginPage.setEmail(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable {
		loginPage.setSenha(arg1);	
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		loginPage.entrar();
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {		
		Assert.assertEquals( contasPage.obterMensagemSucesso(), "Bem vindo, ProjetoBasico!");
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		clicaLink( By.linkText("Contas") );
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		clicaLink( By.linkText("Adicionar") );
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
		escreveCampo("nome", arg1);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		clicaBotao( By.xpath("//button[@class='btn btn-primary']") );
	}

	@Então("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
		Assert.assertEquals( contasPage.obterMensagemSucesso(), "Conta adicionada com sucesso!");
	}

	@Então("^sou notificar que o nome da conta é obrigatório$")
	public void souNotificarQueONomeDaContaÉObrigatório() throws Throwable {
		Assert.assertEquals( contasPage.obterMensagemErro(), "Informe o nome da conta");
	}

	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {		
		Assert.assertEquals( contasPage.obterMensagemErro(), "Já existe uma conta com esse nome!");
	}
	
	@Então("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String mensagem) throws Throwable {
		Assert.assertEquals( contasPage.obterMensagemGenerica(), mensagem);		
	}

}