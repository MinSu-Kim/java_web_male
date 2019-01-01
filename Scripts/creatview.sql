use proj_library;

create view bestMember as select substring(m.jumin,8,1) as sex,m.member_no as member_no, m.kor_name, m.admin, rental_date,b.cate_b_no,b.cate_m_no,b.cate_s_no
FROM book_rental_info i join `member` m on i.member_no=m.member_no join book b on i.book_code=b.book_code;

create view bestsaler as select left(i.book_code,8) as bc, b.title, b.author ,p.pub_name,left(i.rental_date,7)as rental_date,b.cate_b_no,b.cate_m_no,b.cate_s_no,c.cate_b_name
FROM book_rental_info i join book b on i.book_code=b.book_code join publisher p on b.pub_no=p.pub_no join category_b c on c.cate_b_no=b.cate_b_no;
show create view bestsaler;
drop view bestsaler;

create view OverduePopup as select m.kor_name,b.title, r.rental_date,r.return_schedule,m.phone,r.return_date,DATEDIFF(NOW(),return_schedule) as overday
from book_rental_info r join `member` m on r.member_no=m.member_no join book b on r.book_code=b.book_code
where NOW()>return_schedule
and return_date is null 
group by kor_name;


drop view OverduePopup;

SELECT kor_name, title, rental_date, return_schedule, phone, return_date, overday
FROM proj_library.overduepopup;


---- 프로시저 생성하기 -----
delimiter $$
CREATE PROCEDURE `proj_library`.`search_membername`(in korname char(50))
begin
	select kor_name, member_no, phone, jumin
	from member
	where kor_name regexp korname;
end
delimiter ;
------ search_membernoRent ------
DELIMITER $$
CREATE DEFINER=`user_library`@`localhost` PROCEDURE `proj_library`.`search_membernoRent`(in memberno char(50))
begin
	select b.book_code, title, rental_date, return_schedule
	from member m join book_rental_info r on m.member_no = r.member_no
	join book b on b.book_code =  r.book_code
	where m.member_no regexp memberno;
END
DELIMITER ;
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
CREATE DEFINER=`user_library`@`localhost` PROCEDURE `proj_library`.`search_memberno`(in memberno char(50))
begin
	select kor_name, member_no, jumin, phone
	from `member`
	where member_no regexp memberno;
END
DELIMITER ;