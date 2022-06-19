package com.learning.hibenrate.demo;

import com.learning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student student1 = new Student("Jphn", "Yust", "anna@email.com", "test");
//            Student student2 = new Student("Steve", "Jorhita", "anna@email.com");
//            Student student3 = new Student("Abra", "Bonita", "bonita@email.com");
            session.beginTransaction();
            session.persist(student1);
//            session.persist(student2);
//            session.persist(student3);

            session.getTransaction().commit();
            System.out.println("Done! Student is saved");
        } catch (Exception e) {
        } finally {
            factory.close();
        }
    }
}
