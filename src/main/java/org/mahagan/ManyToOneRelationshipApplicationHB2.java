package org.mahagan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Student;
import org.mahagan.domain.Unversity;


public class ManyToOneRelationshipApplicationHB2 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =  new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata =new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        Student student = new Student();
        student.setStudentFirstName("vijay");
        student.setStudentLastName("Mohite");
        student.setSection("Computer");

        Student student1 = new Student();
        student1.setStudentFirstName("Sumit");
        student1.setStudentLastName("Patil");
        student1.setSection("Civil");

        Student student2 = new Student();
        student2.setStudentFirstName("Jiya");
        student2.setStudentLastName("Rane");
        student2.setSection("Mecanical");

        Unversity unversity = new Unversity();
        unversity.setUnversityName("Sppu");

        unversity.setStudent(student);
        session.persist(unversity);

        unversity.setStudent(student1);
        session.persist(unversity);

        unversity.setStudent(student2);
        session.persist(unversity);

        student.setUnversity(unversity);
        session.persist(student);

        student1.setUnversity(unversity);
        session.persist(student1);

        student2.setUnversity(unversity);
        session.persist(student2);

        tsx.commit();
        session.close();

        System.out.println("Data Successfully Inserted");
    }
}