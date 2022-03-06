-----------테이블 삭제------------
DROP TABLE CM;          --게시글 댓글 테이블
DROP TABLE PHOTO;       --게시글 사진 테이블
DROP TABLE BOARD;       --게시판 테이블
DROP TABLE MM;          --모임 인원 테이블
DROP TABLE MT;          --모임 테이블
DROP TABLE MEMBER;      --회원 테이블
DROP TABLE AP;          --모임 가입 테이블
DROP TABLE CLUB;        --모임 테이블
DROP TABLE CG;          --모임 카테고리 테이블
DROP TABLE AD;          --관리자 테이블
DROP TABLE ACCOUNT;     --계정 테이블

-----------시퀀스 삭제------------
DROP SEQUENCE CM_ID;    --게시글 댓글 시퀀스
DROP SEQUENCE P_ID;     --게시글 사진 시퀀스
DROP SEQUENCE B_ID;     --게시판 시퀀스
DROP SEQUENCE MM_ID;    --모임 인원 시퀀스
DROP SEQUENCE MT_ID;    --모임 시퀀스
DROP SEQUENCE M_ID;     --회원 시퀀스
DROP SEQUENCE AP_ID;    --모임 가입 시퀀스
DROP SEQUENCE C_ID;     --모임 시퀀스
DROP SEQUENCE CG_ID;    --모임 카테고리 시퀀스
DROP SEQUENCE AD_ID;    --관리자 시퀀스
DROP SEQUENCE A_ID;     --계정 시퀀스
DROP SEQUENCE C_CHAT;   --모임 채팅방 시퀀스