/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Calendar;      
import java.util.TimeZone;
import java.sql.Connection;     
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class ConexionMySQL {
    
    private String BD;                 
    
    private String USUARIO;             
    
    private String PASS;                
    
    private Connection connection;     
    
    private String HOST;                
    
    private TimeZone zonahoraria;      
    
    public ConexionMySQL(String bd) {   
        HOST = "localhost";
        USUARIO = "root";
        PASS = "";
        BD = bd;
        connection = null;
    }
    
    private void registrarDriver() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al conectar con MySQL: " + e.getMessage());
        }
    }
    
    public void conectar() throws SQLException {                
        if (connection == null || connection.isClosed()) {      
            registrarDriver();                                  
            Calendar now = Calendar.getInstance();              
            zonahoraria = now.getTimeZone();                    
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BD + "?user="      
                    + USUARIO + "&password=" + PASS + "&useLegacyDatetimeCode=false&serverTimezone="                
                    + zonahoraria.getID());
        }
    }
    
    public void desconectar() throws SQLException {              
        if (connection != null && !connection.isClosed()) {     
            connection.close();
        }
    }
    
    public ResultSet ejecutarSelect(String consulta) throws SQLException {      
        Statement stmt = connection.createStatement();                          
        ResultSet rset = stmt.executeQuery(consulta);                           

        return rset;
    }
    
    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {    
        Statement stmt = connection.createStatement();                              
        int fila = stmt.executeUpdate(consulta);                                    

        return fila;
    }
    
}
