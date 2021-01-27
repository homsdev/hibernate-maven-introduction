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
		
//<- Object is on Transient state before Session>
		Laptop l= new Laptop();
		l.setId(54);
		l.setModel("T800X");
		l.setPrice(800);
		session.beginTransaction();
//< Object in Session is on persistence state>
		session.save(l);
		session.getTransaction().commit();
//	<Object is detached from session >	
		session.evict(l);
		l.setPrice(300);
	}
}
