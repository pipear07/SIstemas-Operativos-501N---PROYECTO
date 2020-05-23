/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Razasvacas;

/**
 *
 * @author pipear07
 */
@Stateless
public class RazasvacasFacade extends AbstractFacade<Razasvacas> {

    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RazasvacasFacade() {
        super(Razasvacas.class);
    }
    
}
