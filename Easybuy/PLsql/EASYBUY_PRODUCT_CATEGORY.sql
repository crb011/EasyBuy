--��Ʒ�����
create table EASYBUY_PRODUCT_CATEGORY
(
  EPC_ID        NUMBER(10) primary key not null,--��Ʒ����ID
  EPC_NAME      VARCHAR2(20) not null,--��Ʒ��������
  EPC_PARENT_ID NUMBER(10) not null--��Ʒ���ุID
)
select * from EASYBUY_PRODUCT_CATEGORY

insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (628, '���õ���', 0)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (629, '����', 628)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (630, '����', 628)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (542, 'ͼ��Ӱ��', 0)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (546, 'ͼ��', 542)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (547, '����', 542)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (580, '�ٻ�', 0)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (581, '������Ʒ', 580)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (582, '������Ʒ', 580)
insert into EASYBUY_PRODUCT_CATEGORY (EPC_ID, EPC_NAME, EPC_PARENT_ID)
values (583, '��ױƷ', 580)
