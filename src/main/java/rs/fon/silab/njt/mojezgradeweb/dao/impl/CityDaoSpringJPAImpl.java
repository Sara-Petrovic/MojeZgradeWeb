/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import rs.fon.silab.njt.mojezgradeweb.dao.Dao;
import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;

/**
 *
 * @author korisnik
 */
@Repository(value = "cityDaoSpringJPA")
public class CityDaoSpringJPAImpl implements Dao<Mesto>{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(Mesto city) throws Exception {
        System.out.println("Save city using SpringJPA...");
        entityManager.persist(city);
    }

    @Override
    public List<Mesto> getAll() throws Exception {
        return entityManager
                .createQuery("SELECT c FROM mesto c ORDER BY c.naziv", Mesto.class)
                .getResultList();
    }

    @Override
    public List<Mesto> get(Mesto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Mesto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Mesto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
