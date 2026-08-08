package edu.umg.programacion2.examen01.excepciones;

/**
 * Excepción propia (checked), mismo patrón que ApiUsuariosException de la
 * Clase 3: se lanza cuando algo impide alquilar una película (ya está
 * alquilada, o no existe). Quien llama a alquilar() está obligado a
 * manejarla.
 */
public class PeliculaNoDisponibleException extends Exception {

	public PeliculaNoDisponibleException(String mensaje) {
		super(mensaje);
	}
}
