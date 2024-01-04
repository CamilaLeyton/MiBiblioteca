package com.mibiblioteca.daos;

import com.mibiblioteca.models.Libro;
import com.mibiblioteca.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {
    public Libro findById(Long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Libro.class, 1l);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public List<Libro> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Libro> query = session.createQuery("FROM Libro", Libro.class);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void insert(Libro libro) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(libro);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void update(Libro libro) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(libro);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void delete(Libro libro) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(libro);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception ex) {
        ex.printStackTrace();
    }
}
