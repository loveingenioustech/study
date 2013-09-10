-- wd_user
create table wd_user (username varchar2(20) not null, password varchar2(20), CONSTRAINT PK_USER PRIMARY KEY(username));

-- wd_sort
CREATE TABLE wd_sort(	
  id      INTEGER,
  name    VARCHAR2 (40)   NOT NULL,
  CONSTRAINT PK_SORT PRIMARY KEY(id)
);

-- wd_product
CREATE TABLE wd_product(  
  id        INTEGER,
  sortid    INTEGER         NOT NULL,
  name      VARCHAR2(50)    NOT NULL,
  price     NUMBER          NOT NULL,
  saleprice NUMBER          NOT NULL,
  descript  VARCHAR2(500)   NOT NULL,
  contents  VARCHAR2(2000)  NULL,
  saledate  DATE            NOT NULL,
  salecount INTEGER         NULL,
  image     VARCHAR2(50)    NULL,
  CONSTRAINT PK_PRODUCT PRIMARY KEY(id)
)