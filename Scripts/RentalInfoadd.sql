/*대여 sdj*/
insert into book_rental_info values(1,'2019-01-02',null,'2019-01-09' ,'S0001','6900000401');
select * from book_rental_info;

update book set rental_possible=0 where book_code='6900000401';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='S0001';



/*반납 sdj*/
update book_rental_info set return_date='2019-01-10' where member_no='S0001';
update member_rental_info set now_total=now_total+1 where member_no='S0001';
update proj_library.book set rental_possible=1 where  book_code='6900000401';


UPDATE proj_library.overdue
SET stop_date=1, overdue_count=1, rental_authority=0, stop_end_date='2019-01-11'
where member_no='S0001';



/*대여 kjy*/
insert into book_rental_info values(2,'2018-11-13',null, '2018-11-20','K0001','6900000402');
select * from book_rental_info;

update book set rental_possible=0 where book_code='6900000402';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='K0001';

/*반납 kjy*/
update book_rental_info set return_date='2018-11-18' where member_no='K0001';
update member_rental_info set now_total=now_total+1 where member_no='K0001';
update book set rental_possible=1 where  book_code='6900000402';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2018-11-18'
where member_no='K0001';



/*대여 lch*/
insert into book_rental_info values(3,'2018-12-30',null,'2019-01-06' ,'L0001','6900000403');
select * from book_rental_info;

update book set rental_possible=0 where book_code='6900000403';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='L0001';


/*반납 lch*/
update book_rental_info set return_date='2019-01-06' where member_no='L0001';
update member_rental_info set now_total=now_total+1 where member_no='L0001' ; 
update book set rental_possible=1 where  book_code='6900000403';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2019-01-06'
where member_no='L0001';




/*대여 hgs*/
insert into book_rental_info values(4,'2019-01-01',null,'2019-01-08' ,'H0001','6900000404');
select * from book_rental_info;

update book set rental_possible=0 where book_code='6900000404';

update member_rental_info set now_total=now_total-1, total=total+1 where  member_no='H0001';


/*반납 hgs*/
update book_rental_info set return_date='2019-01-07' where member_no='H0001';
update member_rental_info set now_total=now_total+1  where  member_no='H0001';
update book set rental_possible=1 where  book_code='6900000404';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2019-01-07'
where member_no='H0001';




/*대여 ljm*/
insert into book_rental_info values(10,'2019-01-01',null,'2019-01-08' ,'L0002','6900000405');
select * from book_rental_info;

update book set rental_possible=0 where book_code='6900000405';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='L0002';


/*반납 ljm*/
update book_rental_info set return_date='2019-01-08' where member_no='L0002';
update member_rental_info set now_total=now_total+1 where member_no='L0002';
update book set rental_possible=1 where  book_code='6900000405';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2019-01-08'
where member_no='L0002';




/*대여 kny*/
insert into book_rental_info values(5,'2018-12-01',null,'2018-12-08' ,'K0002','3890000501');
select * from book_rental_info;

update book set rental_possible=0 where book_code='3890000501';

update member_rental_info set now_total=now_total-1, total=total+1 where  member_no='K0002';


/*반납 kny*/
update book_rental_info set return_date='2018-12-13' where member_no='K0002';
update member_rental_info set now_total=now_total+1 where member_no='K0002';
update book set rental_possible=1 where  book_code='3890000501';

UPDATE proj_library.overdue
SET stop_date=5, overdue_count=5, rental_authority=0, stop_end_date='2018-12-18'
where member_no='K0002';




/*대여 psw*/
insert into book_rental_info values(6,'2018-12-10',null,'2018-12-18' ,'P0001','3890000502');
select * from book_rental_info;

update book set rental_possible=0 where book_code='3890000502';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='P0001';


/*반납 psw*/
update book_rental_info set return_date='2018-12-20' where member_no='P0001';
update member_rental_info set now_total=now_total+1 where member_no='P0001';
update book set rental_possible=1 where  book_code='3890000502';

UPDATE proj_library.overdue
SET stop_date=2, overdue_count=2, rental_authority=0, stop_end_date='2018-12-22'
where member_no='P0001';




/*대여 wsm*/
insert into book_rental_info values(7,'2018-12-23',null,'2018-12-30' ,'W0001','3890000503');
select * from book_rental_info;

update book set rental_possible=0 where book_code='3890000503';

update member_rental_info set now_total=now_total-1, total=total+1 where  member_no='W0001';


/*반납 wsm*/
update book_rental_info set return_date='2018-12-24' where member_no='W0001';
update member_rental_info set now_total=now_total+1  where member_no='W0001';
update book set rental_possible=1 where  book_code='3890000503';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2018-12-24'
where member_no='W0001';



/*대여 IU*/
insert into book_rental_info values(8,'2018-12-22',null,'2018-12-29' ,'U0001','3890000504');
select * from book_rental_info;

update book set rental_possible=0 where book_code='3890000504';

update member_rental_info set now_total=now_total-1, total=total+1 where  member_no='U0001';


/*반납 IU*/
update book_rental_info set return_date='2018-12-24' where member_no='U0001';
update member_rental_info set now_total=now_total+1 where member_no='U0001';
update book set rental_possible=1 where  book_code='3890000504';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2018-12-24'
where member_no='U0001';





/*대여 uhj*/
insert into book_rental_info values(9,'2018-12-10',null,'2018-12-24' ,'I0001','3890000505');
select * from book_rental_info;

update book set rental_possible=0 where book_code='3890000505';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no= 'I0001';


/*반납 uhj*/
update book_rental_info set return_date='2018-12-21' where member_no='I0001';
update member_rental_info set now_total=now_total+1 where member_no='I0001';
update book set rental_possible=1 where  book_code='3890000505';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2018-12-21'
where member_no='I0002';










/*----------------------------------------------------------------------------------------------------------------*/




/*1번 대여한 사람*/
insert into book_rental_info values(11,'2019-01-02',null,'2019-01-09' ,'P0002','1180001801');
select * from book_rental_info;

update book set rental_possible=0 where book_code='1180001801';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='P0002';


/*3번 대여한 사람(더 이상 대여 불가)*/
insert into book_rental_info values(12,'2019-01-02',null,'2019-01-09' ,'P0003','1180001802');
select * from book_rental_info;

update book set rental_possible=0 where book_code='1180001802';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='P0003';



insert into book_rental_info values(13,'2019-01-02',null,'2019-01-09' ,'P0003','1180001803');
select * from book_rental_info;

update book set rental_possible=0 where book_code='1180001803';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='P0003';



insert into book_rental_info values(14,'2019-01-02',null,'2019-01-09' ,'P0003','1180001804');
select * from book_rental_info;

update book set rental_possible=0 where book_code='1180001804';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no='P0003';



/*연체한 사람*/
insert into book_rental_info values(15,'2018-12-25',null,'2018-01-01' ,'P0004','1180001805');
select * from book_rental_info;

update book set rental_possible=0 where book_code='1180001805';

update member_rental_info set now_total=now_total-1, total=total+1 where member_no= 'P0004';



update book_rental_info set return_date='2018-01-04' where member_no='P0004';
update member_rental_info set now_total=now_total+1 where member_no='P0004';
update book set rental_possible=1 where  book_code='1180001805';

UPDATE proj_library.overdue
SET stop_date=3, overdue_count=3, rental_authority=0, stop_end_date='2018-01-07'
where member_no='P0004';





/*반납한 사람*/

insert into book_rental_info values(16,'2018-12-23',null,'2018-12-30' ,'P0005','1180001901');
select * from book_rental_info;

update book set rental_possible=0 where book_code='1180001901';

update member_rental_info set now_total=now_total-1, total=total+1 where  member_no='P0005';



update book_rental_info set return_date='2018-12-24' where member_no='P0005';
update member_rental_info set now_total=now_total+1  where member_no='P0005';
update book set rental_possible=1 where  book_code='1180001901';

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2018-12-24'
where member_no='P0005';



