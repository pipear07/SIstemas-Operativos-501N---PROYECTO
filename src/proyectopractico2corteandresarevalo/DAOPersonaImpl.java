/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopractico2corteandresarevalo;
import Interfaces.DAOPersona;
import java.sql.PreparedStatement;
/**
 *
 * @author Pipear07
 */
public class  DAOPersonaImpl extends Conectar implements DAOPersona{

    @Override
    public void registrar(Usuario per) throws Exception {
        try {
            getConexion();
                    PreparedStatement st = this.conexion.prepareStatement("INSERT INTO pruebas.usuarios(Nombre) VALUES(?)");
                    st.setString(1, per.getNombre());
                    st.executeUpdate();
                    st.execute(); 
        } catch (Exception e) {
            throw e;
        }finally{
        this.Desconectar();
        }
    }

    @Override
    public void  modificar(Usuario per) throws Exception {
    try {
            getConexion();
                    PreparedStatement st = this.conexion.prepareStatement("UPDATE pruebas.usuarios SET Nombre WHERE Idusuario= ?;");
                    st.setInt(1, per.getIdusuario());
                    st.executeUpdate();
                    st.execute();
        } catch (Exception e) {
            throw e;
        }finally{
        this.Desconectar();
        }
    }

    @Override
    public void actualizar(Usuario per) throws Exception {
  
    }
    
    @Override
    public void eliminar(Usuario per) throws Exception {
  
    }

    /*
    @Override
    public <any> listar() throws Exception {
 
    }
    */
}
