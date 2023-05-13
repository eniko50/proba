package vp.springdata.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.springdata.students.model.Course;

@Component
public interface CourseRepository extends JpaRepository<Course, Long> {
}
