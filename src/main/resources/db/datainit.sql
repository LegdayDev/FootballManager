SET REFERENTIAL_INTEGRITY FALSE; -- 제약조건 무효화
truncate table users;
truncate table stadium;
truncate table player;
truncate table team;
SET REFERENTIAL_INTEGRITY TRUE; -- 제약조건 재설정