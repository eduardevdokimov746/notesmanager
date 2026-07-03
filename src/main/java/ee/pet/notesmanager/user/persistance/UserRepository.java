package ee.pet.notesmanager.user.persistance;

import ee.pet.notesmanager.user.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Integer> {}
