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

	/**
	 * Ya resuelto: sirve de referencia para las 3 preguntas prácticas de
	 * abajo. Alquila una película por código. Si no existe o ya está
	 * alquilada, propaga la excepción para que quien llame decida qué
	 * mostrar.
	 */
	public void alquilarPorCodigo(String codigo) throws PeliculaNoDisponibleException {
		Pelicula pelicula = buscarPorCodigo(codigo);
		if (pelicula == null) {
			throw new PeliculaNoDisponibleException("No existe ninguna película con código " + codigo);
		}
		pelicula.alquilar();
	}

	
	public Map<String, Integer> contarPeliculasPorGenero() {
	    Map<String, Integer> conteo = new HashMap<>();

	    for (Pelicula pelicula : peliculas) {
	        String genero = pelicula.getGenero();

	        int cantidadActual = conteo.getOrDefault(genero, 0);

	        conteo.put(genero, cantidadActual + 1);
	    }

	    return conteo;
	}

	
	
	public List<Pelicula> buscarPorTituloParcial(String texto) {
	    List<Pelicula> resultados = new ArrayList<>();

	    for (Pelicula pelicula : peliculas) {
	        if (pelicula.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
	            resultados.add(pelicula);
	        }
	    }

	    return resultados;
	}

	
	
	public Pelicula peliculaMasAntiguaDeGenero(String genero) {
	    Pelicula masAntigua = null;

	    for (Pelicula pelicula : peliculas) {
	        if (pelicula.getGenero().equals(genero)) {

	            if (masAntigua == null ||
	                pelicula.getAnioEstreno() < masAntigua.getAnioEstreno()) {

	                masAntigua = pelicula;
	            }
	        }
	    }

	    return masAntigua;
	}
	

	/* EJERCICIO OPCIONAL */
	
	
	public Pelicula alquilarPrimeraDisponibleDeGenero(String genero)
        throws PeliculaNoDisponibleException {

    for (Pelicula pelicula : peliculas) {

        if (pelicula.getGenero().equals(genero)
                && pelicula.estaDisponible()) {

            pelicula.alquilar();

            return pelicula;
        }
    }

    throw new PeliculaNoDisponibleException(
            "No hay películas disponibles del género " + genero
    );
}
}
