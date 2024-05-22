/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Pelicula {

    private int ID, publicacion;
    private String titulo, director;

    public Pelicula(int ID, String titulo, String director, int publicacion) {
        this.ID = ID;
        this.publicacion = publicacion;
        this.titulo = titulo;
        this.director = director;
    }

    public Pelicula(String titulo, String director, int publicacion) {
        this.publicacion = publicacion;
        this.titulo = titulo;
        this.director = director;
    }

    public Pelicula(int ID) {
        this.ID = ID;
        this.publicacion = 0;
        this.titulo = "";
        this.director = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "ID=" + ID + ", publicacion=" + publicacion + ", titulo=" + titulo + ", director=" + director + '}';
    }

}
