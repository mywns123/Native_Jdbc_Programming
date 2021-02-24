select user(), database();

show tables;

desc title;
desc department;
desc employee;

select tno,tname from title ;
select tno,tname from title where tno=1;
insert into title values(6,'인턴');
delete from title where tno=6;
update  title  set tname ='계약직' where tno =6;
 
select deptNO,deptName,floor from department;
select deptNO,deptName,floor from department where deptNO = 1;
insert  into department values (5, '재무',11);
update  Department  set DeptName ='전산' where Deptno =5
delete  from Department where Deptno=5

select empNo,empName,title,manager,salary,dept from employee;
select empNo,empName,title,manager,salary,dept from employee where empNo =2106;
insert into employee values(2222,'태연',5,4377,2500000,1);

create view vw_title
as
select tno,tname, empNo, empName, manager,salary, dept
from  employee e left join title t on e.title  = t.tno;

create view vw_department 
as
select deptNO,deptName,floor, empNo, empName, manager,salary
from  employee e left join department d on e.dept = d.deptNO;

select tno,tname, empNo, empName, manager,salary, dept from vw_title;
select deptNO,deptName,floor, empNo, empName, manager,salary from vw_department;


create view vw_full_employee
as
select  e.empNo,
e.empName,
t.tno as title_no,
t.tname as title_name,
e.manager as manager_no,
m.empName as manager_name,
e.salary,
d.deptNO as dept_no,
d.deptName as dept_name,
d.floor
from  employee e join title t on e.title  = t.tno
	 left join employee m on e.manager = m.empNo
	join department d  on e.dept  = d.deptNO;

select empNo,empName,title_no,title_name,manager_no,manager_name,salary,dept,floor from vw_full_employee;
select empNo,empName,title as title_no ,manager as manager_no ,salary,dept as dept_no from employee ;
drop view vw_full_employee;
select empNo,empName,title_no,title_name,manager_no,manager_name,salary,dept_no,dept_name,floor from vw_full_employee;

insert into employee  values(1004,'천사',5,4377,2000000,1);

update employee 
set dept = 3
where empno =1004;

delete 
from employee 
where empno =1004;

select * from employee ;

select tno,tname from title ;
select deptNO,deptName,floor from department;

delete 
from title 
where tno = 6;


delete 
from department 
where deptNO = 5;

-- 출력
select empNo,empName,title,manager,salary,dept
from department d join employee e on d.deptNO = e.dept 
where d.deptNO = 3;

select empNo,empName,title,manager,salary,dept
from employee 
where dept = (select deptNO from department where deptNO =3);


