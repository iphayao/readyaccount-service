create sequence company_sequence start 10000;
create sequence product_sequence start 10000;
create sequence users_sequence start 10000;

create table users (
    id bigint primary key not null default nextval('users_sequence'),
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    password varchar not null,
    roles varchar not null
);
alter sequence users_sequence owned by users.id;

create table company (
    id bigint primary key not null default nextval('company_sequence'),
    type varchar not null,
    name varchar not null,
    name_en varchar not null,
    address varchar not null,
    address_en varchar not null,
    zip_code varchar not null,
    tax_id varchar not null,
    branch varchar not null,
    branch_en varchar not null,
    phone varchar,
    mobile varchar not null,
    fax varchar,
    website varchar,
    user_id bigint not null,
    updated_date timestamp not null default current_timestamp,
    created_date timestamp not null default current_timestamp,
    foreign key (user_id) references users(id)
);
alter sequence company_sequence owned by company.id;

create table product (
    id bigint not null default nextval('product_sequence'),
    type varchar not null,
    name varchar not null,
    code varchar not null,
    description varchar not null,
    sell_price decimal not null,
    sell_price_with_vat decimal,
    sell_vat_type varchar not null,
    buy_price decimal,
    buy_price_with_vat decimal,
    buy_vat_type varchar,
    unit varchar,
    category varchar,
    barcode varchar,
    inventory decimal,
    company_id bigint not null,
    updated_date timestamp not null default current_timestamp,
    created_date timestamp not null default current_timestamp,
    foreign key (company_id) references company(id)
);
alter sequence product_sequence owned by product.id;


select * from company