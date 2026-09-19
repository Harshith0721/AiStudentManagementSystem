package org.stdumng.aistudentmanagementsystem;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final PercentageRepository percentageRepository;
    public StudentService(StudentRepository studentRepository, PercentageRepository percentageRepository) {
        this.studentRepository = studentRepository;
        this.percentageRepository = percentageRepository;
    }
    @Tool(description = "Add a new student with his percentage to the database")
    public String addStudent(StudentEntity student) {

        System.out.println("🔥 TOOL WAS CALLED!");

        studentRepository.save(student);

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
    @Tool(description = "tool that finds student with percentage")
    public String findPercentage(double percentage){
        List<StudentEntity> l=studentRepository.findByPercentage(percentage);
        for(StudentEntity s:l){
           return s.getFirstName()+" "+s.getLastName();
        }
        return "No student found with percentage: " + percentage;
    }
}
