package com.burger.semregras.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "lanches_personalizados")

public class Lanches_personalizados {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull(message = "O usuário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;
	
	@NotNull(message = "Deve conter ao menos um ingrediente")
    @ManyToMany
    @JoinTable(
        name = "lanche_ingredientes",
        joinColumns = @JoinColumn(name = "lanche_id"),
        inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingredientes> ingredientes;
	
	@Schema(example = "2025-05-24T14:30:00")
    private LocalDateTime dataCriacao;

	@NotNull
	@Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal precoTotal;

    @PrePersist
    @PreUpdate
    public void calcularPrecoTotal() {
        this.precoTotal = ingredientes.stream()
            .map(Ingredientes::getPreco)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
		
}

