package ee.pet.notesmanager.user;

import ee.pet.notesmanager.note.Note;
import ee.pet.notesmanager.note.Note_;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NaturalId(mutable = true)
    private String login;
    private String password;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = Note_.USER, cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Note> notes = new HashSet<>();

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Note createNote(String title) {
        Note note = new Note(this, title);
        notes.add(note);
        return note;
    }

    public boolean deleteNote(Note note) {
        return notes.remove(note);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", notes=" + notes +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
