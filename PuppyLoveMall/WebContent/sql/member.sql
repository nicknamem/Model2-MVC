create table member (
id varchar2(30) primary key,
pw varchar2(20) not null,
name varchar2(20) not null,
age number not null,
gender varchar2(10) not null,
email varchar2(30) not null,
tel varchar2(20) not null,
addr varchar2(100) not null
);

desc member

-- 1 --
insert into member values (
'admin',
'1234',
'관리자',
30,
'M',
'admin@puppy.pu',
'010-1234-1234',
'서울시 영등포구 여의도동'
);

-- 2 --
insert into member values (
'aaa',
'1234',
'홍길동',
30,
'M',
'aaa@aaa.com',
'010-1234-1234',
'서울시 영등포구 여의도동'
);

-- 3 --
insert into member values (
'bbb',
'1234',
'고길동',
40,
'M',
'bbb@bbb.com',
'010-2345-6435',
'서울시 영등포구 대도동'
);

-- 3 --
insert into member values (
'ccc',
'1234',
'김길동',
40,
'M',
'ccc@ccc.com',
'010-2345-6435',
'서울시 영등포구 대도동'
);

select * from member