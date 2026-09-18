package org.stdumng.aistudentmanagementsystem;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Tool(description = "This method is used to add or insert the students")
    public String addStudent(StudentEntity s){
        System.out.println("🔥 TOOL WAS CALLED!");
        StudentEntity se=new StudentEntity();
        se.setFirstName(s.getFirstName());
        se.setLastName(s.getLastName());
        se.setStandard(s.getStandard());
        studentRepository.save(se);
        return "Student added successfully";
    }
    @Tool(description = "Tool for finding students")
    public String find(Long id){
        Optional<StudentEntity> student= studentRepository.findById(id);
        if (student.isPresent()) {
            StudentEntity s = student.get();

            return "Student ID: " + id
                    + ", First Name: " + s.getFirstName()
                    + ", Last Name: " + s.getLastName()
                    + ", Standard: " + s.getStandard();
        }

        return "No student found with ID: " + id;
    }
}
