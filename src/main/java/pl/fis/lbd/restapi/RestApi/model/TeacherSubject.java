package pl.fis.lbd.restapi.RestApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeacherSubject {

    ALGEBRA("Algebra"),
    LAW("Law"),
    BIOLOGY("Biology");

    private final String name;
}
