insert into User (id, username, email, password, apartment, phone) values(1244, 'Gorin', 'gorin@email.com', '$2a$10$p/oNXY32XMaT4ErXUn1pcuVp7MNpO1vnYxtvsbbRYm0c22Lib90ny', 'bloco A, 101', '9999-9999');
insert into User (id, username, email, password, apartment, phone) values(1245, 'Cleo', 'cleo@email.com', '123456', 'bloco B, 202', '9999-8888');
insert into User (id, username, email, password, apartment, phone) values(1246, 'Rose', 'rose@email.com', '123456', 'bloco C, 303', '9999-7777');
COMMIT;

insert into Post values(400, '18/02/2021', 'Bolo de cenoura com cobertura de chocolate por R$30,00 entrego em casa.', 'Bolo de cenoura', 1244);
insert into Post values(401, '19/02/2021','chinelo réi torado tamanho 38, interessados entrar em contato.','Chinelo',1245);

COMMIT;