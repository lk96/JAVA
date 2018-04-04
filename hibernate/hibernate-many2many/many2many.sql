create table project
(
  proid number(20) primary key,
  proname varchar(20) not null
);

create table employee
(
  empid number(20) primary key,
  empname varchar(20)
);

create table proemp
(
  rproid number(20),
  rempid number(20)
);

alter table proemp add constraint fk_rproid 
  foreign key (rproid) references project(proid);
alter table proemp add constraint fk_rempid
  foreign key (rempid) references employee(empid);  