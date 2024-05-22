/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pelicula;

/**
 *
 * @author Usuario
 */
public class ControladorPelicula {

    private ConexionMySQL con;

    public ControladorPelicula(ConexionMySQL con) {
        this.con = con;
    }

    public ArrayList<Pelicula> obtenerPeliculas() throws SQLException {
        ArrayList<Pelicula> arrayPaDevolver = new ArrayList<>();                    

        String consulta = "SELECT TITULO, DIRECTOR, PUBLICACION FROM PELICULAS";   
        ResultSet rst = con.ejecutarSelect(consulta);                               

        while (rst.next()) {                                                              

            String titulo = rst.getString("TITULO");                                        
            String director = rst.getString("DIRECTOR");                                
            int publicacion = rst.getInt("PUBLICACION");                       

            Pelicula p = new Pelicula(titulo, director, publicacion);                       
            arrayPaDevolver.add(p);                                                 
        }
        return arrayPaDevolver;                                                     
    }

    public ArrayList<Pelicula> peliculasAno(int ano) throws SQLException {

        ArrayList<Pelicula> arrayPaDevolver = new ArrayList<>();

        String consulta = "SELECT TITULO, DIRECTOR, PUBLICACION FROM PELICULAS WHERE PUBLICACION > " + ano;
        ResultSet rst = con.ejecutarSelect(consulta);

        while (rst.next()) {                                                        

            String titulo = rst.getString("TITULO");                                        
            String director = rst.getString("DIRECTOR");                                
            int publicacion = rst.getInt("PUBLICACION");                       

            Pelicula p = new Pelicula(titulo, director, publicacion);                      
            arrayPaDevolver.add(p);                                                
        }

        return arrayPaDevolver;
    }
    
    public ArrayList<Pelicula> obtenerID() throws SQLException {

        ArrayList<Pelicula> arrayPaDevolver = new ArrayList<>();

        String consulta = "SELECT ID FROM PELICULAS";
        ResultSet rst = con.ejecutarSelect(consulta);

        while (rst.next()) {                                                      
                                
            int ID = rst.getInt("ID");                      

            Pelicula p = new Pelicula(ID);                       
            arrayPaDevolver.add(p);                                                
        }

        return arrayPaDevolver;
    }
}
