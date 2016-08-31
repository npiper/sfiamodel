drop table ROLE_SKILL_BASELINE;

set scan OFF;


# Table to store a group of ratings showing the 
# particular set of skills required or preferred for
# a particular role at a particular date / baseline
# Superseded says whether the entry is still currently valid
create table ROLE_SKILL_BASELINE
(
   ROLE_NAME VARCHAR2(256) NOT NULL,
   ROLE_LEVEL NUMBER(5) NOT NULL,
   SKILL_ID VARCHAR2(10) NOT NULL,
   MIN_LEVEL_NUMBER NUMBER(5) NOT NULL,
   MAX_LEVEL_NUMBER NUMBER(5) NOT NULL,
   CREATION_DATE TIMESTAMP,
   BASELINE_NAME VARCHAR2(256) NOT NULL,
   COMPULSORY CHAR(1) NOT NULL,
   SUPERSEDED CHAR(1) NOT NULL
);

# Store the current Roles and whether they are active
create table ROLE
{
   ROLE_NAME VARCHAR2(256),
   ACTIVE CHAR(1)
}

# Store the role sub-levels (i.e. Junior, Intermediate, Expert)
# And the salary for that level
create table ROLE_LEVEL
{
   ROLE_NAME VARCHAR2(256) NOT NULL,
   ROLE_LEVEL NUMBER(5) NOT NULL,
   MIN_SALARY NUMBER(8,2),
   MAX_SALARY NUMBER(8,2),
   DESCRIPTION CLOB,
   CREATION_DATE TIMESTAMP NOT NULL,
   SUPERSEDED CHAR(1) NOT NULL
}


# Show that a user achieved a particular role at a particular date
create table USER_ROLE_BASELINE
{
   ROLE_NAME VARCHAR2(256),
   ROLE_LEVEL NUMBER(5),
   USER_ID VARCHAR2(120) NOT NULL,
   CREATION_DATE TIMESTAMP
}