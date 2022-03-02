package com.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.assign.Product;
import com.hibernate.HibernateSessionFactory;

import com.pair.Pair;

public class UserDAO {

	static SessionFactory sf = HibernateSessionFactory.HibernateSessionFactory();

	public Pair<Boolean, String> insertCommand(Product p) {
		// Assume Product object is got from service layer..
		Pair<Boolean, String> hm = null;
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
			hm = new Pair(true, "Insert Done");
			session.close();
			return hm;
		} catch (Exception e) {
			hm = new Pair(false, "Id Already Present");
			return hm;
		} finally {
			session.close();
		}
	}

	public Pair<Boolean, String> updateCommand(Product p) {
		Pair<Boolean, String> hm = null;
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Product p1 = session.get(Product.class, p.getId());
			p1.setId(p.getId());
			p1.setName(p.getName());
			p1.setPrice(p.getPrice());
			p1.setQuantity(p.getQuantity());
			p1.setDiscount(p.getDiscount());
			if (p1 != null) {
				session.update(p1);
				hm = new Pair(true, "Update Done");
			} 
			tx.commit();
			session.close();
			return hm;
		} catch (Exception e) {
			e.printStackTrace();
			hm = new Pair(false, "Some Error");
			return hm;
		} finally {
			session.close();
		}
	}

	public Pair<Boolean, String> delete(int id) {
		Pair<Boolean, String> hm = null;
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Product p1 = session.get(Product.class, id);
			if (p1 != null) {
				session.remove(p1);
				hm = new Pair(true, "Delete Done");
			} else {
				hm = new Pair(false, "Element Not Present");
			}
			tx.commit();
			session.close();
			return hm;
		} catch (HibernateException e) {
			e.printStackTrace();
			hm = new Pair(false, "Internal Error");
			return hm;
		} finally {
			session.close();
		}
	}

	public List<Product> showAll() {
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Product");
			List<Product> list = q.list();
			tx.commit();
			session.close();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Product singleselect(int x) {
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query<Product> q = session.createQuery("from Product where id=:id");
			q.setParameter("id", x);
			Product p = (Product) q.uniqueResult();
			tx.commit();
			return p;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	public boolean validate(String name, String passwd) {
		if (name.equals("admin") && passwd.equals("admin"))
			return true;
		else
			return false;
	}

}
