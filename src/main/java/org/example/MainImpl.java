package org.example;


import org.example.hibernateModel.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class MainImpl
{
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        try {
            Properties properties = new Properties();
            Configuration configuration = new Configuration();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/myserver");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "sHar@112");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
    public static void main( String[] args )
    {
       getDelete();
    }
    public static void getInserted(){
        try {
            SessionFactory sessionFactory = getSessionFactory();
            Session session = sessionFactory.openSession();
            System.out.println("Session open: " + session.isOpen());
            Student student=new Student(6,"Jayant","B.E",100,24);

            Transaction transaction = session.getTransaction();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            System.out.println("inserted successfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void getDelete(){
        try{
            SessionFactory sessionFactory1 = getSessionFactory();
            Session session = sessionFactory1.openSession();
            Student student=new Student(6,"Jayant","B.E",100,24);
            Transaction transaction = session.getTransaction();
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
