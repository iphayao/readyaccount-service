create sequence company_sequence start 10000;
create sequence product_sequence start 10000;
create sequence users_sequence start 10000;
create sequence contract_sequence start 10000;

create table users (
    id bigint primary key not null default nextval('users_sequence'),
    first_name varchar not null,
    last_name varchar not null,
    email varchar not null,
    password varchar not null,
    roles varchar not null
);

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


create table product (
    id bigint primary key not null default nextval('product_sequence'),
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

create table contract (
    id bigint primary key not null default nextval('contract_sequence'),
    type varchar not null,
    person_type varchar not null,
    code varchar not null,
    name varchar not null,
    address varchar not null,
    zip_code varchar not null,
    tax_id varchar not null ,
    branch_code varchar not null,
    branch varchar not null,
    person varchar not null,
    email varchar not null,
    mobile varchar not null,
    bank_id varchar not null,
    bank_account_number varchar not null,
    bank_branch varchar not null,
    bank_account_type varchar not null,
    credit_days varchar not null,
    phone varchar not null,
    fax varchar not null,
    website varchar not null,
    shopping_address varchar not null,
    note varchar not null,
    company_id bigint not null,
    updated_date timestamp not null default current_timestamp,
    created_date timestamp not null default current_timestamp,
    foreign key (company_id) references company(id)
)

alter sequence users_sequence owned by users.id;
alter sequence company_sequence owned by company.id;
alter sequence product_sequence owned by product.id;
alter sequence contract_sequence owned by contract.id;