DROP TABLE CATEGORY;

SET SCAN OFF;

CREATE TABLE CATEGORY(
  CATEGORY VARCHAR2(256) NOT NULL,
  CONSTRAINT TABLE_CATEGORY_PK PRIMARY KEY (CATEGORY)
);

INSERT INTO CATEGORY (CATEGORY) VALUES ('Strategy & planning');

INSERT INTO CATEGORY (CATEGORY) VALUES ('Development');

INSERT INTO CATEGORY (CATEGORY) VALUES ('Business change');

INSERT INTO CATEGORY (CATEGORY) VALUES ('Service provision');

INSERT INTO CATEGORY (CATEGORY) VALUES ('Procurement & management support');

INSERT INTO CATEGORY (CATEGORY) VALUES ('Ancillary skills');


commit;