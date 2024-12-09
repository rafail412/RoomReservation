package kk.roomreservationsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")

public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Long userId;
    @Enumerated(EnumType.STRING)
    private Status status;


    LocalDateTime reservedAt;
    @CreationTimestamp
    LocalDateTime cratedAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    @Version
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomEntity that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && status == that.status && Objects.equals(reservedAt, that.reservedAt) && Objects.equals(cratedAt, that.cratedAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, reservedAt, cratedAt, updatedAt, version);
    }
}




