package com.burger.semregras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.semregras.model.Pedido_item;

public interface PedidoItemRepository extends JpaRepository<Pedido_item, Long>{}
