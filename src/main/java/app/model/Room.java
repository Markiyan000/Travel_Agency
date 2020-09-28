package app.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static app.message.Messages.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_of_people")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private int numberOfPeople;

    @Column(name = "price")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private BigDecimal price;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @Column(name = "quantity")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private int quantity;

    @Column(name = "photo")
    @NotEmpty
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy = "room", cascade = {CascadeType.REMOVE})
    private List<Booking> bookingsOnRooms = new ArrayList<>();

    public Room() {

    }

    public Room(int numberOfPeople, BigDecimal price, String description, int quantity, String photo) {
        this.numberOfPeople = numberOfPeople;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return numberOfPeople == room.numberOfPeople &&
                id.equals(room.id) &&
                price.equals(room.price) &&
                description.equals(room.description) &&
                quantity == room.quantity &&
                photo.equals(room.photo) &&
                roomType.equals(room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfPeople, price, description, quantity, photo, roomType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Booking> getBookingsOnRooms() {
        return bookingsOnRooms;
    }

    public void setBookingsOnRooms(List<Booking> bookingsOnRooms) {
        this.bookingsOnRooms = bookingsOnRooms;
    }



    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfPeople=" + numberOfPeople +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", roomType=" + roomType +
                '}';
    }
}
