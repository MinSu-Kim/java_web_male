INSERT INTO proj_library.`day`
(daty)
VALUES(NOW());

select datediff(daty, now())
from day;

INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('K0001', PASSWORD('dnlqh1220!'), '김재영', 'KJY', '010-9986-5500', concat(left('950316-1111111',8),password(right('950316-1111111',6))), 'rlawpdud301@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','차승원.jpg', true, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('K0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('K0001', 1, 3, 0);
		
	
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('S0001', PASSWORD('dnlqh1220!'), '서동준', 'SDJ', '010-2230-6796', concat(left('910702-1111111',8),password(right('910702-1111111',6))), 'superdongte@naver.com', '41863대구광역시 서구 통학로 17 1, 5층','고창석.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('S0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('S0001', 1, 3, 0);
		
	
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('H0001', PASSWORD('dnlqh1220!'), '황경수', 'HKS', '010-2204-4493', concat(left('000316-1111111',8),password(right('000316-1111111',6))), 'krilln@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','김흥국.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('H0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('H0001', 1, 3, 0);
		

INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('L0001', PASSWORD('dnlqh1220!'), '이천희', 'LCH', '010-5505-0468', concat(left('930121-1111111',8),password(right('930121-1111111',6))), 'rephanoise@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','마동석.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('L0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('L0001', 1, 3, 0);
		
	
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('U0001', PASSWORD('dnlqh1220!'), '유해진', 'UHJ', '010-0000-0000', concat(left('670121-1111111',8),password(right('670121-1111111',6))), 'aaaaaa@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','유해진.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('U0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('U0001', 1, 3, 0);
		
	
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('P0001', PASSWORD('dnlqh1220!'), '박수완', 'PSW', '010-5155-2701', concat(left('940101-2111111',8),password(right('940101-2111111',6))), 'psw2701@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','common.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('P0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('P0001', 1, 3, 0);
		
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('I0001', PASSWORD('dnlqh1220!'), '아이유', 'IU', '010-0000-0000', concat(left('930101-2111111',8),password(right('930101-2111111',6))), 'IU2701@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','아이유.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('I0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('I0001', 1, 3, 0);
		
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('W0001', PASSWORD('dnlqh1220!'), '우선미', 'WSM', '010-9962-8837', concat(left('940104-2111111',8),password(right('940104-2111111',6))), ',mia_3@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','수지.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('W0001', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('W0001', 1, 3, 0);
	
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('L0002', PASSWORD('dnlqh1220!'), '이준민', 'LJM', '010-0000-0000', concat(left('920101-1111111',8),password(right('920101-1111111',6))), ',rlawpdud301@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','이승기.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('L0002', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('L0002', 1, 3, 0);

	
	
INSERT INTO proj_library.`member`
(member_no, password, kor_name, eng_name, phone, jumin, email, address, photo, admin, uniqueness)
VALUES('K0002', PASSWORD('dnlqh1220!'), '김나영', 'KNY', '010-0000-0000', concat(left('920101-2111111',8),password(right('920101-2111111',6))), ',rlawpdud301@naver.com', '41863대구광역시 서구 통학로 17 1, 1층','박지나.jpg', false, null);

insert into proj_library.overdue (member_no, stop_date, overdue_count, rental_authority, stop_end_date)
		values ('K0002', 0, 0, 1, now());
		
insert into proj_library.member_rental_info (member_no, grade, now_total, total)
		values ('K0002', 1, 3, 0);
		
