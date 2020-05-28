/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopractico2corteandresarevalo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Pipear07
 */
public class Conectar {
    protected static Connection conexion = null;

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        Conectar.conexion = conexion;
    }

    public static void conectar() {
        try {
				
// DRIVER para MariaDB  "org.mariadb.jdbc.Driver";
//DriverManager.getConnection("jdbc:mariadb://localhost:3306/Pruebas", "root", "");		
			
			// driver para mysql
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
			//la base de datos se llama escuela
			//El puerto del servidor es 3306
			//El usuario  de conexion a la bd es root
			//Y no tiene password
                        //"%programfiles(x86)%\Microsoft SQL Server\140\Shared\sqlmgmproviderxpsp2up.mof"
                        //prsento muchos inconvenientes con sql pero por fin se logro
                        
            conexion = DriverManager.getConnection("jdbc:sqlserver://PC-PIPEARMO07:1433;databaseName=Pruebas;integratedSecurity=true;"); 
        } catch (SQLException e) {  
          System.out.println("Error de MySQL: " + e.getMessage()); 
        }  catch (Exception e) {
          System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public Conectar() {
        
    }

    public static Connection getInstance() {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
    
    //Le añadi la desconexion
    
    public void Desconectar () throws SQLException{
    
        if(conexion != null){
        if(!conexion.isClosed()){
        conexion.close();
        }   
        }
        
        
    }
    
}
