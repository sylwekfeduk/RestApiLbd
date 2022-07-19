package pl.fis.lbd.restapi.RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.fis.lbd.restapi.RestApi.model.Student;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class TestConfig {
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/all")
                        .queryParam("role", "STUDENT_ROLE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].firstName", Is.is("Jan")));
    }

    @Test
    public void getStudent() throws Exception {
        int id = 2;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/" + id)
                        .queryParam("role", "STUDENT_ROLE"))
                .andExpect(status().isFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("lastName", Is.is("Nowicki")));
    }

    @Test
    public void editStudent() throws Exception {
        Student student = new Student(1, "Andrzej", "Kowalski", 15);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/student").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(student))
                        .queryParam("role", "STUDENT_ROLE"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("lastName", Is.is("Kowalski")));
    }

    @Test
    public void addStudent() throws Exception {
        Student student = new Student(10, "January", "Ciszewski", 25);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/student").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(student))
                        .queryParam("role", "STUDENT_ROLE"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("firstName", Is.is("January")));
    }

    @Test
    public void deleteStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/student/" + 4)
                        .queryParam("role", "STUDENT_ROLE"))
                .andExpect(status().isOk());
    }
}
