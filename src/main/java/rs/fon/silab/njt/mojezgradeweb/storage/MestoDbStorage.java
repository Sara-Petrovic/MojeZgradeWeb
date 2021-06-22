/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.storage;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;

/**
 *
 * @author Aleksandra Mišić
 */
public class MestoDbStorage {

    private static MestoDbStorage instance;

//    private Session session;
    public static MestoDbStorage getInstance() {
        if (instance == null) {
            instance = new MestoDbStorage();
        }
        return instance;
    }

    private MestoDbStorage() {

    }

//    public List<Mesto> getMesto() {
//        session = HibernateUtility.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Query query = session.createQuery("from Mesto");
//        List<Mesto> lista = query.list();
//        session.getTransaction().commit();
//        session.close();
//        return lista;
//    }
    public Mesto getMesto(Mesto mesto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("moje_zgrade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Mesto postoji = em.find(Mesto.class, mesto.getPtt());
            if (postoji == null) {
                return null;
            } else {
                return postoji;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

    public List<Mesto> getAllMesto() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("moje_zgrade");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Mesto> cq = cb.createQuery(Mesto.class);

        Root<Mesto> stud = cq.from(Mesto.class);

        cq.multiselect(stud.get("s_id"), stud.get("s_name"), stud.get("s_age"));
        CriteriaQuery<Mesto> select = cq.select(stud);
        TypedQuery<Mesto> q = em.createQuery(select);
        List<Mesto> list = q.getResultList();

        System.out.print("id");
        System.out.print("\t ptt");
        System.out.println("\t naziv");

        for (Mesto s : list) {
            System.out.print(s.getMestoId());
            System.out.print("\t" + s.getPtt());
            System.out.println("\t" + s.getNaziv());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
return list;
//        try {
//            Query q = em.createNamedQuery("mesto.findAll");
//            List<Mesto> res = q.getResultList();
//            return res;
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//            emf.close();
//        }
//        return null;
    }

}
