insert into category_b values('0','총류');
insert into category_m values('0','0','총류');
insert into category_s values('0','0','0','총류');
insert into publisher values('P001','영남인제교육원');
insert into book_rental_info values(3,'2018-12-10','2018-12-17',null,'2','00001');

SELECT *
from member;
insert into `member` values("1","gfkrtkf", "서동준", "kiggay","01022306796","921012","tjehdxo2002@","비밀","하핫",1,"하말없음");
select kor_name, phone, jumin
from `member` where kor_name="김동준";

call search_memberno("2");
call search_name("김동준");
call search_phone("01022306796");
call search_jumin("921012");

select kor_name, m.member_no, title,rental_date, return_date, return_schedule
from member m left outer join book_rental_info r on m.member_no = r.rental_no
	left outer join book b on b.book_code =  r.rental_no
	where kor_name="김동준";
select member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, memo
from member;

INSERT INTO proj_library.book
(book_code, book_no, pub_no, author, translator, title, price, rental_possible, image, cate_s_no, cate_m_no, cate_b_no)
VALUES('00001', 0, 'P001', '김재영', '김재영', '자바의 정석', 40000, true, NULL, 0, 0, 0);

>>>>>>> branch 'master' of https://github.com/MinSu-Kim/java_web_male.git

SELECT * FROM book;
select * from book_rental_info;
select * from publisher;

SELECT cate_m_no, cate_b_no, cate_m_name
		FROM proj_library.category_m
		WHERE cate_b_no=1;