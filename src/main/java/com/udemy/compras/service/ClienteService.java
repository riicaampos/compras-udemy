package com.udemy.compras.service;

import com.udemy.compras.model.Cliente;
import com.udemy.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements BasicCrudService<Cliente, Long> {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente findById(Long id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listAll() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
