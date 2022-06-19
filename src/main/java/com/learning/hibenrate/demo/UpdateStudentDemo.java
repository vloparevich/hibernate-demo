package com.learning.hibenrate.demo;

import com.learning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            int studentId = 1;
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student ID with id:" + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Updating student...");
            myStudent.setFirstName("Borjomi");
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating email for all the students in bulk...");
            session.createQuery("update Student  set emailAddress='anna@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Everything is updated is updated!");
        } catch (Exception e) {
        } finally {
            factory.close();
        }
    }
}
