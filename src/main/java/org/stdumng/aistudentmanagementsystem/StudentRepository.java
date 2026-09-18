package org.stdumng.aistudentmanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query(value = "SELECT * FROM student_entity where id=:id", nativeQuery = true)
    StudentEntity findById(long id);
}
