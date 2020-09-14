create table EASYBUY_COMMENT --留言表
(
  EC_ID          NUMBER(10) primary key not null,--留言ID
  EC_CONTENT     VARCHAR2(200) not null,--留言内容
  EC_CREATE_TIME DATE not null,--留言创建时间
  EC_REPLY       VARCHAR2(200),--回复内容
  EC_REPLY_TIME  DATE,--回复时间
  EC_NICK_NAME   VARCHAR2(10) not null--留言人昵称
)

insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (655, '刚订了台IPod，很是期待啊', to_date('22-12-2015', 'dd-mm-yyyy'), '货已发出，请注意收货时开箱检查货物是否有问题', to_date('22-12-2015', 'dd-mm-yyyy'), '小乖');
insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (680, '佳能D50现在可以多长时间发货呢', to_date('24-12-2015', 'dd-mm-yyyy'), '一般在订单确认后的第3天发货', to_date('24-02-2015', 'dd-mm-yyyy'), '无极')
commit

select * from EASYBUY_COMMENT
