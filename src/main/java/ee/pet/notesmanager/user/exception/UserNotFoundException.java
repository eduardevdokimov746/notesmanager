package ee.pet.notesmanager.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public class UserNotFoundException extends ErrorResponseException {
    public UserNotFoundException(int id) {
        super(
                HttpStatus.NOT_FOUND,
                ProblemDetail.forStatus(HttpStatus.NOT_FOUND),
                null,
                null,
                new Object[] { id }
        );
    }
}
