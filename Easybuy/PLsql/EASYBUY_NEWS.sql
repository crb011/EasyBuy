--新闻表
create table EASYBUY_NEWS
(
  EN_ID          NUMBER(10) primary key not null,
  EN_TITLE       VARCHAR2(40) not null,--新闻标题
  EN_CONTENT     VARCHAR2(1000) not null,--新闻内容
  EN_CREATE_TIME DATE not null--新闻创建时间
)

select * from EASYBUY_NEWS


insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (529, '最新酷睿笔记本', 'IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。', to_date('23-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (530, '团购无忧', '团购无忧', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (531, '会员特惠月开始了', '会员特惠月开始了', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (649, '加入会员，赢千万大礼包', '加入会员，赢千万大礼包', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (597, '迎双旦促销大酬宾', '迎双旦促销大酬宾', to_date('24-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (650, '新年不夜天，通宵也是开张了', '新年不夜天，通宵也是开张了', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (651, '积分兑换开始了', '积分兑换开始了', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (654, '配货通知', '配货通知', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (653, '团购阿迪1折起', '团购阿迪1折起', to_date('22-12-2015', 'dd-mm-yyyy'))
