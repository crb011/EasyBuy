create sequence seq_eod_id
drop table EASYBUY_SHOPPING
create table EASYBUY_SHOPPING
(
  EOD_ID       NUMBER(10) primary key not null,
  EO_USERNAME   VARCHAR2(20) not null,--�û��˺ţ�ID
  EP_ID        NUMBER(10) not null,--��ƷID
  EP_FILE_NAME VARCHAR2(200) not null,--��ƷͼƬ
  EP_NAME      VARCHAR2(200) not null,--��Ʒ����
  EOD_COST     NUMBER(10,2) not null--����Ʒ���ܼ�Ǯ
)
select * from EASYBUY_SHOPPING
