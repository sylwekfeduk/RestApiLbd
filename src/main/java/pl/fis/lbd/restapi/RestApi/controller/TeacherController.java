package pl.fis.lbd.restapi.RestApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fis.lbd.restapi.RestApi.model.Student;
import pl.fis.lbd.restapi.RestApi.model.Teacher;
import pl.fis.lbd.restapi.RestApi.service.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping(value = "/teacher/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id) {
        return new ResponseEntity<>(teacherService.getTeacher(id), HttpStatus.FOUND);
    }

    @PostMapping(value = "/teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/teacher/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/teacher/class/{id}")
    public ResponseEntity<List<Student>> getTeacherClass(@PathVariable int id) {
        return new ResponseEntity<>(teacherService.getTeacherClass(id), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/teacher/class/{id}/{studentId}")
    public ResponseEntity<Void> deleteStudentFromClassByTeacherId(@PathVariable int id, @PathVariable int studentId) {
        teacherService.deleteStudentFromClassByTeacherId(id, studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
