insert into proj_library.member (member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
values('L0010', password('asdf123!'), '이천희', 'LCH', '010-5505-0468', concat(left('930121-1010101',8),password(right('930121-1010101',6))), 'rephanoise@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','나연.jpg', true, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
values ('L0010', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
values ('L0010', 1, 3, 0);
		
insert into proj_library.member (member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
values('L0011', password('asdf123!'), '이천희', 'LCH', '010-5505-0468', concat(left('930121-2010101',8),password(right('930121-2010101',6))), 'rephanoise@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','나연.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
values ('L0011', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
values ('L0011', 1, 3, 0);
		
insert into proj_library.book_rental_info
values (100, '2018-10-12', '2018-10-18', '2018-10-19', 'L0011', '1370000601');

insert into proj_library.book_rental_info
values (101, '2018-10-12', '2018-10-18', '2018-10-19', 'L0011', '1840001001');

insert into proj_library.book_rental_info
values (102, '2018-10-12', '2018-10-18', '2018-10-19', 'L0011', '2440000901');

insert into proj_library.book_rental_info
values (103, '2018-11-05', '2018-11-10', '2018-11-12', 'L0011', '3270001101');

insert into proj_library.book_rental_info
values (104, '2018-11-05', '2018-11-10', '2018-11-12', 'L0011', '3990000801');

insert into proj_library.book_rental_info
values (105, '2018-11-05', '2018-11-10', '2018-11-12', 'L0011', '6900000403');

insert into proj_library.book_rental_info
values (106, '2018-11-15', '2018-11-20', '2018-11-22', 'L0011', '3890000501');

insert into proj_library.book_rental_info
values (107, '2018-11-27', '2018-12-1', '2018-12-4', 'L0011', '5600000301');

insert into proj_library.book_rental_info
values (108, '2018-11-27', '2018-12-1', '2018-12-4', 'L0011', '2220000104');

insert into proj_library.book_rental_info
values (109, '2018-12-31', null, '2018-1-7', 'L0011', '8000001602');

insert into proj_library.book_rental_info
values (110, '2018-12-31', null, '2018-1-7', 'L0011', '9000001702');