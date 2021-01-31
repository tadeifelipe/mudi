package com.tadeifelipe.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tadeifelipe.mudi.dto.RequisicaoNovoPedido;
import com.tadeifelipe.mudi.model.Pedido;
import com.tadeifelipe.mudi.repository.PedidoRepository;
import com.tadeifelipe.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
			
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		Pedido pedido = requisicao.toPedido();
		pedido.setUser(userRepository.findByUsername(username));
		pedidoRepository.save(pedido);	
		
		return "redirect:/home";
	}
	
}
