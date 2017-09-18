package com.pankaj.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.common.Avatar;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String args[]) {
		System.out.println(HibernateUtils.getSessionFactory().getClass());
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Avatar a = (Avatar) session.get(Avatar.class, 1);
		System.out.println(a);
	}

}