package app.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

import static app.message.Messages.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @Column(name = "photo")
    @NotEmpty
    private String photo;

    @Column(name = "stars")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private int stars;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {

    }

    public Hotel(Long id, String name, String city, String description, String photo, int stars) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.photo = photo;
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars &&
                id.equals(hotel.id) &&
                name.equals(hotel.name) &&
                city.equals(hotel.city) &&
                description.equals(hotel.description) &&
                photo.equals(hotel.photo);
    }

    @Override
    public int hashCode() {
        return 1;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", stars=" + stars;
    }
}
