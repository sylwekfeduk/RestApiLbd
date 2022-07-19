package pl.fis.lbd.restapi.RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.fis.lbd.restapi.RestApi.model.Teacher;
import pl.fis.lbd.restapi.RestApi.model.TeacherSubject;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addTeacher() throws Exception {
        Teacher teacher = new Teacher(3, "Jan", "Bandyta", TeacherSubject.ALGEBRA);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/teacher").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(teacher))
                        .queryParam("role", "TEACHER_ROLE"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("lastName", Is.is("Bandyta")));
    }

    @Test
    public void getTeacher() throws Exception {
        int id = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/" + id)
                        .queryParam("role", "TEACHER_ROLE"))
                .andExpect(status().isFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("lastName", Is.is("Kowalski")));
    }

    @Test
    public void deleteTeacher() throws Exception {
        int id = 2;
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/" + id)
                        .queryParam("role", "TEACHER_ROLE"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTeacherClass() throws Exception {
        int id = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/class/" + id)
                        .queryParam("role", "TEACHER_ROLE"))
                .andExpect(status().isFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].lastName", Is.is("Nowak")))
                .andExpect(jsonPath("$.[0].firstName", Is.is("Jan")))
                .andExpect(jsonPath("$.[0].age", Is.is(30)));
    }

    @Test
    public void deleteStudentFromClassByTeacherId() throws Exception {
        int id = 1;
        int studentId = 1;
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/class/" + id + "/" + studentId)
                        .queryParam("role", "TEACHER_ROLE"))
                .andExpect(status().isOk());
    }
}
