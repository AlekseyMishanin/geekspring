package com.hibernate;

import com.hibernate.dao.SimpleDaoImpl;
import com.hibernate.entity.Product;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        SimpleDaoImpl simpleDaoImpl = new SimpleDaoImpl();
        Session session = simpleDaoImpl.createHibernateSession();
        Product pr = new Product();
        //System.out.println(session.get(Product.class,1L));
        System.out.println(simpleDaoImpl.getListProductFromCustomer(1L));
        //System.out.println(simpleDaoImpl.getHistoryCost(3L,2L));
    }
}
