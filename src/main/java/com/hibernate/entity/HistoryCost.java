package com.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Класс описывает сущность цены товара на момент покупки товара покупателем.
 * */

@Getter
@Setter
@Entity
@Table(name = "sales_history")
public class HistoryCost extends AbstractEntity{

    @Column(name = "cost")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
