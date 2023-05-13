
-- zadatak 1.1

SELECT * 
FROM student 
left join ispit on ispit.student_id = student.id
left join predmet on ispit.predmet_id = predmet.id;


-- zadatak 1.2

SELECT * 
FROM student 
right join ispit on ispit.student_id = student.id
right join predmet on ispit.predmet_id = predmet.id;

-- ili

SELECT * 
FROM predmet 
left join ispit on ispit.predmet_id = predmet.id
left join student on ispit.student_id = student.id;


-- zadatak 1.3

SELECT * 
FROM student
inner join ispit on student.id = ispit.student_id
inner join predmet on predmet.id = ispit.predmet_id;

-- ili

SELECT * 
FROM ispit
left join predmet on ispit.predmet_id = predmet.id
left join student on ispit.student_id = student.id;

-- zadatak 1.5

SELECT count(*), predmet.naziv
FROM predmet 
join ispit on ispit.predmet_id = predmet.id
group by ispit.predmet_id

