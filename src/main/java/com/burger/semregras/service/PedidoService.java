package com.burger.semregras.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.semregras.model.Pedido;
import com.burger.semregras.model.Pedido_item;
import com.burger.semregras.model.StatusPedido;
import com.burger.semregras.repository.PedidoRepository;

@Service
public class PedidoService {


	    @Autowired
	    private PedidoRepository pedidoRepository;

	    public Pedido salvarPedido(Pedido pedido) {
	        for (Pedido_item item : pedido.getItens()) {
	            if ((item.getLanchePronto() == null && item.getLanchePersonalizado() == null) ||
	                (item.getLanchePronto() != null && item.getLanchePersonalizado() != null)) {
	                throw new IllegalArgumentException("Cada item deve conter apenas um tipo de lanche.");
	            }
	            item.setPedido(pedido); 
	        }

	
	        BigDecimal precoTotal = pedido.getItens().stream()
	            .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
	            .reduce(BigDecimal.ZERO, BigDecimal::add);

	        pedido.setPrecoTotal(precoTotal);
	        pedido.setStatus(StatusPedido.PENDENTE);

	        return pedidoRepository.save(pedido);
	    }
	    
	    public List<Pedido> listarTodos() {
	        return pedidoRepository.findAll();
	    }

	}
