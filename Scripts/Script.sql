insert into category_b values('0','총류');
insert into category_m values('0','0','총류');
insert into category_s values('0','0','0','총류');
insert into category_s values('0','1','1',' 저작');
insert into category_s values('0','2','1', '도서관 행정 및 재정');
insert into category_s values('0','3','1','한국어');
insert into category_s values('0','4','1','한국어');
insert into category_s values('0','5','1','한국어');
insert into category_s values('0','6','1','아시아 일반 학회,단체 등');
insert into category_s values('0','7','1','아시아 신문,저널리즘 등');
insert into category_s values('1','1','4','공간');
insert into publisher values('P001','영남인제교육원');

INSERT INTO proj_library.book_rental_info
(rental_date, return_date, return_schedule, member_no, book_code)
VALUES('', '', '', '', '');



insert into book_rental_info values(1,'2018-12-10',null,'2018-12-17','J0011','0000000001');
insert into book_rental_info values(6,'2018-12-11','2018-12-17',null,'J0011','0000000003');
---- 프로시저 생성하기 -----
delimiter $$
CREATE PROCEDURE `proj_library`.`search_membername`(in korname char(50))
begin
	select kor_name, member_no, phone, jumin
	from member
	where kor_name regexp korname;
end $$
delimiter ;
------ search_membernoRent ------
delimiter $$
CREATE PROCEDURE `proj_library`.`search_membernoRent`(in memberno char(50))
begin
	select kor_name, member_no, title, rental_date, return_date, return_schedule
	from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where m.member_no regexp memberno;
END	
delimiter ;
--------- search_phone ------------
delimiter $$
CREATE PROCEDURE `proj_library`.`search_phone`(in phonenum char(30))
begin
	select kor_name, member_no, phone, jumin
	from member
	where phone regexp phonenum;
END
delimiter ;
------- search_memberno--------
DELIMITER $$
$$
CREATE DEFINER=`user_library`@`localhost` PROCEDURE `proj_library`.`search_memberno`(in memberno char(50))
begin
	select kor_name, member_no, jumin, phone
	from `member`
	where member_no regexp memberno;
END$$
DELIMITER ;

DELIMITER $$
$$
CREATE DEFINER=`user_library`@`localhost` PROCEDURE `proj_library`.`search_test`(in memberno char(50))
begin
	select kor_name, member_no, jumin, phone
	from `member`
	where member_no regexp memberno;
END$$
DELIMITER ;

call search_test("T");

SELECT *
from book_rental_info;

delete 
from book_rental_info
where rental_no = 2;

insert into book_rental_info
values (7,'2018-12-10',null,'2018-12-17' ,'2','1110000005');



SELECT *
from member;

select *
from overdue;

select *
from member_rental_info;
insert into `member` values("3","gfkrtkf", "서동준", "kiggay","01022306796","921012-1647545","tjehdxo2002@","비밀","하핫",1,"하말없음");

insert into member values("10",password("king"),"노예1","slave1","010-2343-4533", concat(left('201012-1685651', 8),password(right('201012-1685651', 6)) ),"slave@naever.com","비밀","히히",0,"저는 노예입니다.");

select kor_name, phone, jumin
from `member` where kor_name="개동준";


select '201012-1685651', left('201012-1685651', 6), password(right('201012-1685651', 7)), concat(left('201012-1685651', 6), '-',password(right('201012-1685651', 7)) );


select jumin
from member
where member_no = 'S0002';

select jumin, jumin('921012-1685616')
from `member`
where member_no = 's0002';

call search_memberno("2");
call search_membername("김동준");
call search_phone("01022306796");
call search_jumin("921012");

call search_membername("서동준");
call search_memberno("3");
call search_phone("010-4354-2435");
call search_membernoRent("3");
select kor_name, m.member_no, title, rental_date, return_date, return_schedule
from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where kor_name="김동준";


INSERT INTO proj_library.book
(book_code, book_no, pub_no, author, translator, title, price, rental_possible, image, cate_s_no, cate_m_no, cate_b_no)
VALUES('2210000005', 0, 'P001', '김재영', '김재영', '자바의 정석', 40000, true, null, 2, 2, 1);

insert into proj_library.book
(book_code, book_no, pub_no, author, translator, title, price, rental_possible, image, cate_s_no, cate_m_no, cate_b_no)
values('0000000002', 0, 'P001', '서동준','서동준', 'web개발', 20000,true, null, 0, 0 ,0);

SELECT * FROM book;
select * from book_rental_info;
select * from publisher;

SELECT cate_m_no, cate_b_no, cate_m_name
		FROM proj_library.category_m
		WHERE cate_b_no=1;
	
insert into publisher values('P001', '오라클');
		

	
SELECT cate_s_no, cate_m_no, cate_b_no, cate_s_name FROM proj_library.category_s WHERE cate_m_no=1 AND cate_b_no=1;

select * from `member`;

insert into `member` values("1","asdf", "이천희", "lch","01022306796","921012","tjehdxo2002@","비밀","하핫",0,"하말없음");

select * from book WHERE book_code REGEXP '00001';

/*post*/
LOAD data LOCAL INFILE 'D:/worksapce_project/java_web_male/DataFiles/대구광역시.txt' INTO table post
character set 'euckr'
fields TERMINATED by '|'
IGNORE 1 lines
(@zipcode,@sido,@d,@sigungu,@d,@eupmyeon,@d,@d,@doro,@d,@d,@building1,@building2,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, eupmyeon=@eupmyeon, doro=@doro, building1=@building1, building2=@building2

/*post 서동준꺼*/
LOAD data LOCAL INFILE 'D:/workspace-project/java_web_male/DataFiles/대구광역시.txt' INTO table post
character set 'euckr'
fields TERMINATED by '|'
IGNORE 1 lines
(@zipcode,@sido,@d,@sigungu,@d,@eupmyeon,@d,@d,@doro,@d,@d,@building1,@building2,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, eupmyeon=@eupmyeon, doro=@doro, building1=@building1, building2=@building2



CREATE INDEX idx_post_sido On post(sido);
CREATE INDEX idx_post_doro ON post(doro);

select * from post
where doro = '통학로';

LOAD data LOCAL INFILE '대구광역시.txt' INTO table post
character set 'euckr'
fields TERMINATED by '|'
IGNORE 1 lines
(@zipcode,@sido,@d,@sigungu,@d,@eupmyeon,@d,@d,@doro,@d,@d,@building1,@building2,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, eupmyeon=@eupmyeon, doro=@doro, building1=@building1, building2=@building2



SELECT zipcode, sido, sigungu, eupmyeon, doro, building1, building2
FROM proj_library.post
where sido like '%%';

delete
from book
where book_code = 001158;





INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('J0011', '1111', '김재영', 'kjy', '01099865500', '950316-1111111', 'rlawpdud301@naver.com', '우리집', null, true, null);

INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES(1234, '1111', '김재영', 'kjy', '01099865500', '950316-1111111', 'rlawpdud301@naver.com', '우리집', null, false, null);


select * from member_rental_info;

delete 
from member_rental_info
where member_no = '123';

select * from overdue;

delete 
from overdue
where member_no = '123';

delete 
from member
where member_no ='123';


select o.member_no, o.rental_authority
from member m join overdue o on m.member_no = o.member_no
where o.member_no='123';



create view bestsaler as select left(i.book_code,8) as bc, b.title, b.author ,p.pub_name,left(i.rental_date,7)as rental_date,b.cate_b_no,b.cate_m_no,b.cate_s_no
FROM book_rental_info i join book b on i.book_code=b.book_code join publisher p on b.pub_no=p.pub_no;
show create view bestsaler;
drop view bestsaler;

select *, count(bc) as ranking 
from bestsaler 
where rental_date regexp '2018-1' and bc IN('11100000','00000000','00001')
group by bc limit 0,10;


SELECT rental_no, rental_date, return_date, return_schedule, member_no, book_code
FROM proj_library.book_rental_info
where book_code regexp '^[0][0-9]+$' ;


select * from `member`;
select * from member_rental_info;
select * from overdue;
delete from overdue where member_no = '123';
insert into overdue values(123,0,0,0,null);
insert into overdue values(2,0,0,0,null);

INSERT INTO proj_library.book_rental_info
(rental_date, return_date, return_schedule, member_no, book_code)
VALUES('2018-11-10', '2018-11-10', '2018-11-10', 123, '0000000001');


create view bestMember as select substring(m.jumin,8,1) as sex,m.member_no as member_no, m.kor_name, m.admin, rental_date,b.cate_b_no,b.cate_m_no,b.cate_s_no
FROM book_rental_info i join `member` m on i.member_no=m.member_no join book b on i.book_code=b.book_code;



drop view bestMember;

select *, count(member_no) as ranking 
from bestmember
where rental_date regexp '2018-' and member_no like '12%' and admin =1
group by member_no limit 0,10;


insert into member_rental_info values ('2',1,3,0);
insert into member_rental_info values ('123',1,3,0);

select total from Member_rental_info
		where member_no='2';
	
	
	update Member_rental_info set total = total+1 where member_no='2';

select * from book_rental_info;

select * from member_rental_info;

select * from overdue;

select * from book;

select * from book
where left(book_code, 1) != 'D'

select rental_no FROM proj_library.book_rental_info
   		where book_code='00001';
   	create
or replace
view `bestsaler` as select
    left(`i`.`book_code`,
    8) as `bc`,
    `b`.`title` as `title`,
    `b`.`author` as `author`,
    `p`.`pub_name` as `pub_name`,
    left(`i`.`rental_date`,
    7) as `rental_date`,
    `b`.`cate_b_no` as `cate_b_no`,
    `b`.`cate_m_no` as `cate_m_no`,
    `b`.`cate_s_no` as `cate_s_no`,
    `c`.`cate_b_name` as `cate_b_name`
from
    (((`book_rental_info` `i`
join `book` `b` on
    ((`i`.`book_code` = `b`.`book_code`)))
join `publisher` `p` on
    ((`b`.`pub_no` = `p`.`pub_no`)))
join `category_b` `c` on
    ((`b`.`cate_b_no` = `c`.`cate_b_no`)));


   
   create
or replace
view `bestmember` as select
    substr(`m`.`jumin`,
    8,
    1) as `sex`,
    `m`.`member_no` as `member_no`,
    `m`.`kor_name` as `kor_name`,
    `m`.`admin` as `admin`,
    `i`.`rental_date` as `rental_date`,
    `b`.`cate_b_no` as `cate_b_no`,
    `b`.`cate_m_no` as `cate_m_no`,
    `b`.`cate_s_no` as `cate_s_no`
from
    ((`book_rental_info` `i`
join `member` `m` on
    ((`i`.`member_no` = `m`.`member_no`)))
join `book` `b` on
    ((`i`.`book_code` = `b`.`book_code`)));
update overdue set stop_date = 3 ;
   	
   	select rental_no, member_no, return_date, return_schedule, rental_date FROM proj_library.book_rental_info
   		where book_code='00001' and return_date is null;
   	
select member_no, stop_date, overdue_count, rental_authority, overdue_date from overdue
where member_no='2';

UPDATE proj_library.book
		SET book_code='D0000000001'
		WHERE book_code='0000000001';
select member_no, password, kor_name, eng_name, phone,
		replace(jumin,regexp_substr(jumin,'[[:digit:]]{6}-*[[:digit:]]{7}',1,1)
             ,substr(replace(regexp_substr(jumin,'[[:digit:]]{6}-*[[:digit:]]{7}',1,1),'-'),1,7)||'******') jumin, email, address, photo, admin, uniqueness
		from member;
=======
select * from overdue;

select *,Datediff(stop_end_date, now())
from overdue;


update overdue 
set rental_authority = 1
where Datediff(stop_end_date, now()) < 1;

update overdue set stop_date = if(Datediff(stop_end_date, now())< 1, 0, Datediff(stop_end_date, now())) , rental_authority = if(Datediff(stop_end_date, now())< 1,   1, 0);


select * from book_rental_info;
