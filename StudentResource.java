package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {


    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student) {
        return ResponseEntity.ok(student);

    }

    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student) {
        student.setLastName("test uchun");
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateSecond(@PathVariable Long id,
                                       @RequestBody Student student) {
        student.setLastName("test uchun");
        student.setId(id);
        return ResponseEntity.ok(student);

    }
    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student1=new Student();
        student1.setId(id);
        return ResponseEntity.ok(student1);
    }
    @GetMapping("/students")
    public ResponseEntity getAll(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam Integer age){
        List<Student> students=new ArrayList<>();
        students.add(new Student(id,name,lastName,age));
        students.add(new Student(3L,"name","lastName",28));
        return ResponseEntity.ok(students);



    }



}
