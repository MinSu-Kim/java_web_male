insert into category_b values('0','총류');
insert into category_m values('0','0','총류');
insert into category_s values('0','0','0','총류');
insert into publisher values('P001','영남인제교육원');

INSERT INTO proj_library.book
(book_code, book_no, pub_no, author, translator, title, price, rental_possible, image, cate_s_no, cate_m_no, cate_b_no)
VALUES('00001', 0, 'P001', '김재영', '김재영', '자바의 정석', 40000, true, NULL, 0, 0, 0);

