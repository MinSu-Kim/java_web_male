INSERT INTO proj_library.book_rental_info
(rental_date, return_date, return_schedule, member_no, book_code)
VALUES('2018-12-30', null, '2019-01-06', 'P0001', '0390000201');

UPDATE proj_library.overdue
SET stop_date=0, overdue_count=0, rental_authority=1, stop_end_date='2019-01-02'
WHERE member_no='P0001';

UPDATE proj_library.member_rental_info
SET grade=0, now_total=1, total=1
WHERE member_no='P0001';


