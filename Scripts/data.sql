insert into department(dept_code, dept_name, floor) values 
(1,'����',8),(2,'��ȹ',10),(3, '����',9),(4,'�ѹ�',7);

insert into title(title_code, title_name) values 
(1, '����'), (2, '����'), (3, '����'), (4, '�븮'), (5, '���');

INSERT INTO employee(eno, ename, title,salary, gender,dno,joindate) VALUES 
(4377,'�̼���',1,5000000,1, 2, '2015-03-01'),
(3011,'�̼���',2,4000000,1, 3, '2015-04-01'),
(3426,'�ڿ���',3,3000000,1, 1, '2016-05-01'),
(1003,'������',3,3000000,0, 2, '2016-06-01'),
(1365,'����',5,1500000,0, 1, '2019-05-01'),
(2106,'��â��',4,2500000,0, 2, '2018-08-01'),
(3427,'����ö',4,1500000,0, 2, '2019-03-01');

-- procedure ����

drop procedure if exists salary_total;
DELIMITER $$
$$
create procedure salary_total(in deptno int)
begin
	select dept_name, ifnull(sum(salary),0)as total
	from employee e right join department d on e.dno = d.dept_code
	where dno = deptno;
END$$
DELIMITER ;

call salary_total(2);