DROP TABLE SUBCATEGORY;

set scan off;

CREATE TABLE SUBCATEGORY(
  CATEGORY VARCHAR2(256) not null,
  SUBCATEGORY VARCHAR2(256) not null,
   CONSTRAINT TABLE_SUBCATEGORY_PK PRIMARY KEY (CATEGORY, SUBCATEGORY),
   CONSTRAINT FK_CATEGORY 
   FOREIGN KEY (CATEGORY) 
   REFERENCES CATEGORY(CATEGORY) 
);

INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Strategy & planning','Information strategy' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Strategy & planning','Advice and guidance' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Strategy & planning','Business/information systems strategy and planning' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Strategy & planning','Technical strategy and planning' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Development','Systems development' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Development','Human factors' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Development','Installation and integration' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Business change','Business change management' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Business change','Relationship management' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Service provision','Infrastructure' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Service provision','Operation' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Service provision','User support' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Procurement & management support','Supply management' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Procurement & management support','Quality' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Procurement & management support','Resource management' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Ancillary skills','Education and training' );
INSERT INTO SUBCATEGORY ( CATEGORY, SUBCATEGORY) VALUES (  'Ancillary skills','Sales and marketing' );

commit;

