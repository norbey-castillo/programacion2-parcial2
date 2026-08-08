package edu.umg.programacion2.examen01.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.umg.programacion2.examen01.excepciones.PeliculaNoDisponibleException;
import edu.umg.programacion2.examen01.modelo.Pelicula;

/**
 * Igual que RepositorioUsuarios/CatalogoProductos de clases anteriores: el
 * mismo catálogo de películas guardado en tres colecciones distintas, cada
 * una optimizada para una operación distinta.
 * <p>
 * - ArrayList&lt;Pelicula&gt;: catálogo completo, en orden de llegada.
 * - HashMap&lt;String, Pelicula&gt;: encontrar una película por código al
 * instante.
 * - HashSet&lt;String&gt;: saber qué géneros existen, sin repetidos.
 */
public class Videoclub {

	private final List<Pelicula> peliculas = new ArrayList<>();
	private final Map<String, Pelicula> peliculasPorCodigo = new HashMap<>();
	private final Set<String> generos = new HashSet<>();

	public void agregar(Pelicula pelicula) {
		peliculas.add(pelicula);
		peliculasPorCodigo.put(pelicula.getCodigo(), pelicula);
		generos.add(pelicula.getGenero());
	}

	public void cargarTodos(List<Pelicula> peliculasACargar) {
		for (Pelicula pelicula : peliculasACargar) {
			agregar(pelicula);
		}
	}

	public List<Pelicula> listarTodos() {
		return peliculas;
	}

	public Pelicula buscarPorCodigo(String codigo) {
		return peliculasPorCodigo.get(codigo);
	}

	public Set<String> listarGeneros() {
		return generos;
	}

	public int total() {
		return peliculas.size();
	}

	
}
