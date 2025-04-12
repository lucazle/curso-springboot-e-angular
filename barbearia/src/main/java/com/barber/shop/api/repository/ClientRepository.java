package com.barber.shop.api.repository;

import com.barber.shop.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(final String email);

    Optional<Client> findByEmail(final String email);

    boolean existsByPhone(final String phone);

    Optional<Client> findByPhone(final String phone);
}
