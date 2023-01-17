create table if not exists "products"
(
    id uuid DEFAULT gen_random_uuid() primary key,
    name    varchar(100)     not null,
    company varchar(100)     not null,
    price   double precision not null
);

insert into products (name, company, price)
values ('Snickers', 'Mars', 1.0);
insert into products (name, company, price)
values ('Mars', 'Mars', 1.0);
insert into products (name, company, price)
values ('Mozarella', 'Milkstore Inc.', 1.00);
insert into products (name, company, price)
values ('Ice Tea Lemon', 'Lemonado Inc.', 1.79);
insert into products (name, company, price)
values ('Pepsi light lemon', 'Pepsi co.', 1.29);
insert into products (name, company, price)
values ('Pizza Salami', 'PizzaPlace', 2.59);
insert into products (name, company, price)
values ('Vine', 'Vino de la Tierra de Castilla', 3.50);
insert into products (name, company, price)
values ('Mentos Pure Fresh 6x Package', 'Mentos', 13.00);
insert into products (name, company, price)
values ('Gralic Sauce', 'Knorr', 6.25);
insert into products (name, company, price)
values ('Chocolate Cake', 'CreamyCakes', 6.99);