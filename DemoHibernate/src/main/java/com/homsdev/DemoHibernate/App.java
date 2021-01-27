package com.homsdev.DemoHibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
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

		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		session.beginTransaction();
//		Load method will throw and OnjectNotFoundException if the required id doesn´t exist in DB
		
		Laptop lap=null;
		try {
			lap = (Laptop) session.load(Laptop.class, 105);
			System.out.println(lap);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ID no encontrado");
			session.evict(lap);
		}
		
//Get will return null object if ID does not exist on DB
		lap = (Laptop) session.get(Laptop.class, 105);
		System.out.println(lap);
		session.getTransaction().commit();
	}
}
