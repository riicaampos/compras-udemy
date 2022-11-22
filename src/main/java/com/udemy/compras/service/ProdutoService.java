package com.udemy.compras.service;

import com.udemy.compras.model.Produto;
import com.udemy.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements BasicCrudService<Produto, Long> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<Produto> listAll() {
        return this.repository.findAll();
    }

    @Override
    public Produto save(Produto obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deleteById(Long id) {
      this.repository.deleteById(id);
    }
}
