package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        // Load configuration
        Configuration configuration = new Configuration();
        configuration.configure(); 
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Client client1 = new Client();
        client1.setName("Harsha");
        client1.setGender("Male");
        client1.setAge(20);
        client1.setLocation("Peda Pulipaka");
        client1.setEmailAddress("harsha7@gmail.com");
        client1.setMobileNumber("7777777777");

        Client client2 = new Client();
        client2.setName("Yuga Sai");
        client2.setGender("Male");
        client2.setAge(40);
        client2.setLocation("Vijayawada");
        client2.setEmailAddress("yugasai@gmail.com");
        client2.setMobileNumber("0987654321");

        session.persist(client1);
        session.persist(client2);

        transaction.commit();

        // Print All Records
        Query<Client> query = session.createQuery("from Client", Client.class);
        List<Client> clients = query.getResultList();

        System.out.println("All Clients:");
        for (Client client : clients) {
            System.out.println("ID: " + client.getId());
            System.out.println("Name: " + client.getName());
            System.out.println("Gender: " + client.getGender());
            System.out.println("Age: " + client.getAge());
            System.out.println("Location: " + client.getLocation());
            System.out.println("Email: " + client.getEmailAddress());
            System.out.println("Mobile: " + client.getMobileNumber());
            System.out.println("---------------------------");
        }

        session.close();
        sessionFactory.close();
    }
}
