create view bestMember as select substring(m.jumin,8,1) as sex,m.member_no as member_no, m.kor_name, m.admin, rental_date,b.cate_b_no,b.cate_m_no,b.cate_s_no
FROM book_rental_info i join `member` m on i.member_no=m.member_no join book b on i.book_code=b.book_code;

create view bestsaler as select left(i.book_code,8) as bc, b.title, b.author ,p.pub_name,left(i.rental_date,7)as rental_date,b.cate_b_no,b.cate_m_no,b.cate_s_no
FROM book_rental_info i join book b on i.book_code=b.book_code join publisher p on b.pub_no=p.pub_no;
show create view bestsaler;
drop view bestsaler;