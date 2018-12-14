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

insert into book_rental_info values(5,'2018-12-10','2018-12-17',null,'2','0000000001');
insert into book_rental_info values(6,'2018-12-11','2018-12-17',null,'3','0000000002');
---- 프로시저 생성하기 -----
delimiter $$
CREATE PROCEDURE `proj_library`.`search_membername`(in korname char(50))
begin
	select kor_name, m.member_no, title, rental_date, return_date, return_schedule
from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where kor_name= korname;
end 
delimiter ;

delimiter $$
CREATE PROCEDURE `proj_library`.`search_memberno`(in memberno char(50))
begin
	select kor_name, m.member_no, title, rental_date, return_date, return_schedule
from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where m.member_no= memberno;
END	
delimiter ;

delimiter $$
CREATE PROCEDURE `proj_library`.`search_phone`(in phonenum char(30))
begin
	select kor_name, m.member_no, title, rental_date, return_date, return_schedule
	from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where phone= phonenum;
END
delimiter ;
SELECT *
from book_rental_info;

delete 
from book_rental_info
where rental_no = 2;

insert into book_rental_info
values (7,'2018-12-10',null,'2018-12-17' ,'2','1110000005');



SELECT *
from member;

insert into `member` values("3","gfkrtkf", "서동준", "kiggay","01022306796","921012","tjehdxo2002@","비밀","하핫",1,"하말없음");
select kor_name, phone, jumin
from `member` where kor_name="개동준";

call search_memberno("2");
call search_membername("김동준");
call search_phone("01022306796");
call search_jumin("921012");

call search_membername("서동준");
call search_memberno("3");
call search_phone("010-4354-2435");

select kor_name, m.member_no, title, rental_date, return_date, return_schedule
from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where kor_name="김동준";


select member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, memo
from member;

INSERT INTO proj_library.book
(book_code, book_no, pub_no, author, translator, title, price, rental_possible, image, cate_s_no, cate_m_no, cate_b_no)
VALUES('1110000005', 0, 'P001', '김재영', '김재영', '자바의 정석', 40000, true, null, 0, 0, 0);

insert into proj_library.book
(book_code, book_no, pub_no, author, translator, title, price, rental_possible, image, cate_s_no, cate_m_no, cate_b_no)
values('0000000002', 0, 'P001', '서동준','서동준', 'web개발', 20000,true, null, 0, 0 ,0);

SELECT * FROM book;
select * from book_rental_info;
select * from publisher;

SELECT cate_m_no, cate_b_no, cate_m_name
		FROM proj_library.category_m
		WHERE cate_b_no=1;
	
insert into publisher values('P001', null);
		

	
SELECT cate_s_no, cate_m_no, cate_b_no, cate_s_name FROM proj_library.category_s WHERE cate_m_no=1 AND cate_b_no=1;

select * from `member`;

insert into `member` values("3","asdf", "이천희", "lch","01022306796","921012","tjehdxo2002@","비밀","하핫",0,"하말없음");

select * from book WHERE book_code REGEXP '00001';




/*post*/
LOAD data LOCAL INFILE 'D:/workspace_project/java_web_male/DataFiles/대구광역시.txt' INTO table post
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
VALUES(123, '1111', '김재영', 'kjy', '01099865500', '950316-1111111', 'rlawpdud301@naver.com', '우리집', null, true, null);

INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES(1234, '1111', '김재영', 'kjy', '01099865500', '950316-1111111', 'rlawpdud301@naver.com', '우리집', null, false, null);

