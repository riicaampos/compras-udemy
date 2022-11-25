package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.input.CompraI;
import com.udemy.compras.model.Cliente;
import com.udemy.compras.model.Compra;
import com.udemy.compras.service.ClienteService;
import com.udemy.compras.service.CompraService;
import com.udemy.compras.service.ProdutoService;
import org.apache.commons.lang3.ArrayUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
public class CompraQueryGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private Environment env;

    @Transactional
    public Compra saveCompra(CompraI compra){
        ModelMapper mapper = new ModelMapper();
        Compra c = mapper.map(compra, Compra.class);

        c.setData(new Date());

        c.setCliente(this.clienteService.findById(compra.getCliente()));
        c.setProduto(this.produtoService.findById(compra.getProduto()));

        return this.compraService.save(c);
    }

    @Transactional
    public String deleteCompraById(Long id){
        try{
            this.compraService.deleteById(id);
            return "Compra de id: "+id+" deletada";
        }catch(Exception e){
            return "Erro ao deletar a compra de id: "+id;
        }
    }

    public List<Compra> listAll(Integer page, Integer size){
        return this.compraService.listAll(page,size);
    }

    public Compra findCompraById(Long id){
        return this.compraService.findById(id);
    }
}
