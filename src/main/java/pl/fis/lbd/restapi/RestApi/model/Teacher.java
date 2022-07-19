package pl.fis.lbd.restapi.RestApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String firstName;
    private String lastName;
    private TeacherSubject subject;
}
