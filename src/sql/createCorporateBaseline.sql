drop table corporate_skill_baseline;

set scan off;


create table corporate_SKILL_BASELINE(
  SKILL_ID VARCHAR2(10) NOT NULL,
  LEVEL_NUMBER NUMBER(5) NOT NULL,
  BASELINE_NAME VARCHAR2(256) NOT NULL,
  CREATION_DATE TIMESTAMP NOT NULL,
  DESCRIPTION CLOB
);

