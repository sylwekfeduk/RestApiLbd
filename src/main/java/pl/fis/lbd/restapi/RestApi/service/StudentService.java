package pl.fis.lbd.restapi.RestApi.service;

import org.springframework.stereotype.Service;
import pl.fis.lbd.restapi.RestApi.model.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        students.add(student);
        return students.get(student.getId());
    }

    public Student editStudent(Student student) {
        Student studentUpdated = students.get(student.getId());
        studentUpdated.setAge(student.getAge());
        studentUpdated.setLastName(student.getLastName());
        students.set(student.getId(), studentUpdated);
        return students.get(student.getId());
    }

    public void deleteStudent(int id) {
        students.remove(id);
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public List<Student> getStudentsWithSubject(String subject) {
        List<Student> studentsWithSubject = new ArrayList<>();
        for(Student student: students) {
            if(student.getLearningSubject().equals(subject))
                studentsWithSubject.add(student);
        }
        return studentsWithSubject;
    }

    public Student updateLearningSubject(int id, String subject) {
        Student student = students.get(id);
        student.setLearningSubject(subject);
        return students.set(id, student);
    }
}
