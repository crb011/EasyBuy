--������
create table EASYBUY_ORDER
(
  EO_ID           NUMBER(10) primary key not null,
  EO_USER_ID      VARCHAR2(20) not null,--�û�ID
  EO_USER_NAME    VARCHAR2(20),--�ջ�������
  EO_USER_TEL     VARCHAR2(20),--�ջ��˵绰
  EO_USER_ADDRESS VARCHAR2(200),--�ջ��˵�ַ
  EO_COST         NUMBER(10,2) not null,--�ܼ�Ǯ
  EO_CREATE_TIME  DATE not null,--��������ʱ��
  EO_STATUS       NUMBER(6) not null,--����״̬ (����ˣ�����......)
  EO_TYPE         NUMBER(6) not null--���ʽ  (�����б��ѡ��ť)
)
--����״̬
--1.�����
--2.���ͨ��
--3.���
--4.����
--5.�ջ�ȷ��
--��������: 1:�������2:֧������3:������4:ת��...

select * from EASYBUY_ORDER

--��������ϸ��
create table EASYBUY_ORDER_DETAIL
(
  EOD_ID       NUMBER(10) not null,
  EO_ID        NUMBER(10) not null,
  EP_ID        NUMBER(10) not null,
  EOD_QUANTITY NUMBER(6) not null,
  EOD_COST     NUMBER(10,2) not null
)

create sequence dingdan
start with 13--��1��ʼ
increment by 1--ÿ������1
nomaxvalue--û�����ֵ
nocycle--���ظ�

insert into EASYBUY_ORDER values(3,145,'Сӣ',null,null,160,to_date('2010-12-12','yyyy-mm-dd'),1,2)
insert into EASYBUY_ORDER values(4,148,'С��',null,null,34,to_date('2010-07-18','yyyy-mm-dd'),1,2)
insert into EASYBUY_ORDER values(5,149,'Сӣ',null,null,250,to_date('2010-12-13','yyyy-mm-dd'),1,2)
insert into EASYBUY_ORDER values(6,162,'С��',null,null,100,to_date('2013-12-03','yyyy-mm-dd'),1,2)