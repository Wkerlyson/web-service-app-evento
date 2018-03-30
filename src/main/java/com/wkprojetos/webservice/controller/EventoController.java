package com.wkprojetos.webservice.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wkprojetos.webservice.models.Evento;
import com.wkprojetos.webservice.repository.EventoRepository;


@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@GetMapping(path = "/listar", produces = "application/json")
	public @ResponseBody Iterable<Evento> listarEventos() {
		Iterable<Evento> listaEventos = er.findAll();
		return listaEventos;
	}
	
	@PostMapping(path = "/novo")
	public Evento salvarEvento(@RequestBody @Valid Evento evento) {
		return er.save(evento);
	}
	
	@DeleteMapping(path = "/remover")
	public Evento excluirEvento(@RequestBody Evento evento) {
		er.delete(evento);
		return evento;
	}
	
	@PutMapping(path = "/editar")
	public Evento editarEvento(@RequestBody Evento evento) {
		er.save(evento);
		return evento;
	}
}
