insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Steve', 'JOBS', 'steve', 'steve', 'steve.jobs@apple.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Bill', 'GATES', 'bill', 'bill', 'bill.gates@microsoft.com', '0033 1 23 45 67 89', 'fr', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Mark', 'ZUCKERBERG', 'mark', 'zuckerberg', 'mark.zuckerberg@facebook.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Tim', 'COOK', 'tim', 'cook', 'tim.cook@apple.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Larry', 'Page', 'larry', 'page', 'larry.page@gmail.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Sergey', 'Brin', 'sergey', 'brin', 'sergey.brin@gmail.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Larry', 'ELLISON', 'larry2', 'ellison', 'larry.ellison@oracle.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Jeff', 'BEZOS', 'jeff', 'bezos', 'jeff.bezos@amazon.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Paul', 'ALLEN', 'paul', 'allen', 'paul.allen@microsoft.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Steve', 'BALLMER', 'steve2', 'ballmer', 'steve.ballmer@microsoft.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Jack', 'DORSEY', 'jack', 'dorsey', 'jack.dorsey@twitter.com', '0033 1 23 45 67 89', 'en', true);
insert into users (first_name, family_name, login, password, e_mail, phone, language, enabled) values ('Matt', 'MULLENWEG', 'matt', 'mullenweg', 'matt.mullenweg@wordpress.com', '0033 1 23 45 67 89', 'en', true);

insert into authority (name) values ('admin');
insert into authority (name) values ('technical user');
insert into authority (name) values ('user');

insert into users_authority (id_user, id_authority) values (1, 1);
insert into users_authority (id_user, id_authority) values (1, 2);
insert into users_authority (id_user, id_authority) values (1, 3);
insert into users_authority (id_user, id_authority) values (2, 3);
insert into users_authority (id_user, id_authority) values (3, 3);
	