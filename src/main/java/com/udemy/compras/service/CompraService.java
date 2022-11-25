package com.udemy.compras.service;

import com.udemy.compras.exceptions.DomainException;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import com.udemy.compras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements BasicCrudService<Compra,Long> {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra findById(Long id) {
        return this.compraRepository.findById(id).orElse(null);
    }

    public List<Compra> listAll() {
        return this.compraRepository.findAll();
    }

    public List<Compra> listAll(Integer page, Integer size) {
        return this.compraRepository.findAll(PageRequest.of(page,size, Sort.by("quantidade").descending())).getContent();
    }

    @Override
    @CacheEvict(value = "comprasByCliente", key = "#c.cliente.id")
    public Compra save(Compra c) {
        if(c.getQuantidade() > 100)
            throw new DomainException("Não é possível comprar acima de 100 itens");

        return this.compraRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
      this.compraRepository.deleteById(id);
    }

    @Cacheable(value= "comprasByCliente", key = "#c.id")
    public List<Compra> listAllByCliente(Cliente c) {
        return this.compraRepository.findAllByCliente(c);
    }
}
