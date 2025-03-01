/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;
import java.util.ArrayList;
/**
 *
 * @author Est01
 */
public class GestorBiblioteca {
    private ArrayList<Libro> biblioteca;

    // Constructor
    public GestorBiblioteca() {
        biblioteca = new ArrayList<>();
    }

    // Métodos para agregar, eliminar, ver y buscar libros
    public void agregarLibro(Libro libro) {
        biblioteca.add(libro);
    }

    public boolean eliminarLibro(String isbn) {
        return biblioteca.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    public ArrayList<Libro> verTodosLosLibros() {
        return biblioteca;
    }

    public ArrayList<Libro> buscarLibro(String terminoBusqueda) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().toLowerCase().contains(terminoBusqueda.toLowerCase()) ||
                libro.getAutor().toLowerCase().contains(terminoBusqueda.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }
}
