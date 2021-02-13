create table ali_template (
template_id int UNSIGNED AUTO_INCREMENT,
template_message varchar(2000) not null,
created_by int,
creation_date date,
last_updated_by int,
last_updated_date date,
primary key (template_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;