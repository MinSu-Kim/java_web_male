-- proj_library
DROP SCHEMA IF EXISTS proj_library;

-- proj_library
CREATE SCHEMA proj_library;

-- 책
CREATE TABLE proj_library.book (
	book_code       VARCHAR(50) NOT NULL COMMENT '도서번호', -- 도서번호
	book_no         INT(11)     NOT NULL COMMENT '일련번호', -- 일련번호
	author          VARCHAR(50) NULL     COMMENT '저자', -- 저자
	translator      VARCHAR(50) NULL     COMMENT '역자', -- 역자
	title           VARCHAR(50) NULL     COMMENT '도서명', -- 도서명
	price           INT(11)     NULL     COMMENT '도서가격', -- 도서가격
	rental_possible TINYINT(1)  NOT NULL COMMENT '대여가능여부', -- 대여가능여부
	image           VARCHAR(50) NULL     COMMENT '도서사진', -- 도서사진
	cate_s_no       INT(1)      NULL     COMMENT '소분류', -- 소분류
	cate_m_no       INT(1)      NULL     COMMENT '중분류', -- 중분류
	cate_b_no       INT(1)      NULL     COMMENT '대분류', -- 대분류
	pub_no          VARCHAR(50) NULL     COMMENT '출판사번호' -- 출판사번호
)
COMMENT '책';

-- 책
ALTER TABLE proj_library.book
	ADD CONSTRAINT
		PRIMARY KEY (
			book_code -- 도서번호
		);

-- 도서대여정보
CREATE TABLE proj_library.book_rental_info (
	rental_no       INT(11)     NOT NULL COMMENT '대여번호', -- 대여번호
	rental_date     DATE        NULL     COMMENT '대여일자', -- 대여일자
	return_date     DATE        NULL     COMMENT '반납일자', -- 반납일자
	return_schedule DATE        NULL     COMMENT '반납예정일', -- 반납예정일
	member_no       VARCHAR(50) NOT NULL COMMENT '회원번호', -- 회원번호
	book_code       VARCHAR(50) NULL     COMMENT '도서번호' -- 도서번호
)
COMMENT '도서대여정보';

-- 도서대여정보
ALTER TABLE proj_library.book_rental_info
	ADD CONSTRAINT
		PRIMARY KEY (
			rental_no -- 대여번호
		);

ALTER TABLE proj_library.book_rental_info
	MODIFY COLUMN rental_no INT(11) NOT NULL AUTO_INCREMENT COMMENT '대여번호';

ALTER TABLE proj_library.book_rental_info
	AUTO_INCREMENT = 1;

-- 대분류
CREATE TABLE proj_library.category_b (
	cate_b_no   INT(1)      NOT NULL COMMENT '대분류', -- 대분류
	cate_b_name VARCHAR(50) NOT NULL COMMENT '분류명' -- 분류명
)
COMMENT '대분류';

-- 대분류
ALTER TABLE proj_library.category_b
	ADD CONSTRAINT
		PRIMARY KEY (
			cate_b_no -- 대분류
		);

-- 중분류
CREATE TABLE proj_library.category_m (
	cate_m_no   INT(1)      NOT NULL COMMENT '중분류', -- 중분류
	cate_b_no   INT(1)      NOT NULL COMMENT '대분류', -- 대분류
	cate_m_name VARCHAR(50) NOT NULL COMMENT '분류명' -- 분류명
)
COMMENT '중분류';

-- 중분류
ALTER TABLE proj_library.category_m
	ADD CONSTRAINT
		PRIMARY KEY (
			cate_m_no, -- 중분류
			cate_b_no  -- 대분류
		);

-- 소분류
CREATE TABLE proj_library.category_s (
	cate_s_no   INT(1)      NOT NULL COMMENT '소분류', -- 소분류
	cate_m_no   INT(1)      NOT NULL COMMENT '중분류', -- 중분류
	cate_b_no   INT(1)      NOT NULL COMMENT '대분류', -- 대분류
	cate_s_name VARCHAR(50) NOT NULL COMMENT '분류명' -- 분류명
)
COMMENT '소분류';

-- 소분류
ALTER TABLE proj_library.category_s
	ADD CONSTRAINT
		PRIMARY KEY (
			cate_s_no, -- 소분류
			cate_m_no, -- 중분류
			cate_b_no  -- 대분류
		);

-- 회원
CREATE TABLE proj_library.member (
	member_no  VARCHAR(50)  NOT NULL COMMENT '회원번호', -- 회원번호
	password   VARCHAR(50)  NOT NULL COMMENT '비밀번호', -- 비밀번호
	kor_name   VARCHAR(50)  NOT NULL COMMENT '한글이름', -- 한글이름
	eng_name   VARCHAR(50)  NULL     COMMENT '영어이름', -- 영어이름
	phone      VARCHAR(50)  NOT NULL COMMENT '전화번호', -- 전화번호
	jumin      VARCHAR(50)  NOT NULL COMMENT '주민등록번호', -- 주민등록번호
	email      VARCHAR(100) NOT NULL COMMENT '이메일', -- 이메일
	address    VARCHAR(255) NOT NULL COMMENT '주소', -- 주소
	photo      VARCHAR(100) NULL     COMMENT '사진', -- 사진
	admin      TINYINT(1)   NOT NULL COMMENT '관리자', -- 관리자
	uniqueness VARCHAR(255) NULL     COMMENT '특이사항' -- 특이사항
)
COMMENT '회원';

-- 회원
ALTER TABLE proj_library.member
	ADD CONSTRAINT
		PRIMARY KEY (
			member_no -- 회원번호
		);

-- 회원대여정보
CREATE TABLE proj_library.member_rental_info (
	member_no VARCHAR(50) NOT NULL COMMENT '회원번호', -- 회원번호
	grade     INT(1)      NULL     COMMENT '등급', -- 등급
	now_total INT(1)      NULL     COMMENT '대여가능권수', -- 대여가능권수
	total     INT(4)      NULL     COMMENT '총대여권수' -- 총대여권수
)
COMMENT '회원대여정보';



-- 회원대여정보
ALTER TABLE proj_library.member_rental_info
	ADD CONSTRAINT
		PRIMARY KEY (
			member_no -- 회원번호
		);

-- 연체정보
CREATE TABLE proj_library.overdue (
	member_no        VARCHAR(50) NOT NULL COMMENT '회원번호', -- 회원번호
	stop_date        INT(11)     NULL     COMMENT '정지일수', -- 정지일수
	overdue_count    INT(11)     NULL     COMMENT '연체횟수', -- 연체횟수
	rental_authority TINYINT(1)  NULL     COMMENT '대여권한', -- 대여권한
	overdue_date     Date		 null     COMMENT '연체날짜'  -- 연체날짜
)
COMMENT '연체정보';

drop table proj_library.overdue;
-- 연체정보
ALTER TABLE proj_library.overdue
	ADD CONSTRAINT
		PRIMARY KEY (
			member_no -- 회원번호
		);

-- 출판사
CREATE TABLE proj_library.publisher (
	pub_no   VARCHAR(50) NOT NULL COMMENT '출판사번호', -- 출판사번호
	pub_name VARCHAR(50) NULL     COMMENT '출판사명' -- 출판사명
)
COMMENT '출판사';

-- 출판사
ALTER TABLE proj_library.publisher
	ADD CONSTRAINT
		PRIMARY KEY (
			pub_no -- 출판사번호
		);

-- 우편번호
CREATE TABLE proj_library.post (
	zipcode   char(5)     NULL COMMENT '우편번호', -- 우편번호
	sido      VARCHAR(20) NULL COMMENT '시도', -- 시도
	sigungu   VARCHAR(20) NULL COMMENT '시군구', -- 시군구
	eupmyeon  VARCHAR(20) NULL COMMENT '읍면', -- 읍면
	doro      VARCHAR(80) NULL COMMENT '도로명', -- 도로명
	building1 INT(5)      NULL COMMENT '건물번호1', -- 건물번호1
	building2 INT(5)      NULL COMMENT '건물번호2' -- 건물번호2
)
COMMENT '우편번호';

create table day (
	daty date null
);

-- 책
ALTER TABLE proj_library.book
	ADD CONSTRAINT FK_category_s_TO_Book -- FK_category_s_TO_Book
		FOREIGN KEY (
			cate_s_no, -- 소분류
			cate_m_no, -- 중분류
			cate_b_no  -- 대분류
		)
		REFERENCES proj_library.category_s ( -- 소분류
			cate_s_no, -- 소분류
			cate_m_no, -- 중분류
			cate_b_no  -- 대분류
		),
	ADD INDEX FK_category_s_TO_Book (
		cate_s_no, -- 소분류
		cate_m_no, -- 중분류
		cate_b_no  -- 대분류
	);

-- 책
ALTER TABLE proj_library.book
	ADD CONSTRAINT FK_publisher_TO_Book -- FK_publisher_TO_Book
		FOREIGN KEY (
			pub_no -- 출판사번호
		)
		REFERENCES proj_library.publisher ( -- 출판사
			pub_no -- 출판사번호
		),
	ADD INDEX FK_publisher_TO_Book (
		pub_no -- 출판사번호
	);

-- 도서대여정보
ALTER TABLE proj_library.book_rental_info
	ADD CONSTRAINT FK_Book_TO_book_rent_info -- FK_Book_TO_book_rent_info
		FOREIGN KEY (
			book_code -- 도서번호
		)
		REFERENCES proj_library.book ( -- 책
			book_code -- 도서번호
		)ON UPDATE CASCADE,
		
	ADD INDEX FK_Book_TO_book_rent_info (
		book_code -- 도서번호
	);

-- 도서대여정보
ALTER TABLE proj_library.book_rental_info
	ADD CONSTRAINT FK_member_TO_book_rent_info -- FK_member_TO_book_rent_info
		FOREIGN KEY (
			member_no -- 회원번호
		)
		REFERENCES proj_library.member ( -- 회원
			member_no -- 회원번호
		)ON UPDATE CASCADE,
	ADD INDEX FK_member_TO_book_rent_info (
		member_no -- 회원번호
	);

-- 중분류
ALTER TABLE proj_library.category_m
	ADD CONSTRAINT FK_category_b_TO_category_m -- FK_category_b_TO_category_m
		FOREIGN KEY (
			cate_b_no -- 대분류
		)
		REFERENCES proj_library.category_b ( -- 대분류
			cate_b_no -- 대분류
		),
	ADD INDEX FK_category_b_TO_category_m (
		cate_b_no -- 대분류
	);

-- 소분류
ALTER TABLE proj_library.category_s
	ADD CONSTRAINT FK_category_m_TO_category_s -- FK_category_m_TO_category_s
		FOREIGN KEY (
			cate_m_no, -- 중분류
			cate_b_no  -- 대분류
		)
		REFERENCES proj_library.category_m ( -- 중분류
			cate_m_no, -- 중분류
			cate_b_no  -- 대분류
		),
	ADD INDEX FK_category_m_TO_category_s (
		cate_m_no, -- 중분류
		cate_b_no  -- 대분류
	);

-- 회원대여정보
ALTER TABLE proj_library.member_rental_info
	ADD CONSTRAINT FK_member_TO_member_rent_info -- FK_member_TO_member_rent_info
		FOREIGN KEY (
			member_no -- 회원번호
		)
		REFERENCES proj_library.member ( -- 회원
			member_no -- 회원번호
		)ON UPDATE CASCADE;

-- 연체정보
ALTER TABLE proj_library.overdue
	ADD CONSTRAINT FK_member_TO_overdue -- FK_member_TO_overdue
		FOREIGN KEY (
			member_no -- 회원번호
		)
		REFERENCES proj_library.member ( -- 회원
			member_no -- 회원번호
		)ON UPDATE CASCADE;
		
CREATE USER 'user_library'@'%';
ALTER USER 'user_library'@'%'
IDENTIFIED BY 'rootroot' ;
GRANT Alter ON proj_library.* TO 'user_library'@'%';
GRANT Create ON proj_library.* TO 'user_library'@'%';
GRANT Create view ON proj_library.* TO 'user_library'@'%';
GRANT Delete ON proj_library.* TO 'user_library'@'%';
GRANT Drop ON proj_library.* TO 'user_library'@'%';
GRANT Grant option ON proj_library.* TO 'user_library'@'%';
GRANT Index ON proj_library.* TO 'user_library'@'%';
GRANT Insert ON proj_library.* TO 'user_library'@'%';
GRANT References ON proj_library.* TO 'user_library'@'%';
GRANT Select ON proj_library.* TO 'user_library'@'%';
GRANT Show view ON proj_library.* TO 'user_library'@'%';
GRANT Trigger ON proj_library.* TO 'user_library'@'%';
GRANT Update ON proj_library.* TO 'user_library'@'%';
GRANT Alter routine ON proj_library.* TO 'user_library'@'%';
GRANT Create routine ON proj_library.* TO 'user_library'@'%';
GRANT Create temporary tables ON proj_library.* TO 'user_library'@'%';
GRANT Execute ON proj_library.* TO 'user_library'@'%';
GRANT Lock tables ON proj_library.* TO 'user_library'@'%';
FLUSH PRIVILEGES;

CREATE USER 'user_library'@'localhost';
ALTER USER 'user_library'@'localhost'
IDENTIFIED BY 'rootroot' ;
GRANT Alter ON proj_library.* TO 'user_library'@'localhost';
GRANT Create ON proj_library.* TO 'user_library'@'localhost';
GRANT Create view ON proj_library.* TO 'user_library'@'localhost';
GRANT Delete ON proj_library.* TO 'user_library'@'localhost';
GRANT Drop ON proj_library.* TO 'user_library'@'localhost';
GRANT Grant option ON proj_library.* TO 'user_library'@'localhost';
GRANT Index ON proj_library.* TO 'user_library'@'localhost';
GRANT Insert ON proj_library.* TO 'user_library'@'localhost';
GRANT References ON proj_library.* TO 'user_library'@'localhost';
GRANT Select ON proj_library.* TO 'user_library'@'localhost';
GRANT Show view ON proj_library.* TO 'user_library'@'localhost';
GRANT Trigger ON proj_library.* TO 'user_library'@'localhost';
GRANT Update ON proj_library.* TO 'user_library'@'localhost';
GRANT Alter routine ON proj_library.* TO 'user_library'@'localhost';
GRANT Create routine ON proj_library.* TO 'user_library'@'localhost';
GRANT Create temporary tables ON proj_library.* TO 'user_library'@'localhost';
GRANT Execute ON proj_library.* TO 'user_library'@'localhost';
GRANT Lock tables ON proj_library.* TO 'user_library'@'localhost';
FLUSH PRIVILEGES;
