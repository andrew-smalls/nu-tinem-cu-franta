package nuTinemCuFranta.plai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="organizations")
public class Organization {

    @Id
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String representativeFirstName;
    private String representativeLastName;
    private String description;
    private String webpageLink;
    private String facebookLink;
    private String type;

    public Organization() {
    }

    public Organization(Long id, String name, String address, String phoneNumber, String representativeFirstName, String representativeLastName, String description, String webpageLink, String facebookLink, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.representativeFirstName = representativeFirstName;
        this.representativeLastName = representativeLastName;
        this.description = description;
        this.webpageLink = webpageLink;
        this.facebookLink = facebookLink;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", representativeFirstName='" + representativeFirstName + '\'' +
                ", representativeLastName='" + representativeLastName + '\'' +
                ", description='" + description + '\'' +
                ", webpageLink='" + webpageLink + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getRepresentativeLastName() {
        return representativeLastName;
    }

    public void setRepresentativeLastName(String representativeLastName) {
        this.representativeLastName = representativeLastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebpageLink() {
        return webpageLink;
    }

    public void setWebpageLink(String webpageLink) {
        this.webpageLink = webpageLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
