package pl.fis.lbd.restapi.RestApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fis.lbd.restapi.RestApi.model.Student;
import pl.fis.lbd.restapi.RestApi.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/student/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("successful", "true")
                .body(studentService.getAllStudents());
    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("successful", "true")
                .body(studentService.getStudent(id));
    }

    @PutMapping(value = "/student")
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        return ResponseEntity.ok()
                .header("successful", "true")
                .body(studentService.editStudent(student));
    }

    @PostMapping(value = "/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("successful", "true")
                .body(studentService.addStudent(student));
    }

    @DeleteMapping(value = "/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok()
                .header("successful", "true")
                .build();
    }


}
