package com.rest.switer.dao.hiber;

import java.io.File;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Palina_Piarlukhina on 12/7/2017.
 */
public class HibernateUtil {
   
    public static File cfg = new File("C://Users//Palina_Piarlukhina//Desktop//home//own//Switer//src//main//resources", "hibernate.cfg.xml");
    private static HibernateUtil instance = null;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private HibernateUtil() {
    }

    static {
        try {
            Configuration configuration = new Configuration().configure(cfg);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception he) {
            System.err.println("Erro ao criar a conexao com o base de dados: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return getSessionFactory().openSession();
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public static void testConnection() throws Exception {
        getSessionFactory().openSession();
    }

}
