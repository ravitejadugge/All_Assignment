-- employee
use employee;
show tables;
select * from department;
select * from employee;
select * from project_employee_mapping;
select * from projects;

-- Querry 1 
select * from employee e inner join project_employee_mapping pem on e.id = pem.employee_id  inner join projects p on pem.project_id =p.id;

-- Querry 2
select * from employee e left  join project_employee_mapping pem on e.id = pem.employee_id  left  join projects p on pem.project_id =p.id;
