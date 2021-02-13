create table sys_user (
user_id int UNSIGNED AUTO_INCREMENT,
user_name varchar(100) not null,
password varchar(100) not null,
email varchar(100) not null,
created_by int,
creation_date date,
last_updated_by int,
last_updated_date date,
primary key (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;