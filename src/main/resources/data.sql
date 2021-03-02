insert into Client (id, name, email, password, apartment, phone) values(1244, 'Gorin', 'gorin@email.com', '123456', 'bloco A, 101', '9999-9999');
insert into Client (id, name, email, password, apartment, phone) values(1245, 'Cleo', 'cleo@email.com', '123456', 'bloco B, 202', '9999-8888');
COMMIT;

insert into Post values(400, '18/02/2021','Bolo de cenoura',1244);
COMMIT;