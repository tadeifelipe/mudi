package com.tadeifelipe.mudi.dto;


import javax.validation.constraints.NotBlank;

import com.tadeifelipe.mudi.model.Pedido;
import com.tadeifelipe.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	@NotBlank(message = "Por favor, preencha o nome.")
	private String nomeProduto;
	
	@NotBlank(message = "Por favor, preencha a url.")
	private String urlProduto;
	
	@NotBlank(message = "Por favor, preencha a url da imagem.")
	private String urlImagem;
	
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setDescricao(descricao);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);	
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
}
