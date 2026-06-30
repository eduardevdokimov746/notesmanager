package ee.pet.notesmanager.system.exception;

import org.jspecify.annotations.Nullable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> createResponseEntity(@Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        body = new ApiError(
                HttpStatus.valueOf(statusCode.value()).getReasonPhrase(),
                Optional.ofNullable(body)
                        .map(notNullBody -> {
                                if (notNullBody instanceof ProblemDetail problemDetail) {
                                    return problemDetail.getDetail();
                                }
                                return null;
                            })
                        .orElse(""),
                List.of()
        );

        return super.createResponseEntity(body, headers, statusCode, request);
    }
}
