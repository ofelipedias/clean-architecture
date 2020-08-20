package br.com.felipesilva.postgres.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;

    @Column(name = "dat_create")
    private LocalDateTime create;

    @Column(name = "dat_update")
    private LocalDateTime update;

    @PrePersist
    public void prePersist() {
        this.create = LocalDateTime.now();
    }

    @PreUpdate
    public void preUdpate() {
        this.update = LocalDateTime.now();
    }
}
