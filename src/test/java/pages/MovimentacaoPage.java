package pages;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void selecionaTipoMovimentacao(String valor){
		selecionaCombo("tipo", valor);		
	}
	
	public void setDataMovimentacao(String dataMovimentacao){
		escreveCampo("data_transacao", dataMovimentacao);		
	}

	public void setDataPagamento(String dataPagamento){
		escreveCampo("data_pagamento", dataPagamento);		
	}
	
	public void setDescricao(String descricao){
		escreveCampo("descricao", descricao);		
	}
	
	public void setInteressado(String interessado){
		escreveCampo("interessado", interessado);		
	}
	
	public void setValor(String valor){
		escreveCampo("valor", valor);		
	}
	
	public void selecionaConta(String valor){
		selecionaCombo("conta", valor);
	}
	
	public void selecionaSituacaoPago(){
		clicarRadio("status_pago");
	}
	
	public void selecionaSituacaoPendente(){
		clicarRadio("status_pendente");
	}
	
	public void salva(){
		clicaBotao( By.xpath("//button[@class='btn btn-primary']") );
	}
	
	public String obterMensagemSucesso(){
		return obtemValorTexto(By.xpath(".//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro(){
		return obtemValorTexto(By.xpath(".//div[@class='alert alert-danger']"));
	}
	
	public List<String> obtemErrosCampoEmBranco(){
		
		List<WebElement> erros = getDriver().findElements( By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> lista = new ArrayList<String>();
		
		for (WebElement listando : erros) {
			lista.add( listando.getText() );
		}
		
		return lista;		
	}
}