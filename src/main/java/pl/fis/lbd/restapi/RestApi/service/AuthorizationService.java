package pl.fis.lbd.restapi.RestApi.service;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    public boolean isAuthorized(String URI, String role) {
        if(role == null)
            return false;
        else if(URI.contains("/student") && (role.equals("STUDENT_ROLE") || role.equals("TEACHER_ROLE")))
            return true;
        else if(URI.contains("/teacher") && role.equals("TEACHER_ROLE"))
            return true;
        return false;
    }


}
