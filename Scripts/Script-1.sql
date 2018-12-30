select count(*)+1 from book
where book_code like substring(book_code, 0, 8);

select max(book_no + 1) from book;

select substring(book_code, 0, 8)

select max(book_no + 1) from book
		where book_no;
		
insert into book_rental_info values
(1, '2017-12-18', null, '2017-12-25', 1, 0070041005),
(2, '2017-12-18', null, '2017-12-25', 1, 1110012301);

insert into member values
('L00001', 'asdf', '이천희', 'lch', '010-1234-5678', '123456-1234567', 'asdf@naver.com', '대구광역시 달서구', '이미지 경로', 2,'없음'),
('L00002', 'asdf', '이차니', 'lch', '010-1234-5678', '123456-1234567', 'asdf@naver.com', '대구광역시 달서구', '이미지 경로', 1,'없음'),
('L00003', 'asdf', '이쩌늬', 'lch', '010-1234-5678', '123456-1234567', 'asdf@naver.com', '대구광역시 달서구', '이미지 경로', 2,'없음');

insert into book values
('1230012505', 125, 'asdf', 'asdf', 'asdf', 1111, false, null, 1, 2, 3, null);

select * from book;
select * from book_rental_info;

select b.book_code, b.title, p.pub_name, b.author, bri.rental_date, bri.return_schedule
from book_rental_info as bri
join book as b on b.book_code = bri.book_code
join publisher as p on p.pub_no = b.pub_no
where member_no = 'L00001';

select * from book_rental_info where member_no = 'L00001';

INSERT INTO book_rental_info values
(3, '2018-12-24', '2019-01-01', null, 'A0002', '0040000201'),
(4, '2018-12-24', '2019-01-04', null, 'A0002', '0110000301');

insert into publisher values
('P001', '호우출판'),
('P002', '오라클');

select c.cate_b_name
from book_rental_info as bri
join book as b on b.book_code = bri.book_code
JOIN category_b as c on b.cate_b_no = c.cate_b_no
where member_no = 2;

select count(b.cate_b_no)
from book_rental_info as bri
join book as b on b.book_code = bri.book_code
where member_no = 2 and b.cate_b_no = '0';

select * from publisher;

select * from `member`;

select *
from member
where member_no = 'L0001' and password = '*5FEFDAF71624A2DAA56E303A03AC7A428C6A6652';

select b.*, cb.cate_b_name, cm.cate_m_name, cs.cate_s_name, p.pub_name
from book as b
join category_b as cb on b.cate_b_no = cb.cate_b_no
join category_m as cm on b.cate_m_no = cm.cate_m_no
join category_s as cs on b.cate_m_no = cs.cate_m_no
join publisher as p on b.pub_no = p.pub_no
where b.book_code = '0110000301'
and cb.cate_b_no =b.cate_b_no
and cm.cate_m_no = b.cate_m_no
and cm.cate_b_no = cb.cate_b_no
and cs.cate_s_no = b.cate_s_no
and cs.cate_m_no = cm.cate_m_no
and cs.cate_b_no = cb.cate_b_no
and p.pub_no = b.pub_no;

update book set author='윤성우',
		translator='신민철', title='열혈자바', price=7600,
		rental_possible=1, image=null,
		pub_no='P0001'
		WHERE book_code='0040000201';