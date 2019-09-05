-- generate product
drop table if exists product;
create table if not exists product
(
id int primary key auto_increment,
name varchar(100) not null,
cost int null
);
insert into test.product (name, cost) VALUES ('Milk', 100), ('Vodka', 300), ('Sugar', 150);

-- generate customer
drop table if exists customer;
create table if not exists customer
(
id int auto_increment
primary key,
name int not null
);
insert into test.customer (name) values ('Ivan'), ('Vova'), ('Sergey'), ('Volodya');

-- generate sales_history
drop table if exists sales_history;
create table if not exists sales_history
(
id int auto_increment
primary key,
id_product int not null,
id_customer int not null,
cost int null,
constraint sales_history_customer_id_fk
foreign key (id_customer) references customer (id),
constraint sales_history_product_id_fk
foreign key (id_product) references product (id)
);
insert into test.sales_history(id_product, id_customer, cost) VALUES (1,1,300), (2,3,190), (1,2,110), (3,1,150);