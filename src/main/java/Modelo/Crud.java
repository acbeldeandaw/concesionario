package Modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DAW-A
 */
public class Crud {
    
    public static List<Automovil> getAutomoviles() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Automovil";
        Query q = manager.createNativeQuery(sql,Automovil.class);
        List<Automovil> automoviles =  q.getResultList();

        return automoviles;        
    }
    
    public static List<Automovil> getAutomovilesPaginado(int lineas_pagina, int offset) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Automovil";
        Query q = manager.createNativeQuery(sql,Automovil.class);
        q.setMaxResults(lineas_pagina);
        q.setFirstResult(offset);
        List<Automovil> automoviles =  q.getResultList();
        
        return automoviles;        
    }
    
    public static Automovil getAutomovil(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT a FROM Automovil a WHERE a.id=" + id;
        Query q = manager.createQuery(sql,Automovil.class);
        Automovil automovil =  ( Automovil )q.getSingleResult();
        return automovil;
    }
    
    public static int deleteAutomovil(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Automovil a WHERE a.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        return filasAfectadas;  
    }
    
    public static int updateAutomovil(Automovil a) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Automovil a "
                + "SET a.categoria = '" + a.getCategoria()
                + "', a.precio = '" + a.getPrecio()
                + "', a.marca = '" + a.getMarca()
                + "', a.modelo = '" + a.getModelo()
                + "', a.fab = '" + a.getFab()
                + "', a.foto = '" + a.getFoto()
                + "' WHERE a.id = " + a.getId();
        Query q = manager.createQuery(sql,Automovil.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
    
    public static void insertAutomovil(Automovil a) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Automovil automovil = new Automovil();
        automovil.setCategoria(a.getCategoria());
        automovil.setPrecio(a.getPrecio());
        automovil.setMarca(a.getMarca());
        automovil.setModelo(a.getModelo());
        automovil.setFab(a.getFab());
        automovil.setFoto(a.getFoto());
        
        manager.merge(automovil);
        manager.getTransaction().commit();
    }
}
