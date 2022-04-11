drop table if exists cao_data;
drop table if exists hibernate_sequence;

create table cao_data (
                      id bigint not null,
                      created_date timestamp,
                      object_id varchar(255),
                      naam varchar(255),
                      registratie varchar(255),
                      cao varchar(255),
                      ingangsdatum date,
                      expiratiedatum date,
                      soort varchar(255),
                      type varchar(255),
                      sbi varchar(255),
                      kvo_datum date,
                      primary key (id)
) engine=InnoDB;

create table hibernate_sequence (
    next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values ( 1 );