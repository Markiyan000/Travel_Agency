package app.model;

import app.model.enums.RoomTypeEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomTypeEnum type;

    public RoomType() {

    }

    public RoomType(RoomTypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return id.equals(roomType.id) &&
                type.equals(roomType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomTypeEnum getType() {
        return type;
    }

    public void setType(RoomTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
