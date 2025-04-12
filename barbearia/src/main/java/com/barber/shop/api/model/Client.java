package com.barber.shop.api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "CLIENTS",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_EMAIL", columnNames = "email"),
                @UniqueConstraint(name = "UK_PHONE", columnNames = "phone"),
        }
)
@Getter @Setter @ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150 , name = "name")
    private String name;

    @Column(nullable = false, length = 150, name = "email")
    private String email;

    @Column(nullable = false, length = 11, columnDefinition = "varchar(11)", name = "phone")
    private String phone;

    @ToString.Exclude
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Schedule> schedules = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(phone, client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone);
    }
}
