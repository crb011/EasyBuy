--��Ʒ��
create table EASYBUY_PRODUCT
(
  EP_ID          NUMBER(10) primary key not null,
  EP_NAME        VARCHAR2(20) not null,--��Ʒ����
  EP_DESCRIPTION VARCHAR2(100),--��Ʒ����
  EP_PRICE       NUMBER(10,2) not null,--��Ʒ����
  EP_STOCK       NUMBER(10) not null,--��Ʒ���
  EPC_CHILD_ID   NUMBER(10),--��Ʒ������ID
  EP_FILE_NAME   VARCHAR2(200)--��ƷͼƬ����
)
select * from  EASYBUY_PRODUCT

insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (591, '����', '����', 100, 9999, 546, '591.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (592, '����', '�������', 200, 1997, 582, '592.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (593, '������', 'Ůʿר��', 300, 29998, 583, '596.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (601, '�̷�', '��Ԫ', 20, 199, 581, '601.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (639, '���а�', '���а�', 2, 0, 581, '641.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (643, '����', '��Ʒ', 300, 2996, 581, '643.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (645, '˿��', 'Ůʿ', 50, 500, 581, '645.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (660, '����', '����', 20, 2000, 629, '660.jpg')
insert into EASYBUY_PRODUCT (EP_ID, EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_CHILD_ID, EP_FILE_NAME)
values (663, 'Һ����', '��ƽҺ����ʾ��', 590, 3, 629, '663.jpg')
