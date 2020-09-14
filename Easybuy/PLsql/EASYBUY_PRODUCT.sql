--商品表
create table EASYBUY_PRODUCT
(
  EP_ID          NUMBER(10) primary key not null,
  EP_NAME        VARCHAR2(20) not null,--商品名称
  EP_DESCRIPTION VARCHAR2(100),--商品描述
  EP_PRICE       NUMBER(10,2) not null,--商品单价
  EP_STOCK       NUMBER(10) not null,--商品库存
  EPC_CHILD_ID   NUMBER(10),--商品分类子ID
  EP_FILE_NAME   VARCHAR2(200)--商品图片名称
)
select * from  EASYBUY_PRODUCT

insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (591, '画册', '画册', 100, 9999, 546, '591.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (592, '饭盒', '韩国风格', 200, 1997, 582, '592.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (593, '护肤王', '女士专用', 300, 29998, 583, '596.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (601, '奶粉', '三元', 20, 199, 581, '601.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (639, '旅行包', '旅行包', 2, 0, 581, '641.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (643, '项链', '饰品', 300, 2996, 581, '643.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (645, '丝袜', '女士', 50, 500, 581, '645.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (660, '电视', '三星', 20, 2000, 629, '660.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (663, '液晶屏', '纯平液晶显示器', 590, 3, 629, '663.jpg')
