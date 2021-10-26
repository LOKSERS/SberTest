

create table buying_objects (id bigint generated by default as identity,
 description varchar(255), name varchar(255),primary key (id));

create table customers (id bigint generated by default as identity, last_name varchar(255),
name varchar(255), phone_number varchar(255), primary key (id));

create table requisition (Id bigint generated by default as identity,
credit_amount varchar(255), date date, purchase_cost varchar(255),
buying_obj_id bigint, person_id bigint, person_seller_id bigint, primary key (Id));

create table PUBLIC.sellers (id bigint generated by default as identity, inn varchar(255),
last_name varchar(255), name varchar(255), seller_type varchar(255) not null, primary key (id));


 alter table if exists requisition add constraint ReqToBuyingObj foreign key (buying_obj_id) references buying_objects;
 alter table if exists requisition add constraint ReqToCustomers foreign key (person_id) references customers;
 alter table if exists requisition add constraint ReqToSellers foreign key (person_seller_id) references sellers;