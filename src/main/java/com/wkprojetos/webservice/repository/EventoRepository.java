package com.wkprojetos.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wkprojetos.webservice.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
