package com.hibernate.dao;

import com.hibernate.entity.Customer;
import com.hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SimpleDaoImpl implements SimpleDao{

    private Session session = null;

    public Session createHibernateSession(){

        SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }

    public List<String> getListProductFromCustomer(Long id){
        Transaction tx = session.beginTransaction();
        List<String> list = session.createNamedQuery("Product.allProductFromSomeCustomer")
                .setParameter("id", id)
                .getResultList();
        tx.commit();
        return list;
    }

    public List<String> getListCustomerFromProduct(Long id){
        Transaction tx = session.beginTransaction();
        List<String> list = session.createNamedQuery("Customer.allCustomerFromSomeProduct")
                .setParameter("id", id)
                .getResultList();
        tx.commit();
        return list;
    }

    public void deleteProduct(Product product){
        Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
    }

    public void deleteCustomer(Customer customer){
        Transaction tx = session.beginTransaction();
        session.delete(customer);
        tx.commit();
    }

    public List<String> getHistoryCost(Long idCustomer, Long idProduct){
        Transaction tx = session.beginTransaction();
        List<String> list = session.createNamedQuery("Customer.getHistoryCost")
                .setParameter("id1", idCustomer)
                .setParameter("id2", idProduct)
                .getResultList();
        tx.commit();
        return list;
    }


}
