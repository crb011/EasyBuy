--订单表
create table EASYBUY_ORDER
(
  EO_ID           NUMBER(10) primary key not null,
  EO_USER_ID      VARCHAR2(20) not null,--用户ID
  EO_USER_NAME    VARCHAR2(20),--收货人姓名
  EO_USER_TEL     VARCHAR2(20),--收货人电话
  EO_USER_ADDRESS VARCHAR2(200),--收货人地址
  EO_COST         NUMBER(10,2) not null,--总价钱
  EO_CREATE_TIME  DATE not null,--订单产生时间
  EO_STATUS       NUMBER(6) not null,--订单状态 (待审核，发货......)
  EO_TYPE         NUMBER(6) not null--付款方式  (下拉列表或单选按钮)
)
--订单状态
--1.待审核
--2.审核通过
--3.配货
--4.发货
--5.收货确认
--付款类型: 1:货到付款，2:支付宝，3:网银，4:转账...

select * from EASYBUY_ORDER

--订单表明细表
create table EASYBUY_ORDER_DETAIL
(
  EOD_ID       NUMBER(10) not null,
  EO_ID        NUMBER(10) not null,
  EP_ID        NUMBER(10) not null,
  EOD_QUANTITY NUMBER(6) not null,
  EOD_COST     NUMBER(10,2) not null
)

create sequence dingdan
start with 13--从1开始
increment by 1--每次增长1
nomaxvalue--没有最大值
nocycle--不重复

insert into EASYBUY_ORDER values(3,145,'小樱',null,null,160,to_date('2010-12-12','yyyy-mm-dd'),1,2)
insert into EASYBUY_ORDER values(4,148,'小天',null,null,34,to_date('2010-07-18','yyyy-mm-dd'),1,2)
insert into EASYBUY_ORDER values(5,149,'小樱',null,null,250,to_date('2010-12-13','yyyy-mm-dd'),1,2)
insert into EASYBUY_ORDER values(6,162,'小黑',null,null,100,to_date('2013-12-03','yyyy-mm-dd'),1,2)