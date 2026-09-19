package org.stdumng.aistudentmanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query(value = "SELECT * FROM student_entity where id=:id", nativeQuery = true)
    StudentEntity findById(long id);
    @Query(value = "SELECT s.* FROM student_entity s join percentage_entity p on s.percentage_id=p.id WHERE p.percentage=:percentage",nativeQuery = true)
    List<StudentEntity> findByPercentage(double percentage);
}
