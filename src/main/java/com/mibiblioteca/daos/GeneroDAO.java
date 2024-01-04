package com.mibiblioteca.daos;

import com.mibiblioteca.models.Genero;
import com.mibiblioteca.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GeneroDAO {
    public Genero findById(Long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Genero.class, 1l);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Genero> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Genero> query = session.createQuery("FROM Genero", Genero.class);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void insert(Genero genero) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(genero);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void update(Genero genero) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(genero);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void delete(Genero genero) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(genero);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception ex) {
        ex.printStackTrace();
    }
}
