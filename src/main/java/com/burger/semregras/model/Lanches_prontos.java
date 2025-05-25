package com.burger.semregras.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "lanches_prontos")

public class Lanches_prontos {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;

	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min=3, max=10, message = "O atributo nome deve conter entre 3 e 10 caracteres")
	private String nome;
	
	@NotBlank(message = "O atributo descrição é obrigatório!")
	@Size(min=3, max=100, message= "O atributo descrição deve conter entre 3 a 100 caracteres")
	private String descricao;
	
	@NotNull
	@Column(precision = 8, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "categoria_id", nullable = false)
    private Categorias_lanches categorias_lanches;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categorias_lanches getCategorias_lanches() {
		return categorias_lanches;
	}

	public void setCategorias_lanches(Categorias_lanches categorias_lanches) {
		this.categorias_lanches = categorias_lanches;
	}	
	
}
