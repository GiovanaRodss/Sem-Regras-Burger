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
@Table(name = "ingredientes")

public class Ingredientes {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;

	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min=3, max=20, message = "O atributo nome deve conter entre 3 e 20 caracteres")
	private String nome;
	
	@NotNull
	@Column(precision = 8, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "categoria_id", nullable = false)
    private Categorias_ingredientes categorias_ingredientes;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categorias_ingredientes getCategorias_ingredientes() {
		return categorias_ingredientes;
	}

	public void setCategorias_ingredientes(Categorias_ingredientes categorias_ingredientes) {
		this.categorias_ingredientes = categorias_ingredientes;
	}
	
}
