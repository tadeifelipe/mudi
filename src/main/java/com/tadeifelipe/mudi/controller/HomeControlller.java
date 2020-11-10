package com.tadeifelipe.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tadeifelipe.mudi.model.Pedido;

@Controller
public class HomeControlller {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 9");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61VmUpCs7PL._AC_SL1000_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Xiaomi-Redmi-Note-128GB-4GB/dp/B088HJ3FCX?ref_=Oct_s9_apbd_otopr_hd_bw_bHjJLCl&pf_rd_r=E6MXP06N8J39J3JYSFQD&pf_rd_p=1da659a0-948a-52ba-a216-243433981446&pf_rd_s=merchandised-search-11&pf_rd_t=BROWSE&pf_rd_i=16243803011");
		pedido.setDescricao("uma descrição qualquer");
		
		List<Pedido> pedidos = Arrays.asList(pedido,pedido,pedido);
		model.addAttribute("pedidos",pedidos);
		
		
		return "home";
	}
}
