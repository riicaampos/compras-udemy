package com.udemy.compras.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import com.udemy.compras.model.Produto;
import com.udemy.compras.service.ClienteService;
import com.udemy.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComprasResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Compra c){
        return this.produtoService.findById(c.getProduto().getId());
    }

    public Cliente cliente(Compra c){
        return this.clienteService.findById(c.getCliente().getId());
    }

}
