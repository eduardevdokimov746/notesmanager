package ee.pet.notesmanager.note;

import ee.pet.notesmanager.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.*;

import java.time.Instant;

@Entity
@Table(name = "notes")
@SoftDelete(columnName = "deleted_at", strategy = SoftDeleteType.TIMESTAMP)
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;
    private String title;
    @ColumnDefault("false")
    private boolean isPicked = false;
    @ColumnDefault("false")
    private boolean isArchive = false;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    @Column(updatable = false, insertable = false)
    private Instant deletedAt;

    public Note() {}

    public Note(User user, String title) {
        this.user = user;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isPicked=" + isPicked +
                ", isArchive=" + isArchive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
