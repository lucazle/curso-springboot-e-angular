package com.barber.shop.api.service;

import com.barber.shop.api.model.Client;

import java.util.List;

public interface ClientService {

    Client save(final Client client);

    Client update(final Client client);

    Client findById(final long id);

    void delete(final long id);

    List<Client> findAll();
}
