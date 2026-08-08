package edu.umg.programacion2.examen01;

import java.util.List;
import java.util.Scanner;

import edu.umg.programacion2.examen01.datos.DatosIniciales;
import edu.umg.programacion2.examen01.excepciones.PeliculaNoDisponibleException;
import edu.umg.programacion2.examen01.modelo.Pelicula;
import edu.umg.programacion2.examen01.repositorio.Videoclub;

/**
 * Menú del examen: carga el catálogo inicial y prueba las 3 preguntas
 * prácticas (más el reto opcional) desde consola. No necesitas modificar
 * este archivo.
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		Videoclub videoclub = new Videoclub();
		videoclub.cargarTodos(DatosIniciales.obtener());
		System.out.println("Catálogo cargado: " + videoclub.total() + " películas.");

		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			String opcion = teclado.nextLine().trim();

			switch (opcion) {
			case "1":
				listarTodos(videoclub);
				break;
			case "2":
				contarPorGenero(videoclub);
				break;
			case "3":
				buscarPorTitulo(videoclub, teclado);
				break;
			case "4":
				masAntiguaDeGenero(videoclub, teclado);
				break;
			case "5":
				alquilarPorCodigo(videoclub, teclado);
				break;
			case "6":
				alquilarPrimeraDisponible(videoclub, teclado);
				break;
			case "0":
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}

		teclado.close();
		System.out.println("Fin del examen.");
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("=== Examen Parcial 1 (Sección B) - Sistema de Videoclub ===");
		System.out.println("1) Listar todo el catálogo");
		System.out.println("2) Contar películas por género (Pregunta práctica 1)");
		System.out.println("3) Buscar por título parcial (Pregunta práctica 2)");
		System.out.println("4) Película más antigua de un género (Pregunta práctica 3)");
		System.out.println("5) Alquilar una película por código (ya resuelto, de referencia)");
		System.out.println("6) Alquilar la primera disponible de un género (Reto opcional)");
		System.out.println("0) Salir");
		System.out.print("Opción: ");
	}

	private static void listarTodos(Videoclub videoclub) {
		for (Pelicula pelicula : videoclub.listarTodos()) {
			System.out.println(pelicula);
		}
	}

	private static void contarPorGenero(Videoclub videoclub) {
		try {
			System.out.println(videoclub.contarPeliculasPorGenero());
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void buscarPorTitulo(Videoclub videoclub, Scanner teclado) {
		System.out.print("Texto a buscar en el título: ");
		String texto = teclado.nextLine().trim();
		try {
			List<Pelicula> resultado = videoclub.buscarPorTituloParcial(texto);
			if (resultado.isEmpty()) {
				System.out.println("Sin coincidencias.");
				return;
			}
			for (Pelicula pelicula : resultado) {
				System.out.println(pelicula);
			}
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void masAntiguaDeGenero(Videoclub videoclub, Scanner teclado) {
		System.out.print("Género (ej. Drama): ");
		String genero = teclado.nextLine().trim();
		try {
			Pelicula resultado = videoclub.peliculaMasAntiguaDeGenero(genero);
			System.out.println(resultado != null ? resultado : "No hay películas en ese género.");
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void alquilarPorCodigo(Videoclub videoclub, Scanner teclado) {
		System.out.print("Código a alquilar: ");
		String codigo = teclado.nextLine().trim();
		try {
			videoclub.alquilarPorCodigo(codigo);
			System.out.println("Alquiler realizado.");
		} catch (PeliculaNoDisponibleException ex) {
			System.out.println("No se pudo alquilar: " + ex.getMessage());
		}
	}

	private static void alquilarPrimeraDisponible(Videoclub videoclub, Scanner teclado) {
		System.out.print("Género (ej. Drama): ");
		String genero = teclado.nextLine().trim();
		try {
			Pelicula alquilada = videoclub.alquilarPrimeraDisponibleDeGenero(genero);
			System.out.println("Alquilada: " + alquilada);
		} catch (PeliculaNoDisponibleException ex) {
			System.out.println("No se pudo alquilar: " + ex.getMessage());
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}
}
