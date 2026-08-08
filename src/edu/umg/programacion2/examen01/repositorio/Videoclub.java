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

	/**
	 * PREGUNTA PRÁCTICA 1 (20 pts): completar contarPeliculasPorGenero().
	 * <p>
	 * Enunciado: recorrer el catálogo y devolver un Map donde la clave es el
	 * género y el valor es cuántas películas hay de ese género.
	 * <p>
	 * Entrada de ejemplo: [El padrino-Drama, Pinocho-Animación,
	 * Casablanca-Drama].
	 * Salida esperada: {Drama=2, Animación=1} (el orden puede variar, HashMap
	 * no garantiza orden).
	 * <p>
	 * Pista: recorre peliculas con un for-each. Para cada película, usa
	 * conteo.getOrDefault(genero, 0) para saber el valor actual (0 si es la
	 * primera vez que aparece ese género) y guarda ese valor + 1 con put().
	 * <p>
	 * Criterios de evaluación:
	 * - No usa streams ni lambdas, solo un for-each y el Map.
	 * - Usa Map.getOrDefault(), no un HashSet auxiliar ni containsKey().
	 * - Si el catálogo está vacío, retorna un Map vacío (no null).
	 */
	public Map<String, Integer> contarPeliculasPorGenero() {
		// TODO: reemplazar esta línea por la lógica descrita arriba.
		throw new UnsupportedOperationException("TODO: completar contarPeliculasPorGenero() en Videoclub");
	}

	/**
	 * PREGUNTA PRÁCTICA 2 (20 pts): completar buscarPorTituloParcial().
	 * <p>
	 * Enunciado: recorrer el catálogo y devolver solo las películas cuyo
	 * título contenga el texto buscado, sin importar mayúsculas o
	 * minúsculas.
	 * <p>
	 * Entrada de ejemplo: "El padrino", "El rey león", "Casablanca";
	 * buscarPorTituloParcial("rey").
	 * Salida esperada: una lista con "El rey león" (contiene "rey", ignorando
	 * mayúsculas/minúsculas).
	 * <p>
	 * Pista: usa pelicula.getTitulo().toLowerCase().contains(texto.toLowerCase())
	 * dentro de un for-each, y agrega las coincidencias a una lista nueva.
	 * <p>
	 * Criterios de evaluación:
	 * - No modifica la lista original (peliculas).
	 * - La búsqueda ignora mayúsculas/minúsculas.
	 * - Si no hay coincidencias, retorna una lista vacía (no null).
	 */
	public List<Pelicula> buscarPorTituloParcial(String texto) {
		// TODO: reemplazar esta línea por la lógica descrita arriba.
		throw new UnsupportedOperationException("TODO: completar buscarPorTituloParcial() en Videoclub");
	}

	/**
	 * PREGUNTA PRÁCTICA 3 (20 pts): completar peliculaMasAntiguaDeGenero().
	 * <p>
	 * Enunciado: dado el nombre de un género, encontrar la película con MENOR
	 * año de estreno (la más antigua) dentro de ese género. Si el género no
	 * tiene ninguna película, retornar null.
	 * <p>
	 * Entrada de ejemplo: peliculaMasAntiguaDeGenero("Drama") con el catálogo
	 * de DatosIniciales.
	 * Salida esperada: la película de género Drama con menor año.
	 * <p>
	 * Pista: primero filtra las películas de ese género con un for-each
	 * (misma idea que buscarPorTituloParcial, pero comparando género con
	 * equals() en vez de usar contains()). Con esa lista más corta, recorre
	 * guardando en una variable la película "más antigua vista hasta ahora" y
	 * compara año contra año.
	 * <p>
	 * Criterios de evaluación:
	 * - Recorrido manual: no usa Collections.sort() ni Comparator.
	 * - Compara géneros con equals(), nunca con ==.
	 * - Compara años con &lt;, nunca con ==.
	 * - Si el género no existe o no tiene películas, retorna null, no lanza
	 *   excepción.
	 */
	public Pelicula peliculaMasAntiguaDeGenero(String genero) {
		// TODO: reemplazar esta línea por la lógica descrita arriba.
		throw new UnsupportedOperationException("TODO: completar peliculaMasAntiguaDeGenero() en Videoclub");
	}

	/**
	 * RETO OPCIONAL (10 pts extra): completar alquilarPrimeraDisponibleDeGenero().
	 * <p>
	 * Enunciado: dado el nombre de un género, alquilar la PRIMERA película
	 * disponible que se encuentre de ese género (recorriendo en el orden del
	 * catálogo) y retornarla. Si no hay ninguna disponible en ese género,
	 * lanzar PeliculaNoDisponibleException con un mensaje claro.
	 * <p>
	 * Pista: reutiliza pelicula.alquilar() (ya lanza la excepción si ESA
	 * película puntual está alquilada), pero aquí el punto es encontrar una
	 * que SÍ esté disponible antes de intentar alquilarla (usa
	 * estaDisponible()).
	 * <p>
	 * Criterios de evaluación:
	 * - Compara género con equals().
	 * - Usa estaDisponible() antes de llamar alquilar().
	 * - Si ninguna está disponible en ese género, lanza la excepción (no
	 *   retorna null).
	 */
	public Pelicula alquilarPrimeraDisponibleDeGenero(String genero) throws PeliculaNoDisponibleException {
		// TODO (opcional): reemplazar esta línea por la lógica descrita arriba.
		throw new UnsupportedOperationException(
				"TODO opcional: completar alquilarPrimeraDisponibleDeGenero() en Videoclub");
	}
}
