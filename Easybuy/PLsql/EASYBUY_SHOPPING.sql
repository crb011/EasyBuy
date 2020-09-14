create sequence seq_eod_id
drop table EASYBUY_SHOPPING
create table EASYBUY_SHOPPING
(
  EOD_ID       NUMBER(10) primary key not null,
  EO_USERNAME   VARCHAR2(20) not null,--用户账号：ID
  EP_ID        NUMBER(10) not null,--商品ID
  EP_FILE_NAME VARCHAR2(200) not null,--商品图片
  EP_NAME      VARCHAR2(200) not null,--商品名称
  EOD_COST     NUMBER(10,2) not null--此商品的总价钱
)
select * from EASYBUY_SHOPPING
