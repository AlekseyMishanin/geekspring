package com.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Класс сущности продукта.
 * */

@Getter
@Setter
@Entity
@Table(name = "product")
@NamedQuery(name = "Product.allProductFromSomeCustomer",
        query = "select distinct a.name from Product a left join a.customers s where s.id = :id")
public class Product extends AbstractEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;

    @ManyToMany
    @JoinTable(name = "sales_history",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_customer"))
    private List<Customer> customers;

    /**
     * Сущность отражающая детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом
     * */
    @OneToMany(mappedBy = "product")
    private List<HistoryCost> historyCosts;
}
