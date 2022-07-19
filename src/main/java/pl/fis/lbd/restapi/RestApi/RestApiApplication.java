package pl.fis.lbd.restapi.RestApi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.fis.lbd.restapi.RestApi.model.Student;
import pl.fis.lbd.restapi.RestApi.model.Teacher;
import pl.fis.lbd.restapi.RestApi.model.TeacherSubject;
import pl.fis.lbd.restapi.RestApi.service.StudentService;
import pl.fis.lbd.restapi.RestApi.service.TeacherService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class RestApiApplication {

	private final StudentService studentService;
	private final TeacherService teacherService;

	@PostConstruct
	public void initList() {
		Student student = new Student(0, "Jan", "Kowalski", 24, "Law");
		Student student2 = new Student(1, "Jan", "Nowak", 30, "Biology");
		Student student3 = new Student(2, "Jerzy", "Nowicki", 31, "Law");
		Student student4 = new Student(3, "Michał", "Styczeń", 15, "Algebra");
		Student student5 = new Student(4, "Damian", "Sierpień", 60, "Biology");
		Student student6 = new Student(5, "Andrzej", "Jankowicz", 16, "Algebra");
		Student student7 = new Student(6, "Piotr", "Marzec", 16, "Algebra");
		Student student8 = new Student(7, "Zdzisław", "Kwiecień", 16, "Biology");
		Student student9 = new Student(8, "Zbigniew", "Czerwiec", 16, "Algebra");
		Student student10 = new Student(9, "Andrzej", "Listopad", 16, "Biology");
		studentService.addStudent(student);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		studentService.addStudent(student4);
		studentService.addStudent(student5);
		studentService.addStudent(student6);
		studentService.addStudent(student7);
		studentService.addStudent(student8);
		studentService.addStudent(student9);
		studentService.addStudent(student10);

		Teacher teacher = new Teacher(0, "Andrzej", "Kwieciński", TeacherSubject.ALGEBRA);
		Teacher teacher1 = new Teacher(1, "Zbigniew", "Kowalski", TeacherSubject.BIOLOGY);
		Teacher teacher2 = new Teacher(2, "Janusz", "Nowak", TeacherSubject.BIOLOGY);
		teacherService.addTeacher(teacher);
		teacherService.addTeacher(teacher1);
		teacherService.addTeacher(teacher2);
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
