package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Student;
import org.mahagan.domain.Unversity;

import java.util.Iterator;
import java.util.List;

public class ManyToOneRelationshipApplicationFetchDataHB2 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =  new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata =new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("From Unversity unversity");
        List<Unversity> list = query.getResultList();
        Iterator<Unversity>iterator = list.listIterator();

        while(iterator.hasNext())
        {
            Unversity unversity = iterator.next();
            System.out.println(unversity.getUnversityName());

                Student student = unversity.getStudent();
                System.out.println(student.getStudentFirstName()+" "+student.getStudentLastName()+" "+student.getSection());
        }
        session.close();
        System.out.println("Data Fetch Successfully");
    }
}
