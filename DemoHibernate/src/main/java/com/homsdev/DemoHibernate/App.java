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

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);

		
		Session session = sf.openSession();
		session.beginTransaction();
		
		//		Fetch all data from a table
//		Query query=session.createQuery("from Student"); 
//		List<Student> students=	query.list();
//		
//		for(Student student:students) {
//			System.out.println(student);
//		}
		
		//Fetch data that satisfies the condition
//		Query query=session.createQuery("from Student where marks >50"); 
//		List<Student> students=	query.list();
//		
//		for(Student student:students) {
//			System.out.println(student);
//		}
		
		//Fetch one single value
//		Query query=session.createQuery("from Student where rollno = 2");
//		Student student=(Student)query.uniqueResult();
//		System.out.println(student);
		

		//Fetch data with  dynamic values without giving name to parameter
//		int param=60;
//		Query query=session.createQuery("select sum(marks) from Student s where s.marks > ?");
//		query.setParameter(0, param);
//		Long marksSum= (Long)query.uniqueResult();
//		System.out.println(marksSum);
		
		//Fetch data with  dynamic values giving name to parameter
//				int param=60;
//				Query query=session.createQuery("select sum(marks) from Student s where s.marks > :param");
//				query.setParameter("param", param);
//				Long marksSum= (Long)query.uniqueResult();
//				System.out.println(marksSum);
		
//		Fetch only some columns from data
		Query query=session.createQuery("select name,marks from Student s where s.rollno = 4");
		Object[] student= (Object[]) query.uniqueResult();
		System.out.println(student[0]+" : "+student[1]);
		
	}
}
