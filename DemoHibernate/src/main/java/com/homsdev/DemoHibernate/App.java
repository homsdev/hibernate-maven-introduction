package com.homsdev.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure()
				.addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		session.beginTransaction();
		Alien a= (Alien) session.get(Alien.class, 101);
		System.out.println(a);
		session.getTransaction().commit();
		session.close();
		
		session=sf.openSession();
		session.beginTransaction();	
		Alien b= (Alien) session.get(Alien.class, 101);
		System.out.println(b);
		session.getTransaction().commit();
		session.beginTransaction();
	}
}
