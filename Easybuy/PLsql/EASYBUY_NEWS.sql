--���ű�
create table EASYBUY_NEWS
(
  EN_ID          NUMBER(10) primary key not null,
  EN_TITLE       VARCHAR2(40) not null,--���ű���
  EN_CONTENT     VARCHAR2(1000) not null,--��������
  EN_CREATE_TIME DATE not null--���Ŵ���ʱ��
)

select * from EASYBUY_NEWS


insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (529, '���¿�ʼǱ�', 'IBMEϵ��ȫ�������У����¿��˫�˴���������֤CPU����Ч����ת��', to_date('23-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (530, '�Ź�����', '�Ź�����', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (531, '��Ա�ػ��¿�ʼ��', '��Ա�ػ��¿�ʼ��', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (649, '�����Ա��Ӯǧ������', '�����Ա��Ӯǧ������', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (597, 'ӭ˫����������', 'ӭ˫����������', to_date('24-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (650, '���겻ҹ�죬ͨ��Ҳ�ǿ�����', '���겻ҹ�죬ͨ��Ҳ�ǿ�����', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (651, '���ֶһ���ʼ��', '���ֶһ���ʼ��', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (654, '���֪ͨ', '���֪ͨ', to_date('22-12-2015', 'dd-mm-yyyy'))
insert into EASYBUY_NEWS (EN_ID, EN_TITLE, EN_CONTENT, EN_CREATE_TIME)
values (653, '�Ź�����1����', '�Ź�����1����', to_date('22-12-2015', 'dd-mm-yyyy'))
