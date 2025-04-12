package com.barber.shop.api.activity;

import com.barber.shop.api.exception.EmailInUseException;
import com.barber.shop.api.exception.NotFoundException;
import com.barber.shop.api.exception.PhoneInUseException;
import com.barber.shop.api.model.Client;
import com.barber.shop.api.repository.ClientRepository;
import com.barber.shop.api.service.ClientQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ClientQueryActivity implements ClientQueryService {

    @Autowired
    private  ClientRepository repository;
    @Override
    public Client findById(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Não foi encontrado o cliente"));
    }

    @Override
    public List<Client> list() {
        return repository.findAll();
    }

    @Override
    public void verifyPhone(String phone) {

        if(repository.existsByPhone(phone)) {
            var message = "O telefone " + phone + " já está em uso.";
            throw new PhoneInUseException(message);
        }

    }

    @Override
    public void verifyPhone(long id, String phone) {

        var optional = repository.findByPhone(phone);
//        if( optional.isPresent() && Objects.equals(optional.get().getPhone(), phone)) {
//            var message = "O telefone " + phone + " já está em uso por " + optional.get().getName();
//            throw new PhoneInUseException(message);
//        }
    }

    @Override
    public void verifyEmail(String email) {

        if(repository.existsByEmail(email)) {
            var message = "O email " + email + " já está em uso.";
            throw new EmailInUseException(message);
        }
    }

    @Override
    public void verifyEmail(long id, String email) {

        var optional = repository.findByEmail(email);
//        if( optional.isPresent() && Objects.equals(optional.get().getEmail(), email)) {
//            var message = "O email " + email + " já está em uso por " + optional.get().getName();
//            throw new PhoneInUseException(message);
//        }

    }
}
