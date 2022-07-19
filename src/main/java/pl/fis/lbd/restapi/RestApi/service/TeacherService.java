package pl.fis.lbd.restapi.RestApi.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fis.lbd.restapi.RestApi.model.Student;
import pl.fis.lbd.restapi.RestApi.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final StudentService studentService;
    private List<Teacher> teachers = new ArrayList<>();

    public Teacher addTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teachers.get(teacher.getId());
    }

    public void deleteTeacher(int id) {
        teachers.remove(id);
    }

    public Teacher getTeacher(int id) {
        return teachers.get(id);
    }

    public List<Student> getTeacherClass(int id) {
        Teacher teacher = teachers.get(id);
        return studentService.getStudentsWithSubject(teacher.getSubject().getName());
    }

    public void deleteStudentFromClassByTeacherId(int id, int studentId) {
        Teacher teacher = teachers.get(id);
        List<Student> studentsWithSubject = studentService.getStudentsWithSubject(teacher.getSubject().getName());
        if(teacher.getSubject().getName().equals(studentsWithSubject.get(studentId)))
            studentsWithSubject.get(studentId).setLearningSubject("");
    }
}
