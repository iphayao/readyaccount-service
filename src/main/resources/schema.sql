create table product (
    id uuid default uuid_generate_v4(),
    type VARCHAR not null,
    name VARCHAR not null,
    code VARCHAR not null,
    description VARCHAR not null,
    sell_price DECIMAL not null,
    sell_price_with_vat DECIMAL,
    sell_vat_type VARCHAR not null,
    buy_price DECIMAL,
    buy_price_with_vat DECIMAL,
    buy_vat_type VARCHAR,
    unit VARCHAR,
    category VARCHAR,
    barcode VARCHAR,
    inventory DECIMAL
)