package servicos;

import entidades.Filme;
import entidades.Nota;
import entidades.TipoAluguel;
import utils.DataUtils;

public class ServicoAluguel {

	public Nota alugar(Filme meuFilme, TipoAluguel tipoAluguel) {

		if (meuFilme.getQuantidadeFilme() == 0) {
			throw new RuntimeException("Não há unidades disponíveis para locação!");
		}

		Nota minhaNota = new Nota();

		switch (tipoAluguel) {
		case COMUM:
			minhaNota.setValorAluguel(meuFilme.getValorAluguel());
			minhaNota.setDataEntrega(DataUtils.obterDataComDiasAdiantado(1));
			minhaNota.setPontuacao(1);
			break;

		case EXTENDIDO:
			minhaNota.setValorAluguel(meuFilme.getValorAluguel() * 2);
			minhaNota.setDataEntrega(DataUtils.obterDataComDiasAdiantado(3));
			minhaNota.setPontuacao(2);
			break;
		
		case SEMANAL:
			minhaNota.setValorAluguel(meuFilme.getValorAluguel() * 3);
			minhaNota.setDataEntrega(DataUtils.obterDataComDiasAdiantado(7));
			minhaNota.setPontuacao(3);
			break;

		default:
			System.out.println("Tipo de aluguel não existe!");
			break;
		}

		meuFilme.setQuantidadeFilme(meuFilme.getQuantidadeFilme() - 1);

		return minhaNota;
	}
}