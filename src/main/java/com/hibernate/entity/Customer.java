package com.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Класс сущности покупателя.
 * */

@Getter
@Setter
@Entity
@Table(name="customer")
@NamedQueries({
        @NamedQuery(name = "Customer.allCustomerFromSomeProduct",
        query = "select distinct a.name from Customer a left join a.products s where s.id = :id"),
        @NamedQuery(name = "Customer.getHistoryCost",
        query = "select distinct s.cost from Customer a left join a.historyCosts s where a.id = :id1 and s.product.id = :id2")
})
public class Customer  extends AbstractEntity implements Serializable{

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "sales_history",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

    /**
     * Сущность отражающая детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом
     * */
    @OneToMany(mappedBy = "customer")
    private List<HistoryCost> historyCosts;
}
