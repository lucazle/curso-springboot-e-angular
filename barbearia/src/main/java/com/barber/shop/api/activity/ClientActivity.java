package com.barber.shop.api.activity;

import com.barber.shop.api.model.Client;
import com.barber.shop.api.repository.ClientRepository;
import com.barber.shop.api.service.ClientQueryService;
import com.barber.shop.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientActivity implements ClientService {

    @Autowired
    private  ClientRepository clientRepository;

    @Autowired
    private  ClientQueryService clientQueryService;
    @Override
    public Client save(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

//    public Client update(Long id, Client client) {
//
//        final Client clientUpdate = clientRepository.getReferenceById(id);
//
//        clientUpdate.setName(client.getName());
//        clientUpdate.setPhone(client.getPhone());
//        clientUpdate.setEmail(client.getEmail() );
//        return clientRepository.save(clientUpdate);
//    }

    @Override
    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(long id) {
        clientQueryService.findById(id);
        clientRepository.deleteById(id);

    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
