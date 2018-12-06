-- 도서관
DROP SCHEMA IF EXISTS proj_library;

-- 도서관
CREATE SCHEMA proj_library;

-- 책
CREATE TABLE proj_library.Book (
	book_code    CHAR               NOT NULL COMMENT '분류번호+넘버링+중복권수', -- 도서번호
	book_no      int                NOT NULL COMMENT '일련번호', -- 일련번호
	publisher_no INT NULL     COMMENT '출판사번호', -- 출판사번호
	writter      CHAR               NULL     COMMENT '저자', -- 저자
	translator   CHAR               NULL     COMMENT '역자', -- 역자
	title        CHAR               NULL     COMMENT '도서명', -- 표제
	priece       INT                NULL     COMMENT '도서가격', -- 가격
	rentable     BOOLEAN            NOT NULL COMMENT '대여 가능 여부', -- 대여가능여부
	image        CHAR               NULL     COMMENT '도서 사진', -- 이미지
	categoryno_s CHAR               NULL     COMMENT '소분류', -- 소분류
	categoryno_m CHAR               NULL     COMMENT '중분류', -- 중분류
	categoryno_b CHAR               NULL     COMMENT '대분류' -- 대분류
)
COMMENT '책';

-- 책
ALTER TABLE proj_library.Book
	ADD CONSTRAINT PK_Book -- 책 기본키
		PRIMARY KEY (
			book_code -- 도서번호
		);

-- 회원
CREATE TABLE proj_library.member (
	member_no CHAR        NOT NULL COMMENT '회원번호', -- 회원번호
	password  VARCHAR(14) NOT NULL COMMENT '비밀번호', -- 비밀번호
	kor_name  char        NOT NULL COMMENT '한글이름', -- 한글이름
	eng_name  char        NOT NULL COMMENT '영어이름', -- 영어이름
	phone     CHAR        NOT NULL COMMENT '전화번호', -- 전화번호
	jumin     CHAR        NOT NULL COMMENT '주민등록번호', -- 주민등록번호
	email     CHAR        NOT NULL COMMENT '이메일', -- 이메일
	address   CHAR        NOT NULL COMMENT '주소', -- 주소
	photo     CHAR        NULL     COMMENT '사진', -- 사진
	admin     BOOLEAN     NOT NULL COMMENT '관리자', -- 관리자
	memo      CHAR        NULL     COMMENT '메모' -- 메모
)
COMMENT '회원';

-- 회원
ALTER TABLE proj_library.member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			member_no -- 회원번호
		);

-- 도서대여정보
CREATE TABLE proj_library.book_rent_info (
	rentno         int  NOT NULL COMMENT '대여번호', -- 대여번호
	member_no      CHAR NOT NULL COMMENT '회원번호', -- 회원번호
	rentdate       DATE NULL     COMMENT '대여일자', -- 대여일자
	returndate     DATE NULL     COMMENT '반납일자', -- 반납일자
	returnschedule DATE NULL     COMMENT '반납예정일', -- 반납예정일
	book_code      CHAR NULL     COMMENT '도서번호' -- 도서번호
)
COMMENT '도서대여정보';

-- 도서대여정보
ALTER TABLE proj_library.book_rent_info
	ADD CONSTRAINT PK_book_rent_info -- 도서대여정보 기본키
		PRIMARY KEY (
			rentno -- 대여번호
		);

-- 연체정보
CREATE TABLE proj_library.overdue (
	member_no    CHAR    NOT NULL COMMENT '회원번호', -- 회원번호
	blacklist    BOOLEAN NULL     COMMENT '블랙리스트', -- 블랙리스트
	stopdate     int     NULL     COMMENT '사용정지일', -- 사용정지일
	overduecount int     NULL     COMMENT '연체횟수' -- 연체횟수
)
COMMENT '연체정보';

-- 연체정보
ALTER TABLE proj_library.overdue
	ADD CONSTRAINT PK_overdue -- 연체정보 기본키
		PRIMARY KEY (
			member_no -- 회원번호
		);

-- 소분류
CREATE TABLE proj_library.category_s (
	categoryno_s CHAR NOT NULL COMMENT '소분류', -- 소분류
	categoryno_m CHAR NOT NULL COMMENT '중분류', -- 중분류
	categoryno_b CHAR NOT NULL COMMENT '대분류', -- 대분류
	thema_s      CHAR NOT NULL COMMENT '장르' -- 장르
)
COMMENT '소분류';

-- 소분류
ALTER TABLE proj_library.category_s
	ADD CONSTRAINT PK_category_s -- 소분류 기본키
		PRIMARY KEY (
			categoryno_s, -- 소분류
			categoryno_m, -- 중분류
			categoryno_b  -- 대분류
		);

-- 회원대여정보
CREATE TABLE proj_library.member_rent_info (
	member_no CHAR   NOT NULL COMMENT '회원번호', -- 회원번호
	now_total INT(1) NULL     COMMENT '대여중갯수', -- 대여중갯수
	total     INT    NULL     COMMENT '총대여갯수', -- 총대여갯수
	grade     INT(1) NULL     COMMENT '등급' -- 등급
)
COMMENT '회원대여정보';

-- 회원대여정보
ALTER TABLE proj_library.member_rent_info
	ADD CONSTRAINT PK_member_rent_info -- 회원대여정보 기본키
		PRIMARY KEY (
			member_no -- 회원번호
		);

-- 중분류
CREATE TABLE proj_library.category_m (
	categoryno_m CHAR NOT NULL COMMENT '중분류', -- 중분류
	categoryno_b CHAR NOT NULL COMMENT '대분류', -- 대분류
	thema_m      CHAR NOT NULL COMMENT '장르' -- 장르
)
COMMENT '중분류';

-- 중분류
ALTER TABLE proj_library.category_m
	ADD CONSTRAINT PK_category_m -- 중분류 기본키
		PRIMARY KEY (
			categoryno_m, -- 중분류
			categoryno_b  -- 대분류
		);

-- 대분류
CREATE TABLE proj_library.category_b (
	categoryno_b CHAR NOT NULL COMMENT '대분류', -- 대분류
	thema_b      CHAR NOT NULL COMMENT '장르' -- 장르
)
COMMENT '대분류';

-- 대분류
ALTER TABLE proj_library.category_b
	ADD CONSTRAINT PK_category_b -- 대분류 기본키
		PRIMARY KEY (
			categoryno_b -- 대분류
		);

-- 출판사
CREATE TABLE proj_library.TABLE (
	publisher_no INT NOT NULL COMMENT '출판사번호', -- 출판사번호
	name         INT NULL     COMMENT '출판사명' -- 출판사명
)
COMMENT '출판사';

-- 출판사
ALTER TABLE proj_library.TABLE
	ADD CONSTRAINT PK_TABLE -- 출판사 기본키
		PRIMARY KEY (
			publisher_no -- 출판사번호
		);

-- 책
ALTER TABLE proj_library.Book
	ADD CONSTRAINT FK_category_s_TO_Book -- 소분류 -> 책
		FOREIGN KEY (
			categoryno_s, -- 소분류
			categoryno_m, -- 중분류
			categoryno_b  -- 대분류
		)
		REFERENCES proj_library.category_s ( -- 소분류
			categoryno_s, -- 소분류
			categoryno_m, -- 중분류
			categoryno_b  -- 대분류
		);

-- 책
ALTER TABLE proj_library.Book
	ADD CONSTRAINT FK_TABLE_TO_Book -- 출판사 -> 책
		FOREIGN KEY (
			publisher_no -- 출판사번호
		)
		REFERENCES proj_library.TABLE ( -- 출판사
			publisher_no -- 출판사번호
		);

-- 도서대여정보
ALTER TABLE proj_library.book_rent_info
	ADD CONSTRAINT FK_member_TO_book_rent_info -- 회원 -> 도서대여정보
		FOREIGN KEY (
			member_no -- 회원번호
		)
		REFERENCES proj_library.member ( -- 회원
			member_no -- 회원번호
		);

-- 도서대여정보
ALTER TABLE proj_library.book_rent_info
	ADD CONSTRAINT FK_Book_TO_book_rent_info -- 책 -> 도서대여정보
		FOREIGN KEY (
			book_code -- 도서번호
		)
		REFERENCES proj_library.Book ( -- 책
			book_code -- 도서번호
		);

-- 연체정보
ALTER TABLE proj_library.overdue
	ADD CONSTRAINT FK_member_TO_overdue -- 회원 -> 연체정보
		FOREIGN KEY (
			member_no -- 회원번호
		)
		REFERENCES proj_library.member ( -- 회원
			member_no -- 회원번호
		);

-- 소분류
ALTER TABLE proj_library.category_s
	ADD CONSTRAINT FK_category_m_TO_category_s -- 중분류 -> 소분류
		FOREIGN KEY (
			categoryno_m, -- 중분류
			categoryno_b  -- 대분류
		)
		REFERENCES proj_library.category_m ( -- 중분류
			categoryno_m, -- 중분류
			categoryno_b  -- 대분류
		);

-- 회원대여정보
ALTER TABLE proj_library.member_rent_info
	ADD CONSTRAINT FK_member_TO_member_rent_info -- 회원 -> 회원대여정보
		FOREIGN KEY (
			member_no -- 회원번호
		)
		REFERENCES proj_library.member ( -- 회원
			member_no -- 회원번호
		);

-- 중분류
ALTER TABLE proj_library.category_m
	ADD CONSTRAINT FK_category_b_TO_category_m -- 대분류 -> 중분류
		FOREIGN KEY (
			categoryno_b -- 대분류
		)
		REFERENCES proj_library.category_b ( -- 대분류
			categoryno_b -- 대분류
		);
		
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
