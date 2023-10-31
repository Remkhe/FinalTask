package Tests;
import java.sql.Timestamp;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "company", schema = "public",catalog = "x_clients_db_r06g_user")
public class CompanyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private int id;
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;
    @Basic
    @Column (name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Basic
    @Column(name = "create_timestamp", nullable = false)
    private Timestamp createDateTime;

    @Basic
    @Column(name = "change_timestamp", nullable = false)
    private Timestamp lastChangedDateTime;

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = 300)
    private String description;

    public Timestamp isDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", createDateTime=" + createDateTime +
                ", lastChangedDateTime=" + lastChangedDateTime +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deletedAt=" + deletedAt +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = Boolean.valueOf(String.valueOf(active));
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Timestamp getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    public void setLastChangedDateTime(Timestamp lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyEntity that)) return false;
        return id == that.id && isActive == that.isActive && Objects.equals(createDateTime, that.createDateTime) && Objects.equals(lastChangedDateTime, that.lastChangedDateTime) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive, createDateTime, lastChangedDateTime, name, description);
    }

}