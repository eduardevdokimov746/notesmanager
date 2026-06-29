package ee.pet.notesmanager.user;

import org.hibernate.Session;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.processing.CheckHQL;

import java.util.List;

@CheckHQL
@NamedQuery(name = "selectAllUsers", query = "from User")
public class Queries {
    public static List<User> get(Session session) {
        return session.createQuery("from User", User.class)
                .getResultList();
    }
}
