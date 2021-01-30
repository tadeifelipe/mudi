package com.tadeifelipe.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tadeifelipe.mudi.model.Pedido;
import com.tadeifelipe.mudi.repository.PedidoRepository;

@Controller
public class HomeControlller {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
