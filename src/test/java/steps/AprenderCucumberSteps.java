package steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import utils.DateConverter;
import cucumber.api.java.pt.Então;

public class AprenderCucumberSteps {

	@Dado("^que criei  arquivo corretamente$")
	public void queCrieiArquivoCorretamente() throws Throwable {

	}

	@Quando("^executa-lo$")
	public void executaLo() throws Throwable {

	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {

	}

	/* ______________________________________ */

	private int contador = 0;

	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
		System.out.println("Contador é: " + contador);
	}

	@Quando("^incrementar o valor em (\\d+)$")
	public void incrementarOValorEm(int arg1) throws Throwable {
		contador += arg1;
		System.out.println("É incrementado em: " + arg1);
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);
	}

	/* ______________________________________ */

	Date entrega = new Date();

	@Dado("^que a entrega é  dia (.*)$")
	public void que_a_entrega_é_dia(@Transform(DateConverter.class) Date data) throws Throwable {
		
		entrega = data;
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mês|meses)$")
	public void a_entrega_atrasar_em(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);

		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);

		} else if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, arg1);

		}
		entrega = cal.getTime();
	}

	@Então("^a entrega deverá ser efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void a_entrega_deverá_ser_efetuada_em(String data) throws Throwable {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}

	/* ______________________________________ */
 
	
	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
	
	}
	
	@Dado("^que o valor da passagem é R\\$ (\\d{1,4},\\d{2})$")
	public void queOValorDaPassagemÉR$(double valorReais) throws Throwable {
		System.out.println(valorReais);
	}
	
	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void queONomeDoPassageiroÉ(String nomePAssageiro) throws Throwable {

	}
	
	@Dado("^que o telefone do passageiro é 9(\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {

	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {

	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {

	}
}