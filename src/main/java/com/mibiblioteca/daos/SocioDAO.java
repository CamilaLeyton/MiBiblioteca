package com.mibiblioteca.daos;

import com.mibiblioteca.models.Prestamo;
import com.mibiblioteca.models.Socio;
import com.mibiblioteca.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class SocioDAO {

    public Socio findById(Long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Socio.class, 1l);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public List<Socio> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Socio> query = session.createQuery("FROM Socio", Socio.class);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public List<Socio> findByNombre(String nombre){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (List<Socio>) session.createQuery("FROM Socio WHERE nombre='"+nombre+"'").list();
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Socio> findByApellido(String apellido){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (List<Socio>) session.createQuery("FROM Socio WHERE apellido='"+apellido+"'").list();
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static void addPrestamoToSocio(Long socioId, Prestamo prestamo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Obtener el socio
            Socio socio = session.get(Socio.class, socioId);
            if (socio != null) {
                // Verificar si la lista de préstamos es null y crearla si es necesario
                List<Prestamo> prestamos = socio.getPrestamos();
                if (prestamos == null) {
                    prestamos = new ArrayList<>();
                }

                // Añadir el nuevo préstamo a la lista
                prestamos.add(prestamo);

                // Actualizar la lista de préstamos del socio
                socio.setPrestamos(prestamos);

                // Actualizar el socio en lugar de usar persist
                session.update(socio);

                transaction.commit();
            } else {
                // Manejar el caso en el que no se encuentra el socio
                System.out.println("No se encontró un socio con el ID proporcionado.");
            }
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }



    public void insert(Socio socio) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(socio);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void update(Socio socio) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(socio);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    public void delete(Socio socio) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(socio);
            transaction.commit();
        } catch (Exception ex) {
            handleException(ex);
        }
    }

    private void handleException(Exception ex) {
        // Aquí podrías hacer algo más útil, como lanzar una excepción personalizada o registrar el error.
        ex.printStackTrace();
    }
}


