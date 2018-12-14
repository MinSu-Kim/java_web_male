select count(*)+1 from book
where book_code like substring(book_code, 0, 8);

select max(book_no + 1) from book;

select substring(book_code, 0, 8)

select max(book_no + 1) from book
		where book_no;