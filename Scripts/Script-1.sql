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
(1, '2018-12-24', '2019-01-01', null, 'L00001', '1110000301'),
(2, '2018-12-24', '2019-01-04', null, 'L00001', '1110000201');

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