package com.hibernate.dao;

import com.hibernate.entity.Customer;
import com.hibernate.entity.Product;

import java.util.List;


/**
 * Интерфейс описывает доступные действия.
 * */
public interface SimpleDao {
    //получить список продуктов по id покупателя
    List<String> getListProductFromCustomer(Long id);
    //получить список покупателей по id продукта
    List<String> getListCustomerFromProduct(Long id);
    //удалить продукт
    void deleteProduct(Product product);
    //удалить покупателя
    void deleteCustomer(Customer customer);
    //по связке покупатель-продукт посмотреть список с историей цен
    List<String> getHistoryCost(Long idCustomer, Long idProduct);

}
