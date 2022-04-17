use processflow;
show tables;
select * from checklist;
select * from process;
select * from process_stage_mapping;
select * from stage;
select * from stage_task_mapping;
select * from task;
select * from task_checklist_mapping;

-- Querry 1 ----- 

select p.name as process_name,s.name as stage_name, t.name as task_name,GROUP_CONCAT( c.name) as checklist_name  
from process p inner join process_stage_mapping psm on p.id=psm.process_id 
inner join stage s on psm.stage_id=s.id
inner join stage_task_mapping stm on s.id=stm.stage_id 
inner join task t on stm.task_id = t.id 
inner join task_checklist_mapping tcm on t.id=tcm.task_id 
inner join checklist c on tcm.checklist_id = c.id where p.id=1 group by s.name,t.name;