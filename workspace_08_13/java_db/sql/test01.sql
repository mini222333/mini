select e.employee_id,e.first_name,d.department_name,m.first_name
from employees e,employees m,departments d
where e.manager_id=m.employee_id and e.department_id=d.department_id; 



select e.last_name,e.salary
from employees e,employees m
where e.manager_id=m.employee_id and e.salary>m.salary;

select first_name,last_name,salary
from employees,jobs
where employees.job_id=jobs.job_id and salary between 9000 and 10000 and job_title='Sales Representative'



