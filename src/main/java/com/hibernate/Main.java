package com.hibernate;

import com.hibernate.dao.SimpleDaoImpl;
import com.hibernate.entity.Customer;
import com.hibernate.entity.Product;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        InitialiseDb.forcePrepareData();

        SimpleDaoImpl simpleDaoImpl = new SimpleDaoImpl();
        Session session = simpleDaoImpl.createHibernateSession();

        System.out.println("Get list product - " + session.get(Product.class,1L));
        System.out.println(simpleDaoImpl.getListProductFromCustomer(1L));
        System.out.println("Get list customer - " + session.get(Customer.class,1L));
        System.out.println(simpleDaoImpl.getListCustomerFromProduct(1L));
        System.out.println("History cost to idProduct=2 for idCustomer=3 " + simpleDaoImpl.getHistoryCost(3L,2L));
        Product pr = session.get(Product.class,1L);
        simpleDaoImpl.deleteProduct(pr);
        Customer cs = session.get(Customer.class,1L);
        simpleDaoImpl.deleteCustomer(cs);
    }
}
