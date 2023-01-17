create table if not exists "products"
(
    id uuid DEFAULT gen_random_uuid() primary key,
    name    varchar(100)     not null,
    company varchar(100)     not null,
    price   double precision not null
);