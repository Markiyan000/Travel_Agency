package app.dto;

import app.annotation.LocalDateConstraint;
import app.model.Booking;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

import static app.message.Messages.NUMBER_CONSTRAINT;

public class BookingDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @LocalDateConstraint
    private LocalDate arrivalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @LocalDateConstraint
    private LocalDate departureDate;

    @Column(name = "number_of_rooms")
    @Min(value = 1, message = NUMBER_CONSTRAINT)
    private int numberOfRooms;

    public BookingDto() {

    }

    public BookingDto(@NotNull LocalDate arrivalDate, @NotNull LocalDate departureDate, @Min(value = 1, message = NUMBER_CONSTRAINT) int numberOfRooms) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberOfRooms = numberOfRooms;
    }

    public static BookingDto valueOf(Booking booking) {
        return new BookingDto(booking.getArrivalDate(), booking.getDepartureDate(), booking.getNumberOfRooms());
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

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}
