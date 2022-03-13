package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
	 Cliente cliente = catalogoClienteService.bucar(entrega.getCliente().getId());		
		
	 	 entrega.setCliente(cliente);
		 entrega.setStatus(StatusEntrega.PEDENTE);	
		 entrega.setDataPedido(LocalDateTime.now());
		 
		return entregaRepository.save(entrega);	
	}

}
