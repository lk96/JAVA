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
INSERT INTO commodity VALUES (1,'中式童装',120,'套','童装','中式童装',1);
INSERT INTO commodity VALUES (2,'女士套装',200,'套','女装','女士职业套装',1);
INSERT INTO commodity VALUES (3,'男士西服',200,'套','男装','男士西服套装',1);
INSERT INTO commodity VALUES (4,'笔记本电脑',4000,'台','电脑','双核笔记本电脑',2);
INSERT INTO commodity VALUES (5,'移动硬盘',400,'块','电脑周边','1t移动硬盘',2);
INSERT INTO commodity VALUES (6,'液晶电视',5000,'台','电视','4k高清液晶电视',3);
INSERT INTO commodity VALUES (7,'滚筒洗衣机',4000,'台','洗衣机','滚筒洗衣机',3);
INSERT INTO commodity VALUES (8,'《hibernate编程》',30,'本','实体书','介绍hibernate编程',4);
INSERT INTO commodity VALUES (9,'《Java核心》',50,'本','实体书','介绍Java编程核心',4);
INSERT INTO commodity VALUES (10,'《海底两万里》',40,'本','电子书','经典科幻小说',4);
INSERT INTO commodity VALUES (11,'优盘',30,'个','电脑周边','16G优盘',2);
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
INSERT INTO customer VALUES (1,'张三','13800000000','中国上海××区××路','13800000000@138.com','男','热爱编程的程序员',25,sysdate);
INSERT INTO customer VALUES (2,'李四','13888888888','中国北京××区××路','13888888888@138.com','女','酷爱网购的白领',20,sysdate);
INSERT INTO customer VALUES (3,'王五','15888888888','中国深圳××区××路','15888888888@158.com','男','这个家伙很懒，什么也没有留下',35,sysdate);
INSERT INTO customer VALUES (4,'赵六','13900000000',NULL,NULL,'男',NULL,40,sysdate);
CREATE TABLE orderform (
  Id number NOT NULL ,
  customer number DEFAULT NULL,
  tradedate date DEFAULT NULL,
  status varchar(10) DEFAULT NULL,
  amount number DEFAULT NULL,
  PRIMARY KEY (Id)
)
INSERT INTO orderform VALUES (1,1,sysdate,'已收货',4400);
INSERT INTO orderform VALUES (2,2,sysdate,'已发货',520);
INSERT INTO orderform VALUES (3,3,sysdate,'已付款',9120);
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
INSERT INTO seller VALUES (1,'A服装店','13000000000','中国北京××区','www.a.com',5,'经营各式服装');
INSERT INTO seller VALUES (2,'B数码店','15800000000','中国浙江杭州市××区','www.b.com',4,'经营各类数码电子产品');
INSERT INTO seller VALUES (3,'C电器店','13012341234','中国广东深圳市××区','www.c.com',4,'经营各类家电');
INSERT INTO seller VALUES (4,'D书店','18600000000','中国陕西西安市××区','www.d.com',5,'经营各类实体书与电子书');