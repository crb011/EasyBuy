create table EASYBUY_COMMENT --���Ա�
(
  EC_ID          NUMBER(10) primary key not null,--����ID
  EC_CONTENT     VARCHAR2(200) not null,--��������
  EC_CREATE_TIME DATE not null,--���Դ���ʱ��
  EC_REPLY       VARCHAR2(200),--�ظ�����
  EC_REPLY_TIME  DATE,--�ظ�ʱ��
  EC_NICK_NAME   VARCHAR2(10) not null--�������ǳ�
)

insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (655, '�ն���̨IPod�������ڴ���', to_date('22-12-2015', 'dd-mm-yyyy'), '���ѷ�������ע���ջ�ʱ����������Ƿ�������', to_date('22-12-2015', 'dd-mm-yyyy'), 'С��');
insert into EASYBUY_COMMENT (EC_ID, EC_CONTENT, EC_CREATE_TIME, EC_REPLY, EC_REPLY_TIME, EC_NICK_NAME)
values (680, '����D50���ڿ��Զ೤ʱ�䷢����', to_date('24-12-2015', 'dd-mm-yyyy'), 'һ���ڶ���ȷ�Ϻ�ĵ�3�췢��', to_date('24-02-2015', 'dd-mm-yyyy'), '�޼�')
commit

select * from EASYBUY_COMMENT
