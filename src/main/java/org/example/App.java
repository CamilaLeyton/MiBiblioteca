package org.example;

import com.mibiblioteca.daos.*;
import com.mibiblioteca.models.*;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        AutorDAO autorDAO = new AutorDAO();

        //Crea un nuevo autor
        Autor newAutor1 = new Autor("William", "Shakespeare", "Inglaterra");
        Autor newAutor2 = new Autor("Gabriel", "Garcia Marquez", "Colombia");
        Autor newAutor3 = new Autor("J.K", "Rowling", "Inglaterra");
        Autor newAutor4 = new Autor("Isabel", "Allende", "Chile");
        Autor newAutor5 = new Autor("Howard", "Lovecraft", "Estados Unidos");


        //Inserta el nuevo actor en la base de datos
        autorDAO.insert(newAutor1);
        autorDAO.insert(newAutor2);
        autorDAO.insert(newAutor3);
        autorDAO.insert(newAutor4);
        autorDAO.insert(newAutor5);


        ///////////////////////////////////////////////////////////////////////////
        LibroDAO libroDAO = new LibroDAO();

        Libro newLibro1 = new Libro("Cien años de soledad", 1967);
        newLibro1.setAutor(newAutor2);
        Libro newLibro2 = new Libro("En las montañas de la locura", 1931);
        newLibro2.setAutor(newAutor5);
        Libro newLibro3 = new Libro("Macbeth", 1623);
        newLibro3.setAutor(newAutor1);
        Libro newLibro4 = new Libro("La casa de los espíritus", 1982);
        newLibro4.setAutor(newAutor4);
        Libro newLibro5 = new Libro("Romeo y Julieta", 1597);
        newLibro5.setAutor(newAutor1);
        Libro newLibro6 = new Libro("Eva Luna", 1987);
        newLibro6.setAutor(newAutor4);
        Libro newLibro7 = new Libro("Harry Potter y la cámara secreta", 1998);
        newLibro7.setAutor(newAutor3);
        Libro newLibro8 = new Libro("Harry Potter y la piedra filosofal", 1997);
        newLibro8.setAutor(newAutor3);
        Libro newLibro9 = new Libro("El llamado de Cthulhu", 1928);
        newLibro9.setAutor(newAutor5);
        Libro newLibro10 = new Libro("Hamlet", 1609);
        newLibro10.setAutor(newAutor1);


        libroDAO.insert(newLibro1);
        libroDAO.insert(newLibro2);
        libroDAO.insert(newLibro3);
        libroDAO.insert(newLibro4);
        libroDAO.insert(newLibro5);
        libroDAO.insert(newLibro6);
        libroDAO.insert(newLibro7);
        libroDAO.insert(newLibro8);
        libroDAO.insert(newLibro9);
        libroDAO.insert(newLibro10);


    ////////////////////////////////////////////////////////////////////////////

        GeneroDAO generoDAO = new GeneroDAO();

        //GENEROS
        Genero newNovela = new Genero("Novela");
        Genero newDrama = new Genero("Drama");
        Genero newFantasia = new Genero("Fantasia");
        Genero newFiccion = new Genero("Ficcion");
        Genero newMisterio = new Genero("Misterio");

        generoDAO.insert(newNovela);
        generoDAO.insert(newDrama);
        generoDAO.insert(newFantasia);
        generoDAO.insert(newFiccion);
        generoDAO.insert(newMisterio);


        newLibro1.setGenero(newNovela);
        newLibro2.setGenero(newFiccion);
        newLibro3.setGenero(newDrama);
        newLibro4.setGenero(newNovela);
        newLibro5.setGenero(newDrama);
        newLibro6.setGenero(newNovela);
        newLibro7.setGenero(newFantasia);
        newLibro8.setGenero(newFantasia);
        newLibro9.setGenero(newMisterio);
        newLibro10.setGenero(newDrama);


        // Actualiza los libros en la base de datos
        libroDAO.update(newLibro1);
        libroDAO.update(newLibro2);
        libroDAO.update(newLibro3);
        libroDAO.update(newLibro4);
        libroDAO.update(newLibro5);
        libroDAO.update(newLibro6);
        libroDAO.update(newLibro7);
        libroDAO.update(newLibro8);
        libroDAO.update(newLibro9);
        libroDAO.update(newLibro10);


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        SocioDAO socioDAO = new SocioDAO();
        //SOCIOS
        Socio newSocio1 = new Socio("Cristobal", "Lira", 963852, " principal 45", "cris123@gmail.com");
        Socio newSocio2 = new Socio("Camila", "Leyton", 123456, " new york 123", "cam.leytong@gmail.com");
        Socio newSocio3 = new Socio("Juan", "Pérez", 789012, "avenida 567", "juan.perez@gmail.com");
        Socio newSocio4 = new Socio("Ana", "González", 654321, "calle 890", "ana.gonzalez@gmail.com");
        Socio newSocio5 = new Socio("Luis", "Martínez", 135790, "plaza 246", "luis.martinez@gmail.com");
        Socio newSocio6 = new Socio("María", "Leyton", 246801, "new york 123", "maria.rodriguez@gmail.com");

        socioDAO.insert(newSocio1);
        socioDAO.insert(newSocio2);
        socioDAO.insert(newSocio3);
        socioDAO.insert(newSocio4);
        socioDAO.insert(newSocio5);
        socioDAO.insert(newSocio6);

        ///////////////////////////////////////////////////////////////////////

        PrestamoDAO prestamoDAO = new PrestamoDAO();

        // Crear nuevos préstamos y asignarlos a los socios
        Prestamo nuevoPrestamo1 = new Prestamo();
        nuevoPrestamo1.setFecha_prestamo(new Date(123, 9,1));
        nuevoPrestamo1.setFecha_devolucion(new Date());
        nuevoPrestamo1.setDevuelto(true);
        nuevoPrestamo1.setSocio(newSocio1);
        nuevoPrestamo1.setLibro(newLibro4);

        Prestamo nuevoPrestamo2 = new Prestamo();
        nuevoPrestamo2.setFecha_prestamo(new Date(123, 10,23));
        nuevoPrestamo2.setFecha_devolucion(new Date(124, 1, 1));
        nuevoPrestamo2.setDevuelto(true);
        nuevoPrestamo2.setSocio(newSocio1);
        nuevoPrestamo2.setLibro(newLibro6);

        Prestamo nuevoPrestamo3 = new Prestamo();
        nuevoPrestamo3.setFecha_prestamo(new Date(123, 11, 2));
        nuevoPrestamo3.setDevuelto(false);
        nuevoPrestamo3.setSocio(newSocio4);
        nuevoPrestamo3.setLibro(newLibro2);

        Prestamo nuevoPrestamo4 = new Prestamo();
        nuevoPrestamo4.setFecha_prestamo(new Date());
        nuevoPrestamo4.setDevuelto(false);
        nuevoPrestamo4.setSocio(newSocio6);
        nuevoPrestamo4.setLibro(newLibro7);

        // Guardar los prestamos en la base de datos
        prestamoDAO.insert(nuevoPrestamo1);
        prestamoDAO.insert(nuevoPrestamo2);
        prestamoDAO.insert(nuevoPrestamo3);
        prestamoDAO.insert(nuevoPrestamo4);

        // Añadir los prestamos a los socios y guardarlos en la base de datos
        SocioDAO.addPrestamoToSocio(newSocio1.getId(), nuevoPrestamo1);
        SocioDAO.addPrestamoToSocio(newSocio1.getId(), nuevoPrestamo2);
        SocioDAO.addPrestamoToSocio(newSocio4.getId(), nuevoPrestamo3);
        SocioDAO.addPrestamoToSocio(newSocio6.getId(), nuevoPrestamo4);

        // Listar todos los libros
        List<Libro> allLibros = libroDAO.findAll();
        for (Libro libro : allLibros) {
            System.out.println("Los libros que tenemos son");
            System.out.println("ID: " + libro.getId());
            System.out.println("Nombre: "+ libro.getNombre());
            System.out.println("Genero: "+ libro.getGenero().getNombre());
            System.out.println("Autor: " + libro.getAutor().getNombre()+" "+libro.getAutor().getApellido());
           System.out.println("Fecha de publicacion: " + libro.getFecha_publicacion());
            System.out.println("-----");
        }

        // Listar todos los socios
        List<Socio> allSocios = socioDAO.findAll();
        for (Socio socio : allSocios) {
            System.out.println("SOCIOS:");
            System.out.println("ID: " + socio.getId());
            System.out.println("Nombre Completo: "+ socio.getNombre() +" "+socio.getApellido());
            System.out.println("Correo: "+ socio.getCorreo());
            System.out.println("Telefono: "+ socio.getTelefono());
            System.out.println("Direccion: " + socio.getDireccion());
            System.out.println("-----");
        }


        List<Prestamo> prestamosNoDevueltos = prestamoDAO.findByDevuelto(false);
        // Imprimir los prestamos NO devueltos
        for (Prestamo prestamo : prestamosNoDevueltos) {
            System.out.println("ID: " + prestamo.getId());
            System.out.println("Fecha Préstamo: " + prestamo.getFecha_prestamo());
            System.out.println("Fecha Devolución: " + prestamo.getFecha_devolucion());
            System.out.println("Devuelto: " + prestamo.isDevuelto());
            System.out.println("Socio: " + prestamo.getSocio().getNombre() + " " + prestamo.getSocio().getApellido());
            System.out.println("Libro: " + prestamo.getLibro().getNombre());
            System.out.println("-----");
        }

        List<Prestamo> prestamosDevueltos = prestamoDAO.findByDevuelto(true);
        // Imprimir los prestamos devueltos
        for (Prestamo prestamo : prestamosDevueltos) {
            System.out.println("ID: " + prestamo.getId());
            System.out.println("Fecha Préstamo: " + prestamo.getFecha_prestamo());
            System.out.println("Fecha Devolución: " + prestamo.getFecha_devolucion());
            System.out.println("Devuelto: " + prestamo.isDevuelto());
            System.out.println("Socio: " + prestamo.getSocio().getNombre() + " " + prestamo.getSocio().getApellido());
            System.out.println("Libro: " + prestamo.getLibro().getNombre());
            System.out.println("-----");
        }
    }
}
