package com.mibiblioteca.daos;

import com.mibiblioteca.models.Autor;
import com.mibiblioteca.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {

    public Autor findById(Long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Autor.class, 1l);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public List<Autor> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Autor> query = session.createQuery("FROM Autor", Autor.class);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Autor findByNombre(String nombre){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Autor> query = session.createQuery("FROM Autor WHERE nombre = :nombre", Autor.class);
            query.setParameter("nombre", nombre);
            return query.uniqueResult();
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public void insert(Autor autor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(autor);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void update(Autor autor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(autor);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void delete(Autor autor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(autor);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception ex) {
        ex.printStackTrace();
    }
}
