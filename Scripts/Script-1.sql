select count(*)+1 from book
where book_code like substring(book_code, 0, 8);

select max(book_no + 1) from book;

select substring(book_code, 0, 8)

select max(book_no + 1) from book
		where book_no;
		
insert into book_rental_info values
(1, '2017-12-18', null, '2017-12-25', 2, 5030000701),
(2, '2017-12-18', null, '2017-12-25', 2, 3600000301);