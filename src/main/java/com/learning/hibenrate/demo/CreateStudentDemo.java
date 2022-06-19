package com.learning.hibenrate.demo;

import com.learning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("Stefania24", "Samsunovich", "anna@email.com", "testStefania");
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            System.out.println("Done! Student is saved");
        } catch (Exception e) {
        } finally {
            factory.close();
        }

    }
}
