package edu.umg.programacion2.examen01.modelo;

import edu.umg.programacion2.examen01.excepciones.PeliculaNoDisponibleException;

/**
 * Cualquier ítem que se pueda alquilar y devolver debe implementar esta
 * interface. Mismo patrón que Pagable/Bonificable de clases anteriores: el
 * resto del programa trabaja contra el contrato, sin importar el tipo real.
 */
public interface Prestable {

	void alquilar() throws PeliculaNoDisponibleException;

	void devolver();

	boolean estaDisponible();
}
