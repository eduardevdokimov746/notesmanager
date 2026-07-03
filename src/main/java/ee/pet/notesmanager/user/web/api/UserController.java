package ee.pet.notesmanager.user.web.api;

import ee.pet.notesmanager.user.exception.UserNotFoundException;
import ee.pet.notesmanager.user.persistance.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GetByIdResponse> getById(@PathVariable int id) {
        var optionalUser = this.userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(id);
        }

        return ResponseEntity.ok(GetByIdResponse.buildBy(optionalUser.get()));
    }
}
