CREATE TABLE commodity (
  Id number NOT NULL,
  name varchar(100) DEFAULT NULL,
  price number DEFAULT NULL,
  unit varchar(50) DEFAULT NULL,
  category varchar(100) DEFAULT NULL,
  description varchar(1000) DEFAULT NULL,
  seller number DEFAULT NULL,
  PRIMARY KEY (Id)
);
INSERT INTO commodity VALUES (1,'��ʽͯװ',120,'��','ͯװ','��ʽͯװ',1);
INSERT INTO commodity VALUES (2,'Ůʿ��װ',200,'��','Ůװ','Ůʿְҵ��װ',1);
INSERT INTO commodity VALUES (3,'��ʿ����',200,'��','��װ','��ʿ������װ',1);
INSERT INTO commodity VALUES (4,'�ʼǱ�����',4000,'̨','����','˫�˱ʼǱ�����',2);
INSERT INTO commodity VALUES (5,'�ƶ�Ӳ��',400,'��','�����ܱ�','1t�ƶ�Ӳ��',2);
INSERT INTO commodity VALUES (6,'Һ������',5000,'̨','����','4k����Һ������',3);
INSERT INTO commodity VALUES (7,'��Ͳϴ�»�',4000,'̨','ϴ�»�','��Ͳϴ�»�',3);
INSERT INTO commodity VALUES (8,'��hibernate��̡�',30,'��','ʵ����','����hibernate���',4);
INSERT INTO commodity VALUES (9,'��Java���ġ�',50,'��','ʵ����','����Java��̺���',4);
INSERT INTO commodity VALUES (10,'�����������',40,'��','������','����ƻ�С˵',4);
INSERT INTO commodity VALUES (11,'����',30,'��','�����ܱ�','16G����',2);
CREATE TABLE customer (
  Id number NOT NULL ,
  name varchar(100) DEFAULT NULL,
  tel varchar(50) DEFAULT NULL,
  address varchar(1000) DEFAULT NULL,
  email varchar(300) DEFAULT NULL,
  sex varchar(30) DEFAULT NULL,
  description varchar(4000) DEFAULT NULL,
  age number DEFAULT NULL,
  birthday date DEFAULT NULL,
  PRIMARY KEY (Id)
);
INSERT INTO customer VALUES (1,'����','13800000000','�й��Ϻ�����������·','13800000000@138.com','��','�Ȱ���̵ĳ���Ա',25,sysdate);
INSERT INTO customer VALUES (2,'����','13888888888','�й���������������·','13888888888@138.com','Ů','�ᰮ�����İ���',20,sysdate);
INSERT INTO customer VALUES (3,'����','15888888888','�й����ڡ���������·','15888888888@158.com','��','����һ������ʲôҲû������',35,sysdate);
INSERT INTO customer VALUES (4,'����','13900000000',NULL,NULL,'��',NULL,40,sysdate);
CREATE TABLE orderform (
  Id number NOT NULL ,
  customer number DEFAULT NULL,
  tradedate date DEFAULT NULL,
  status varchar(10) DEFAULT NULL,
  amount number DEFAULT NULL,
  PRIMARY KEY (Id)
)
INSERT INTO orderform VALUES (1,1,sysdate,'���ջ�',4400);
INSERT INTO orderform VALUES (2,2,sysdate,'�ѷ���',520);
INSERT INTO orderform VALUES (3,3,sysdate,'�Ѹ���',9120);
CREATE TABLE orderitem (
  Id number NOT NULL ,
  ORDERID number DEFAULT NULL,
  COMMODITY number DEFAULT NULL,
  DISCOUNT number DEFAULT NULL,
  ACTPRICE number DEFAULT NULL,
  AMOUNT number DEFAULT NULL,
  PRIMARY KEY (Id)
)
INSERT INTO orderitem VALUES (1,1,4,1,4000,1);
INSERT INTO orderitem VALUES (2,1,5,1,400,1);
INSERT INTO orderitem VALUES (3,2,1,1,120,1);
INSERT INTO orderitem VALUES (4,2,2,1,200,1);
INSERT INTO orderitem VALUES (5,2,3,1,200,1);
INSERT INTO orderitem VALUES (6,3,6,1,5000,1);
INSERT INTO orderitem VALUES (7,3,7,1,4000,1);
INSERT INTO orderitem VALUES (8,3,8,1,30,1);
INSERT INTO orderitem VALUES (9,3,9,1,50,1);
INSERT INTO orderitem VALUES (10,3,10,1,40,1);
CREATE TABLE seller (
  Id number NOT NULL ,
  name varchar(100) DEFAULT NULL,
  tel varchar(1000) DEFAULT NULL,
  address varchar(2000) DEFAULT NULL,
  website varchar(500) DEFAULT NULL,
  star number DEFAULT NULL,
  business varchar(2000) DEFAULT NULL,
  PRIMARY KEY (Id)
)
INSERT INTO seller VALUES (1,'A��װ��','13000000000','�й�����������','www.a.com',5,'��Ӫ��ʽ��װ');
INSERT INTO seller VALUES (2,'B�����','15800000000','�й��㽭�����С�����','www.b.com',4,'��Ӫ����������Ӳ�Ʒ');
INSERT INTO seller VALUES (3,'C������','13012341234','�й��㶫�����С�����','www.c.com',4,'��Ӫ����ҵ�');
INSERT INTO seller VALUES (4,'D���','18600000000','�й����������С�����','www.d.com',5,'��Ӫ����ʵ�����������');