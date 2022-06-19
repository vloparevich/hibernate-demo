package com.learning.hibenrate.demo;

import com.learning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session;
        try {
            int studentId = 4;
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);

            System.out.println("Deleting student:" + student);

            session.createQuery("delete from Student where id=" + studentId).executeUpdate();

            session.getTransaction().commit();
            System.out.println("Student deleted...");
        } catch (Exception e) {
        } finally {
            factory.close();
        }
    }
}
