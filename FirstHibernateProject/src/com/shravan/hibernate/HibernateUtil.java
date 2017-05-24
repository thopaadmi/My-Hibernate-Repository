package com.shravan.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {

		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			//serviceRegistry = new ServiceRegistryBuilder().applySettings(
				//	configuration.getProperties()).buildServiceRegistry();
			 serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {

			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
