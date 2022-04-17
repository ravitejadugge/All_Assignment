show databases;

use eventpool;
show tables;
select * from contribution;
select * from event;
select * from event_type;
select * from `group` ;
select * from refused;
select * from user;
select * from user_group;

-- query 1
select * from event where id in (select event_id from contribution c  where user_id=9);
-- query 2
select * from event where id not in (select event_id from contribution c  where user_id=11);
-- query 3
SELECT * from  employee e right outer join project_employee_mapping pem 
on e.id = pem.employee_id
right outer join projects p 
on pem.project_id = p.id  ;

-- query 4
select sum(amount) from contribution where user_id=12;
-- query 5
select g.id,count(ug.user_id) as user_count,g.name,g.created_by,g.created_on from `group` g 
join user_group ug on g.id=ug.group_id join `user` u on u.id =g.created_by where u.id = 12 group by ug.group_id ;

