package com.learning.hibenrate.demo;

import com.learning.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student", Student.class).getResultList();
            displayStudents(students);
            students = session.createQuery("from Student s where s.lastName='Yust'", Student.class).getResultList();
            System.out.println("\n\nStudents who have last name of 'Yust'");

            displayStudents(students);


            students = session.createQuery("from Student s where s.lastName='Dog' OR s.firstName='Steve'", Student.class).getResultList();
            System.out.println("from Student s where s.lastName='Dog' OR s.firstName='Steve'");
            displayStudents(students);


            students = session.createQuery("from Student s where s.emailAddress LIKE 'getta%'", Student.class).getResultList();
            System.out.println("from Student s where s.emailAddress LIKE 'getta%'");
            displayStudents(students);

            System.out.println("Done! Students are retrieved");
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            factory.close();

        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
