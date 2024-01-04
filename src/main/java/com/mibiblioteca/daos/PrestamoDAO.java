package com.mibiblioteca.daos;

import com.mibiblioteca.models.Prestamo;
import com.mibiblioteca.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PrestamoDAO {
    public Prestamo findById(Long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Prestamo.class, 1l);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

        public List<Prestamo> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Prestamo> query = session.createQuery("FROM Prestamo",Prestamo.class);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Prestamo> findByDevuelto(boolean devuelto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Prestamo> query = session.createQuery("FROM Prestamo WHERE devuelto = :devuelto", Prestamo.class);
            query.setParameter("devuelto", devuelto);
            return query.list();
        } catch (Exception ex) {
            handleException(ex);
            return null;
        }
    }

    public void insert(Prestamo prestamo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(prestamo);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void update(Prestamo prestamo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(prestamo);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void delete(Prestamo prestamo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(prestamo);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception ex) {
        ex.printStackTrace();
    }
}
