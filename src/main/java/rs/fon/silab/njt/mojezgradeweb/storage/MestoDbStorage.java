/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.storage;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;

/**
 *
 * @author Aleksandra Mišić
 */
public class MestoDbStorage {

    private static MestoDbStorage instance;

    private Session session;

    public static MestoDbStorage getInstance() {
        if (instance == null) {
            instance = new MestoDbStorage();
        }
        return instance;
    }

    private MestoDbStorage() {

    }

    public List<Mesto> getMesto() {
        session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Mesto");
        List<Mesto> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

}
