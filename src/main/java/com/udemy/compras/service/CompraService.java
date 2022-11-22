package com.udemy.compras.service;

import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import com.udemy.compras.repository.ClienteRepository;
import com.udemy.compras.repository.CompraRepository;
import com.udemy.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Compra> listAll() {
        return this.compraRepository.findAll();
    }

    @Override
    public Compra save(Compra obj) {
        return this.compraRepository.save(obj);
    }

    @Override
    public void deleteById(Long id) {
      this.compraRepository.deleteById(id);
    }

    public List<Compra> listAllByCliente(Cliente c) {
        return this.compraRepository.findAllByCliente(c);
    }
}
