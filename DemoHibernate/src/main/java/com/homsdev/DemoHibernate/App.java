package com.homsdev.DemoHibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Alien alien= new Alien();
        
        alien.setAid(102);
        alien.setAname("HomSo");
        alien.setAcolor("red");
        
        Configuration con= new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
        SessionFactory sf= con.buildSessionFactory(reg);
        Session session= sf.openSession();
        
        Transaction tx= session.beginTransaction();
  
        session.save(alien);
  
        tx.commit();
        
    }
}
