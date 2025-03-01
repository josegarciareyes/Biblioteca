/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Est01
 */
public class Biblioteca {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Eliminar Libro");
            System.out.println("3. Ver Todos los Libros");
            System.out.println("4. Buscar Libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    gestor.agregarLibro(new LibroConcreto(titulo, autor, isbn));
                    System.out.println("Libro agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    if (gestor.eliminarLibro(isbnEliminar)) {
                        System.out.println("Libro eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró un libro con ese ISBN.");
                    }
                    break;

                case 3:
                    System.out.println("Lista de libros:");
                    for (Libro libro : gestor.verTodosLosLibros()) {
                        System.out.println(libro);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el título o autor a buscar: ");
                    String termino = scanner.nextLine();
                    var resultados = gestor.buscarLibro(termino);
                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron libros que coincidan con la búsqueda.");
                    } else {
                        System.out.println("Resultados de búsqueda:");
                        for (Libro libro : resultados) {
                            System.out.println(libro);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

