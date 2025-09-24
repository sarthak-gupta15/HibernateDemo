package com.binarybrain;

import com.binarybrain.model.Student;
import com.binarybrain.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class App {
    public static void main(String[] args) {
        // Get session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create a student
        Student student = new Student(null, "Sarthak", 22);
        Student student1 = new Student();


        // Save it
        session.persist(student);
        student1.setName("anurag");
        student1.setAge(15);
        session.persist(student1);

        transaction.commit();
        session.close();

        HibernateUtil.shutdown();
        System.out.println("Student saved successfully!");
    }
}
