/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopractico2corteandresarevalo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Pipear07
 */
public class VerificaConexion {
     public static void main(String[] args) {
            Connection con= null;
            PreparedStatement stmt ;
	    ResultSet rs ;       
        
            
         
        try {
            con= Conectar.getInstance();    
               // La Query
	        stmt = con.prepareStatement("SELECT Nombre, Documento FROM Usuarios");
	        rs = stmt.executeQuery();
	   
	        // Recorremos el resultado
                //Encabezad de la tablas a mostrar
                System.out.println ("Nombre "+" Documento");
                //mientras el apuntador encuentre un elemento en el arreglo (resultset) haga
                //trae cada campo (nombre de la columna) de la consulta
	        while (rs.next())                  
	          System.out.println (rs.getString("Nombre")+"     "+rs.getString("Documento"));

	      } catch (SQLException sqle) { 
	           System.out.println("Error en la ejecuciÃ³n sqle:" 
	             + sqle.getErrorCode() + " " + sqle.getMessage());    
	      } catch (Exception e) { 
	           System.out.println("Error en la ejecuciÃ³n e:" 
	             +  " " + e.getMessage());    
	      }finally{
            
        }
              }
}
