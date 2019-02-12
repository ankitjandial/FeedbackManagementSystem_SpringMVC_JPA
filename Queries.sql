SELECT * FROM FACULTY_SKILL;

SELECT * FROM EMPLOYEE_MASTER;

SELECT * FROM COURSE_MASTER;

select * from TRAINING_PROGRAM;

select seq_course_id.nextval from dual;

drop table FACULTY_SKILL;

create table faculty_skill(faculty_id number(5) primary key references employee_master(employee_id),skill_set varchar2(200))

select * from FEEDBACK_MASTER;

insert into FEEDBACK_MASTER Select * from FEEDBACK_MASTER
select distinct(Faculty_name),to_char( end_date, 'dd-mm-yyyy' ),course_name,FB_PRs_COMM,FB_CLRFY_DBTS,FB_TM,FB_HND_OUT,FB_HW_SW_NTWRK from 
(select distinct(e.employee_name),t.end_date,c.course_name,round((select avg(FB_Prs_comm) from feedback_master
where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_PRs_COMM,
round((select avg(FB_Clrfy_dbts) from feedback_master where training_code in (select training_code from training_program where 
faculty_code = t.faculty_code)),2) as FB_CLRFY_DBTS, round((select avg(FB_TM) from feedback_master where training_code in 
(select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_TM, 
round((select avg(FB_Hnd_out) from feedback_master where training_code in (select training_code from training_program where 
faculty_code = t.faculty_code)),2) as FB_HND_OUT, round((select avg(FB_Hw_Sw_Ntwrk) from feedback_master where training_code in 
(select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_HW_SW_NTWRK from training_program t	
join feedback_master f on f.training_code=t.training_code join employee_master e on e.employee_id=t.faculty_code join course_master c 
on c.course_id=t.course_code	where to_char( end_date, 'mm' )=03)


select to_char(end_date, 'dd-mm-yyyy'),c.course_name ,e.employee_name,f.FB_Prs_comm  ,f.FB_Clrfy_dbts,f.FB_TM ,f.FB_Hnd_out ,f.FB_Hw_Sw_Ntwrk from training_program t join feedback_master f on f.training_code=t.training_code join employee_master e on e.employee_id=t.faculty_code join course_master c on c.course_id=t.course_code where to_char( end_date, 'mm' )=03

select distinct(e.employee_name),to_char( end_date, 'dd-mm-yyyy' ),c.course_name,round((select avg(FB_Prs_comm) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_PRs_COMM, round((select avg(FB_Clrfy_dbts) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_CLRFY_DBTS, round((select avg(FB_TM) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_TM, round((select avg(FB_Hnd_out) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_HND_OUT, round((select avg(FB_Hw_Sw_Ntwrk) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_HW_SW_NTWRK from training_program t	join feedback_master f on f.training_code=t.training_code join employee_master e on e.employee_id=t.faculty_code join course_master c on c.course_id=t.course_code	where to_char( end_date, 'mm' )=03