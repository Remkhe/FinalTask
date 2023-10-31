package Tests;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public",catalog = "x_clients_db_r06g_user")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private int id;
    @Basic
    @Column(name = "is_active")
    private boolean isActive;
    @Basic
    @Column(name = "create_timestamp",nullable = true)
    private Timestamp createDateTime;
    @Basic
    @Column(name = "change_timestamp",nullable = true)
    private Timestamp lastChangedDateTime;
    @Basic
    @Column(name = "first_name",nullable = false,length = 300)
    private String firstName;
    @Basic
    @Column(name = "last_name",nullable = false,length = 300)
    private String lastName;
    @Basic
    @Column(name = "middle_name",nullable = false,length = 300)
    private String middleName ;
    @Basic
    @Column(name = "phone",nullable = false, length = 100)
    private String phone;
    @Basic
    @Column(name = "email",nullable = false,length = 100)
    private String email;
    @Basic
    @Column(name = "birthdate",nullable = false, length = 100)
    private String birthdate ;
    @Basic
    @Column(name = "avatar_url ",nullable = false,length = 300)
    private String avatar_url ;
    @Basic
    @Column(name = "company_id ",nullable = false)
    private int companyId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", createDateTime=" + createDateTime +
                ", lastChangedDateTime=" + lastChangedDateTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", companyId=" + companyId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity that)) return false;
        return id == that.id && isActive == that.isActive && companyId == that.companyId && Objects.equals(createDateTime, that.createDateTime) && Objects.equals(lastChangedDateTime, that.lastChangedDateTime) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(middleName, that.middleName) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(birthdate, that.birthdate) && Objects.equals(avatar_url, that.avatar_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive, createDateTime, lastChangedDateTime, firstName, lastName, middleName, phone, email, birthdate, avatar_url, companyId);
    }
}
