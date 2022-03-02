package com.hibernate;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.assign.Product;

public class HibernateSessionFactory {
	private static SessionFactory session = null;

	private HibernateSessionFactory() {
	}
	
	public static SessionFactory HibernateSessionFactory()  {
		if (session == null) {
			Properties settings = new Properties();
			System.out.println("aayush"+System.getenv("USERNAME"));
			System.out.println(System.getenv("PASSWORD"));
			System.out.println(System.getenv("DATABASE_URL_HEROKU"));
			settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, System.getenv("DATABASE_URL_HEROKU"));
            settings.put(Environment.USER, System.getenv("USERNAME"));
            settings.put(Environment.PASS, System.getenv("PASSWORD"));
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "update");
			Configuration cfg = new Configuration().setProperties(settings).addAnnotatedClass(Product.class);
//			Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class);
			session = cfg.buildSessionFactory();
		}
		return session;
	}
	public static void closeFactory() {
		if(session.isOpen()) {
			session.close();
		}
	}
	
}