-- ������
DROP SCHEMA IF EXISTS proj_library;

-- ������
CREATE SCHEMA proj_library;

-- å
CREATE TABLE proj_library.Book (
	book_code    CHAR    NOT NULL COMMENT '�з���ȣ+�ѹ���+�ߺ��Ǽ�', -- ������ȣ
	book_no      int     NOT NULL COMMENT '�Ϸù�ȣ', -- �Ϸù�ȣ
	title        CHAR    NULL     COMMENT '������', -- ǥ��
	writter      CHAR    NULL     COMMENT '�۰�', -- ����
	translator   CHAR    NULL     COMMENT '����', -- ����
	priece       INT     NULL     COMMENT '��������', -- ����
	publisher    CHAR    NULL     COMMENT '���ǻ�', -- ���ǻ�
	rentable     BOOLEAN NOT NULL COMMENT '�뿩 ���� ����', -- �뿩���ɿ���
	image        CHAR    NULL     COMMENT '���� ����', -- �̹���
	categoryno_s CHAR    NULL     COMMENT '�Һз�', -- �Һз�
	categoryno_m CHAR    NULL     COMMENT '�ߺз�', -- �ߺз�
	categoryno_b CHAR    NULL     COMMENT '��з�' -- ��з�
)
COMMENT 'å';

-- å
ALTER TABLE proj_library.Book
	ADD CONSTRAINT PK_Book -- å �⺻Ű
		PRIMARY KEY (
			book_code -- ������ȣ
		);

-- ȸ��
CREATE TABLE proj_library.member (
	member_no CHAR        NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	password  VARCHAR(14) NOT NULL COMMENT '��й�ȣ', -- ��й�ȣ
	kor_name  char        NOT NULL COMMENT '�ѱ��̸�', -- �ѱ��̸�
	eng_name  char        NOT NULL COMMENT '�����̸�', -- �����̸�
	phone     CHAR        NOT NULL COMMENT '��ȭ��ȣ', -- ��ȭ��ȣ
	jumin     CHAR        NOT NULL COMMENT '�ֹε�Ϲ�ȣ', -- �ֹε�Ϲ�ȣ
	email     CHAR        NOT NULL COMMENT '�̸���', -- �̸���
	address   CHAR        NOT NULL COMMENT '�ּ�', -- �ּ�
	photo     CHAR        NULL     COMMENT '����', -- ����
	admin     BOOLEAN     NOT NULL COMMENT '������', -- ������
	memo      CHAR        NULL     COMMENT '�޸�' -- �޸�
)
COMMENT 'ȸ��';

-- ȸ��
ALTER TABLE proj_library.member
	ADD CONSTRAINT PK_member -- ȸ�� �⺻Ű
		PRIMARY KEY (
			member_no -- ȸ����ȣ
		);

-- �����뿩����
CREATE TABLE proj_library.book_rent_info (
	rentno     int  NOT NULL COMMENT '�뿩��ȣ', -- �뿩��ȣ
	member_no  CHAR NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	rentdate   DATE NULL     COMMENT '�뿩����', -- �뿩����
	returndate DATE NULL     COMMENT '�ݳ�����', -- �ݳ�����
	book_code  CHAR NULL     COMMENT '������ȣ' -- ������ȣ
)
COMMENT '�����뿩����';

-- �����뿩����
ALTER TABLE proj_library.book_rent_info
	ADD CONSTRAINT PK_book_rent_info -- �����뿩���� �⺻Ű
		PRIMARY KEY (
			rentno -- �뿩��ȣ
		);

-- ��ü����
CREATE TABLE proj_library.overdue (
	member_no    CHAR    NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	blacklist    BOOLEAN NULL     COMMENT '������Ʈ', -- ������Ʈ
	stopdate     int     NULL     COMMENT '���������', -- ���������
	overduecount int     NULL     COMMENT '��üȽ��' -- ��üȽ��
)
COMMENT '��ü����';

-- ��ü����
ALTER TABLE proj_library.overdue
	ADD CONSTRAINT PK_overdue -- ��ü���� �⺻Ű
		PRIMARY KEY (
			member_no -- ȸ����ȣ
		);

-- �Һз�
CREATE TABLE proj_library.category_s (
	categoryno_s CHAR NOT NULL COMMENT '�Һз�', -- �Һз�
	categoryno_m CHAR NOT NULL COMMENT '�ߺз�', -- �ߺз�
	categoryno_b CHAR NOT NULL COMMENT '��з�', -- ��з�
	thema_s      CHAR NOT NULL COMMENT '�帣' -- �帣
)
COMMENT '�Һз�';

-- �Һз�
ALTER TABLE proj_library.category_s
	ADD CONSTRAINT PK_category_s -- �Һз� �⺻Ű
		PRIMARY KEY (
			categoryno_s, -- �Һз�
			categoryno_m, -- �ߺз�
			categoryno_b  -- ��з�
		);

-- ȸ���뿩����
CREATE TABLE proj_library.member_rent_info (
	member_no CHAR   NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	now_total INT(1) NULL     COMMENT '�뿩�߰���', -- �뿩�߰���
	total     INT    NULL     COMMENT '�Ѵ뿩����', -- �Ѵ뿩����
	grade     INT(1) NULL     COMMENT '���' -- ���
)
COMMENT 'ȸ���뿩����';

-- ȸ���뿩����
ALTER TABLE proj_library.member_rent_info
	ADD CONSTRAINT PK_member_rent_info -- ȸ���뿩���� �⺻Ű
		PRIMARY KEY (
			member_no -- ȸ����ȣ
		);

-- �ߺз�
CREATE TABLE proj_library.category_m (
	categoryno_m CHAR NOT NULL COMMENT '�ߺз�', -- �ߺз�
	categoryno_b CHAR NOT NULL COMMENT '��з�', -- ��з�
	thema_m      CHAR NOT NULL COMMENT '�帣' -- �帣
)
COMMENT '�ߺз�';

-- �ߺз�
ALTER TABLE proj_library.category_m
	ADD CONSTRAINT PK_category_m -- �ߺз� �⺻Ű
		PRIMARY KEY (
			categoryno_m, -- �ߺз�
			categoryno_b  -- ��з�
		);

-- ��з�
CREATE TABLE proj_library.category_b (
	categoryno_b CHAR NOT NULL COMMENT '��з�', -- ��з�
	thema_b      CHAR NOT NULL COMMENT '�帣' -- �帣
)
COMMENT '��з�';

-- ��з�
ALTER TABLE proj_library.category_b
	ADD CONSTRAINT PK_category_b -- ��з� �⺻Ű
		PRIMARY KEY (
			categoryno_b -- ��з�
		);

-- å
ALTER TABLE proj_library.Book
	ADD CONSTRAINT FK_category_s_TO_Book -- �Һз� -> å
		FOREIGN KEY (
			categoryno_s, -- �Һз�
			categoryno_m, -- �ߺз�
			categoryno_b  -- ��з�
		)
		REFERENCES proj_library.category_s ( -- �Һз�
			categoryno_s, -- �Һз�
			categoryno_m, -- �ߺз�
			categoryno_b  -- ��з�
		);

-- �����뿩����
ALTER TABLE proj_library.book_rent_info
	ADD CONSTRAINT FK_member_TO_book_rent_info -- ȸ�� -> �����뿩����
		FOREIGN KEY (
			member_no -- ȸ����ȣ
		)
		REFERENCES proj_library.member ( -- ȸ��
			member_no -- ȸ����ȣ
		);

-- �����뿩����
ALTER TABLE proj_library.book_rent_info
	ADD CONSTRAINT FK_Book_TO_book_rent_info -- å -> �����뿩����
		FOREIGN KEY (
			book_code -- ������ȣ
		)
		REFERENCES proj_library.Book ( -- å
			book_code -- ������ȣ
		);

-- ��ü����
ALTER TABLE proj_library.overdue
	ADD CONSTRAINT FK_member_TO_overdue -- ȸ�� -> ��ü����
		FOREIGN KEY (
			member_no -- ȸ����ȣ
		)
		REFERENCES proj_library.member ( -- ȸ��
			member_no -- ȸ����ȣ
		);

-- �Һз�
ALTER TABLE proj_library.category_s
	ADD CONSTRAINT FK_category_m_TO_category_s -- �ߺз� -> �Һз�
		FOREIGN KEY (
			categoryno_m, -- �ߺз�
			categoryno_b  -- ��з�
		)
		REFERENCES proj_library.category_m ( -- �ߺз�
			categoryno_m, -- �ߺз�
			categoryno_b  -- ��з�
		);

-- ȸ���뿩����
ALTER TABLE proj_library.member_rent_info
	ADD CONSTRAINT FK_member_TO_member_rent_info -- ȸ�� -> ȸ���뿩����
		FOREIGN KEY (
			member_no -- ȸ����ȣ
		)
		REFERENCES proj_library.member ( -- ȸ��
			member_no -- ȸ����ȣ
		);

-- �ߺз�
ALTER TABLE proj_library.category_m
	ADD CONSTRAINT FK_category_b_TO_category_m -- ��з� -> �ߺз�
		FOREIGN KEY (
			categoryno_b -- ��з�
		)
		REFERENCES proj_library.category_b ( -- ��з�
			categoryno_b -- ��з�
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
