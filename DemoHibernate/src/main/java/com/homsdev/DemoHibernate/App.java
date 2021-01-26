package com.homsdev.DemoHibernate;

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

		Configuration con = new Configuration().configure()
				.addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Alien a= null;
		
		Session session1 = sf.openSession();
		session1.beginTransaction();
		Query q1=session1.createQuery("from Alien where aid=101");
		q1.setCacheable(true);//This instruction makes available the use of cache for the query
		a=(Alien)q1.uniqueResult();
		System.out.println(a.getAname());
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query q2=session2.createQuery("from Alien where aid=101");
		q2.setCacheable(true);//This instruction makes available the use of cache for the query
		a=(Alien)q2.uniqueResult();
		System.out.println(a.getAname());
		session2.getTransaction().commit();
		session2.close();
		
	}
}
