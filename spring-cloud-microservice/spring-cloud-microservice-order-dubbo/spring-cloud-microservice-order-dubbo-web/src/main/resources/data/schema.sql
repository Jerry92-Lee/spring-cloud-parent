drop table order_table if exists;
create table order_table (id bigint generated by default as identity, order_sn varchar(20), user_id bigint, primary key (id));