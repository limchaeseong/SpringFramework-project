------------테이블 확인------------
SELECT * FROM CM;          --게시글 댓글 테이블
SELECT * FROM PHOTO;       --게시글 사진 테이블
SELECT * FROM BOARD;       --게시판 테이블
SELECT * FROM MM;          --모임 인원 테이블
SELECT * FROM MT;          --모임 테이블
SELECT * FROM MEMBER;      --회원 테이블
SELECT * FROM AP;          --모임 가입 테이블
SELECT * FROM CLUB;        --모임 테이블
SELECT * FROM CG;          --모임 카테고리 테이블
SELECT * FROM AD;          --관리자 테이블
SELECT * FROM ACCOUNT;     --계정 테이블

------------테이블 제약조건 확인------------
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='CM';          --게시글 댓글 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='PHOTO';       --게시글 사진 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='BOARD';       --게시판 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='MM';          --모임 인원 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='MT';          --모임 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='MEMBER';      --회원 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='AP';          --모임 가입 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='CLUB';        --모임 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='CG';          --모임 카테고리 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='AD';          --관리자 테이블
SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='ACCOUNT';     --계정 테이블

------------현재 시퀀스값 확인------------
SELECT CM_ID.CURRVAL FROM DUAL;    --게시글 댓글 시퀀스
SELECT P_ID.CURRVAL FROM DUAL;     --게시글 사진 시퀀스
SELECT B_ID.CURRVAL FROM DUAL;     --게시판 시퀀스
SELECT MM_ID.CURRVAL FROM DUAL;    --모임 인원 시퀀스
SELECT MT_ID.CURRVAL FROM DUAL;    --모임 시퀀스
SELECT M_ID.CURRVAL FROM DUAL;     --회원 시퀀스
SELECT AP_ID.CURRVAL FROM DUAL;    --모임 가입 시퀀스
SELECT C_ID.CURRVAL FROM DUAL;     --모임 시퀀스
SELECT CG_ID.CURRVAL FROM DUAL;    --모임 카테고리 시퀀스
SELECT AD_ID.CURRVAL FROM DUAL;    --관리자 시퀀스
SELECT A_ID.CURRVAL FROM DUAL;     --계정 시퀀스
SELECT C_CHAR.CURRVAL FROM DUAL;   --모임 채팅방 시퀀스

