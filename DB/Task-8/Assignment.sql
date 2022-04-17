-- employee
use employee;
show tables;
select * from department;
select * from employee;
select * from project_employee_mapping;
select * from projects;

-- Querry 3
select * from employee e left  join project_employee_mapping pem on e.id = pem.employee_id  left  join projects p on pem.project_id =p.id;

-- Querry 4
select id,name from projects union select id,name from department;
