package nuTinemCuFranta.plai.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    private String volunteerName;
    private String[] roles;
    private String[] badges;
    private String[] organizations;
    private String currentStatus;
    private Long profilePictureId;
    private String description;
    private String[] interests;

    public Volunteer(String volunteerName, String description) {
        this.volunteerName = volunteerName;
        this.description = description;
    }

    public Volunteer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return Objects.equals(id, volunteer.id)  &&
                Objects.equals(volunteerName, volunteer.volunteerName);
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", volunteerName='" + volunteerName + '\'' +
                ", roles=" + Arrays.toString(roles) +
                ", badges=" + Arrays.toString(badges) +
                ", organizations=" + Arrays.toString(organizations) +
                ", currentStatus='" + currentStatus + '\'' +
                ", profilePicture=" + profilePictureId +
                ", description='" + description + '\'' +
                ", interests=" + Arrays.toString(interests) +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String[] getBadges() {
        return badges;
    }

    public void setBadges(String[] badges) {
        this.badges = badges;
    }

    public String[] getOrganizations() {
        return organizations;
    }

    public void setOrganizations(String[] organizations) {
        this.organizations = organizations;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Long getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePicture(Long  profilePictureId) {
        this.profilePictureId = profilePictureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }
}
