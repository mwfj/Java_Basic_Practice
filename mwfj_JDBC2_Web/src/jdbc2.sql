

create table student(
  s_id varchar2(50) primary key,
  s_name nvarchar2(50),
  s_age number
);

drop table student;

create SEQUENCE s_student nocache;

create or replace trigger t_student
before insert 
on student for each row
begin
  --select s_student.nextval into :NEW.s_id from dual;
  if :NEW.s_id is NULL then
    select sys_guid() into :NEW.s_id from dual;
  end if;
end;

insert into student(s_name, s_age)
values('王昌昊', 21);

insert into student(s_id, s_name, s_age)
values('AFAKSFJKALSJFAKSFJKAFS', '王昌昊', 21);

select * from student;

delete from student where s_id in(
'B0BDF33C449C4AD7953C3171D8D304CF',
'0C2A384695A541A18FCB6F30A7E3E4D5');

select sys_guid() from dual;


--- 当pagerNO = 1， pagerSize = 3
--- 当pagerNO = 2， pagerSize = 3



SELECT * FROM (
	SELECT ROWNUM M, s_id, s_name, s_age FROM student 
    WHERE ROWNUM <= (2 * 5)
    ) TEMP WHERE TEMP.M > 5 ;

select count(s_id) from student;



create or replace procedure p_student_count(
  p_str nvarchar2,
  p_count out number
)
AS
begin
  dbms_output.put_line('输入参数是：' || p_str);
  select count(s_id) into p_count from student;
end;

set serveroutput on;
declare
  param nvarchar2(500) := '你好';
  result_count number;
begin
  p_student_count(param, result_count);
  dbms_output.put_line('行数是：' || result_count);
end;



delete from student where S_ID = '366E6BBFAF394288B0364929F3D086BB';

create table studentlog(
  message nvarchar2(50)
);

select * from studentlog;


create or replace procedure p_student_log(
  p_name in nvarchar2,
  p_age in int,
  p_message in nvarchar2
)
AS 
begin
  insert into student(s_name, s_age) values(p_name, p_age);
  insert into studentlog values(p_message);
  commit;
  exception 
    when others then
      rollback;
end;

select count(s_id) from student where s_name like '%%';

SELECT * FROM (
	SELECT ROWNUM M, s_id, s_name, s_age FROM student 
    WHERE ROWNUM <= 3 AND s_name like '%e%'
    ) TEMP WHERE TEMP.M > 0 ;

select count(s_id) from student;

