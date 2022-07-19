package pl.fis.lbd.restapi.RestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalErrorHandler {

    /*@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> notValidArguments(Exception ex){
        return ResponseEntity.badRequest()
                .header("successful","false")
                .body("Not valid arguments");
    }*/

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> dataNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("successful", "false")
                .body("The given index doesn't exist in database");
    }
}
