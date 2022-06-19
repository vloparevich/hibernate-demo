package com.learning.hibenrate.demo;

import com.learning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("Guffie", "Doe", "dog@daffie.com", "testGooffie");
            session.beginTransaction();

            session.persist(student);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("Retrieved student: " + myStudent.toString());
            session.getTransaction().commit();
            System.out.println("Done! Student is retrieved");
        } catch (Exception e) {
        } finally {
            factory.close();
        }

    }
}
