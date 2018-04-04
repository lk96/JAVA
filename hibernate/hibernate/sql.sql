create table students(
sid number primary key,
sname varchar2(10),
gender varchar2(10),
birthday Date,
address varchar2(50)

)
ALTER TABLE students ADD picture blob;