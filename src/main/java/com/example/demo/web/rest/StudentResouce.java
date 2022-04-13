package com.example.demo.web.rest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResouce {
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(){
        Student student = new Student(2L,"Abbos","To'lqinov","4-kurs");
        Student student1 = new Student(2L,"Zafar","Zafarov","2-kurs");
        Student student2 = new Student(2L,"Axror","To'lqinov","1-kurs");
        List<Student>students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student(id,"Abbos","To'lqinov","4-kurs");
        return ResponseEntity.ok(student);
    }
    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id ,
                                 @RequestBody Student studentNew){
        Student student = new Student(1L,"Abbos","To'lqinov","4-kurs");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Ma'limot o'chirildi !");
    }
}
