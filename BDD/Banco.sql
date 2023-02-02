CREATE DATABASE banco;
USE banco;


create table clientes(
idUsuario int (5) primary key auto_increment,
usuario varchar(20),
contraseña int(6),
saldo int,
cbu varchar(12) 
);



create table movimientos(
idMovimiento int(5) primary key auto_increment,
Usuario varchar(15),
tipoMovimiento varchar(10),
fecha date,
saldoMovimiento int(10),
saldoCajero int(10)
);


create table cajero(
idCajero int(5) primary key auto_increment,
usuario varchar(5),
montoCajero int(10)
);


insert into clientes (usuario,contraseña,saldo,cbu) VALUES ("nicolas2764",662520,5000,"2-13415213-5");
insert into clientes (usuario,contraseña,saldo,cbu) VALUES ("juan3421",432512,15400,"2-14213532-6");
insert into clientes (usuario,contraseña,saldo,cbu) VALUES ("rosales5431",352135,1000,"2-15148978-3");
insert into clientes (usuario,contraseña,saldo,cbu) VALUES ("perz5412",894213,100000,"2-12543653-9");
insert into cajero (usuario,montoCajero) VALUES ("admin",1000000);


select usuario,contraseña from clientes;
select * from movimientos;








