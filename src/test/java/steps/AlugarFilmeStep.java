package steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import entidades.Filme;
import entidades.Nota;
import entidades.TipoAluguel;
import servicos.ServicoAluguel;
import utils.DataUtils;

public class AlugarFilmeStep {

	private Filme filme = new Filme();
	private ServicoAluguel servico = new ServicoAluguel();
	private Nota minhaNota = new Nota();
	private String retornoAlugar;
	private TipoAluguel tipoAluguel;

	@Dado("^um filme$")
	public void umFilme(DataTable tabela) {
		Map<String, String> map = tabela.asMap(String.class, String.class);

		filme.setQuantidadeFilme(Integer.parseInt(map.get("estoque")));
		filme.setValorAluguel(Integer.parseInt(map.get("preco")));
		String tipo = map.get("tipo");

		if (tipo.equals("comum"))
			tipoAluguel = TipoAluguel.COMUM;
		else if (tipo.equals("extendido"))
			tipoAluguel = TipoAluguel.EXTENDIDO;
		else
			tipoAluguel = TipoAluguel.SEMANAL;
	}

	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int unidades) {
		filme.setQuantidadeFilme(unidades);
	}

	@Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
	public void queOPrecoDoAluguelSejaR$(int valorAluguel) {
		filme.setValorAluguel(valorAluguel);
	}

	@Quando("^alugar$")
	public void alugar() {
		try {
			minhaNota = servico.alugar(filme, tipoAluguel);

		} catch (Exception e) {
			retornoAlugar = e.getMessage();
		}
	}

	@Então("^o preço do aluguel será de R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráDeR$(int preco) {
		Assert.assertEquals(preco, minhaNota.getValorAluguel());
		System.out.println("Valor aluguel: " + minhaNota.getValorAluguel());

	}

	@Então("^o estoque do filme será de (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráDeUnidade(int estoque) {
		Assert.assertEquals(estoque, filme.getQuantidadeFilme());

		System.out.println("Estoque do filme: " + filme.getQuantidadeFilme());
	}

	@Então("^não será possivel por falta de estoque$")
	public void nãoSeráPossivelPorFaltaDeEstoque() {
		Assert.assertEquals("Não há unidades disponíveis para locação!", retornoAlugar);
		System.out.println(retornoAlugar);
	}

	@Dado("^que o tipo de aluguel seja (.*)$")
	public void queOTipoDeAluguelSejaExtendido(String aluguel) {
		if (aluguel.equals("comum"))
			tipoAluguel = TipoAluguel.COMUM;
		else if (aluguel.equals("extendido"))
			tipoAluguel = TipoAluguel.EXTENDIDO;
		else
			tipoAluguel = TipoAluguel.SEMANAL;
	}

	@Então("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int dias) {
		Date dataEsperada = DataUtils.obterDataComDiasAdiantado(dias);
		Date dataReal = minhaNota.getDataEntrega();

		System.out.println("dataEsperada: " + dataEsperada);
		System.out.println("dataReal: " + dataReal);

		DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		Assert.assertEquals(formatar.format(dataEsperada), formatar.format(dataReal));
	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int pontuacao) {
		Assert.assertEquals(pontuacao, minhaNota.getPontuacao());
	}
}