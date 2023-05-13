use vp;

select * from student;

select * from predmet;

select * from ispit;

-- zadatak 1
select * from student 
	left join ispit on student.id = ispit.student_id
    left join predmet on ispit.predmet_id = predmet.id;
    
-- zadatak 2
select * from predmet
	left join ispit on predmet.id = ispit.predmet_id
    left join student on ispit.student_id = student.id;
    
-- zadatak 3
select * from ispit
	left join predmet on ispit.predmet_id = predmet.id
    left join student on ispit.student_id = student.id;
    
-- zadatak 4
select student.id, avg(ispit.ocena), ime, prezime from student 
	left join ispit on student.id = ispit.student_id
    left join predmet on ispit.predmet_id = predmet.id
    where ispit.ocena is not null
    group by student.id;
    
-- zadatak 5
select naziv, count(predmet.id) from ispit
	left join predmet on predmet.id = ispit.predmet_id
    left join student on ispit.student_id = student.id
    group by predmet.id
    order by count(predmet.id) desc;
    
-- zadatak 6
-- selektovati predmet sa najvisom prosecnom ocenom
select naziv, max(avg_ocena) from (
select naziv, avg(ocena) as avg_ocena from predmet
	left join ispit on predmet.id = ispit.predmet_id
    group by predmet.id) prosecne_ocene;