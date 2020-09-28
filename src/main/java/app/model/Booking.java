package app.model;

import app.annotation.LocalDateConstraint;
import org.springframework.format.annotation.DateTimeFormat;
import static app.message.Messages.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "arrival_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @LocalDateConstraint
    private LocalDate arrivalDate;

    @Column(name = "departure_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @LocalDateConstraint
    private LocalDate departureDate;

    @Column(name = "price")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private BigDecimal price;

    @Column(name = "number_of_rooms")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private int numberOfRooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public Booking() {

    }

    public Booking(LocalDate arrivalDate, LocalDate departureDate, BigDecimal price, int numberOfRooms) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", price=" + price +
                ", numberOfRooms=" + numberOfRooms;
    }
}
