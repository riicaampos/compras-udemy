package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.input.ProdutoI;
import com.udemy.compras.model.Produto;
import com.udemy.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ProdutoQueryGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService service;

    @Transactional
    public Produto saveProduto(ProdutoI produto){
        ModelMapper mapper = new ModelMapper();
        Produto prod = mapper.map(produto, Produto.class);
        return this.service.save(prod);
    }

    public List<Produto> listAllProdutos(){
        return this.service.listAll();
    }

    public Produto produtoById(Long id){
        return this.service.findById(id);
    }

    @Transactional
    public String deleteProdutoById(Long id){
        try{
            this.service.deleteById(id);
            return "Produto de id: "+id+" foi deletado";
        }catch(Exception e){
            return "Não foi possível deleter produto de id: "+id;
        }
    }


}
