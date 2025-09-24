package com.binarybrain.util;

import com.binarybrain.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure().buildSessionFactory();
            Configuration cfg = new Configuration().configure(); // find hibernate.cfg.xml file
            cfg.addAnnotatedClass(Student.class);  // register entity programmatically
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
