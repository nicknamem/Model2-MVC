create table puppy (
id number not null primary key,
kind varchar2(60) not null,
price number not null,
image varchar2(40) not null,
country varchar2(30) not null,
height number,
weight number,
content varchar2(4000),
readcount number
);

create sequence puppy_seq increment by 1 start with 1;

commit

-- 1
insert into puppy values(
puppy_seq.nextval,
'푸들',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);

insert into puppy values(
puppy_seq.nextval,
'',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);

insert into puppy values(
puppy_seq.nextval,
'푸들',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);

insert into puppy values(
puppy_seq.nextval,
'푸들',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);

insert into puppy values(
puppy_seq.nextval,
'푸들',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);

insert into puppy values(
puppy_seq.nextval,
'푸들',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);

insert into puppy values(
puppy_seq.nextval,
'푸들',
1000000,
'pu.jpg',
'프랑스',
1,
20,
'털이많다',
0
);