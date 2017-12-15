create table boardqna (
board_num number not null primary key,
board_name varchar2(20) not null,
board_pass varchar2(15) not null,
board_subject varchar2(150) not null,
board_content varchar2(2000) not null,
board_file varchar2(50) not null,
board_re_ref number not null,
board_re_lev number not null,
board_re_seq number not null,
board_readcount number default 0,
board_date date not null
);

insert into boardqna values (
1,
'홍길동',
'1234',
'QNA 게시판입니다.',
'퍼피코리아에 대해 궁금한 것을 물어보세요',
'up.jpg',
0,0,0,0,sysdate
);

create table boardreview (
board_num number not null primary key,
board_name varchar2(20) not null,
board_pass varchar2(15) not null,
board_subject varchar2(150) not null,
board_content varchar2(2000) not null,
board_file varchar2(50) not null,
board_re_ref number not null,
board_re_lev number not null,
board_re_seq number not null,
board_readcount number default 0,
board_date date not null
)