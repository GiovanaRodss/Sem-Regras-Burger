package com.burger.semregras.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity

public class Pedido_item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
    private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	 
	@ManyToOne
    @JoinColumn(name = "lanche_pronto_id")
    private Lanches_prontos lanchePronto;
	 
	@ManyToOne
    @JoinColumn(name = "lanche_personalizado_id")
    private Lanches_personalizados lanchePersonalizado;
	 
	@NotNull
	 private BigDecimal precoUnitario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Lanches_prontos getLanchePronto() {
		return lanchePronto;
	}

	public void setLanchePronto(Lanches_prontos lanchePronto) {
		this.lanchePronto = lanchePronto;
	}

	public Lanches_personalizados getLanchePersonalizado() {
		return lanchePersonalizado;
	}

	public void setLanchePersonalizado(Lanches_personalizados lanchePersonalizado) {
		this.lanchePersonalizado = lanchePersonalizado;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}

