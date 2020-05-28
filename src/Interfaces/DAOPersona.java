/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.awt.List;
import java.util.*;
import java.util.AbstractCollection.*;

/**
 *
 * @author Pipear07
 */
import proyectopractico2corteandresarevalo.Usuario;
public interface DAOPersona {
    
      public void registrar(Usuario per) throws Exception;
      public void modificar(Usuario per) throws Exception;
      public void actualizar(Usuario per) throws Exception;
      public void eliminar(Usuario per) throws Exception;
    //  public List<Usuario> listar() throws Exception;
    
}
