package com.sistema.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.models.Publicacion;
import com.sistema.blog.repositories.PublicacionRepositorio;

@Service
public class PublicacionServicioImpl implements PublicacionServicio {

	@Autowired
	private PublicacionRepositorio publicacionRepositorio;

	@Override
	public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {
		// Convertir el DTO a una entidad
		Publicacion publicacion = new Publicacion();
		publicacion.setTitulo(publicacionDTO.getTitulo());
		publicacion.setDescripcion(publicacionDTO.getDescripcion());
		publicacion.setContenido(publicacionDTO.getContenido());
		Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);

		// Covertir de entidad a DTO
		PublicacionDTO publicacionRespuesta = new PublicacionDTO();
		publicacionRespuesta.setId(nuevaPublicacion.getId());
		publicacionRespuesta.setTitulo(nuevaPublicacion.getTitulo());
		publicacionRespuesta.setDescripcion(nuevaPublicacion.getDescripcion());
		publicacionRespuesta.setContenido(nuevaPublicacion.getContenido());
		return publicacionRespuesta;
	}

}
