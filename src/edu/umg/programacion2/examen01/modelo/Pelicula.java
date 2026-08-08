package edu.umg.programacion2.examen01.modelo;

import edu.umg.programacion2.examen01.excepciones.PeliculaNoDisponibleException;

/**
 * Modelo con encapsulamiento (privado + getters), igual que Usuario y
 * Producto de las clases anteriores. Implementa Prestable: sabe alquilarse y
 * devolverse a sí misma, y avisa cuando no se puede alquilar lanzando una
 * excepción propia en vez de solo retornar false.
 */
public class Pelicula implements Prestable {

	private final String codigo;
	private final String titulo;
	private final String director;
	private final String genero;
	private final int anioEstreno;
	private boolean disponible;

	public Pelicula(String codigo, String titulo, String director, String genero, int anioEstreno) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.anioEstreno = anioEstreno;
		this.disponible = true; // 1. Toda película nueva entra disponible.
	}

	@Override
	public void alquilar() throws PeliculaNoDisponibleException {
		// IMPORTANTE: no basta con "devolver false" si ya está alquilada.
		// Lanzamos una excepción propia (checked) para obligar a quien llama
		// a decidir qué hacer, igual que con ApiUsuariosException en la Clase 3.
		if (!disponible) {
			throw new PeliculaNoDisponibleException("La película \"" + titulo + "\" ya está alquilada.");
		}
		disponible = false;
	}

	@Override
	public void devolver() {
		disponible = true;
	}

	@Override
	public boolean estaDisponible() {
		return disponible;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDirector() {
		return director;
	}

	public String getGenero() {
		return genero;
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	@Override
	public String toString() {
		String estado = disponible ? "disponible" : "alquilada";
		return String.format("[%s] %s (%d) - %s - %s - %s", codigo, titulo, anioEstreno, director, genero, estado);
	}
}
