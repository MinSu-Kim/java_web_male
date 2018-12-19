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
