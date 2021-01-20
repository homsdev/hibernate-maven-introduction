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
public class App {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		Student student=new Student();
		student.setName("HomS");
		student.setRollno(1);
		student.setMarks(50);
		
		Laptop laptop=new Laptop();
		laptop.setId(101);
		laptop.setModel("Dell");
		
		student.getLaptops().add(laptop);
		laptop.getStudents().add(student);		
		
		Transaction tx = session.beginTransaction();
		
		session.save(laptop);
		session.save(student);
		
		
		tx.commit();
	}
}
