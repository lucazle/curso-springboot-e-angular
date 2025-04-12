package com.barber.shop.api.service;

import com.barber.shop.api.model.Client;

import java.util.List;

public interface ClientQueryService {

    Client findById(final long id);

    List<Client> list();

    void verifyPhone(final String phone);

    void verifyPhone(final long id, final String phone);

    void verifyEmail(final String email);

    void verifyEmail(final long id, final String email);
}
