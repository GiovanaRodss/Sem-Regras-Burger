package com.burger.semregras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.semregras.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{}
