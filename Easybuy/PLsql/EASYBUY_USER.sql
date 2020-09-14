
create table EASYBUY_USER  --用户注册
(
  EU_USER_ID       VARCHAR2(10) primary key not null, --登录名
  EU_USER_NAME     VARCHAR2(20) not null,--用户名(昵称)
  EU_PASSWORD      VARCHAR2(20) not null,--密码
  EU_SEX           VARCHAR2(1) not null,--性别
  EU_BIRTHDAY      DATE,--生日
  EU_IDENTITY_CODE VARCHAR2(60),--身份证号
  EU_EMAIL         VARCHAR2(80),--email
  EU_MOBILE        VARCHAR2(11),--电话
  EU_ADDRESS       VARCHAR2(200),--地址
  EU_STATUS        NUMBER(6) not null--用户权限状态，1普通用户  2管理员
)
create sequence EASYBUY_USER_xul --创建序列
start with 1--从1开始
increment by 1--每次增长1
nomaxvalue--没有最大值
nocycle--不重复

select * from EASYBUY_USER

insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('ss', '普通用户', 'ss', 'F', null, null, null, null, '北京市海淀区成府路207号', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('admin', '管理员', 'admin', 'T', null, null, null, null, '北京市海淀区成府路207号', 2);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('sss', '小乖', '123456', 'T', null, null, null, null, '北京海淀区中关村大厦202', 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('www', '大家米', 'www', 'T', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('q', 'JQ', 'q', 'T', to_date('02-01-2010', 'dd-mm-yyyy'), null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('a', 'amdda', 'a', 'F', null, null, null, null, null, 1);
insert into EASYBUY_USER (EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS)
values ('w', 'w', 'w', 'T', null, null, null, null, 'w', 1);
commit;
