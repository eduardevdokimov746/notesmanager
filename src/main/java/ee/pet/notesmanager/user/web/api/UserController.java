package ee.pet.notesmanager.user.web.api;

import ee.pet.notesmanager.user.User;
import ee.pet.notesmanager.user.exception.UserNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SessionFactory sessionFactory;

    public UserController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GetByIdResponse> getById(@PathVariable int id) {
        var userOrNull = this.sessionFactory.fromSession(session -> session.find(User.class, id));

        if (userOrNull == null) {
            throw new UserNotFoundException(id);
        }

        return ResponseEntity.ok(GetByIdResponse.buildBy(userOrNull));
    }
}
