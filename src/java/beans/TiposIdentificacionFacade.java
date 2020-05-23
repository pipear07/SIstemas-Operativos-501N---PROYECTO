/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.TiposIdentificacion;

/**
 *
 * @author pipear07
 */
@Stateless
public class TiposIdentificacionFacade extends AbstractFacade<TiposIdentificacion> {

    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposIdentificacionFacade() {
        super(TiposIdentificacion.class);
    }
    
}
