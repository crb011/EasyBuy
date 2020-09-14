
create table EASYBUY_USER  --�û�ע��
(
  EU_USER_ID       VARCHAR2(10) primary key not null, --��¼��
  EU_USER_NAME     VARCHAR2(20) not null,--�û���(�ǳ�)
  EU_PASSWORD      VARCHAR2(20) not null,--����
  EU_SEX           VARCHAR2(1) not null,--�Ա�
  EU_BIRTHDAY      DATE,--����
  EU_IDENTITY_CODE VARCHAR2(60),--���֤��
  EU_EMAIL         VARCHAR2(80),--email
  EU_MOBILE        VARCHAR2(11),--�绰
  EU_ADDRESS       VARCHAR2(200),--��ַ
  EU_STATUS        NUMBER(6) not null--�û�Ȩ��״̬��1��ͨ�û�  2����Ա
)
create sequence EASYBUY_USER_xul --��������
start with 1--��1��ʼ
increment by 1--ÿ������1
nomaxvalue--û�����ֵ
nocycle--���ظ�

select * from EASYBUY_USER

insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('ss', '��ͨ�û�', 'ss', 'F', null, null, null, null, '�����к������ɸ�·207��', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('admin', '����Ա', 'admin', 'T', null, null, null, null, '�����к������ɸ�·207��', 2);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('sss', 'С��', '123456', 'T', null, null, null, null, '�����������йش����202', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('www', '�����', 'www', 'T', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('q', 'JQ', 'q', 'T', to_date('02-01-2010', 'dd-mm-yyyy'), null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('a', 'amdda', 'a', 'F', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('w', 'w', 'w', 'T', null, null, null, null, 'w', 1);
commit;
