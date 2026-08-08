package edu.umg.programacion2.examen01.datos;

import java.util.ArrayList;
import java.util.List;

import edu.umg.programacion2.examen01.modelo.Pelicula;

/**
 * Catálogo de arranque, para no depender de ningún API externo durante el
 * examen (a diferencia de la Clase 3, aquí no hace falta internet).
 */
public class DatosIniciales {

	public static List<Pelicula> obtener() {
		List<Pelicula> peliculas = new ArrayList<>();
		peliculas.add(new Pelicula("V-1", "El padrino", "Francis Ford Coppola", "Drama", 1972));
		peliculas.add(new Pelicula("V-2", "Pinocho", "Ben Sharpsteen", "Animación", 1940));
		peliculas.add(new Pelicula("V-3", "Casablanca", "Michael Curtiz", "Drama", 1942));
		peliculas.add(new Pelicula("V-4", "Metropolis", "Fritz Lang", "Ciencia ficción", 1927));
		peliculas.add(new Pelicula("V-5", "2001: Odisea del espacio", "Stanley Kubrick", "Ciencia ficción", 1968));
		peliculas.add(new Pelicula("V-6", "Ciudadano Kane", "Orson Welles", "Drama", 1941));
		peliculas.add(new Pelicula("V-7", "El rey león", "Rob Minkoff", "Animación", 1994));
		peliculas.add(new Pelicula("V-8", "Blade Runner", "Ridley Scott", "Ciencia ficción", 1982));
		return peliculas;
	}
}
